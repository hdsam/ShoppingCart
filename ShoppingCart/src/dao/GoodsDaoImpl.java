package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import dbUtil.DBConnectionFactory;
import entity.Goods;

public class GoodsDaoImpl {
	DBConnectionFactory dcf = DBConnectionFactory.getInstance();
	
	public GoodsDaoImpl() {

	}
	//添加记录到tbl_cart表，添加商品到购物车
	public void addGoodsToCart(int goodsId,int num) {
		Connection conn=dcf.getConnection();
		String sql2="insert into tbl_cart (totalNum,goodsId) values(?,?)";
		try {
			update(conn,sql2,num,goodsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	//更新tbl_cart中的数据，从购物中删除商品
	public void updateGoodsFromCart(int goodsId, int num) {
		Connection conn=dcf.getConnection();
		String sql="update tbl_cart set totalNum=totalNum +? where goodsId=?";
		try {
			update(conn,sql,num,goodsId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

		//从数据库的tbl_cart表中查询上次未付款的商品
	public HashMap<Goods, Integer> queryGoodsFromCart() {
		Connection conn=dcf.getConnection();
		ResultSet rs=null;
		HashMap<Goods, Integer> goodsMap=new HashMap<Goods,Integer>();
		String sql="select g.goodsId,g.goodsName,g.goodsPrice,c.totalNum "
					+" from tbl_cart as c join tbl_goods as g "
					+" on c.goodsId=g.goodsId ";
		try {
			rs=query(conn, sql);
			while(rs.next()){
				Goods goods=new Goods();
				goods.setGoodsId(rs.getInt(1));
				goods.setGoodsName(rs.getString(2));
				goods.setGoodsPrice(rs.getInt(3));
				goodsMap.put(goods, new Integer(rs.getInt(4)));	
			}
		} catch (SQLException e) {
			System.out.println("cart表查询异常");
			e.printStackTrace();
		}
		return goodsMap;
	}

	public ArrayList<Goods> getGoodsList() {
		ArrayList<Goods> goodsList=new ArrayList<Goods>();
		Connection conn = dcf.getConnection();
		ResultSet rs=null;
		String sql="select goodsId,goodsName,goodsPrice,goodsNum from tbl_goods";
		try {
			rs=query(conn, sql);
			while(rs.next()){
				Goods g=new Goods();
				g.setGoodsId(rs.getInt(1));;
				g.setGoodsName(rs.getString(2));
				g.setGoodsPrice(rs.getInt(3));
				g.setGoodsNum(rs.getInt(4));
				goodsList.add(g);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return goodsList;
	}

	// 单表更新
	protected boolean update(Connection conn,String sql, Object ... objects) throws SQLException {
		PreparedStatement pst = createPreparedStatement(conn,sql,objects);
		boolean bool = pst.execute();
		return bool;
	}
	
	//单表查询
	protected ResultSet query(Connection conn,String sql, Object... objects) throws SQLException {
		PreparedStatement pst = createPreparedStatement(conn,sql, objects);
		ResultSet rs = pst.executeQuery();
		return rs;
	}
	//创建预编译的sql语句
	protected PreparedStatement createPreparedStatement(Connection conn,String sql, Object... objects) throws SQLException {
		PreparedStatement pst = null;
		pst = conn.prepareStatement(sql);
		for (int i = 0; i < objects.length; i++) {
			pst.setObject(i+1, objects[i]);
		}
		return pst;
	}

}
