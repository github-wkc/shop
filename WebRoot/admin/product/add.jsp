<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
	</HEAD>
	
	<body>
		<form id="userAction_save_do" name="Form1" action="${pageContext.request.contextPath}/adminProduct_save.action" method="post" enctype="multipart/form-data">
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="8"
						height="26">
						<strong><STRONG>商品分类</STRONG>
						</strong>
					</td>
				</tr>

				<tr>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						商品名称：
					</td>
					<td width="20%" class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="pname" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						市场价格：
					</td>
					<td width="20%" bgColor="#ffffff" colspan="3">
						<input type="text" name="market_price" value="" id="userAction_save_do_logonName" class="bg" />
					</td>
				</tr>
				<tr>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						店铺价格：
					</td>
					<td width="20%" class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="shop_price" value="" id="userAction_save_do_logonName" class="bg"/>
					</td>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						是否热销：
					</td>
					<td width="20%" bgColor="#ffffff" colspan="3">
						<select name="is_hot">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</td>
				</tr>
				<tr>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						商品描述：
					</td>
					<td width="20%" class="ta_01" bgColor="#ffffff" colspan="3">
						<textarea name="pdesc"  rows="10px" cols="40px"></textarea> 
					</td>
					<td width="20%" align="center" bgColor="#f5fafe" class="ta_01">
						图片上传：
					</td>
					<td width="20%" bgColor="#ffffff" colspan="3">
					<%-- 	<input type="text" name="is_hot" value="" id="userAction_save_do_logonName" class="bg"/>--%>
						<input type="file" name="upload" value=""/>
					</td>
				</tr>
				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						所属的二级分类：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<select name="categorysecond.csid">
						<s:iterator value="list" var="cs">
							<option value="<s:property value="#cs.csid"/>"><s:property value="#cs.csname"/></option>
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