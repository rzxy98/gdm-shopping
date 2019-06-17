package com.springcloud.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.Orders;
import com.springcloud.service.OrdersService;
import com.springcloud.vo.ResultValue;

@RestController
@RequestMapping("orders")
public class OrdersContoller {
	
	@Autowired
	private OrdersService ordersService;
	
	/**
	 * 查询满足条件的订单信息
	 * @param orders  查询条件
	 * @param pageNumber  页数
	 * @return
	 */
	@RequestMapping(value="/selectOrders")
	public ResultValue selectOrders(Orders orders,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		
		try {
			//查询满足条件的商品信息
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			//从分页信息中获得商品信息
			List<Orders> list = pageInfo.getList();
			//如果查询到满足条件的商品信息
			if(list !=null && list.size() > 0) {
				
				rv.setCode(0);
				//将商品信息添加到指定键存入map集合中
				Map<String,Object> map = new HashMap<>();
				map.put("ordersList", list);
				
				PageUtils pageUtils = new PageUtils(pageInfo.getPages()*PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				//将分页信息以指定名字存入map集合中
				map.put("pageUtils", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("没有找到满足条件的订单信息！！");
		return rv;
	}
	
	/**
	 *  修改指定订单编号的订单状态
	 * @param orders  修改信息
	 * @return 
	 */
	@RequestMapping(value = "/updateOrdersStauts")
	public ResultValue updateOrdersStauts(Orders orders) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer status = this.ordersService.updateOrdersStatus(orders);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("修改订单状态成功！！");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("修改订单状态失败！！");
		return rv;
	}
	
	@RequestMapping(value = "/selectGroup")
	public ResultValue selectGroup(Orders orders) {
		ResultValue rv = new ResultValue();
		
		try {
			List<Orders> list = this.ordersService.selectGroup(orders);
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				List<String> x = new ArrayList<>();
				List<Double> y = new ArrayList<>();
				//将查询结果中商品名称存入x集合，销量存入y集合
				for (Orders order : list) {
					x.add(order.getOrderMonth());
					y.add(order.getOrderPrice());
				}
				
				Map<String,Object> map = new HashMap<>();
				map.put("x", x);
				map.put("y", y);
				rv.setDataMap(map);
				
				return rv;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	

}
