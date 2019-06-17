package com.springcloud.vo;

import java.util.Map;

import lombok.Data;

/**
  *���ر���Ŀ������controller���صĽ������
 * @author ASUS
 *
 */
@Data
public class ResultValue implements java.io.Serializable{
	
	private static final long serialVersionUID = -7333058567132357663L;
	/**
	 * ���õ�ǰ���ص�״̬
	 */
	private Integer code;
	/**
	 * ���÷��ص���Ϣ
	 */
	private String message;
	/**
	 * ���÷��ص�����
	 */
	private Map<String,Object>dataMap;

}
