package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.springcloud.common.PageUtils;
import com.springcloud.entity.OrderDetail;
import com.springcloud.service.OrderDetailsService;
import com.springcloud.vo.ResultValue;

@RestController
@RequestMapping("orderDetails")
public class OrderDetailsController {

	@Autowired
	private OrderDetailsService OrderDetialsService;

	@RequestMapping(value="selectByOrderId")
	public ResultValue selectByOrderId(@RequestParam("orderId") Integer orderId,
			@RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();

		try {
			// 查询出指定编号的用户信息
			PageInfo<OrderDetail> pageInfo = this.OrderDetialsService.selectByOrderId(orderId, pageNumber);
			List<OrderDetail> list = pageInfo.getList();
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				// 将商品信息添加到指定键存入map集合中
				Map<String, Object> map = new HashMap<>();
				map.put("orderDetailsList", list);

				PageUtils pageUtils = new PageUtils(5,pageInfo.getPages() * 5);
				pageUtils.setPageNumber(pageNumber);
				// 将分页信息以指定名字存入map集合中
				map.put("pageUtils", pageUtils);
				rv.setDataMap(map);

				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		rv.setCode(1);
		rv.setMessage("查询不到指定的订单明细信息！！！");
		return rv;
	}

}
