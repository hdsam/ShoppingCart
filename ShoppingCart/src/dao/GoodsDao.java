package dao;

import java.util.ArrayList;

import entity.Goods;

public interface GoodsDao {
	
	public void addGoods(Goods goods);
	public void deleteGoods(int goodsId);
	public void queryGoods(int goodsId);
	public ArrayList<Goods> getGoodsList();
	
}
