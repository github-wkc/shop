package cn.wkc.shop.user.action;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import cn.wkc.shop.user.model.User;
import cn.wkc.shop.user.service.UserService;
import cn.wkc.shop.utils.MailUtils;
import cn.wkc.shop.utils.UUIDUtils;
import cn.wkc.shop.utils.VertifyCodeUtils;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	private User user = new User();
	private UserService userService;
	private String checkcode;
	
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}

	@Resource(name = "userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public String registerPage() {
		return "registerPage";
	}
	
	public String loginPage(){
		return "loginPage";
	}

	public User getModel() {
		return user;
	}

	public String findByName() throws IOException {
		HttpServletResponse hr = ServletActionContext.getResponse();
		hr.setContentType("text/html;charset=UTF-8");
		if (user.getUsername().equals("")) {
			return NONE;
		}
		User returnUser = userService.findByName(user);
		if (returnUser != null) {
			hr.getWriter().println("<font color='red'> 用户名已经存在</font>");
		} else {
			hr.getWriter().println("<font color='green'> 用户名可以使用</font>");
		}
		return NONE;
	}

	public String register() throws Exception { 
		String recheckcode = (String) ServletActionContext.getRequest().getSession().
			getAttribute("checkcode");
		if(!recheckcode.equalsIgnoreCase(checkcode)){
			this.addFieldError("checkcode", "验证码不正确");
			return "input";
		}
		//   用校验框架进行校验时   先执行框架里校验，在执行代码，如果表单的内容不符合校验，返回input视图。
		User reuser = userService.findByName(user);
		if(reuser != null){
			this.addFieldError("username", "用户名已经存在");
			return "input";   // 这里得返回input视图，不会自动返回input视图。
		}
		user.setState(0);
		user.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());
		userService.save(user);
		MailUtils.sendMail(user.getEmail(), user.getCode());
		this.addActionMessage("账号已经注册成功，快去邮箱激活吧");
		return "msg";
	}
	
	public String login(){
		String recheckcode = (String) ServletActionContext.getRequest().getSession().
			getAttribute("checkcode");
		if(!recheckcode.equalsIgnoreCase(checkcode)){
			this.addFieldError("checkcode", "验证码错误");
			return LOGIN;
		}
		User reuser = userService.login(user);
		if(reuser == null){
			this.addActionError("登录失败:用户名或密码错误或用户未激活!");
			return LOGIN;
		}
		//登陆成功
		ServletActionContext.getRequest().getSession().setAttribute("reuser", reuser);
		return "loginSuccess";
	}
	
	public String active(){
		String code = user.getCode();
		User reuser = userService.findByCode(code);
		if(reuser == null){
			this.addActionMessage("激活失败，激活码错误------------");
		}
		reuser.setState(1);
		reuser.setCode(null);
		userService.update(reuser);
		this.addActionMessage("激活成功，请去登陆---------------");
		return "msg";
	}
	
	public String quit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return "quit";
	}
	public String vertify() throws IOException{
		VertifyCodeUtils.get();
		return NONE;
	}
	
	
}