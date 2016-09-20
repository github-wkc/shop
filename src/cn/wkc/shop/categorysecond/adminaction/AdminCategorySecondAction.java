package cn.wkc.shop.categorysecond.adminaction;

import java.util.List;

import javax.annotation.Resource;

import cn.wkc.shop.category.model.Category;
import cn.wkc.shop.category.service.CategoryService;
import cn.wkc.shop.categorysecond.model.CategorySecond;
import cn.wkc.shop.categorysecond.service.CategorySecondService;
import cn.wkc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategorySecondAction extends ActionSupport implements ModelDriven<CategorySecond>{

	private CategorySecondService categorySecondService;
	private CategorySecond categorySecond = new CategorySecond();
	private int currentPage;
	private CategoryService categoryService;
	private int cid;
	
	public void setCid(int cid) {
		this.cid = cid;
	}

	@Resource(name="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Resource(name="categorySecondService")
	public void setCategorySecondService(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public CategorySecond getModel() {
		return categorySecond;
	}
	
	public String findAllByPage(){
		PageBean<CategorySecond> pagebean = categorySecondService.findAllByPage(currentPage);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findAllByPage";
	}
	
	public String delete(){
		///  先查询，在删除，设置cascade
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		categorySecondService.delete(categorySecond);
		return "deleteSuccess";
	}
	
	public String addPage(){
		List<Category> clist  = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "addPage";
	}
	
	public String save(){    //  categorysecond 中的category 的id 已经添加了，， select的标签 name= category.cid
		categorySecondService.save(categorySecond);     //   当保存二级分类时， 一级分类的id有了，就可以保存了,不用设置cascade  
		return "saveSuccess";
	}
	
	public String editPage(){
		categorySecond = categorySecondService.findByCsid(categorySecond.getCsid());
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "editPage";
	}
	
	public String edit(){
		System.out.println(".............................");
		System.out.println(categorySecond.getCsid());
		System.out.println(categorySecond.getCategory().getCid());
		categorySecondService.update(categorySecond);
		return "editSuccess";
	}
}
