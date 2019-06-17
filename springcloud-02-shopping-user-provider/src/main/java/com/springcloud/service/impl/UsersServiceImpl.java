package com.springcloud.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.repository.UsersRepository;
import com.springcloud.service.UsersService;

/**
 * ģ�Ͳ��ʵ���࣬ʵ���û�ģ��ķ���
 * @author ASUS
 *
 */
@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public Users login(Integer userId, String userPsw, Integer jdictionId) {
		return this.usersRepository.login(userId, userPsw, jdictionId);
	}

	@Override
	public Users insert(Users users) {
		return this.usersRepository.save(users);
	}

	@Override
	public Page<Users> select(Users users, Integer pageNumber) {
		//���ݲ�ѯ���ݣ�������̬����
		@SuppressWarnings("serial")
		Specification<Users> pecification = new Specification<Users>() {
			
			@Override
			public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
				//����list���ϣ����ڱ������е�whereList����
				List<Predicate> whereList = new ArrayList<>();
				
				//����Users�еĲ�ѯ��������̬������ѯ����
				if(users.getUserName() != null && !users.getUserName().trim().equals("")) {
					whereList.add(criteriaBuilder.like(root.get("userName"), "%" + users.getUserName() + "%"));
				}
				if(users.getUserStatus()!=-1) {
					whereList.add(criteriaBuilder.equal(root.get("userStatus"), users.getUserStatus()));
				}
				//�����е�������and��ϵ������һ�𣬲�����
				return criteriaBuilder.and(whereList.toArray(new Predicate[whereList.size()]));
				
			}
		};
		//����JPA�ķ�ҳ��Ϣ
		PageRequest of = PageRequest.of(pageNumber,PageUtils.PAGE_ROW_COUNT);
		return usersRepository.findAll(pecification, of);
	}

	@Transactional
	@Override
	public Integer updateStatus(Integer userId, Integer userStatus) {
		return this.usersRepository.updateStatus(userId, userStatus);
	}

	@Override
	public Users selectById(Integer userId) {
	
		return this.usersRepository.findById(userId).get();
	}

	@Transactional
	@Override
	public Integer update(Users users) {
		return this.usersRepository.update(users);
	}

	@Transactional
	@Override
	public Integer updateMessage(Users users) {
		if (users.getUserHphoto()!=null && !users.getUserHphoto().trim().equals("")) {
			return this.usersRepository.updateImage(users);
		}else if(users.getUserPsw()!=null && !users.getUserPsw().trim().equals("")) {
			return this.usersRepository.updatePassword(users);
		}else if(users.getUserName()!=null && !users.getUserName().trim().equals("")) {
			return this.usersRepository.updateName(users);
		}
		return 0;
	}

}
