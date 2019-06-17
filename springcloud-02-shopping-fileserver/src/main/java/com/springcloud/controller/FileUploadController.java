package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {

	//��application.properties�ļ��л��ָ������ֵ����������Ӧ�ĳ�Ա����
	@Value("${web.user-path}")
	private String userPath;
	@Value("${web.goods-path}")
	private String goodsPath;
	
	/**
	 * �û�ͷ���ϴ�
	 * @param file
	 * @return
	 */
	//MultipartFileΪspringbootΪ�����ṩ�ϴ��ļ�����
	@RequestMapping(value ="userUpload")
	public ResultValue userUpload(@RequestParam("userHphoto") MultipartFile file) {
		ResultValue rv = new ResultValue();
		//�ϴ��ļ�
		try {
			Map<String, Object> map = this.uploadFile(userPath, file);
			if(map != null && map.size() >0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�ͷ���ϴ�ʧ�ܣ�������");
		return rv;
	}
	
	@RequestMapping(value ="goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {
		ResultValue rv = new ResultValue();
		//�ϴ��ļ�
		try {
			Map<String, Object> map = this.uploadFile(goodsPath, file);
			if(map != null && map.size() >0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ƷͼƬ�ϴ�ʧ�ܣ�������");
		return rv;
	}
	
	/**
	 *  ɾ����ƷͼƬ
	 * @param goodsImg
	 * @return
	 */
	@RequestMapping(value = "/deleteGoodsImg")
	public ResultValue deleteGoodsImg(@RequestParam("goodsImg") String goodsImg) {
		ResultValue rv=new ResultValue();
		try {
			//��url�л����ƷͼƬ������
			int IndexOf = goodsImg.lastIndexOf("/");
			if(IndexOf !=-1) {
				String fileName = goodsImg.substring(IndexOf + 1);
//				System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//�ж��ļ���Ŀ¼�Ƿ����
				file.delete();
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	@RequestMapping(value = "/deleteUserPhoto")
	public ResultValue deleteUserPhoto(@RequestParam("userHphoto") String userPhoto) {
		ResultValue rv=new ResultValue();
		try {
			//��url�л����ƷͼƬ������
			int IndexOf = userPhoto.lastIndexOf("/");
			if(IndexOf !=-1) {
				String fileName = userPhoto.substring(IndexOf + 1);
//				System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//�ж��ļ���Ŀ¼�Ƿ����
				file.delete();
				rv.setCode(0);
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		rv.setCode(1);
		return rv;
	}
	
	
	/**
	 * �ϴ��ļ�
	 * @param path  �ϴ��ļ���·��
	 * @param file  �ϴ����ļ�
	 * @return  �ɹ�����java.util.map���͵�ʵ�������򷵻�null
	 * @throws IOException 
	 */
	private Map<String,Object> uploadFile(String path,MultipartFile file) throws IOException{
		//����µ��ļ���
				String fileName=UploadUtils.getFileName();
				
				//�����ϴ��ļ����ļ�������ļ�����չ��
				String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
				
				//�ϴ��ļ�
				//1�����ļ�ת�����ֽ����͵�����
				byte[] bytes = file.getBytes();
				//2������file����󣬲������ļ����ϴ�·�����ļ���
				File saveFile = new File(path+fileName+extendedName);
				//3���ϴ��ļ�
				FileCopyUtils.copy(bytes, saveFile);
				
				//���ļ��ϴ��ɹ�ʱ�����ļ��µ��ļ�������չ�����ݻ���ͼ��
				Map<String,Object> map= new HashMap<>();
				map.put("fileName", fileName);
				map.put("extendedName", extendedName);
				return map;
	}
	
}
