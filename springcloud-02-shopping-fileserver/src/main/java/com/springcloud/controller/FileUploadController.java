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

	//从application.properties文件中获得指定键的值，并赋给相应的成员变量
	@Value("${web.user-path}")
	private String userPath;
	@Value("${web.goods-path}")
	private String goodsPath;
	
	/**
	 * 用户头像上传
	 * @param file
	 * @return
	 */
	//MultipartFile为springboot为我们提供上传文件的类
	@RequestMapping(value ="userUpload")
	public ResultValue userUpload(@RequestParam("userHphoto") MultipartFile file) {
		ResultValue rv = new ResultValue();
		//上传文件
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
		rv.setMessage("用户头像上传失败！！！！");
		return rv;
	}
	
	@RequestMapping(value ="goodsUpload")
	public ResultValue goodsUpload(@RequestParam("goodsImage") MultipartFile file) {
		ResultValue rv = new ResultValue();
		//上传文件
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
		rv.setMessage("商品图片上传失败！！！！");
		return rv;
	}
	
	/**
	 *  删除商品图片
	 * @param goodsImg
	 * @return
	 */
	@RequestMapping(value = "/deleteGoodsImg")
	public ResultValue deleteGoodsImg(@RequestParam("goodsImg") String goodsImg) {
		ResultValue rv=new ResultValue();
		try {
			//从url中获得商品图片的名字
			int IndexOf = goodsImg.lastIndexOf("/");
			if(IndexOf !=-1) {
				String fileName = goodsImg.substring(IndexOf + 1);
//				System.out.println(fileName);
				File file = new File(this.goodsPath + fileName);
				//判断文件或目录是否存在
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
			//从url中获得商品图片的名字
			int IndexOf = userPhoto.lastIndexOf("/");
			if(IndexOf !=-1) {
				String fileName = userPhoto.substring(IndexOf + 1);
//				System.out.println(fileName);
				File file = new File(this.userPath + fileName);
				//判断文件或目录是否存在
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
	 * 上传文件
	 * @param path  上传文件的路径
	 * @param file  上传的文件
	 * @return  成功返回java.util.map类型的实例，否则返回null
	 * @throws IOException 
	 */
	private Map<String,Object> uploadFile(String path,MultipartFile file) throws IOException{
		//获得新的文件名
				String fileName=UploadUtils.getFileName();
				
				//根据上传文件的文件名获得文件的扩展名
				String extendedName = UploadUtils.getExendedName(file.getOriginalFilename());
				
				//上传文件
				//1、将文件转换成字节类型的数组
				byte[] bytes = file.getBytes();
				//2、创建file类对象，并设置文件名上传路径和文件名
				File saveFile = new File(path+fileName+extendedName);
				//3、上传文件
				FileCopyUtils.copy(bytes, saveFile);
				
				//当文件上传成功时，将文件新的文件名与拓展名传递回视图层
				Map<String,Object> map= new HashMap<>();
				map.put("fileName", fileName);
				map.put("extendedName", extendedName);
				return map;
	}
	
}
