package cn.wkc.shop.product.action;

import javax.annotation.Resource;

import cn.wkc.shop.product.model.Product;
import cn.wkc.shop.product.service.ProductService;
import cn.wkc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ProductAction extends ActionSupport implements ModelDriven<Product>{

	private Product product = new Product();
	private ProductService productService;
	private int cid;   //  一级分类的id
	private int currentPage;  // 分页查询的 当前页
	private int csid;   // 二级分类的id
	
	public int getCsid() {
		return csid;
	}

	public void setCsid(int csid) {
		this.csid = csid;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCid() {
		return cid;
	}

	@Resource(name="productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}
	// 与商品详情有关
	public String findByPid(){
		product = productService.findByPid(product.getPid());
		return "findByPid";
	}
	// 根据一级分类id查询商品
	public String findByCid(){
		//   分页显示
		PageBean<Product> pagebean = productService.findByPageCid(cid , currentPage);
		// 添加到值栈
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findByCid";
	}
	// 根据二级分类id进行查询
	public String findByCSid(){
		PageBean<Product> pagebean = productService.findByPageCSid(csid,currentPage);
		// 添加到值栈 
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findByCSid";
	}
}
