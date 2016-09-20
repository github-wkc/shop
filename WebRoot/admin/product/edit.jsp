<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminProduct_edit.action" method="post" enctype="multipart/form-data">
			<input type="hidden" name="pid" value="<s:property value="model.pid"/>"/>
			<input type="hidden" name="image" value="<s:property value="model.image"/>"/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<strong><STRONG>编辑产品</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td width="20%" class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="pname" value="<s:property value="model.pname"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td width="20%" bgColor="#ffffff" colspan="3">
						<input type="text" name="market_price" value="<s:property value="model.market_price"/>" id="userAction_save_do_logonName" class="bg" />
					</td>
				</tr>
				<tr>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						店铺价格：
					</td>
					<td width="20%" class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="shop_price" value="<s:property value="model.shop_price"/>" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热销：
					</td>
					<td width="20%" bgColor="#ffffff" colspan="3">
						<select name="is_hot">
							<option value="1"  <s:if test="model.is_hot == 1">selected="selected"</s:if>>是</option>
							<option value="0" <s:if test="model.is_hot == 0">selected="selected"</s:if>>否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td width="20%" class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="pdesc"  rows="10px" cols="40px"><s:property value="model.pdesc"/></textarea> 
					</td>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						重新上传图片：
					</td>
					<td width="20%" bgColor="#ffffff" colspan="3">
						<input type="file" name="upload" value=""/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属二级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="categorysecond.csid">
							<s:iterator value="cslist" var="cs">
								<s:if test="model.categorysecond.csid == #cs.csid">
									<option selected="selected"   value="<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></option>
								</s:if>
								<s:else>
									<option value="<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></option>
								</s:else>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>