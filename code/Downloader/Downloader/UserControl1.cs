using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Drawing;
using System.Data;
using System.Text;
using System.Windows.Forms;
using System.Threading;
using System.IO;
using System.Net;

namespace Downloader
{

    using System.Runtime.InteropServices;

    [Guid("67134AD0-705A-4CD6-B520-56435E59EDE6"), ProgId("Downloader.UserControl1"), ComVisible(true)]
    public partial class UserControl1 : UserControl, IObjectSafety
    {
        #region IObjectSafety 成员 格式固定

        private const string _IID_IDispatch = "{00020400-0000-0000-C000-000000000046}";
        private const string _IID_IDispatchEx = "{a6ef9860-c720-11d0-9337-00a0c90dcaa9}";
        private const string _IID_IPersistStorage = "{0000010A-0000-0000-C000-000000000046}";
        private const string _IID_IPersistStream = "{00000109-0000-0000-C000-000000000046}";
        private const string _IID_IPersistPropertyBag = "{37D84F60-42CB-11CE-8135-00AA004BB851}";

        private const int INTERFACESAFE_FOR_UNTRUSTED_CALLER = 0x00000001;
        private const int INTERFACESAFE_FOR_UNTRUSTED_DATA = 0x00000002;
        private const int S_OK = 0;
        private const int E_FAIL = unchecked((int)0x80004005);
        private const int E_NOINTERFACE = unchecked((int)0x80004002);

        private bool _fSafeForScripting = true;
        private bool _fSafeForInitializing = true;

        private long fileLength = 0;  //文件大小

        public long downLength = 0;//已经下载文件大小，外面想用就改成公共属性 
        public int percent = 0;  //下载文件的百分数
        public string url;       //下载文件URL
        public string md5Code;   //文件MD6
        public string path;      //下载的本地路径
        public bool done = false;    //下载完成的标志
        public bool failed = false;  //下载标志
        public bool stopDown = true; //是否要中断下载
        public bool debug = false;   //调试信息标志

        public int time_out = 15*1000;  //超时时间

        private Thread downloadThread;



        public int GetInterfaceSafetyOptions(ref Guid riid, ref int pdwSupportedOptions, ref int pdwEnabledOptions)
        {
            int Rslt = E_FAIL;

            string strGUID = riid.ToString("B");
            pdwSupportedOptions = INTERFACESAFE_FOR_UNTRUSTED_CALLER | INTERFACESAFE_FOR_UNTRUSTED_DATA;
            switch (strGUID)
            {
                case _IID_IDispatch:
                case _IID_IDispatchEx:
                    Rslt = S_OK;
                    pdwEnabledOptions = 0;
                    if (_fSafeForScripting == true)
                        pdwEnabledOptions = INTERFACESAFE_FOR_UNTRUSTED_CALLER;
                    break;
                case _IID_IPersistStorage:
                case _IID_IPersistStream:
                case _IID_IPersistPropertyBag:
                    Rslt = S_OK;
                    pdwEnabledOptions = 0;
                    if (_fSafeForInitializing == true)
                        pdwEnabledOptions = INTERFACESAFE_FOR_UNTRUSTED_DATA;
                    break;
                default:
                    Rslt = E_NOINTERFACE;
                    break;
            }

            return Rslt;
        }

        public int SetInterfaceSafetyOptions(ref Guid riid, int dwOptionSetMask, int dwEnabledOptions)
        {
            int Rslt = E_FAIL;
            string strGUID = riid.ToString("B");
            switch (strGUID)
            {
                case _IID_IDispatch:
                case _IID_IDispatchEx:
                    if (((dwEnabledOptions & dwOptionSetMask) == INTERFACESAFE_FOR_UNTRUSTED_CALLER) && (_fSafeForScripting == true))
                        Rslt = S_OK;
                    break;
                case _IID_IPersistStorage:
                case _IID_IPersistStream:
                case _IID_IPersistPropertyBag:
                    if (((dwEnabledOptions & dwOptionSetMask) == INTERFACESAFE_FOR_UNTRUSTED_DATA) && (_fSafeForInitializing == true))
                        Rslt = S_OK;
                    break;
                default:
                    Rslt = E_NOINTERFACE;
                    break;
            }

            return Rslt;
        }

        #endregion

        public UserControl1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            MessageBox.Show("Click!!!!");
        }
        //启动下载
        public int StartDown()
        {
            log("开始下载");
            this.done = false;
            this.percent = 0;
            this.fileLength = 0;

            this.downLength = 0;//已经下载文件大小，外面想用就改成公共属性 
            this.percent = 0;
            this.failed = false;

            stopDown = false;
           
            //检查文件是否存在
            if (File.Exists(this.path))
            {
                log("the file is existed "+this.path);
                string oldCode = GetMd5Code(this.path);

                //MD5码校验
                if (null != oldCode && oldCode.Length != 0)
                {
                     log("server code " + this.md5Code);
                    log("local code " + oldCode);
                    if (this.md5Code == oldCode)
                    {
  
                        this.done = true;
                        this.stopDown = true;

                        return 2;
                    }
                    else
                    {
                        log("the md code is not same");
                    }
                }
                else
                {
                    log("local code is empty");
                }

            }
            else
            {
                log("file is not exist");
            }
            log("to start thread");
            ThreadStart ts = new ThreadStart(down);
             downloadThread = new Thread(ts);
            downloadThread.Start();
          
            return 2;
        }

        public void down()
        {

 
            ProgressBar progressBar = new ProgressBar();
            httpDownFile(this.url, this.path, progressBar);
        }


        public void httpDownFile(string url, string fileName, ProgressBar progressBar)
        {

            Label lable = new Label();

   
            httpDownFile(url, fileName, progressBar, lable);

            lable.Dispose();

        }


        //获取文件的的MD5码值
        public string GetMd5Code(String fileName)
        {

            string code = "";
            try
           {
                 FileStream file = new FileStream(fileName, FileMode.Open);
                 System.Security.Cryptography.MD5 md5 = new System.Security.Cryptography.MD5CryptoServiceProvider();
                 byte[] retVal = md5.ComputeHash(file);
                 file.Close();
 
                StringBuilder sb = new StringBuilder();
                 for (int i = 0; i < retVal.Length; i++)
                 {
                 sb.Append(retVal[i].ToString("x2"));
                 }
                 code = sb.ToString();
           }
           catch (Exception ex)
           {
                  log("GetMD5HashFromFile() fail,error:" + ex.Message);
           }
         return code;

        }

        ///   <summary> 

        ///   文件下载 

        ///   </summary> 

        ///   <param   name= "url "> 连接 </param> 

        ///   <param   name= "fileName "> 本地保存文件名 </param> 

        ///   <param   name= "progressBar "> 进度条 </param> 

        ///   <param   name= "label "> 返回已经下载的百分比 </param> 

        public string httpDownFile(string url, string fileName, ProgressBar progressBar, Label label)
        {

            string strState = "No";

            stopDown = false;

            Stream str = null, fs = null;
            log("down thread start.the url is " + url);
            try
            {

                //获取下载文件长度 

                fileLength = getDownLength(url);

                downLength = 0;

                if (fileLength > 0)
                {
                    log("get the file length " + fileLength);
                    MyWebClient DownFile = new MyWebClient(this.time_out);
                  
                    str = DownFile.OpenRead(url);

                    //判断并建立文件 

                    if (createFile(fileName))
                    {

                        byte[] mbyte = new byte[1024];

                        int readL = str.Read(mbyte, 0, 1024);

                        fs = new FileStream(fileName, FileMode.OpenOrCreate, FileAccess.Write);

                        //读取流 

                        while (readL != 0)
                        {

                            if (stopDown)
                            {
                                break;
                            }

                            downLength += readL;//已经下载大小 

                            fs.Write(mbyte, 0, readL);//写文件 

                            readL = str.Read(mbyte, 0, 1024);//读流 

                            progressBar.Value = (int)(downLength * 100 / fileLength);

                            label.Text = progressBar.Value.ToString() + "% ";
                            percent = progressBar.Value;

                            Application.DoEvents();

                            strState = "OK";

                        }
                        this.done = true;

                        str.Close();

                        fs.Close();

                    }
                    else
                    {

                        MessageBox.Show("文件目录创建失败：" + fileName  + "本地磁盘" + "不存在或者对目录没有写权限");
                        this.failed = true;
                    }


                }
                else
                {
                    MessageBox.Show("服务器连接失败,远程文件不存在");
                    this.failed = true;
                }


            }

            catch (Exception ex)
            {

                if (str != null)

                    str.Close();

                if (fs != null)

                    fs.Close();
                if (!stopDown)
                {
                    MessageBox.Show("下载被中断");
                }
                else
                {
                    MessageBox.Show("下载被中断");
                }
               
                this.failed = true;
                log("下载失败" + ex.Message);
 

            }
            stopDown = true;

            return strState;

        }



        ///   <summary> 

        ///   文件下载 

        ///   </summary> 

        ///   <param   name= "url "> 连接 </param> 

        ///   <param   name= "fileName "> 本地保存文件名 </param> 

        public void httpDownFile(string url, string fileName)
        {

            try
            {

                MyWebClient DownFile = new MyWebClient(this.time_out);

                DownFile.DownloadFile(url, fileName);

            }

            catch (Exception  ex)
            {

                if (this.debug)
                {
                    MessageBox.Show(ex.Message);
                }

            }

        }



        ///   <summary> 

        ///   获取下载文件大小 

        ///   </summary> 

        ///   <param   name= "url "> 连接 </param> 

        ///   <returns> 文件长度 </returns> 

        private long getDownLength(string url)
        {
            WebRequest wrq = null;
            WebResponse wrp = null;
            try
            {
                
                 wrq = WebRequest.Create(url);
                wrq.Timeout = this.time_out * 1000;
                wrp = (WebResponse)wrq.GetResponse();

                wrp.Close();

                return wrp.ContentLength;

            }
            catch (Exception ex)
            {

                log("can not get the lenggth from remote web site, the url is " + url);
                log("the exception is "+ex.StackTrace);
                if (null != wrq)
                {
                    try
                    {
                        wrp.Close();
                    }
                    catch(Exception e)
                    {
                        log(e.Message);
                    }
                    
                }
               

                return 0;

            }

        }
        private void log(string log)
        {
            if(this.debug)
            {
                MessageBox.Show(log);
            }
        }


        ///   <summary> 

        ///   建立文件(文件如已经存在，删除重建) 

        ///   </summary> 

        ///   <param   name= "fileName "> 文件全名(包括保存目录) </pa

        ///   <returns> </returns> 

        private bool createFile(string fileName)
        {
            log("the create file is " + fileName);
            string filePath = System.IO.Path.GetDirectoryName(fileName);
            try
            {
                log("the file path is "+filePath);
                if (!Directory.Exists(filePath))
                {
                    log("the file path is not exist, so create it first");
                    Directory.CreateDirectory(filePath);
                }
             

                if (File.Exists(fileName))
                {
                    log("the file is existed,delete it " + fileName);
                    File.Delete(fileName);

                }

                Stream s = File.Create(fileName);

                s.Close();
                log("create file success");
                return true;

            }

            catch (Exception ex)
            {

                log("create file failed"+ex.Message);
                

                return false;

            }

        }


        /**中断下载**/
        public void CloseDown()
        {

            log("close down");
            stopDown = true;

            try
            {
                if (null != downloadThread)
                {
                    downloadThread.Abort();
                } 
            }
            catch(Exception e)
            {
                log("abort thread failed");
            }
            
        }
        public bool DownloadFile(string downLoadUrl, string saveFullName)
        {
            bool flagDown = false;
            System.Net.HttpWebRequest httpWebRequest = null;
            try
            {
                //根据url获取远程文件流
                httpWebRequest = (System.Net.HttpWebRequest)System.Net.HttpWebRequest.Create(downLoadUrl);

                System.Net.HttpWebResponse httpWebResponse = (System.Net.HttpWebResponse)httpWebRequest.GetResponse();
                System.IO.Stream sr = httpWebResponse.GetResponseStream();

                //创建本地文件写入流
                System.IO.Stream sw = new System.IO.FileStream(saveFullName, System.IO.FileMode.Create);

                long totalDownloadedByte = 0;
                byte[] by = new byte[1024];
                int osize = sr.Read(by, 0, (int)by.Length);
                while (osize > 0)
                {
                    totalDownloadedByte = osize + totalDownloadedByte;
                    sw.Write(by, 0, osize);
                    osize = sr.Read(by, 0, (int)by.Length);
                }
                System.Threading.Thread.Sleep(100);
                flagDown = true;
                sw.Close();
                sr.Close();
            }
            catch (System.Exception)
            {
                if (httpWebRequest != null)
                    httpWebRequest.Abort();
            }
            return flagDown;
        }
    }
}

