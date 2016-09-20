<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- saved from url=(0043)http://localhost:8080/mango/cart/list.jhtml -->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>购物车</title>

<link href="${pageContext.request.contextPath}/css/common.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/cart.css" rel="stylesheet" type="text/css"/>
<link href="${pageContext.request.contextPath}/css/product.css" rel="stylesheet" type="text/css"/>

</head>
<body>
<div class="container header">
	<div class="span5">
		<div class="logo">
			<a href="http://localhost:8080/mango/">
				<img src="${pageContext.request.contextPath}/image/r___________renleipic_01/logo.gif" alt="传智播客"/>
			</a>
		</div>
	</div>
	<div class="span9">
<div class="headerAd">
					<img src="${pageContext.request.contextPath}/image/header.jpg" width="320" height="50" alt="正品保障" title="正品保障"/>
</div>	</div>
	

	<%@ include file="menu.jsp" %>
	
</div>	<div class="container cart">
		<div class="span24">
			<div class="step step1">
				
			</div>
				<s:if test="pagebean.list.size() != 0"><%-- 判断items的为空     .size() ==0  如果是get/set方法 可以直接写.size --%>
				<table>
					<tbody>
					<s:iterator value="pagebean.list" var="order">
					<tr>
						<td colspan="5" >
						订单编号：<s:property value="#order.oid"/>
						订单状态：&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<s:if test="#order.state == 1 ">
							<font color="red">已经提交定单,还没有付款</font>	
						</s:if>
						<s:if test="#order.state == 2 ">
							<font color="red">已经付款，正在努力发货</font>	
						</s:if>
						<s:if test="#order.state == 3 ">
							<font color="red">已经发货</font>	
						</s:if>
						<s:if test="#order.state == 4 ">
							<font color="red">交易完毕</font>	
						</s:if>
						</td>
					</tr>	
					<tr>
						<th>图片</th>
						<th>商品</th>
						<th>价格</th>
						<th>数量</th>
						<th>小计</th>
					</tr>
					
						<s:iterator value="#order.orderItems" var="item">
						<tr>
							<td width="60">
								<input type="hidden" name="id" value="22"/>
								<img src="${pageContext.request.contextPath }/<s:property value="#item.product.image"/>"/>
							</td>
							<td>
								<a target="_blank"><s:property value="#item.product.pname"/></a>
							</td>
							<td>
								￥<s:property value="#item.product.shop_price"/>
							</td>
							<td class="quantity" width="60">
								<s:property value="#item.count"/>
							</td>
							<td width="140">
								<span class="subtotal">￥<s:property value="#item.subtotal"/></span>
							</td>
						</tr>
						</s:iterator>
					</s:iterator>
				</tbody>
				</table>
				<dl id="giftItems" class="hidden" style="display: none;">
				</dl>
			
				<div class="pagination">
					<span class="currentPage">共<s:property value="pagebean.totalPage"/>页</span>
			<s:if test="pagebean.currentPage != 1">
				<a class="previousPage" href="${pageContext.request.contextPath }/order_findByPageUid.action?uid=<s:property value="#session.reuser.uid"/>&currentPage=<s:property value="pagebean.currentPage-1"/>">&nbsp;</a>
			</s:if>
				<a class="currentPage" href="#"><s:property value="pagebean.currentPage"/></a>
			<s:if test="pagebean.currentPage != pagebean.totalPage">		
				<a class="nextPage" href="${pageContext.request.contextPath }/order_findByPageUid.action?uid=<s:property value="#session.reuser.uid"/>&currentPage=<s:property value="pagebean.currentPage+1"/>">&nbsp;</a>
			</s:if>
					
				</div>
				</s:if>
				<s:else>
					<div><strong><font  size="3">您还没有购物，快去购物吧</font></strong></div>
				</s:else>
		</div>
	</div>
	
<div class="container footer">
	<div class="span24">
		<div class="footerAd">
					<img src="${pageContext.request.contextPath}/image/footer.jpg" width="950" height="52" alt="我们的优势" title="我们的优势">
</div>	</div>
	<div class="span24">
		<ul class="bottomNav">
				<li>
						<a >关于我们</a>
						|
					</li>
					<li>
						<a>联系我们</a>
						|
					</li>
					<li>
						<a>招贤纳士</a>
						|
					</li>
					<li>
						<a>法律声明</a>
						|
					</li>
					<li>
						<a>友情链接</a>
						|
					</li>
					<li>
						<a target="_blank">支付方式</a>
						|
					</li>
					<li>
						<a  target="_blank">配送方式</a>
						|
					</li>
					<li>
						<a>服务声明</a>
						|
					</li>
					<li>
						<a>广告声明</a>
						
					</li>
		</ul>
	</div>
	<div class="span24">
		<div class="copyright">Copyright © 2005-2015 网上商城 版权所有</div>
	</div>
</div>
</body></html>