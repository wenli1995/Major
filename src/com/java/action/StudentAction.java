package com.java.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.hibernate.annotations.Cascade;

import com.java.dao.MajorDao;
import com.java.dao.StudentDao;
import com.java.model.Major;
import com.java.model.Student;
import com.java.util.ResponseUtil;
import com.java.util.StringUtil;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

public class StudentAction extends ActionSupport  implements ServletRequestAware{

	/**
	 * @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})在添加或修改Student时，只传入class.id,数据表t_class数据表中该记录其他值还存在。
	 * 如果CascadeType.MERGE,只传入class.id会导致t_class数据表中该记录其他值都变为NULL;
	 */
	private static final long serialVersionUID = 1L;
	private HttpServletRequest request;
	
	StudentDao studentDao=new StudentDao();
	MajorDao classDao=new MajorDao();
	private List<Student> studentList;
	private List<Major> selectClassList;
	private Student querystudent;
	private Student student;
	private String mainPage;
	private String studentId;
	private String title;
	
	public String getMainPage() {
		return mainPage;
	}

	public void setMainPage(String mainPage) {
		this.mainPage = mainPage;
	}

	public List<Major> getSelectClassList() {
		return selectClassList;
	}

	public void setSelectClassList(List<Major> selectClassList) {
		this.selectClassList = selectClassList;
	}

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}
	
	
	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Student getQuerystudent() {
		return querystudent;
	}

	public void setQuerystudent(Student querystudent) {
		this.querystudent = querystudent;
	}
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String list() throws Exception{
		selectClassList=classDao.query(null);  //查询时班级下拉列表s
		studentList=studentDao.query(querystudent);
		mainPage="studentList.jsp";
		return SUCCESS;
	}
	
	
	public String preSave(){
		mainPage="studentPresave.jsp";
		selectClassList=classDao.query(null);
		if(StringUtil.isNotEmpty(studentId)){
			title="学生信息修改";
			student=studentDao.getStudentById(Integer.parseInt(studentId));  //修改时前端显示界面
		}else{
			title="学生信息添加";
		}
		return SUCCESS;
		
	}
	
	public String saveStudent() throws Exception{
		if(StringUtil.isNotEmpty(studentId)){
			student.setId(Integer.parseInt(studentId));     //因为ID不是通过c_stuClass传入，所以需要手动设置
		}
		studentDao.save(student);
		return "save";
	}
	
	
	public String deleteStudent() throws Exception{
		JSONObject resultJson1=new JSONObject(); 
		Student deletStudent=studentDao.getStudentById(Integer.parseInt(studentId));
		studentDao.delete(deletStudent);
		resultJson1.put("status", "success");
		ResponseUtil.write(resultJson1, ServletActionContext.getResponse());
		return null;
	}

	@Override
	public void setServletRequest(HttpServletRequest request) {
		// TODO Auto-generated method stub
		this.request=request;
	}
	
}
