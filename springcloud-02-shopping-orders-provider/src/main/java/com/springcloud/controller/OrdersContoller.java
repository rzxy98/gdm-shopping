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
	 * ��ѯ���������Ķ�����Ϣ
	 * @param orders  ��ѯ����
	 * @param pageNumber  ҳ��
	 * @return
	 */
	@RequestMapping(value="/selectOrders")
	public ResultValue selectOrders(Orders orders,@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		
		try {
			//��ѯ������������Ʒ��Ϣ
			PageInfo<Orders> pageInfo = this.ordersService.selectOrders(orders, pageNumber);
			//�ӷ�ҳ��Ϣ�л����Ʒ��Ϣ
			List<Orders> list = pageInfo.getList();
			//�����ѯ��������������Ʒ��Ϣ
			if(list !=null && list.size() > 0) {
				
				rv.setCode(0);
				//����Ʒ��Ϣ��ӵ�ָ��������map������
				Map<String,Object> map = new HashMap<>();
				map.put("ordersList", list);
				
				PageUtils pageUtils = new PageUtils(pageInfo.getPages()*PageUtils.PAGE_ROW_COUNT);
				pageUtils.setPageNumber(pageNumber);
				//����ҳ��Ϣ��ָ�����ִ���map������
				map.put("pageUtils", pageUtils);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("û���ҵ����������Ķ�����Ϣ����");
		return rv;
	}
	
	/**
	 *  �޸�ָ��������ŵĶ���״̬
	 * @param orders  �޸���Ϣ
	 * @return 
	 */
	@RequestMapping(value = "/updateOrdersStauts")
	public ResultValue updateOrdersStauts(Orders orders) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer status = this.ordersService.updateOrdersStatus(orders);
			if(status > 0) {
				rv.setCode(0);
				rv.setMessage("�޸Ķ���״̬�ɹ�����");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("�޸Ķ���״̬ʧ�ܣ���");
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
				//����ѯ�������Ʒ���ƴ���x���ϣ���������y����
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
