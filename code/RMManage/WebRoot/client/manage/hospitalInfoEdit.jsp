<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>


<div class="pageContent">
	<s:form method="post" name="hsForm" action="user/HospitalManage" class="pageForm required-validate" onsubmit="return iframeCallback(this);"  >
	
		<div class="pageFormContent" layoutH="56">

			<dl>
				<dt>医院编号：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.id"  alt="" size="30" readonly="true" value="${hospitalModel.hospital.id}"/></dd>
			</dl>		
			<dl>
				<dt>医院名称：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.name"  alt="" size="30" value="${hospitalModel.hospital.name}"/></dd>
			</dl>			
			<dl style="width:100%;">
				<dt>医院地址：</dt>
				<dd style="width:70%;"><input type="hidden" id="currentProvince" value="${hospitalModel.hospital.province}"/>
				<input type="hidden" id="currentCity" value="${hospitalModel.hospital.city}"/>
				<input type="hidden" id="currentCounty" value="${hospitalModel.hospital.county}"/>

				<select id="editProvince" name="hospitalModel.hospital.province" style="margin-left:0px;"></select>
				<select id="editCity" name="hospitalModel.hospital.city"></select>
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


			<dl>
				<dt>医院规模：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.rank"  alt="" size="30" value="${hospitalModel.hospital.rank}"/></dd>
			</dl>			
			<dl>
				<dt>医院电话：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.hospitalPhone"  alt="" size="30" value="${hospitalModel.hospital.hospitalPhone}"/></dd>
			</dl>
			<dl>
				<dt>联系方式：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contactWay"  alt="" size="30" value="${hospitalModel.hospital.contactWay}"/></dd>
			</dl>
			<dl>
				<dt>联系人：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contacts"  alt="" size="30" value="${hospitalModel.hospital.contacts}"/></dd>
			</dl>
			<dl>
				<dt>联系电话：</dt>			
				<dd><input type="text" name="hospitalModel.hospital.contactsPhone"  alt="" size="30" value="${hospitalModel.hospital.contactsPhone}"/></dd>
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

				<li style="padding:0px 30px 0px 10px;"><s:submit method="infoSave" value="保 存" cssClass="mispButton primary"></s:submit></li>			
				<li><input type="button" class="mispButton primary close" value="关 闭" /></li>
				
			</ul>
		</div>
	</s:form>
</div>
