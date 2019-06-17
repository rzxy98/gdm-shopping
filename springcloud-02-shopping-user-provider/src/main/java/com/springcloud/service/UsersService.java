package com.springcloud.service;

import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

public interface UsersService {

	/**
	 * 验证用户登录是否成功
	 * @param userId   用户编号
	 * @param userPsw  用户密码
	 * @param premissionId  权限编号
	 * @return  成功返回登录用户的完整信息，失败返回null
	 */
	public abstract Users login(Integer userId,String userPsw,Integer jdictionId);
	
	/**
	 * 添加新的用户信息
	 * @param users 新的用户信息
	 * @return 添加成功返回con.springcloud.entity.Users类型的实例，否则返回null
	 */
	public abstract Users insert(Users users);
	/**
	 * 查询满足条件的用户信息
	 * @param user  查询条件
	 * @param pageNumber  查询页数
	 * @return  成功返回org.springframework.data.domain.Page类型的实例，否则返回null
	 */
	public abstract Page<Users> select(Users user,Integer pageNumber);
	
	/**
	 * 修改users 表中指定编号的用户状态
	 * @param userId   用户编号
	 * @param userStatus  用户状态
	 * @return  修改成功返回大于0的整数，否则返回0
	 */
	public abstract Integer updateStatus(Integer userId,Integer userStatus);
	
	/**
	 * 查询指定编号的用户信息
	 * @param userId   用户id
	 * @return  用户
	 */
	public abstract Users selectById(Integer userId);
	
	/**
	 *   修改指定编号的用户信息
	 * @param users
	 * @return 修改成功返回大于0的整数，否则返回0
	 */
	public abstract Integer update(Users users);
	
	/**
	 * 根据参数修改指定编号的用户的头像或密码或昵称
	 * @param users
	 * @return  修改成功返回大于0的整数，否则返回0
	 */
	public abstract Integer updateMessage(Users users);
}
