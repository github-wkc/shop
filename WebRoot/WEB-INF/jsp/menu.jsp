<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<script type="text/javascript">
	function show(){
		var show = document.getElementById("dic");
		show.style.display = "block";
	}
	function hidden1(){
		var hidden = document.getElementById("dic");
		hidden.style.display = "none";
	}
</script>
<div class="span10 last">
		<div class="topNav clearfix">
			<ul>
			<s:if test="#session.reuser == null">
				<li id="headerLogin" class="headerLogin" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_loginPage.action">登录</a>|
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_registerPage.action">注册</a>|
				</li>
			</s:if>
			<s:else>
				<li id="" class="" style="display: list-item;">
					<s:property value="#session.reuser.name"/>|
				</li>
				<li id="" class="" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/order_myOrder.action?currentPage=1"  onmousemove="show();">我的订单</a>|
					<div style="margin-left:5px;width:50px;height:60px; display:none; position:absolute; background-color: gray"  id="dic" onmousemove="show();" onmouseout="hidden1();">
						<a href="${pageContext.request.contextPath }/">未付款</a>
						<a href="${pageContext.request.contextPath }/">已付款</a>
					</div>
				</li>
				<li id="headerRegister" class="headerRegister" style="display: list-item;">
					<a href="${pageContext.request.contextPath }/user_quit.action">退出</a>|
				</li>
			</s:else>
				<li id="headerUsername" class="headerUsername"></li>
				<li id="headerLogout" class="headerLogout">
					<a>[退出]</a>|
				</li>
						<li>
							<a>会员中心</a>
							|
						</li>
						<li>
							<a>购物指南</a>
							|
						</li>
						<li>
							<a>关于我们</a>
							
						</li>
			</ul>
		</div>
		<div class="cart">
			<a  href="${pageContext.request.contextPath }/cart_myCart.action">购物车</a>
		</div>
			<div class="phone">
				客服热线:
				<strong>96008/53277764</strong>
			</div>
	</div>
	<div class="span24">
		<ul class="mainNav">
					<li>
						<a href="${pageContext.request.contextPath }/index.action">首页</a>
						|
					</li>
					<s:iterator value="#session.clist" var="c">
						<li>
							<a href="${pageContext.request.contextPath }/product_findByCid.action?cid=<s:property value="#c.cid"/>&currentPage=1"><s:property value="#c.cname"/></a>
							|
						</li>
					</s:iterator>
		</ul>
	</div>

</div>	