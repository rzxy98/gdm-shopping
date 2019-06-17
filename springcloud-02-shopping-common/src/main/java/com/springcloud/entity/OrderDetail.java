package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * order_details���Ӧ��ʵ���࣬���ڷ�װ������ϸ��һ����Ϣ
 * 
 * @author ASUS
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = -569452398984381835L;

	/**
	 * ������ϸ���
	 */
	private Integer orderDetailId;

	/**
	 * �������
	 */
	private Integer orderId;

	/**
	 * ��Ʒ���
	 */
	private Integer goodsId;

	/**
	 * ��Ʒ����
	 */
	private String goodsName;

	/**
	 * �ɽ���
	 */
	private Double transactionPrice;

	/**
	 * �ɽ�����
	 */
	private Integer transactionCount;

}