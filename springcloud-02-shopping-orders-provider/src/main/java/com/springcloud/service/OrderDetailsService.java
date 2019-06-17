package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetail;

public interface OrderDetailsService {
	/**
	 *  查询指定订单编号的订单明细信息（分页功能）
	 * @param orderId  订单编号
	 * @param pageNumber  页数
	 * @return
	 */
	public abstract PageInfo<OrderDetail> selectByOrderId(Integer orderId,Integer pageNumber);

}
