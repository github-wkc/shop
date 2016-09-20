package cn.wkc.shop.index.action;

import java.util.List;

import javax.annotation.Resource;

import cn.wkc.shop.category.model.Category;
import cn.wkc.shop.category.service.CategoryService;
import cn.wkc.shop.product.model.Product;
import cn.wkc.shop.product.service.ProductService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class IndexAction extends ActionSupport {
	
	private CategoryService categoryService;
	private ProductService productService;
	
	@Resource(name="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Resource(name="categoryService")
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public String execute() throws Exception {
		List<Category> clist = categoryService.findAll();
		// 注意是actioncontext
		// 显示所有的一级分类，二级分类，以及商品
		ActionContext.getContext().getSession().put("clist",clist);
		// 显示hot商品
		List<Product> plist = productService.findHot();
		ActionContext.getContext().getValueStack().set("plist", plist);
		
		// 显示最新商品
		List<Product> nlist = productService.findNew();
		ActionContext.getContext().getValueStack().set("nlist", nlist);
		return "index";
	}
}
