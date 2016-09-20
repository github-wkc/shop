package cn.wkc.shop.product.adminaction;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import cn.wkc.shop.categorysecond.model.CategorySecond;
import cn.wkc.shop.categorysecond.service.CategorySecondService;
import cn.wkc.shop.product.dao.ProductDao;
import cn.wkc.shop.product.model.Product;
import cn.wkc.shop.product.service.ProductService;
import cn.wkc.shop.utils.PageBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminProductAction extends ActionSupport implements
		ModelDriven<Product> {

	private Product product = new Product();
	private ProductService productService;
	private CategorySecondService categorySecondService;
	private int currentPage;
	// 文件上传的三个属性
	File upload; //
	String uploadFileName;
	String uploadContextType;

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setUploadContextType(String uploadContextType) {
		this.uploadContextType = uploadContextType;
	}

	public File getUpload() {
		return upload;
	}

	@Resource(name = "categorySecondService")
	public void setCategorySecond(CategorySecondService categorySecondService) {
		this.categorySecondService = categorySecondService;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	@Resource(name = "productService")
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public Product getModel() {
		return product;
	}

	public String findAllByPage() {
		PageBean<Product> pagebean = productService.findAllByPage(currentPage);
		ActionContext.getContext().getValueStack().set("pagebean", pagebean);
		return "findAllByPage";
	}

	public String addPage() {
		List<CategorySecond> list = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("list", list);
		System.out.println(list.get(0).getCsid());
		return "addPage";
	}

	public String save() throws IOException{
		product.setPdate(new Date());  
		if(upload != null ){
			/*String delPath = ServletActionContext.getServletContext().getRealPath(
					"/" + product.getImage());
			File file = new File(delPath);
			file.delete();*/
			// 获得上传图片的服务器端路径.
		/**
		 * 
		 * 文件上传没有处理重名问题
		 * 
		 */
			String path = ServletActionContext.getServletContext().getRealPath(
					"/products");
			// 创建文件类型对象:
			File diskFile = new File(path , product.getCategorysecond().getCsid() + "/" +  uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);
			product.setImage("products/" + product.getCategorysecond().getCsid()+ "/" +  uploadFileName);
			productService.save(product);
		}
		return "saveSuccess";
	}
	public String delete(){
		// 删除图片
		Product reproduct = productService.findByPid(product.getPid());
		String path = ServletActionContext.getServletContext().getRealPath("/products");
		int index = path.indexOf("products");
		path = path.substring(0, index);
		System.out.println(path);
		path = path + reproduct.getImage();
		System.out.println(path);
		File file = new File(path);
		file.delete();
		//  从数据库中删除记录 
		productService.delete(product);
		return "delete";
	}
		
	public String editPage(){
		product = productService.findByPid(product.getPid());
		// 查询二级分类
		List<CategorySecond> cslist = categorySecondService.findAll();
		ActionContext.getContext().getValueStack().set("cslist", cslist);
		return "editPage";
	}
	
	public String edit() throws IOException{
		//  如果文件不重传，但是二级分类改变了会影响到，图片的保存位置。不容易管理。   // 当二级分类的改变了
		//，图片的存储路径就变化了，但是图片还没有移动，因为upload为空，所以不执行移动图片操作
		if(upload != null){
			//  文件重传了，删除以前的图片
			File file1 = new File("/" + product.getImage());
			file1.delete();
			// 保存新的图片
			String path = ServletActionContext.getServletContext().getRealPath("/products");
			path = path + "/" + product.getPid() + "/" + uploadFileName;
			File file = new File(path);
			FileUtils.copyFile(upload, file);
			product.setImage("products/" + product.getCategorysecond().getCsid() + "/" + uploadFileName);
		}
		product.setPdate(new Date());
		productService.update(product);
		return "edit";
	}
	
}
