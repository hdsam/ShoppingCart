package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import dao.GoodsDaoImpl;
import dbUtil.DBConnectionFactory;
import entity.Goods;

public class Test {

	public static void main(String[] args) {
//		ArrayList<Goods> goodsList =new ArrayList<Goods>();
//		DBConnectionFactory dcf=DBConnectionFactory.getInstance();
//		Connection	conn=dcf.getConnection();
//		String sql="select * from tbl_goods";
//		ResultSet rs=null;
//		try {
//			PreparedStatement pst=conn.prepareStatement(sql);
//			rs=pst.executeQuery();
//			while (rs.next()) {
//				Goods g=new Goods();
//				g.setGoodsId(rs.getInt("goodsId"));
//				g.setGoodsName(rs.getString("goodsName"));
//				g.setGoodsPrice(rs.getString("goodsPrice"));
//				g.setGoodsNum(rs.getInt("goodsNum"));
//				goodsList.add(g);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	
//		for(int i=0;i<goodsList.size();i++){
//			Goods goods=goodsList.get(i);
//			System.out.print(goods.getGoodsId());
//			System.out.print(goods.getGoodsName());
//			System.out.print(goods.getGoodsPrice());
//			System.out.println(goods.getGoodsNum());
//			}
		GoodsDaoImpl dgi=new GoodsDaoImpl();
		HashMap<Goods, Integer>goodsMap=dgi.queryGoodsFromCart();
		Iterator<Goods> gs=goodsMap.keySet().iterator();
		while(gs.hasNext()){
			gs.next().toString();
		}
	}

}
