package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Class2 {
	/**
	 * 二级类别编号
	 */
    private Integer class2Id;

    /**
	 * 二级类别名称
	 */
    private String class2Name;

    /**
	 * 一级类别编号
	 */
    private Integer class1Id;

    /**
	 * 备注
	 */
    private String remark;
    
}