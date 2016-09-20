package cn.wkc.shop.category.adminaction;

import java.util.List;

import javax.annotation.Resource;

import cn.wkc.shop.category.model.Category;
import cn.wkc.shop.category.service.CategoryService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminCategoryAction extends ActionSupport implements
		ModelDriven<Category> {

	private Category category = new Category();
	private CategoryService categoryService;

	@Resource(name = "categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	@Override
	public Category getModel() {
		return category;
	}

	public String findAll() {
		List<Category> clist = categoryService.findAll();
		ActionContext.getContext().getValueStack().set("clist", clist);
		return "findAll";
	}

	public String save() {
		categoryService.save(category);
		return "saveSuccess";
	}

	public String delete() {
		// 注意，因为删除一级分类的同时，也删除二级分类，所以得失先查询，还得级联，在删除。()
		Category c = categoryService.findByCid(category.getCid());
		categoryService.delete(c);
		return "delete";
	}

	public String edit() {
		// 用模型驱动，把需要传递的值传递过去
		category = categoryService.findByCid(category.getCid());
		return "edit";
	}

	public String update() {
		categoryService.update(category);
		return "update";
	}

}
