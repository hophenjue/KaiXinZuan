/**  

 * @文件名 :BaseEntity.java 

 * @包名   :com.spider.film.entity 

 * @日期   :2015-1-8 上午10:22:49 

 * @版本   :V4.2.0
  
 * @版权声明:Copyright (c) 2014年 spider. All rights reserved.

 */
package com.studioxl.entity;

import java.io.Serializable;

/**
 * @ClassName: BaseEntity
 * @Description: 实体类的基类
 * @author tufengchao
 * @date 2015-1-8 上午10:22:49
 * 
 */
public class BaseEntity implements Serializable {
	private String result;
	private String message;

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
