package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class1 {
	/**
	 * 一级类别编号
	 */
    private Integer class1Id;

    /**
	 * 一级类别名称
	 */
    private String class1Name;

    /**
	 *序号
	 */
    private Integer class1Unm;

    /**
	 * 一级类别备注
	 */
    private String remark;
    
}