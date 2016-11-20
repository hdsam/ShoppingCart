<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="entity.Cart"%>
<%@page import="dao.GoodsDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.Goods"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
}

.content table {
	line-height: 40px;
	width: 600px;
	margin: 60px auto;
	text-align: center;
}

.content table {
	
}
</style>
</head>
<body>
	<div class="content">

		<table border="1px solid #858585" cellpadding="0" cellspacing="0">
			<tr>
				<th colspan="5">购物车</th>
			</tr>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>购买量</th>
				<th>操作</th>
			</tr>
			<%
				Cart cart = new Cart();
				HashMap<Goods, Integer> goodsMap = cart.getGoodsMap();
				double totalPrice = 0.0;
				Iterator<Goods> it = goodsMap.keySet().iterator();
				while (it.hasNext()) {
					Goods goods = it.next();
					int goodsNum = goodsMap.get(goods);
					if(goodsNum>0){
					totalPrice += goods.getGoodsPrice() * goodsNum;
			%>
			<tr>
				<td><%=goods.getGoodsId()%></td>
				<td><%=goods.getGoodsName()%></td>
				<td><%=goods.getGoodsPrice()%></td>
				<td><%=goodsNum%></td>
				<td><a
					href="handleServlet?goodsId=<%=goods.getGoodsId()%>&status=-1">从购物车中删除</a></td>
			</tr>
			<%	
					}
				}
			%>
			<tr>
				<td colspan="4">合计：<%=totalPrice%>元</td>
				<td><a href="success.jsp?totalPrice=<%=totalPrice%>">结算</a></td>
			<tr />
		</table>
	</div>

</body>
</html>