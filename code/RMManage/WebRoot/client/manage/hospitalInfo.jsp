<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>

<script type="text/javascript">
function submitForm(url){
    var thisForm = document.hsForm;
	thisForm.action="user/HospitalManage!"+url;
	return validateCallback(thisForm,navTabAjaxDone);
}
</script>

<div class="pageContent">
	<s:form method="post" name="hsForm" action="user/HospitalManage" class="pageForm required-validate"  >
		<div class="pageFormContent" layoutH="56">

	
		
		
			<p>
				<label>医院编号：</label>			
				<input type="text" name="hospitalModel.hospital.id"  alt="" size="30" readonly="true" value="${hospitalModel.hospital.id}"/>
			</p>		
			<p>
				<label>医院名称：</label>			
				<input type="text" name="hospitalModel.hospital.name"  alt="" size="30" value="${hospitalModel.hospital.name}"/>

		

			</p>			
			<p style="width:800px !important;">
				<label>医院地址：</label>
				<input type="hidden" id="currentProvince" value="${hospitalModel.hospital.province}"/>
				<input type="hidden" id="currentCity" value="${hospitalModel.hospital.city}"/>
				<input type="hidden" id="currentCounty" value="${hospitalModel.hospital.county}"/>

				<select id="cmbProvince" name="hospitalModel.hospital.province" style="margin-left:0px;"></select>
				<select id="cmbCity" name="hospitalModel.hospital.city"></select>
				<select id="cmbArea" name="hospitalModel.hospital.county"></select>

				<script type="text/javascript">
					addressInit('cmbProvince', 'cmbCity', 'cmbArea', document.getElementById("currentProvince").value, document.getElementById("currentCity").value, document.getElementById("currentCounty").value);
	
				</script>


				

			</p>

				<dl style="height:20px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >详细地址：</dt>
					<dd style="float:left !important;padding-left:6px !important;"><textarea name="hospitalModel.hospital.address" cols="95" rows="1" style="text-align:left;">${hospitalModel.hospital.address}</textarea></dd>
				</dl>				


			<p>
				<label>医院规模：</label>			
				<input type="text" name="hospitalModel.hospital.rank"  alt="" size="30" value="${hospitalModel.hospital.rank}"/>
			</p>			
			<p>
				<label>医院电话：</label>			
				<input type="text" name="hospitalModel.hospital.hospitalPhone"  alt="" size="30" value="${hospitalModel.hospital.hospitalPhone}"/>
			</p>
			<p>
				<label>联系方式：</label>			
				<input type="text" name="hospitalModel.hospital.contactWay"  alt="" size="30" value="${hospitalModel.hospital.contactWay}"/>
			</p>
			<p>
				<label>联系人：</label>			
				<input type="text" name="hospitalModel.hospital.contacts"  alt="" size="30" value="${hospitalModel.hospital.contacts}"/>
			</p>
			<p>
				<label>联系电话：</label>			
				<input type="text" name="hospitalModel.hospital.contactsPhone"  alt="" size="30" value="${hospitalModel.hospital.contactsPhone}"/>
			</p>
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >医院简介：</dt>
					<dd style="float:left !important;padding-left:6px !important;"><textarea name="hospitalModel.hospital.resume" cols="95" rows="7" >${hospitalModel.hospital.resume}</textarea></dd>
				</dl>
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >医院描述：</dt>
					<dd style="float:left !important;padding-left:6px !important;"><textarea name="hospitalModel.hospital.remark" cols="95" rows="7" >${hospitalModel.hospital.remark}</textarea></dd>
				</dl>			
			
		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >
				<li style="padding:0px 30px 0px 10px;"><div class="buttonContent"><input type="button"  value="保 存" onclick="submitForm('modify')"/></div></li>
				<li><div class="buttonContent"><input type="button"  value="取 消" onclick="submitForm('cancel')"/></div></li>
			</ul>
		</div>
	</s:form>
</div>
