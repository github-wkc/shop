package cn.wkc.shop.adminuser.action;
import javax.annotation.Resource;
import cn.wkc.shop.adminuser.model.AdminUser;
import cn.wkc.shop.adminuser.service.AdminUserService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminUserAction extends ActionSupport implements ModelDriven<AdminUser>{
	
	private AdminUser adminUser = new AdminUser();
	private AdminUserService adminUserService;
	
	@Resource(name="adminUserService")
	public void setAdminUserService(AdminUserService adminUserService) {
		this.adminUserService = adminUserService;
	}

	public AdminUser getModel() {
		return adminUser;
	}
	
	public String login(){
		AdminUser user = adminUserService.login(adminUser);
		if(user == null){
			this.addActionError("用户名或者密码错误");
			return "index";
		}
		
		return "login";
	}
}
