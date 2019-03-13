package com.java.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.java.dao.UserDao;
import com.java.model.User;
import com.opensymphony.xwork2.ActionSupport;

public class UserAction extends ActionSupport implements ServletRequestAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	UserDao userDao=new UserDao();
	private User user;
	private String error;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String  login(){
		HttpSession session=request.getSession();
		User currentManager=userDao.Login(user);
		if(currentManager==null){
			error="用户名或密码错误";
			return ERROR;
		}else{
			session.setAttribute("currentManager", currentManager);
			return SUCCESS;
		}
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
