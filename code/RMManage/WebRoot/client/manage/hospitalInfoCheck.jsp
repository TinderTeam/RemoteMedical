<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
%>

<input id="currentUser" value="${loginUser.userName}" style="display:none;"/>
<input id="targetUser" value="${hospitalModel.hospital.id}" style="display:none;"/>
<script type="text/javascript">

   $(function () 
    {

        var text_width=$("#textW").width();
        //alert(text_width);
        $(".field").width(text_width+120 + "px");
        
        });

   		 $('input,textarea',$('form[name=hsForm2]')).prop('readonly',true);
		 $("select").prop('disabled', true);
 
function submitHsForm2(url){
    var thisForm = document.hsForm2;
	thisForm.action="user/HospitalManage!"+url;
	return iframeCallback(thisForm,navTabAjaxDone);
	
}		   
</script>

<div class="pageContent">
	<s:form method="post" name="hsForm2" action="user/HospitalManage" class="pageForm required-validate"  >
		<input type="text" name="selectedID" value="${selectedID}"  style="display:none;"/>	
		
		<input type="text" name="hospitalModel.hospital.state" value="${hospitalModel.hospital.state}"  style="display:none;"/>
		<div class="pageFormContent" layoutH="56" style="padding:0px 20px 20px 80px;">
	<fieldset style="margin-top:20px;" class="field">
		<legend>关键信息</legend>
		 <div style="height:180px;overflow:hidden !important;" class="pageFormContent nowrap"  >
			<dl style="width:45%;clear:none;">
				<dt style="width:20% ">医院账号：</dt>			
				<dd style="width:75% "><input type="text" name="hospitalModel.hospital.id"  alt="" size="30" readonly="readonly" value="${hospitalModel.hospital.id}"/>
				</dd>
			</dl>		
			<dl style="width:45%;clear:none;">
				<dt style="width:20% ">医院名称：</dt>			
				<dd style="width:75% "><input type="text" name="hospitalModel.hospital.name" class="required " maxlength="64" size="30" value="${hospitalModel.hospital.name}" />
				</dd>
			</dl>			
			<dl class="nowrap">
				<dt style="width:9% ">医院地址：</dt>
				<dd>
				<input type="hidden" id="currentCProvince" value="${hospitalModel.hospital.province}"/>
				<input type="hidden" id="currentCCity" value="${hospitalModel.hospital.city}"/>
				<input type="hidden" id="currentCCounty" value="${hospitalModel.hospital.county}"/>

				<select id="editCProvince" name="hospitalModel.hospital.province" style="margin-left:0px;"></select>
				<select id="editCCity" name="hospitalModel.hospital.city" ></select>
				<select id="editCArea" name="hospitalModel.hospital.county"></select>

				<script type="text/javascript">
					addressInit('editCProvince', 'editCCity', 'editCArea', document.getElementById("currentCProvince").value, document.getElementById("currentCCity").value, document.getElementById("currentCCounty").value);
	
				</script>
				</dd>
			</dl>
			
			<dl class="nowrap">
				<dt style="width:9% ">详细地址：</dt>			
				<dd ><input type="text" name="hospitalModel.hospital.address"  maxlength="255" size="93" value="${hospitalModel.hospital.address}"/>
				</dd>
			</dl>

			<dl style="width:45%;clear:none;">
				<dt style="width:20% ">医院规模：</dt>			
				<dd style="width:75% "><input type="text" name="hospitalModel.hospital.rank"  maxlength="32" size="30" value="${hospitalModel.hospital.rank}"/>
				</dd>
			</dl>			

			<dl style="width:45%;clear:none;">
				<dt style="width:20% ">联系方式：</dt>			
				<dd style="width:75% "><input type="text" name="hospitalModel.hospital.contactWay"  maxlength="32" size="30" value="${hospitalModel.hospital.contactWay}"/>
				</dd>
			</dl>
			<dl style="width:45%;clear:none;">
				<dt style="width:20% ">联系人：</dt>			
				<dd style="width:75% "><input type="text" name="hospitalModel.hospital.contacts"  maxlength="64" size="30" value="${hospitalModel.hospital.contacts}"/>
				</dd>
			</dl>
			<dl style="width:45%;clear:none;">
				<dt style="width:20% ">医院电话：</dt>			
				<dd style="width:75% "><input type="text" name="hospitalModel.hospital.hospitalPhone" class="telephone" maxlength="16" size="30" value="${hospitalModel.hospital.hospitalPhone}"/>
				</dd>
			</dl>
			</div>
	</fieldset>
	<fieldset style="margin-top:20px;margin-bottom:40px;" class="field">
		<legend>扩展描述</legend>	
		<div style="height:350px;overflow:hidden !important;" class="pageFormContent nowrap"  >
			<dl class="nowrap">
				<dt  style="width:9% ">联系电话：</dt>			
				<dd >
				<textarea name="hospitalModel.hospital.contactsPhone"  cols="100" rows="3" maxlength="255" class="phonelist required" id="textW">${hospitalModel.hospital.contactsPhone}</textarea>
				<span class="info" >*以英文分号隔开，不超过10个号码</span>
				</dd>
			</dl>

				<dl class="nowrap">
					<dt style="width:9% " >医院简介：</dt>
					<dd ><textarea name="hospitalModel.hospital.resume" cols="100" rows="7" maxlength="2000">${hospitalModel.hospital.resume}</textarea>
					<span class="info" >*输入不超过2000个字符</span>
					</dd>
				</dl>
				<dl class="nowrap">
					<dt  style="width:9% ">医院描述：</dt>
					<dd ><textarea name="hospitalModel.hospital.remark" cols="100" rows="7" maxlength="2000">${hospitalModel.hospital.remark}</textarea>
					<span class="info" >*输入不超过2000个字符</span>
					</dd>
				</dl>	
		</div>		
	</fieldset>		
		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:40%" >

				<li style="padding:0px 30px 0px 10px;">
				<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitHsForm2('applyAgree')">同 意</button></div></div>
				</li>
				<li style="padding:0px 30px 0px 10px;">
						<div class="buttonActive"><div class="buttonContent"><button type="submit" onclick="submitHsForm2('applyRefuse')">拒 绝</button></div></div>
				</li>

			</ul>
		</div>
	</s:form>
</div>