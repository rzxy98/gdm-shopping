package com.springcloud.vo;

import java.util.Map;

import lombok.Data;

/**
  *返回本项目中所有controller返回的结果类型
 * @author ASUS
 *
 */
@Data
public class ResultValue implements java.io.Serializable{
	
	private static final long serialVersionUID = -7333058567132357663L;
	/**
	 * 设置当前返回的状态
	 */
	private Integer code;
	/**
	 * 设置返回的信息
	 */
	private String message;
	/**
	 * 设置返回的数据
	 */
	private Map<String,Object>dataMap;

}
