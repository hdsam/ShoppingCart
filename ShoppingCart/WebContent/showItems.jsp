<%@page import="dao.GoodsDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entity.Goods" %>
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
	margin: 60px auto;
	text-align: center;
}
.content table tr{
	line-height: 40px;
}
.content table input {
	display: inline-block;
	width: 60px;
}
</style>
</head>
<body>
	<div class="content">
	
		<table border="1px solid #858585" width="600px" cellpadding="0" cellspacing="0">
			<tr>
				<th colspan="6">所有商品</th>
			</tr>
			<tr>
				<th>商品编号</th>
				<th>商品名称</th>
				<th>商品价格</th>
				<th>库存量</th>
				<th>购买数量</th>
				<th>确认购买</th>
			</tr>
			<% GoodsDaoImpl gdi=new GoodsDaoImpl();
				ArrayList<Goods> goodsList =gdi.getGoodsList();
				for(int i=0;i<goodsList.size();i++){
					Goods goods=goodsList.get(i);
					session.setAttribute("goodsId"+goods.getGoodsId(), goods);
				%>
			<tr>
				<td><%=goods.getGoodsId() %></td>
				<td><%=goods.getGoodsName() %></td>
				<td><%=goods.getGoodsPrice() %></td>
				<td><%=goods.getGoodsNum() %></td>
				<td><input type="number" min="1" max="<%=goods.getGoodsNum() %>"/></td>
				<td><a href="handleServlet?goodsId=<%=goods.getGoodsId()%>&status=1">是</a></td>
			</tr>
			<%	}%>
		</table>
	</div>

</body>
</html>