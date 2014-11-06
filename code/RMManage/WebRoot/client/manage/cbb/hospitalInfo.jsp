<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<input id="currentUser" value="${loginUser.userName}" style="display:none;"/>
<input id="targetUser" value="${hospitalModel.hospital.id}" style="display:none;"/>
<input id="operateType" value="${operateType}" style="display:none;"/>
<script type="text/javascript">

    
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
		<div class="pageFormContent" layoutH="56">

			<dl style="width:50%;">
				<dt>医院账号：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.id"  alt="" size="50" readonly="true" value="${hospitalModel.hospital.id}"/></dd>
			</dl>		
			<dl style="width:50%;">
				<dt>医院名称：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.name" class="required " maxlength="64" size="50" value="${hospitalModel.hospital.name}" /></dd>
			</dl>			
			<dl style="width:50%;">
				<dt>医院地址：</dt>
				<dd style="width:70%;">
				
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
			
			<dl style="width:50%;">
				<dt>详细地址：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.address"  maxlength="255" size="50" value="${hospitalModel.hospital.address}"/></dd>
			</dl>

			<dl style="width:50%;">
				<dt>医院规模：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.rank"  maxlength="32" size="50" value="${hospitalModel.hospital.rank}"/></dd>
			</dl>			

			<dl style="width:50%;">
				<dt>联系方式：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contactWay"  maxlength="32" size="50" value="${hospitalModel.hospital.contactWay}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>联系人：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contacts"  maxlength="64" size="50" value="${hospitalModel.hospital.contacts}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>医院电话：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.hospitalPhone"  maxlength="16" size="50" value="${hospitalModel.hospital.contactsPhone}"/></dd>
			</dl>
			<div class="divider"></div>
			<dl style="width:100%;height:50px;">
				<dt >联系电话：</dt>			
				<dd style="width:85%;">
				<textarea name="hospitalModel.hospital.contactsPhone"  cols="100" rows="3" maxlength="255" class="phonelist">${hospitalModel.hospital.hospitalPhone}</textarea>
				<span class="info" style="float:right;">*以英文分号隔开，不超过10个号码</span>
				</dd>
			</dl>

				<dl class="nowrap">
					<dt >医院简介：</dt>
					<dd ><textarea name="hospitalModel.hospital.resume" cols="100" rows="7" maxlength="800">${hospitalModel.hospital.resume}</textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt >医院描述：</dt>
					<dd ><textarea name="hospitalModel.hospital.remark" cols="100" rows="7" maxlength="800">${hospitalModel.hospital.remark}</textarea></dd>
				</dl>			
			
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
							<c:when test="${hospitalModel.hospital.state =='已创建'}">
								<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSubmit" value="提 交 " cssClass="mispButton primary"></s:submit></li>	
							</c:when>
							<c:otherwise>
								<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit></li>
							</c:otherwise>
						
						</c:choose>
							<c:choose>
								<c:when test="${loginUser.accountType==2}">
									<li><input type="button" class="mispButton primary close" value="关 闭"/></li>
								</c:when>
								<c:otherwise>
									<li><s:submit method="cancel" value="返 回" cssClass="mispButton primary"></s:submit></li>
								</c:otherwise>
							</c:choose>							
					</c:otherwise>
						
				</c:choose>			

				
			</ul>
		</div>
	</s:form>
</div>
