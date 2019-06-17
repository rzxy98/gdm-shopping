package com.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.dao.OrdersMapper;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;

/**
 * 订单模块的实现类，用于实现订单模块的方法
 * 
 * @author ASUS
 *
 */
@Service
public class OrdersServiceImpl implements OrdersService {

	@Autowired
	private OrdersMapper ordersMapper;

	@Override
	public PageInfo<Orders> selectOrders(Orders orders, Integer pageNumber) {
		if(orders.getUser() !=null) {
			// 首先在名称用户名的两端加%
			orders.getUser().setUserName("%"+ orders.getUser().getUserName() +"%");
		}
		// 设置每页的信息
		PageHelper.startPage(pageNumber + 1, PageUtils.PAGE_ROW_COUNT);
		// 查询满足条件的商品信息
		List<Orders> list = this.ordersMapper.selectOrders(orders);
		return new PageInfo<>(list);
	}

	@Override
	public Integer updateOrdersStatus(Orders orders) {
		return this.ordersMapper.updateOrdersStatus(orders);
	}

	@Override
	public List<Orders> selectGroup(Orders orders) {
		return this.ordersMapper.selectGroup(orders);
	}

}
