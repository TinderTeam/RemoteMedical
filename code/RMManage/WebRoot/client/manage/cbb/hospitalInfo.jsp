<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<input id="currentUser" value="${loginUser.userName}" style="display:none;"/>
<input id="targetUser" value="${hospitalModel.hospital.id}" style="display:none;"/>
<input id="operateType" value="${operateType}" style="display:none;"/>
<script type="text/javascript">

   $(function () 
    {

        var text_width=$("#textW").width();
        //alert(text_width);
        $(".field").width(text_width+120 + "px");
        
        });
    var operateType =$("#operateType").val();
    if(operateType=='check')
    {
   		 $('input,textarea',$('form[name=hsForm]')).prop('readonly',true);
		 $("select").prop('disabled', true);
    }
	
	   
</script>

<div class="pageContent">
	<s:form method="post" name="hsForm" action="user/HospitalManage" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);"  >
		<input type="text" name="selectedID" value="${selectedID}"  style="display:none;"/>	
		<input id="operateType" value="${operateType}" style="display:none;"/>
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
				<input type="hidden" id="currentProvince" value="${hospitalModel.hospital.province}"/>
				<input type="hidden" id="currentCity" value="${hospitalModel.hospital.city}"/>
				<input type="hidden" id="currentCounty" value="${hospitalModel.hospital.county}"/>

				<select id="editProvince" name="hospitalModel.hospital.province" style="margin-left:0px;"></select>
				<select id="editCity" name="hospitalModel.hospital.city" ></select>
				<select id="editArea" name="hospitalModel.hospital.county"></select>

				<script type="text/javascript">
					addressInit('editProvince', 'editCity', 'editArea', document.getElementById("currentProvince").value, document.getElementById("currentCity").value, document.getElementById("currentCounty").value);
	
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
				<c:choose>
					<c:when test="${operateType =='check'}">
						<li style="padding:0px 30px 0px 10px;"><s:submit method="applyAgree" value="同 意" cssClass="mispButton primary"></s:submit></li>
						<li style="padding:0px 30px 0px 10px;"><s:submit method="applyRefuse" value="拒 绝" cssClass="mispButton danger"></s:submit></li>						
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${hospitalModel.hospital.state ==0}"> 
								<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSubmit" value="提 交 " cssClass="mispButton primary"></s:submit></li>	
							</c:when>
							<c:otherwise>
								<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit></li>
							</c:otherwise>
						
						</c:choose>
						<li><s:submit method="cancel" value="返 回" cssClass="mispButton primary"></s:submit></li>
						
					</c:otherwise>
						
				</c:choose>			

				
			</ul>
		</div>
	</s:form>
</div>
