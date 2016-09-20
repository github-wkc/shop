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
										订单编号
									</td>
									<td align="center" width="15%">
										总金额
									</td>
									<td align="center" width="15%">
										收货人
									</td>
									<td align="center" width="25%">
										收货地址
									</td>
									<td align="center" width="8%">
										联系电话
									</td>
									<td align="center" width="8%">
										订单状态
									</td>
									<td width="7%" align="center">
										订单详情
									</td>
								</tr>
								<s:iterator var="order" value="pagebean.list" status="status">
										<tr onmouseover="this.style.backgroundColor = 'white'"
											onmouseout="this.style.backgroundColor = '#F5FAFE';">
											<td HEIGHT: 22px" align="center"
												>
												<s:property value="#status.count"/>
											</td>
											<td style=" HEIGHT: 22px" align="center">
												<s:property value="#order.oid"/>
											</td>
											<td style=" HEIGHT: 22px" align="center"
												>
												<s:property value="#order.total"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:property value="#order.name"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:property value="#order.addr"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:property value="#order.phone"/>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<s:if test="#order.state == 1">
													未付款													
												</s:if>
												<s:if test="#order.state == 2">
													已付款
												</s:if>
												<s:if test="#order.state == 3">
													已发货
												</s:if>
												<s:if test="#order.state == 4">
													交易完毕
												</s:if>
											</td>
											<td align="center" style="HEIGHT: 22px">
												<a href="${pageContext.request.contextPath }/adminOrder_findDetails.action?oid=<s:property value="#order.oid"/>">订单详情</a>
											</td>
									</s:iterator>	
							</table>
							<div>
							<span>共<s:property value="pagebean.totalRecord"/>订单</span>
							<span>共<s:property value="pagebean.totalPage"/>页</span>
						<s:if test="pagebean.currentPage != 1">
							<a class="firstPage" href="${pageContext.request.contextPath }/adminOrder_findAllByPage.action?currentPage=1">首页</a>
								
							<a class="previousPage" href="${pageContext.request.contextPath }/adminOrder_findAllByPage.action?currentPage=<s:property value="pagebean.currentPage - 1"/>">上一页</a>
						</s:if>
							<a class="currentPage" href="#"><s:property value="pagebean.currentPage"/></a>
						<s:if test="pagebean.currentPage != pagebean.totalPage">		
							<a class="nextPage" href="${pageContext.request.contextPath }/adminOrder_findAllByPage.action?currentPage=<s:property value="pagebean.currentPage+1"/>">下一页</a>
							
							<a class="lastPage" href="${pageContext.request.contextPath }/adminOrder_findAllByPage.action?currentPage=<s:property value="pagebean.totalPage"/>">尾页</a>
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

