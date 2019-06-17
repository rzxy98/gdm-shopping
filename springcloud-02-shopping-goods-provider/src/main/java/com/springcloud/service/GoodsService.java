package com.springcloud.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.Goods;

public interface GoodsService {

	/**
	 * 添加新的商品信息
	 * 
	 * @param goods
	 * @return 成功返回大于0的数，失败返回0
	 */
	public abstract Integer insert(Goods goods);

	/**
	 * 查询满足条件的商品信息（分页功能）
	 * 
	 * @param goods 查询条件
	 * @return 成功返回com.github.pagehelper.PageInfo<goods>类型的实例，否则返回null
	 */
	public abstract PageInfo<Goods> select(Goods goods, Integer PageNumber);

	/**
	 * 根据条件修改商品的信息
	 * 
	 * @param goods 修改商品的信息
	 * @return 成功返回大于0的整数，失败返回0
	 */
	public abstract Integer updateGoodsById(Goods goods);

	/**
	 * 修改吸顶编号的商品信息
	 * 
	 * @param goods 修改的商品信息
	 * @return 成功返回大于0的整数，失败返回0
	 */
	public abstract Integer update(Goods goods);

	/**
	 * 查询销量前十的商品信息
	 * 
	 * @return 成功返回java.util.List类型的实例，否则返回null
	 */
	public abstract List<Goods> selecGroup();

}
