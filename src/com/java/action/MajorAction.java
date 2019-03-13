package com.java.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;

import com.java.dao.MajorDao;
import com.java.dao.StudentDao;
import com.java.model.Major;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;


public class MajorAction extends ActionSupport implements ServletRequestAware {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	
	MajorDao classDao=new MajorDao();
	StudentDao studentDao=new StudentDao();
	
	private Major major;   //��ѯʱ����
	private Major stuClass=new Major();;	//�޸Ļ�����ʱ����
	private String c_id;         //�޸�ʱ����id;
	private String c_grade; 
	private String c_className;
	private String title;   //��ʶ���޸Ļ�������
	private String mainPage;
	private List<Major> classList;

	public Major getStuClass() {
		return stuClass;
	}
	public void setStuClass(Major stuClass) {
		this.stuClass = stuClass;
	}
	
	
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	public String getC_id() {
		return c_id;
	}
	
	public String getC_grade() {
		return c_grade;
	}
	public void setC_grade(String c_grade) {
		this.c_grade = c_grade;
	}
	public String getC_className() {
		return c_className;
	}
	public void setC_className(String c_className) {
		this.c_className = c_className;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMainPage() {
		return mainPage;
	}
	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}
	
	public List<Major> getClassList() {
		return classList;
	}
	public void setClassList(List<Major> classList) {
		this.classList = classList;
	}
	public String list() throws Exception{
		classList=classDao.query(major);
		mainPage="classList.jsp";
		return SUCCESS;
	}
	
	public String preSave(){
		mainPage="classPresave.jsp";
		if(StringUtil.isNotEmpty(c_id)){
			title="�༶��Ϣ�޸�";
			stuClass=classDao.getClassById(Integer.parseInt(c_id));  //�޸�ʱǰ����ʾ����
		}else{
			title="�༶��Ϣ���";
		}
		return SUCCESS;
		
	}
	
	public String saveClass() throws Exception{
		if(StringUtil.isNotEmpty(c_id)){
			stuClass.setId(Integer.parseInt(c_id));     //��ΪID����ͨ��c_stuClass���룬������Ҫ�ֶ�����
		}
		stuClass.setGrade(c_grade);     //��ﴫ��namestuClass.gradeû�취���룿��
		stuClass.setClassName(c_className);
		classDao.add(stuClass);
		return "save";
	}
	
	
	public String delete() throws Exception{
		Major stuClass=classDao.getClassById(Integer.parseInt(c_id));
		JSONObject resultJson=new JSONObject(); 
		if(studentDao.exitsStudentsByClassId(c_id)){
			resultJson.put("error", "�ð༶�´���ѧ����������ɾ��");
		}else{
			
			classDao.delete(stuClass);
			resultJson.put("status", true);
		}
		ResponseUtil.write(resultJson, ServletActionContext.getResponse());
		return null;
	}
	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
}
