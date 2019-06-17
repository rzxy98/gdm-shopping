package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetail;

public interface OrderDetailsService {
	/**
	 *  ��ѯָ��������ŵĶ�����ϸ��Ϣ����ҳ���ܣ�
	 * @param orderId  �������
	 * @param pageNumber  ҳ��
	 * @return
	 */
	public abstract PageInfo<OrderDetail> selectByOrderId(Integer orderId,Integer pageNumber);

}
