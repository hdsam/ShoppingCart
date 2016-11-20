package entity;

import java.util.HashMap;
import dao.GoodsDaoImpl;

public class Cart {

	private HashMap<Goods, Integer> goodsMap;
	private GoodsDaoImpl gdi;

	public void addGoods(Goods g, int num) {
		if (!goodsMap.containsKey(g)) {
			gdi.addGoodsToCart(g.getGoodsId(), num);
			this.goodsMap.put(g, num);
		} else if (goodsMap.get(g) < g.getGoodsNum()) {
			gdi.updateGoodsFromCart(g.getGoodsId(), num);
			this.goodsMap.replace(g, g.getGoodsNum()+num);
		}
	}

	public void deleteGoods(Goods g, int num) {
		if (goodsMap.get(g) > 0) {
			gdi.updateGoodsFromCart(g.getGoodsId(), -num);
			this.goodsMap.replace(g, goodsMap.get(g)-num);
		}
	}

	public Cart() {
		gdi = new GoodsDaoImpl();
		this.goodsMap=gdi.queryGoodsFromCart();
	}

	public HashMap<Goods, Integer> getGoodsMap() {
		return this.goodsMap;
	}

}
