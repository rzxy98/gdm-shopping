package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

@RestController
public class UsersController {
	@Autowired
	private UsersService userService;

	/**
	 * �û���¼
	 * @param userId  �û����
	 * @param userPsw �û�����
	 * @param jdictionId  �û�Ȩ��
	 * @return
	 */
	@RequestMapping(value="/login")
	public ResultValue login(@RequestParam("userId") Integer userId,@RequestParam("userPsw") String userPsw,@RequestParam("jdictionId") Integer jdictionId) {
		ResultValue rv = new ResultValue();
		try {
			Users login =this.userService.login(userId, userPsw, jdictionId);
			if(login != null) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��¼��Ϣ����ȷ�����������룡����");
		return rv;
	}
	@RequestMapping(value="/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Users insert = this.userService.insert(users);
			if(insert !=null) {
				rv.setCode(1);
				rv.setMessage("�û�¼��ɹ�������");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�¼��ʧ�ܣ�����");
		return rv;
	}
	
	@RequestMapping(value="select")
	public ResultValue select(Users users,@RequestParam("pageNumber") Integer pageNumber) {
		
		ResultValue rv =new ResultValue();
		try {
			Page<Users> page = this.userService.select(users, pageNumber);
			//��÷�ҳ������
			List<Users> list = page.getContent();
			//�жϲ�ѯ������
			if(list != null && list.size() > 0) {
				rv.setCode(0);
				
				Map<String,Object> map = new HashMap<>();
				map.put("userList", list);
				
				PageUtils pageUtils =new PageUtils((int)page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				//����ҳ��Ϣ��ӵ�map��
				map.put("pageUtils", pageUtils);
				
				//��map��ӵ�ResultValue������
				rv.setDataMap(map);
				
				return rv;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value="/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		
		try {
			this.userService.updateStatus(userId, userStatus);
			if(userStatus>0) {
				rv.setCode(0);
				rv.setMessage("�޸��û�״̬�ɹ�������");
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(0);
		rv.setMessage("�û�״̬�޸�ʧ�ܣ�����");
		return rv;
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value="/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		
		ResultValue rv = new ResultValue();
		try {
			//����service�еķ���������ò�ѯ�Ľ��
			Users users = this.userService.selectById(userId);
			//���ݲ�ѯ�ɹ�
			if(users != null) {
				rv.setCode(0);
				//����map���ϱ����ѯ���
				Map<String,Object> map = new HashMap<>();
				//����ѯ������浽Map������
				map.put("users", users);
				//��map������ӵ�ResultValue������
				rv.setDataMap(map);
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("��ô�����Ϣ������");
		return rv;
	}
	
	@RequestMapping(value="/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			//����service����Ӧ�ķ����޸��û���Ϣ��������޸��Ƿ�ɹ�
			Integer update = this.userService.update(users);
			//����޸ĳɹ�
			if(update > 0) {
				//���ý����״̬Ϊ0
				rv.setCode(0);
				//����ResultValue�Ķ���
				return rv;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("�û��޸�ʧ�ܣ���");
		return rv;
	}
	
	@RequestMapping(value="/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		
		try {
			Integer Message = this.userService.updateMessage(users);
			if(Message > 0) {
				rv.setCode(0);
				rv.setMessage("�û���Ϣ�޸ĳɹ�����");
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		rv.setMessage("�û���Ϣ�޸�ʧ�ܣ���");
		return rv;
	}
	
}
