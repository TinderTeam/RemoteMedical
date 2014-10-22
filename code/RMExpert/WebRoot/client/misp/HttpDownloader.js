/*
版权所有(C) 2009-2014 荆门泽优软件有限公司
保留所有权利
官方网站：http://www.ncmem.com
官方博客：http://www.cnblogs.com/xproer
产品首页：http://www.ncmem.com/webplug/http-downloader/index.asp
在线演示：http://www.ncmem.com/products/http-downloader/demo/index.html
开发文档：http://www.cnblogs.com/xproer/archive/2011/03/15/1984950.html
升级日志：http://www.cnblogs.com/xproer/archive/2011/03/15/1985091.html
示例下载：http://l2.yunpan.cn/lk/Q8sYvBFX2ZCvR
文档下载：http://l2.yunpan.cn/lk/Q27XLcZmUmuxT
联系邮箱：1085617561@qq.com
联系QQ：1085617561
更新记录：
	2014-02-27 优化版本号。
*/

//删除元素值
Array.prototype.remove = function(val)
{
	for (var i = 0, n = 0; i < this.length; i++)
	{
		if (this[i] != val)
		{
			this[n++] = this[i]
		}
	}
	this.length -= 1
}

//全局对象
var FileDownloaderMgrInstance = null; //上传管理器实例

//加截Chrome插件
function LoadChromeCtl(oid,mime,path)
{
	var acx = '<embed id="objHttpDownFF" type="' + mime + '" pluginspage="' + path + '" width="1" height="1"/>';
	if (null != oid)
	{
		$("#" + oid).append(acx);
	}
	else
	{
		document.write(acx);
	}
}

/*
2009-11-5 文件管理类
属性：
UpFileList
*/
function FileDownloaderMgr()
{
	var _this = this;
	this.Config = {
		  "Folder"			: "D:\\"
		, "Debug"			: false//调试模式
		, "LogFile"			: "f:\\log.txt"//日志文件路径。
		, "Company"			: "荆门泽优软件有限公司"
		, "Version"			: "1,2,33,21370"
		, "License"			: ""//
        , "UrlCreate"       : "http://localhost:8080/HttpDownloader/db/down_create.jsp"
        , "UrlDel"          : "http://localhost:8080/HttpDownloader/db/down_del.jsp"
        , "UrlList"         : "http://localhost:8080/HttpDownloader/db/down_list.jsp"
        , "UrlUpdate"       : "http://localhost:8080/HttpDownloader/db/down_update.jsp"
        //x86
		, "ClsidDown"		: "E94D2BA0-37F4-4978-B9B9-A4F548300E48"
		, "ClsidPart"		: "6528602B-7DF7-445A-8BA0-F6F996472569"
		, "CabPath"			: "http://www.ncmem.com/download/HttpDownloader/HttpDownloader.cab"
		//x64
		, "ClsidDown64"		: "0DADC2F7-225A-4cdb-80E2-03E9E7981AF8"
		, "ClsidPart64"		: "19799DD1-7357-49de-AE5D-E7A010A3172C"
		, "CabPath64"		: "http://www.ncmem.com/download/HttpDownloader/HttpDownloader64.cab"
		//Firefox
		, "MimeType"		: "application/npHttpDown"
		, "CabPathFirefox"	: "http://www.ncmem.com/download/HttpDownloader/HttpDownloader.xpi"
		//Chrome
		, "CrxName"			: "npHttpDown"
		, "MimeTypeChr"		: "application/npHttpDown"
		, "CabPathChrome"	: "http://www.ncmem.com/download/HttpDownloader/HttpDownloader.crx"
		, "exePath"	        : "http://www.ncmem.com/download/HttpDownloader/HttpDownloader.exe"
	};
	
	this.ActiveX = {
		  "Down"	: "Xproer.HttpDownloader"
		, "Part"	: "Xproer.DownloaderPartition"
		//64bit
		, "Down64"	: "Xproer.HttpDownloader64"
		, "Part64"	: "Xproer.DownloaderPartition64"
	};

	this.Fields = {
        "uid" : 0
	};
	
	//检查版本 Win32/Win64/Firefox/Chrome
	_this.firefox = false;
	_this.ie = false;
	_this.chrome = false;
	
	var browserName = navigator.userAgent.toLowerCase();
	_this.ie = browserName.indexOf("msie") > 0;
	_this.ie = _this.ie ? _this.ie : browserName.search(/(msie\s|trident.*rv:)([\w.]+)/)!=-1;
	_this.firefox = browserName.indexOf("firefox") > 0;
	_this.chrome = browserName.indexOf("chrome") > 0;

	this.CheckVersion = function()
	{
		//Win64
		if (window.navigator.platform == "Win64")
		{
			_this.Config["CabPath"] = _this.Config["CabPath64"];

			_this.Config["ClsidDown"] = _this.Config["ClsidDown64"];
			_this.Config["ClsidPart"] = _this.Config["ClsidPart64"];

			_this.ActiveX["Down"] = _this.ActiveX["Down64"];
			_this.ActiveX["Part"] = _this.ActiveX["Part64"];
		} //Firefox
		else if (_this.firefox)
		{
			_this.Config["CabPath"] = _this.Config["CabPathFirefox"];
		}
		else if (_this.chrome)
		{
			_this.Config["CabPath"] = _this.Config["CabPathChrome"];
			_this.Config["MimeType"] = _this.Config["MimeTypeChr"];
		}
	};
	_this.CheckVersion();
	
	FileDownloaderMgrInstance = this;
	this.FileFilter = new Array();			//文件过滤器
	this.DownloadCount = 0; 				//上传项总数
	this.DownloadList = new Object();		//下载项列表
	this.DownloadQueue = new Array();		//下载队列
	this.UnDownloadIdList = new Array();	//未下载项ID列表
	this.DownloadIdList = new Array();		//正在下载的ID列表
	this.CompleteList = new Array();		//已下载完的列表
	this.DownerPool = new Array();          //IE内核缓存
	this.DownerPoolFF = new Array();        //chr内核缓存

	this.GetHtml = function()
	{ 
		//自动安装CAB
		var acx = '<div style="display:none">';
		/*
			IE静态加载代码：
			<object id="objDownloader" classid="clsid:E94D2BA0-37F4-4978-B9B9-A4F548300E48" codebase="http://www.qq.com/HttpDownloader.cab#version=1,2,22,65068" width="1" height="1" ></object>
			<object id="objPartition" classid="clsid:6528602B-7DF7-445A-8BA0-F6F996472569" codebase="http://www.qq.com/HttpDownloader.cab#version=1,2,22,65068" width="1" height="1" ></object>
		*/
		//下载控件
		acx += '<object id="objDownloader" classid="clsid:' + this.Config["ClsidDown"] + '"';
		acx += ' codebase="' + this.Config["CabPath"] + '#version='+_this.Config["Version"]+'" width="1" height="1" ></object>';
		//文件夹选择控件
		acx += '<object id="objPartition" classid="clsid:' + this.Config["ClsidPart"] + '"';
		acx += ' codebase="' + this.Config["CabPath"] + '#version='+_this.Config["Version"]+'" width="1" height="1" ></object>';
		acx += '</div>';
		//上传列表项模板
		acx += '<div class="UploaderItem" id="UploaderTemplate">\
					<div class="UploaderItemLeft">\
						<div class="FileInfo">\
							<div name="fileName" class="FileName top-space">HttpUploader程序开发.pdf</div>\
							<div name="fileSize" class="FileSize" child="1"></div>\
						</div>\
						<div class="ProcessBorder top-space"><div name="process" class="Process"></div></div>\
						<div name="msg" class="PostInf top-space">已上传:15.3MB 速度:20KB/S 剩余时间:10:02:00</div>\
					</div>\
					<div class="UploaderItemRight">\
						<div class="BtnInfo"><a name="btn" class="Btn" href="javascript:void(0)">取消</a></div>\
						<div name="percent" class="ProcessNum">35%</div>\
					</div>\
				</div>';
		//分隔线
		acx += '<div class="Line" id="FilePostLine"></div>';
		//上传列表
		acx += '<div >\
					<div class="content">\
						<div id="FilePostLister"></div>\
					</div>\
					<div class="footer"></div>\
				</div>';
		return acx;
	};
	
	//IE浏览器信息管理对象
	this.BrowserIE = {
	    plugin:null
        ,"Check": function()//检查插件是否已安装
		{
			try
			{
				var com = new ActiveXObject(_this.ActiveX["Down"]);
				return true;
			}
			catch (e) { return false; }
		}
		, "Setup": function ()//安装插件
		{
		}
		, "CopyFile": function(src, dst)//复制文件
		{
		    var obj = this.plugin;
			obj.CopyFile(src, dst);
		}
		, "MoveFile": function(src, dst)//移动文件
		{
		    var obj = this.plugin;
			obj.MoveFile(src, dst);
		}
		, "OpenPath": function(path)//打开文件夹
		{
		    var obj = this.plugin;
			obj.OpenPath(path);
		}
		, "OpenFolderDialog": function()
		{ 
		    var obj = this.plugin;
			obj.InitPath = _this.Config["Folder"];
			if (!obj.ShowFolder()) return;

			_this.Config["Folder"] = obj.Folder;
		}
        , "GetMacs": function ()
        {
            var list = this.plugin.GetMacs();//是一个JSON数据            
            if (list == null) return null;
            if (list.lbound(1) == null) return null;

            for (var index = list.lbound(1) ; index <= list.ubound(1) ; index++)
            {
                return list.getItem(index);
            }
            return "0";
        }
		, "Init": function ()
		{
		    this.plugin = document.getElementById("objPartition");
		}
	};
	//FireFox浏览器信息管理对象
	this.BrowserFF = {
	    plugin: null
        , "Check": function ()//检查插件是否已安装
		{
		    var mimetype = navigator.mimeTypes;
		    if (typeof mimetype == "object" && mimetype.length)
		    {
		        for (var i = 0; i < mimetype.length; i++)
		        {
		            if (mimetype[i].type == _this.Config["MimeType"].toLowerCase())
		            {
		                return mimetype[i].enabledPlugin;
		            }
		        }
		    }
		    else
		    {
		        mimetype = [_this.Config["MimeType"]];
		    }
		    if (mimetype)
		    {
		        return mimetype.enabledPlugin;
		    }
		    return false;
		}
		, "Setup": function()//安装插件
		{
			var xpi = new Object();
			xpi["Calendar"] = _this.Config["CabPathFirefox"];
			InstallTrigger.install(xpi, function(name, result) { });
		}
		, "CopyFile": function(src, dst)//复制文件
		{
			var obj = this.plugin;
			obj.CopyFile(src, dst);
		}
		, "MoveFile": function(src, dst)//移动文件
		{
			var obj = this.plugin;
			obj.MoveFile(src, dst);
		}
		, "OpenPath": function(path)//打开路径
		{
			var obj = this.plugin;
			obj.OpenPath(path);
		}
		, "OpenFolderDialog": function()//设置下载目录
		{
			this.plugin.InitPath = _this.Config["Folder"];
			if (!this.plugin.ShowFolder()) return;
			_this.Config["Folder"] = this.plugin.GetFolder();
		}
        , "GetMacs": function ()
        {
            var obj = this.plugin.GetMacs();//是一个JSON数据
            return obj[0];
        }
		, "Init": function()//初始化控件
		{
			var atl             = document.getElementById("objHttpDownFF");
			atl.Licensed	    = _this.Config["Company"];
			atl.License		    = _this.Config["License"];
			atl.InitPath	    = _this.Config["Folder"];
			atl.Debug		    = _this.Config["Debug"];
			atl.LogFile		    = _this.Config["LogFile"];
			atl.OnConnected     = HttpDownloader_Connected;
			atl.OnComplete	    = HttpDownloader_Complete;
			atl.OnPost		    = HttpDownloader_Process;
			atl.OnError		    = HttpDownloader_Error;
			atl.OnGetFileSize   = HttpDownloader_GetFileSize;
			atl.OnGetFileName   = HttpDownloader_GetFileName;
			atl.OnBeginDown     = HttpDownloader_BeginDown;
			this.plugin = atl;
		}
	};
	//Chrome浏览器
	this.BrowserChrome = {
	    plugin: null
        , "Check": function ()//检查插件是否已安装
		{
			for (var i = 0, l = navigator.plugins.length; i < l; i++)
			{
				if (navigator.plugins[i].name == _this.Config["CrxName"])
				{
					return true;
				}
			}
			return false;
		}
		, "Setup": function()//安装插件
		{
			document.write('<iframe style="display:none;" src="' + _this.Config["CabPathChrome"] + '"></iframe>');
		}
		, "CopyFile": function(src, dst)//复制文件
		{
		    var obj = this.plugin;
			obj.CopyFile(src, dst);
		}
		, "MoveFile": function(src, dst)//移动文件
		{
		    var obj = this.plugin;
			obj.CopyFile(src, dst);
		}
		, "OpenPath": function(path)
		{ 
		    var obj = this.plugin;
			obj.OpenPath(path);
		}
		, "OpenFolderDialog": function()//设置下载目录
		{
			this.plugin.InitPath = _this.Config["Folder"];
			if (!this.plugin.ShowFolder()) return;
			_this.Config["Folder"] = this.plugin.GetFolder();
		}
        , "GetMacs": function ()
        {
            var obj = this.plugin.GetMacs();//是一个JSON数据
            return obj[0];
        }
		, "Init": function()//初始化控件
		{
			var atl = document.getElementById("objHttpDownFF");
			atl.Licensed	= _this.Config["Company"];
			atl.License		= _this.Config["License"];
			atl.InitPath	= _this.Config["Folder"];
			atl.Debug		= _this.Config["Debug"];
			atl.LogFile		= _this.Config["LogFile"];
			atl.OnConnected = HttpDownloader_Connected;
			atl.OnComplete	= HttpDownloader_Complete;
			atl.OnPost		= HttpDownloader_Process;
			atl.OnError		= HttpDownloader_Error;
			atl.OnGetFileSize = HttpDownloader_GetFileSize;
			atl.OnGetFileName = HttpDownloader_GetFileName;
			atl.OnBeginDown = HttpDownloader_BeginDown;
			this.plugin = atl;
		}
	};

	_this.Browser = this.BrowserIE;
	//Firefox
	if (_this.firefox)
	{
		_this.Browser = this.BrowserFF;
		if (!_this.Browser.Check()) { _this.Browser.Setup(); }
	} //Chrome
	else if (_this.chrome)
	{
		_this.Browser = this.BrowserChrome;
		if (!_this.Browser.Check()) { _this.Browser.Setup(); }
	}

	//安全检查，在用户关闭网页时自动停止所有上传任务。
	this.SafeCheck = function()
	{
		$(window).bind("beforeunload", function()
		{
			if (_this.DownloadIdList.length > 0)
			{
				event.returnValue = "您还有程序正在运行，确定关闭？";
			}
		});

		$(window).bind("unload", function()
		{ 
			if (_this.DownloadIdList.length > 0)
			{
				_this.StopAll();
			}
		});
	};
	
	this.Load = function()
	{
		document.write(this.GetHtml());
		LoadChromeCtl(null, this.Config["MimeType"], this.Config["CabPathFirefox"]);
	};
	
	//加截到指定控件
	this.LoadTo = function(id)
	{
		var obj = document.getElementById(id);
		obj.innerHTML = this.GetHtml();
		LoadChromeCtl(id, this.Config["MimeType"], this.Config["CabPathFirefox"]);
	};

	//初始化，一般在window.onload中调用
	this.Init = function ()
	{
	    this.UploaderListDiv = document.getElementById("FilePostLister");
	    this.UploaderTemplateDiv = document.getElementById("UploaderTemplate");
	    this.FirefoxAtl = document.getElementById("objHttpDownFF");
	    _this.Browser.Init(); //
	    //设置下载文件夹
	    $("#btnSetFolder").click(function () { _this.OpenFolderDialog(); });

	    this.LoadData();
	};

    //加载未未完成列表
	this.LoadData = function ()
	{
	    $.ajax({
	        type: "GET"
            //, dataType: 'jsonp'
            //, jsonp: "callback" //自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
            , url: _this.Config["UrlList"]
            , data: { uid: _this.Fields["uid"], mac: _this.Browser.GetMacs(), time : Date() }
            , success: function (msg)
            {
                var json = eval("("+decodeURIComponent(msg)+")");
                 $.each(json, function (i, item) {
                     var obj = _this.AddFile(item.pathSvr);
                     obj.idSvr = item.idSvr;
                     obj.ATL.SetFilePathLoc(item.pathLoc);
                     obj.pButton.text("续传");
                     //item.idSvr;
                     //item.uid;
                     //item.mac;
                     //item.pathLoc;
                     //item.pathSvr;
                     //item.lengthLoc;
                 });
                 //_this.PostFirst();
            }
            , error: function (req, txt, err) {  }
            , complete: function (req, sta) {req = null;}
	    });
	};

	//上传队列是否已满
	this.IsPostQueueFull = function()
	{
		//目前只支持同时下载三个文件
		if (this.DownloadIdList.length >= 3)
		{
			return true;
		}
		return false;
	};

	//添加一个上传ID
	this.AppendUploadId = function(fid)
	{
		this.DownloadIdList.push(fid);
	};

	/*
	从当前上传ID列表中删除指定项。
	此函数将会重新构造一个Array
	*/
	this.RemoveDownloadId = function(fid)
	{
		if (this.DownloadIdList.length == 0) return;
		this.DownloadIdList.remove(fid);
	};

	//停止所有上传项
	this.StopAll = function()
	{
		for (var i = 0, l = this.DownloadIdList.length; i < l; ++i)
		{
			this.DownloadList[this.DownloadIdList[i]].Stop();
		}
		this.DownloadIdList.length = 0;
	};

	/*
	添加到上传列表
	参数
	fid 上传项ID
	uploaderItem 新的上传对象
	*/
	this.AppenToUploaderList = function(fid, uploaderItem)
	{
		this.DownloadList[fid] = uploaderItem;
		this.DownloadCount++;
	};

	/*
	添加到上传列表层
	1.添加到上传列表层
	2.添加分隔线
	参数：
	fid 上传项ID
	uploaderDiv 新的上传信息层
	*/
	this.AppendToUploaderListDiv = function(fid, uploaderDiv)
	{
		this.UploaderListDiv.appendChild(uploaderDiv);

		var split = "<div class=\"Line\" style=\"display:block;\" id=\"FilePostLine" + fid + "\"></div>";
		this.UploaderListDiv.insertAdjacentHTML("beforeEnd", split);
		var obj = document.getElementById("FilePostLine" + fid);
		return obj;
	};

	//传送当前队列的第一个文件
	this.PostFirst = function()
	{
		//未上传列表不为空
		if (this.UnDownloadIdList.length > 0)
		{
			//同时上传三个任务
			while (this.UnDownloadIdList.length > 0
				&& !this.IsPostQueueFull())
			{
				//上传队列已满
				if (this.IsPostQueueFull()) return;
				var index = this.UnDownloadIdList.shift();
				this.DownloadList[index].Download();
			}
		}
	};

	/*
	验证文件名是否存在
	参数:
	[0]:文件名称
	*/
	this.Exist = function(url)
	{
		for (a in this.DownloadList)
		{
			if (this.DownloadList[a].FileUrl == url)
			{
				return true;
			}
		}
		return false;
	};

	/*
	根据ID删除上传任务
	参数:
	fid 上传项ID。唯一标识
	*/
	this.Delete = function(fid)
	{
		var obj = this.DownloadList[fid];
		if (null == obj) return;

		//删除div
		document.removeChild(obj.div);
		//删除分隔线
		document.removeChild(obj.spliter);
	};

	/*
	设置文件过滤器
	参数：
	filter 文件类型字符串，使用逗号分隔(exe,jpg,gif)
	*/
	this.SetFileFilter = function(filter)
	{
		this.FileFilter.length = 0;
		this.FileFilter = filter.split(",");
	};

	/*
	判断文件类型是否需要过滤
	根据文件后缀名称来判断。
	*/
	this.NeedFilter = function(fname)
	{
		if (this.FileFilter.length == 0) return false;
		var exArr = fname.split(".");
		var len = exArr.length;
		if (len > 0)
		{
			for (var i = 0, l = this.FileFilter.length; i < l; ++i)
			{
				//忽略大小写
				if (this.FileFilter[i].toLowerCase() == exArr[len - 1].toLowerCase())
				{
					return true;
				}
			}
		}
		return false;
	};

	//打开文件夹选择对话框
	this.OpenFolderDialog = function()
	{
		_this.Browser.OpenFolderDialog();
	};
}

/*
添加一个文件到上传队列
参数:
	url			远程文件地址
	fileName	自定义下载文件名称
*/
FileDownloaderMgr.prototype.AddFile = function (url)
{
    //本地文件名称存在
    //if (this.Exist(url)) return;
    //此类型为过滤类型
    //if (this.NeedFilter(url)) return;

    var fileNameArray = url.split("/");
    var fileName = fileNameArray[fileNameArray.length - 1];
    //自定义文件名称
    if (typeof (arguments[1]) == "string")
    {
        fileName = arguments[1];
    }
    var fid = this.DownloadCount;
    this.UnDownloadIdList.push(fid);

    var downer = new HttpDownloader(fid, url, this);
    downer.Manager = this;
    var newTable = this.UploaderTemplateDiv.cloneNode(true);
    newTable.style.display = "block";
    newTable.id = "item" + fid;
    var jq = $(newTable);
    var objFileName = jq.find("div[name='fileName']")
    var objFileSize = jq.find("div[name='fileSize']");
    var objProcess = jq.find("div[name='process']");
    var objMsg = jq.find("div[name='msg']");
    var objBtn = jq.find("a[name='btn']");
    var objPercent = jq.find("div[name='percent']");

    objFileName.text(fileName);
    objFileName.attr("title", url);
    var fileSize = objFileSize;
    //fileSize.innerText = downer.FileSize;
    downer.pFileName = objFileName;
    downer.pFileSize = fileSize;
    downer.pProcess = objProcess;
    downer.pMsg = objMsg;
    downer.pMsg.text("");
    downer.pButton = objBtn;
    downer.pButton.attr("fid", fid);
    downer.pButton.attr("domid", "item" + fid);
    downer.pButton.attr("lineid", "FilePostLine" + fid);
    downer.pButton.bind("click", BtnControlClick);
    downer.pPercent = objPercent;
    downer.pPercent.text("0%");
    downer.Manager = this;
    //自定义下载文件名称
    //downer.ATL.SetFileName(fileName);
    downer.FileNameLoc = fileName;
    
    //添加到上传列表
    this.AppenToUploaderList(fid, downer);
    //添加到上传列表层
    downer.spliter = this.AppendToUploaderListDiv(fid, newTable);
    downer.div = newTable;
    //downer.Post(); //开始上传
    downer.Ready(); //准备
    return downer;
}

/*
单击控制按钮
参数:
[0]
*/
function BtnControlClick()
{
	//var element = event.srcElement; //<a fid=""></a>
	var element = $(this);
	var obj = FileDownloaderMgrInstance.DownloadList[element.attr("fid")];

	switch (element.text())
	{
		case "暂停":
		case "停止":
			obj.Stop();
			break;
		case "取消":
			{
				var lister = FileDownloaderMgrInstance.UploaderListDiv;
				lister.removeChild(obj.div);
				lister.removeChild(obj.spliter);
				obj.Stop();
			}
			break;
		case "续传":
		case "重试":
			obj.Download();
			break;
		case "打开":
			obj.OpenPath();
	}
	return false;
}
//错误类型
var DownloadErrorCode = {
	  "0": "连接服务器失败"
	, "1": "URL地址为空"
	, "2": "获取远程文件错误"
	, "3": "未设置本地目录"
	, "4": "创建文件错误"
	, "5": "向本地文件写入数据失败"
	, "6": "公司未授权"
	, "7": "域名未授权"
	, "8": "文件大小超过限制"
	, "9": "文件夹是相对路径"
	, "10": "文件夹路径太长"
	, "11": "路径无效"
	, "12": "读取远程文件数据错误"
	, "13": "设置异步回调函数失败"
	//HTTP标准错误
	, "400": "错误请求"
	, "401": "未授权"
	, "402": "支付请求"
	, "403": "禁止访问"
	, "404": "未找到页面"
	, "405": "方法不允许"
	, "406": "不接受请求"
	, "407": "需要验证代码"
	, "408": "请求超时"
	, "409": "访问冲突"
	, "410": "已过时"
	, "411": "未指定请求内容长度"
	, "412": "前提条件失败"
	, "413": "请求内容过长"
	, "414": "请求地址过长"
	, "415": "不支持的媒体类型"
	, "416": "请求范围不符合要求"
	, "417": "预期失败"
	, "500": "内部服务错误"
	, "501": "未实现"
	, "502": "错误的网关"
	, "503": "服务不可用"
	, "504": "网关超时"
	, "505": "HTTP版本不支持"
};
//状态
var HttpDownloaderState = {
	Ready: 0,
	Posting: 1,
	Stop: 2,
	Error: 3,
	GetNewID: 4,
	Complete: 5,
	WaitContinueUpload: 6,
	None: 7,
	Waiting: 8
};

//文件下载对象
function HttpDownloader(fileID ,fileUrl ,mgr)
{
    var _this = this;
	//this.pMsg;
	//this.pProcess;
	//this.pPercent;
	//this.pButton
	//this.pFileSize
    this.Manager = mgr;
    this.DownerPool = mgr.DownerPool;
    this.DownerPoolFF = mgr.DownerPoolFF;
	this.ActiveX = mgr.ActiveX;
	this.Config = mgr.Config;
	this.Fields = mgr.Fields;
	this.FirefoxAtl = mgr.FirefoxAtl;
	this.firefox = mgr.firefox;
	this.chrome = mgr.chrome;
	this.Browser = mgr.Browser;
	this.State = HttpDownloaderState.None;
    //attr
	this.idSvr = 0;//与服务器数据表 f_id 对应
	this.mac = mgr.Browser.GetMacs();
	this.FileUrl = fileUrl;
	this.FileID = fileID;
	this.LocalFolder = this.Config["Folder"];
	this.LocalFilePath = "";//下载的本地文件完整路径。示例：D:\\Soft\\QQ2012.exe
	this.FileNameLoc = "";//自定义文件名称
	
	//初始化控件
	this.ATL = {
		"Create": function ()
		{
            //有缓存对象
		    if (_this.DownerPool.length > 0)
		    {
		        var com = _this.DownerPool.pop();
		        this.com = com;
		    }//无缓存
		    else
		    {
		        this.com = new ActiveXObject(_this.ActiveX["Down"]);
		    }
		    this.com.Object = _this;
		    this.com.License = _this.Config["License"];
			this.com.Company = _this.Config["Company"];
			this.com.FileUrl = _this.FileUrl;
			this.com.LocalFolder = _this.Config["Folder"];
			//自定义文件名称
			if (_this.FileNameLoc.length > 4)
			{
				this.com.FileName = _this.FileNameLoc;
			}
		    //event
			this.com.OnComplete     = HttpDownloader_Complete;
			this.com.OnPost         = HttpDownloader_Process;
			this.com.OnError        = HttpDownloader_Error;
			this.com.OnConnected    = HttpDownloader_Connected;
			this.com.OnGetFileSize  = HttpDownloader_GetFileSize;
			this.com.OnGetFileName  = HttpDownloader_GetFileName;
			this.com.OnBeginDown    = HttpDownloader_BeginDown;
		}
		, "SetFileName": function (name) { this.com.FileName = name; }
        , "SetFilePathLoc": function (path) { this.com.LocalFilePath = path;}
		//get
		, "GetFileSize": function () { return this.com.FileSize; }
		, "GetFileLengthLoc": function () { return this.com.FileLengthLoc; }
		, "GetFilePathLoc": function () { return this.com.LocalFilePath; }
		, "GetResponse": function () { return this.com.Response; }
		, "GetMD5": function () { return this.com.MD5; }
		, "GetMd5Percent": function () { return this.com.Md5Percent; }
		, "GetPostedLength": function () { return this.com.PostedLength; }
		, "GetErrorCode": function () { return this.com.ErrorCode; }
		//methods
		, "Download": function () { this.com.Download(); }
		, "Stop": function () { this.com.Stop(); }
		, "ClearFields": function () { this.com.ClearFields(); }
		, "AddField": function (fn, fv) { this.com.AddField(fn, fv); }
		, "Dispose": function () { delete this.com; }
		, "IsPosting": function () { return this.com.IsPosting(); }
		, "OpenPath": function () { this.com.OpenPath(); }
		, "OpenFile": function () { this.com.OpenFile(); }
		//property
		, "com": null
		, "FileID": 0//由控件分配的
	};
	//Firefox 插件
	this.ATLFF = {
	    "Create": function ()
	    {
            //有缓存
	        if (_this.DownerPoolFF.length > 0)
	        {
	            var index = _this.DownerPoolFF.pop();
	            this.idSign = index;
	        }
	        else
	        {
	            this.idSign = this.Atl.AddFile();
	        }	        
	        this.Atl.SetObject(this.idSign, _this);
	        this.Atl.SetLocalFolder(this.idSign, _this.Config["Folder"]);
	        this.Atl.SetFileUrl(this.idSign, _this.FileUrl);
	        //自定义文件名称
	        if (_this.FileNameLoc.length > 4)
	        {
	        	this.Atl.SetFileName(this.idSign,_this.FileNameLoc);
	        }
	    }
		, "SetFileName": function (name) { this.Atl.SetFileName(this.idSign, name); }
        , "SetFilePathLoc": function (path) { this.Atl.SetFilePathLoc(this.idSign,path);}
		//get
		, "GetFileSize": function () { return this.Atl.FileSize; }
        , "GetFileLengthLoc": function () { return this.Atl.GetFileLengthLoc(this.idSign);}
		, "GetFilePathLoc": function () { return this.Atl.GetFilePathLoc(this.idSign); }
		, "GetFileLength": function () { return this.Atl.FileLength; }
		, "GetResponse": function () { return this.Atl.Response; }
		, "GetPostedLength": function () { return this.Atl.PostedLength; }
		, "GetErrorCode": function () { return this.Atl.ErrorCode; }
		//methods
		, "Download": function () { this.Atl.Download(this.idSign); }
		, "Stop": function () { this.Atl.Stop(this.idSign); }
		, "ClearFields": function () { this.Atl.ClearFields(this.idSign); }
		, "AddField": function (fn, fv) { this.Atl.AddField(this.idSign, fn, fv); }
		, "Dispose": function () { this.Atl.Remove(this.idSign); }
		, "IsPosting": function () { return this.Atl.IsPosting(this.idSign); }
		, "OpenPath": function () { this.Atl.OpenPath(this.idSign); }
		, "OpenFile": function () { this.Atl.OpenFile(this.idSign); }
		//property
		, "Atl": _this.FirefoxAtl
		, "idSign": "0"//由控件分配的标识符，全局唯一。
	};
	//是Firefox或Chrome浏览器
	if (this.firefox||this.chrome){this.ATL = this.ATLFF;}
	this.ATL.Create();
	
	//方法-准备
	this.Ready = function()
	{
		//this.pButton.style.display = "none";
		this.pMsg.text( "正在下载队列中等待..." );
		this.State = HttpDownloaderState.Ready;
	};

	//方法-开始下载
	this.Download = function()
	{
		this.pButton.show();
		this.pButton.text("停止");
		this.pMsg.text("开始连接服务器...");
		this.State = HttpDownloaderState.Posting;
		this.Manager.AppendUploadId(this.FileID);
		this.ATL.Download();
	};

	//方法-启动下一个传输
	this.DownNext = function()
	{
		if (this.Manager.UnDownloadIdList.length > 0)
		{
			var index = this.Manager.UnDownloadIdList.shift();
			var obj = this.Manager.DownloadList[index];

			//空闲状态
			if (HttpDownloaderState.Ready == obj.State)
			{
				obj.Download();
			}
		}
	};
	
	//打开文件所在路径
	this.OpenPath = function()
	{
		this.ATL.OpenPath();
	};
	
	//方法-停止传输
	this.Stop = function()
	{
	    this.ATL.Stop();
        this.SvrUpdate();
		this.State = HttpDownloaderState.Stop;
		this.pButton.text( "续传" );
		this.pMsg.text( "下载已停止");
		//从上传列表中删除
		this.Manager.RemoveDownloadId(this.FileID);
		//添加到未上传列表
		this.Manager.UnDownloadIdList.push(this.FileID);
		//上传下一个
		this.DownNext();
	};
	
	//释放内存
	this.Dispose = function()
	{
	    if (this.firefox || this.chrome)
	    {
	        this.DownerPoolFF.push(this.ATL.FileID);
	    }
	    else
	    {
	        this.DownerPool.push(this.ATL.Atl);
	    }
		//this.ATL.Dispose();
	};

    //在出错，停止中调用
	this.SvrUpdate = function ()
	{
	    $.ajax({
	        type: "GET"
            , dataType: 'jsonp'
            , jsonp: "callback" //自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
            , url: _this.Config["UrlUpdate"]
            , data: { uid: _this.Fields["uid"], fid:_this.idSvr,mac: _this.mac, lenLoc: _this.ATL.GetFileLengthLoc(), lengthSvr: _this.fileSize, time: Date() }
        , success:
        function (msg)
        {
        }
        , error: function (req, txt, err) { }
        , complete: function (req, sta) { req = null; }
	    });
	};

    //在服务端创建一个数据，用于记录下载信息，一般在HttpDownloader_BeginDown中调用
	this.SvrCreate = function ()
	{
        //已记录将不再记录
	    if (this.idSvr) return;

	    $.ajax({
	        type: "GET"
            , dataType: 'jsonp'
            , jsonp: "callback" //自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
            , url: _this.Config["UrlCreate"]
            , data: { uid: _this.Fields["uid"], mac: _this.mac, pathLoc: encodeURIComponent(_this.ATL.GetFilePathLoc()), pathSvr: encodeURIComponent(_this.FileUrl), lengthLoc: "0", lengthSvr: _this.fileSize, time: Date() }
            , success: function (json)
            {
                //var json = eval(msg);
                //json = json[0];
                _this.idSvr = json.idSvr;
            }
            , error: function (req, txt, err) {  }
            , complete: function (req, sta) { req = null; }
	    });
	};

    //一般在HttpDownloader_Complete中调用
	this.SvrDelete = function ()
	{
	    $.ajax({
	        type: "GET"
            , dataType: 'jsonp'
            , jsonp: "callback" //自定义的jsonp回调函数名称，默认为jQuery自动生成的随机函数名
            , url: _this.Config["UrlDel"]
            , data: { uid: _this.Fields["uid"], fid:_this.idSvr,mac: _this.mac, time: Date() }
            , success:function (json)
            {
                //var res = eval(msg);
            }
            , error: function (req, txt, err) {   }
            , complete: function (req, sta) { req = null; }
	    });
	};
}

//连接成功
function HttpDownloader_Connected(obj)
{
	obj.pMsg.text( "服务器连接成功" );
}

//传输完毕
function HttpDownloader_Complete(obj)
{
	obj.pButton.text( "打开" );
	obj.pProcess.css("width","100%");
	obj.pPercent.text( "100%" );
	obj.pMsg.text( "下载完成" );
	obj.State = HttpDownloaderState.Complete;
	obj.LocalFilePath = obj.ATL.LocalFilePath;
	obj.SvrDelete();
	obj.Dispose();
	obj.DownNext();
}

//获取文件大小
function HttpDownloader_GetFileSize(obj,size)
{
    obj.pFileSize.text(size);
    obj.fileSize = size;
}

//获取文件大小(在最后执行)
function HttpDownloader_GetFileName(obj,name)
{
	obj.pFileName.text(name);
	obj.pFileName.attr("title", name);
}

function HttpDownloader_BeginDown(obj)
{
	obj.SvrCreate();
}

//传输进度
function HttpDownloader_Process(obj, speed, downLen, percent, time)
{
	obj.pPercent.text(percent);
	obj.pProcess.css("width", percent);
	var msg =["已下载", downLen, " 速度:", speed, "/S", " 剩余时间:", time];
	obj.pMsg.text( msg.join("") );
}

//传输错误
function HttpDownloader_Error(obj, err)
{
	obj.pMsg.text( DownloadErrorCode[err] );
	obj.pButton.text( "重试" );
	obj.State = HttpDownloaderState.Error;
	obj.SvrUpdate();
	obj.Dispose();
	obj.DownNext(); //继续传输下一个
}