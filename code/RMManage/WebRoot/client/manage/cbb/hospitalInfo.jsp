<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<input id="currentUser" value="${loginUser.userName}" style="display:none;"/>
<input id="targetUser" value="${hospitalModel.hospital.id}" style="display:none;"/>
<script type="text/javascript">

    var currentUser =$("#currentUser").val();
    var targetUser =$("#targetUser").val();
    if(currentUser!=targetUser)
    {
   		 $('input,textarea',$('form[name=hsForm]')).prop('readonly',true);
		 $("select").prop('readonly', true);
    }
	
	   
</script>

<div class="pageContent">
	<s:form method="post" name="hsForm" action="user/HospitalManage" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);"  >
		<input type="text" name="selectedID" value="${selectedID}"  style="display:none;"/>	

		<div class="pageFormContent" layoutH="56">

			<dl style="width:50%;">
				<dt>医院账号：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.id"  alt="" size="50" readonly="true" value="${hospitalModel.hospital.id}"/></dd>
			</dl>		
			<dl style="width:50%;">
				<dt>医院名称：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.name"  alt="" size="50" value="${hospitalModel.hospital.name}" /></dd>
			</dl>			
			<dl style="width:100%;">
				<dt>医院地址：</dt>
				<dd style="width:70%;"><input type="hidden" id="currentProvince" value="${hospitalModel.hospital.province}"/>
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
					<dt>详细地址：</dt>
					<dd><textarea name="hospitalModel.hospital.address" cols="95" rows="1" style="text-align:left;">${hospitalModel.hospital.address}</textarea></dd>
				</dl>				


			<dl style="width:50%;">
				<dt>医院规模：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.rank"  alt="" size="50" value="${hospitalModel.hospital.rank}"/></dd>
			</dl>			
			<dl style="width:50%;">
				<dt>医院电话：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.hospitalPhone"  alt="" size="50" value="${hospitalModel.hospital.hospitalPhone}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>联系方式：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contactWay"  alt="" size="50" value="${hospitalModel.hospital.contactWay}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>联系人：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contacts"  alt="" size="50" value="${hospitalModel.hospital.contacts}"/></dd>
			</dl>
			<dl style="width:50%;">
				<dt>联系电话：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contactsPhone"  alt="" size="50" value="${hospitalModel.hospital.contactsPhone}"/></dd>
			</dl>
				<dl class="nowrap">
					<dt >医院简介：</dt>
					<dd ><textarea name="hospitalModel.hospital.resume" cols="95" rows="7" >${hospitalModel.hospital.resume}</textarea></dd>
				</dl>
				<dl class="nowrap">
					<dt >医院描述：</dt>
					<dd ><textarea name="hospitalModel.hospital.remark" cols="95" rows="7" >${hospitalModel.hospital.remark}</textarea></dd>
				</dl>			
			
		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >
			<c:choose>
				<c:when test="${loginUser.userName==hospitalModel.hospital.id}">
					<c:choose>
						<c:when test="${hospitalModel.hospital.state =='已创建'}">
							<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSubmit" value="提 交 " cssClass="mispButton primary"></s:submit></li>	
						</c:when>
						<c:otherwise>
							<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit></li>
						</c:otherwise>
					</c:choose>
							
					<li><input type="button" class="mispButton primary close" value="关 闭" /></li>
				</c:when>
				<c:otherwise>
					<li style="padding:0px 30px 0px 10px;"><s:submit method="applyAgree" value="同 意" cssClass="mispButton primary"></s:submit></li>
					<li style="padding:0px 30px 0px 10px;"><s:submit method="applyRefuse" value="拒 绝" cssClass="mispButton danger"></s:submit></li>				
				</c:otherwise>
			</c:choose>

				
			</ul>
		</div>
	</s:form>
</div>
