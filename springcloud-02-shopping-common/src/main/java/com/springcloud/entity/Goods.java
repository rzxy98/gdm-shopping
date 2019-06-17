package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author ASUS
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
	/**
	 * ��Ʒ���
	 */
    private Integer goodsId;

    /**
	 * ��Ʒ����
	 */
    private String goodsName;

    /**
	 * ��Ʒ�۸�
	 */
    private Double goodsPrices;

    /**
	 * ��Ʒ�ۿ�
	 */
    private Double goodsDiscount;

    /**
	 * ��Ʒ״̬  0��ʾԤ�ۣ�1��ʾ������2���¼�
	 */
    private Integer goodsStatus;

    /**
	 * ��Ʒ����
	 */
    private Integer goodsCount;

    /**
	 * ��Ʒ�Ƿ���Ʒ 0����Ʒ ��1������Ʒ
	 */
    private Integer goodsIsNew;

    /**
	 * ��Ʒ�Ƿ�����
	 */
    private Integer goodsIsHot;

    /**
	 * ��Ʒ�ȼ�
	 */
    private Integer goodsLevel;

    /**
	 * ��Ʒ���
	 */
    private String goodsBrief;

    /**
	 * ��Ʒ����
	 */
    private String goodsDetails;

    /**
	 * ��ƷͼƬ
	 */
    private String goodsPhoto;

    /**
	 * ��Ʒ�������
	 */
    private Integer class2Id;
    /**
     * ��ѯ��������Ʒ�۸�����
     */
    private Double goodsPriceMin;
    /**
     * ��ѯ��������Ʒ�۸�����
     */
    private Double goodsPriceMax;
    /**
     * ��ѯ������һ�������
     */
    private Integer class1Id;
    
    /**
     * ��Ʒ���������ڱ���ͳ�Ʒ���Ľ��
     */
    private Integer goodsSum;
   
}