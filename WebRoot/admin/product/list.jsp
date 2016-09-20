<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="${pageContext.request.contextPath}/css/Style1.css" rel="stylesheet" type="text/css" />
		
		<script language="javascript" src="${pageContext.request.contextPath}/js/public.js"></script>
		<script type="text/javascript">
		//	function addUser(){
		//		window.location.href = "${pageContext.request.contextPath}/admin/category/add.jsp";
		//	}
		function addProduct(){
			window.location.href="${pageContext.request.contextPath}/adminProduct_addPage.action";
		}
		</script>
	</HEAD>
	<body>
		<br>
		<form id="Form1" name="Form1" action="${pageContext.request.contextPath}/user/list.jsp" method="post">
			<table cellSpacing="1" cellPadding="0" width="100%" align="center" bgColor="#f5fafe" border="0">
				<TBODY>
					<tr>
						<td class="ta_01" align="center" bgColor="#afd1f3">
							<strong>商品 列 表</strong>
						</TD>
					</tr>
					<tr>
						<td class="ta_01" align="right">
							<button type="button" id="add" name="add" value="添加" class="button_add" onclick="addProduct()">
&#28155;&#21152;
</button>

						</td>
					</tr>
					<tr>
						<td class="ta_01" align="center" bgColor="#f5fafe">
							<table cellspacing="0" cellpadding="1" rules="all"
								bordercolor="gray" border="1" id="DataGrid1"
								style="BORDER-RIGHT: gray 1px solid; BORDER-TOP: gray 1px solid; BORDER-LEFT: gray 1px solid; WIDTH: 100%; WORD-BREAK: break-all; BORDER-BOTTOM: gray 1px solid; BORDER-COLLAPSE: collapse; BACKGROUND-COLOR: #f5fafe; WORD-WRAP: break-word">
								<tr
									style="FONT-WEIGHT: bold; FONT-SIZE: 12pt; HEIGHT: 25px; BACKGROUND-COLOR: #afd1f3">

									<td align="center" width="8%">
										序号
									</td>
									<td align="center" width="15%">
										商品图片
									</td>
									<td align="center" width="15%">
										商品名称
									</td>
									<td align="center" width="30%">
										商品描述
									</td>
									<td align="center" width="8%">
										商品价格
									</td>
									<td align="center" width="8%">
										是否热卖
									</td>
									<td width="7%" align="center">
										编辑
									</td>
									<td width="7%" align="center">
										删除
									</td>
								</tr>
								<s:iterator var="p" value="pagebean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<s:property value="#status.count"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<img style="height:80px; width:80px"   src="${pageContext.request.contextPath }/<s:property value="#p.image"/>"/>
											</td>
											<td style="CURSOR: hand; HEIGHT: 22px" align="center"
												>
												<s:property value="#p.pname"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:property value="#p.pdesc"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:property value="#p.shop_price"/>
											</td>
											
											<s:if test="#p.is_hot == 1">
											<td align="center" style="HEIGHT: 22px">
												热卖
											</td>
											</s:if>
											<s:else>
												<td align="center" style="HEIGHT: 22px">
													不热卖
												</td>
											</s:else>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/adminProduct_editPage.action?pid=<s:property value="#p.pid"/>">
													<img src="${pageContext.request.contextPath}/images/i_edit.gif" border="0" style="CURSOR: hand">
												</a>
											</td>
									
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath}/adminProduct_delete.action?pid=<s:property value="#p.pid"/>">
													<img src="${pageContext.request.contextPath}/images/i_del.gif" width="16" height="16" border="0" style="CURSOR: hand">
												</a>
											</td>
										</tr>
									</s:iterator>	
							</table>
							<div>
							<span>共<s:property value="pagebean.totalPage"/>页</span>
						<s:if test="pagebean.currentPage != 1">
							<a class="firstPage" href="${pageContext.request.contextPath }/adminProduct_findAllByPage.action?currentPage=1">首页</a>
								
							<a class="previousPage" href="${pageContext.request.contextPath }/adminProduct_findAllByPage.action?currentPage=<s:property value="pagebean.currentPage - 1"/>">上一页</a>
						</s:if>
							<a class="currentPage" href="#"><s:property value="pagebean.currentPage"/></a>
						<s:if test="pagebean.currentPage != pagebean.totalPage">		
							<a class="nextPage" href="${pageContext.request.contextPath }/adminProduct_findAllByPage.action?currentPage=<s:property value="pagebean.currentPage+1"/>">下一页</a>
							
							<a class="lastPage" href="${pageContext.request.contextPath }/adminProduct_findAllByPage.action?currentPage=<s:property value="pagebean.totalPage"/>">尾页</a>
						</s:if>
					</div>
						</td>
					</tr>
					<tr>
						
				</tr>
				</TBODY>
			</table>
		</form>
	</body>
</HTML>

