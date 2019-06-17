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
	 * 商品编号
	 */
    private Integer goodsId;

    /**
	 * 商品名称
	 */
    private String goodsName;

    /**
	 * 商品价格
	 */
    private Double goodsPrices;

    /**
	 * 商品折扣
	 */
    private Double goodsDiscount;

    /**
	 * 商品状态  0表示预售，1表示热卖，2已下架
	 */
    private Integer goodsStatus;

    /**
	 * 商品数量
	 */
    private Integer goodsCount;

    /**
	 * 商品是否新品 0是新品 ，1不是新品
	 */
    private Integer goodsIsNew;

    /**
	 * 商品是否热卖
	 */
    private Integer goodsIsHot;

    /**
	 * 商品等级
	 */
    private Integer goodsLevel;

    /**
	 * 商品简介
	 */
    private String goodsBrief;

    /**
	 * 商品详情
	 */
    private String goodsDetails;

    /**
	 * 商品图片
	 */
    private String goodsPhoto;

    /**
	 * 商品二级类别
	 */
    private Integer class2Id;
    /**
     * 查询条件：商品价格下限
     */
    private Double goodsPriceMin;
    /**
     * 查询条件：商品价格上限
     */
    private Double goodsPriceMax;
    /**
     * 查询条件：一级类别编号
     */
    private Integer class1Id;
    
    /**
     * 商品销量：用于保存统计分组的结果
     */
    private Integer goodsSum;
   
}