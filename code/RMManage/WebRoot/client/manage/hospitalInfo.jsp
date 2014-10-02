<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="s" uri="/struts-tags"%>



<div class="pageContent">
	<s:form method="post" action="user/HospitalManage" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);" >
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
				<select class="combox" name="hospitalModel.hospital.province" ref="w_combox_city" refUrl="demo/combox/city_{value}.html"  >
					<c:choose>  
     						<c:when test="${hospitalModel.hospital.province!=null}">   
   							 <option value="${hospitalModel.hospital.province}" selected="selected">${hospitalModel.hospital.province}</option>
   						</c:when>  
     
  					    <c:otherwise>  
  					    	<option value="all">所在省市</option> 
                        </c:otherwise>  
                    </c:choose>
					<option value="bj">北京</option>
					<option value="sh">上海</option>
				</select>
				<select class="combox" name="hospitalModel.hospital.city" id="w_combox_city" ref="w_combox_area" refUrl="demo/combox/area_{value}.html"  >
					<c:choose>  
     					<c:when test="${hospitalModel.hospital.city!=null}">   
   							 <option value="${hospitalModel.hospital.city}" selected="selected">${hospitalModel.hospital.city}</option>
   						</c:when>  
     
  					    <c:otherwise>  
  					    	<option value="all">所在城市</option> 
                        </c:otherwise>  
                    </c:choose>					
					
				</select>
				<select class="combox" name="hospitalModel.hospital.county" id="w_combox_area" >
					<c:choose>  
     					<c:when test="${hospitalModel.hospital.county!=null}">   
   							 <option value="${hospitalModel.hospital.county}" selected="selected">${hospitalModel.hospital.county}</option>
   						</c:when>  
     
  					    <c:otherwise>  
  					    	<option value="all">所在区县</option>
                        </c:otherwise>  
                    </c:choose>				
					
				</select>			
				

			</p>

				<dl style="height:20px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >详细地址：</dt>
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="hospitalModel.hospital.address" cols="95" rows="1" >${hospitalModel.hospital.address}</textarea></dd>
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
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="hospitalModel.hospital.resume" cols="95" rows="7" >${hospitalModel.hospital.resume}</textarea></dd>
				</dl>
				<dl style="height:110px !important;width:100%;">
					<dt style="text-align:left;width:10%;" >医院描述：</dt>
					<dd style="float:left !important;padding-left:7px !important;"><textarea name="hospitalModel.hospital.remark" cols="95" rows="7" >${hospitalModel.hospital.remark}</textarea></dd>
				</dl>			
			
		</div>
		<div class="formBar" >
			<ul style="float:none!important;margin-left:35%" >
				<li style="padding:0px 30px 0px 10px;"><s:submit value="保 存"  /></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取 消</button></div></div></li>
			</ul>
		</div>
	</s:form>
</div>
