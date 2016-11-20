package entity;

import java.io.Serializable;

public class Goods implements Serializable {

	private static final long serialVersionUID = 1L;

	private int goodsId;
	private String goodsName;
	private int goodsPrice;
	private int goodsNum;

	public int getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(int goodsNum) {
		this.goodsNum = goodsNum;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(int goodsprice) {
		this.goodsPrice = goodsprice;
	}

	public String toString() {
		return "Goods [goodsId=" + goodsId + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + "]";
	}

	@Override
	public int hashCode() {
		return this.getGoodsId() + this.getGoodsName().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof Goods) {
			Goods g = (Goods) obj;
			return this.goodsId == g.goodsId && this.goodsName.equals(g.goodsName);

		} else {
			return false;
		}

	}

}
