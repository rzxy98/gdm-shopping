package com.springcloud.service;

import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

public interface UsersService {

	/**
	 * ��֤�û���¼�Ƿ�ɹ�
	 * @param userId   �û����
	 * @param userPsw  �û�����
	 * @param premissionId  Ȩ�ޱ��
	 * @return  �ɹ����ص�¼�û���������Ϣ��ʧ�ܷ���null
	 */
	public abstract Users login(Integer userId,String userPsw,Integer jdictionId);
	
	/**
	 * ����µ��û���Ϣ
	 * @param users �µ��û���Ϣ
	 * @return ��ӳɹ�����con.springcloud.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users insert(Users users);
	/**
	 * ��ѯ�����������û���Ϣ
	 * @param user  ��ѯ����
	 * @param pageNumber  ��ѯҳ��
	 * @return  �ɹ�����org.springframework.data.domain.Page���͵�ʵ�������򷵻�null
	 */
	public abstract Page<Users> select(Users user,Integer pageNumber);
	
	/**
	 * �޸�users ����ָ����ŵ��û�״̬
	 * @param userId   �û����
	 * @param userStatus  �û�״̬
	 * @return  �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateStatus(Integer userId,Integer userStatus);
	
	/**
	 * ��ѯָ����ŵ��û���Ϣ
	 * @param userId   �û�id
	 * @return  �û�
	 */
	public abstract Users selectById(Integer userId);
	
	/**
	 *   �޸�ָ����ŵ��û���Ϣ
	 * @param users
	 * @return �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer update(Users users);
	
	/**
	 * ���ݲ����޸�ָ����ŵ��û���ͷ���������ǳ�
	 * @param users
	 * @return  �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateMessage(Users users);
}
