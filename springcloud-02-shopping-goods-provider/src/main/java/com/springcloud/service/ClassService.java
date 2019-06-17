package com.springcloud.service;

import java.util.List;
/**
 * 用于定义一级类别和二级类别模块的方法
 */
import com.springcloud.entity.Class1;
import com.springcloud.entity.Class2;

public interface ClassService {
	/**
	 * 查询所有一级类别的信息
	 * @return  成功返回java.util.list中的实例，失败返回null
	 */
	public abstract List<Class1> selectAllClass1();
	
	/**
	 * 根据一级类别的编号查询对应得二级类别的信息
	 * @param class1Id  一级类别编号
	 * @return  成功返回java.util.list 中的实例，失败返回null
	 */
	public abstract List<Class2> selectClass2ByClass1Id(Integer class1Id);

}
