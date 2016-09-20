package cn.wkc.shop.categorysecond.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.wkc.shop.categorysecond.dao.CategorySecondDao;
import cn.wkc.shop.categorysecond.model.CategorySecond;
import cn.wkc.shop.utils.PageBean;

@Component("categorySecondService")
public class CategorySecondService {
	
	private CategorySecondDao categorySecondDao;
	
	@Resource(name="categorySecondDao")
	public void setCategorySecondDao(CategorySecondDao categorySecondDao) {
		this.categorySecondDao = categorySecondDao;
	}

	public PageBean<CategorySecond> findAllByPage(int currentPage) {
		PageBean<CategorySecond> pagebean = new PageBean<CategorySecond>();
		int record = 8;
		pagebean.setCurrentPage(currentPage);   //
		pagebean.setRecord(record);  ///
		int totalRecord = categorySecondDao.fingTotalRecord();
		pagebean.setTotalRecord(totalRecord);  //  
		int totalPage = 0;
		if(totalRecord % record == 0){
			totalPage = totalRecord / record;
		}else{
			totalPage = totalRecord / record + 1;
		}
		pagebean.setTotalPage(totalPage);    //  
		int begin = (currentPage - 1) * record;
		List<CategorySecond> list = categorySecondDao.findAllByPage(begin, record);
		pagebean.setList(list);
		return pagebean;
	}

	public void delete(CategorySecond categorySecond) {
		categorySecondDao.delete(categorySecond);
	}

	public void save(CategorySecond categorySecond) {
		categorySecondDao.save(categorySecond);
	}

	public CategorySecond findByCsid(int csid) {
		return categorySecondDao.findByCsid(csid);
	}

	public void update(CategorySecond categorySecond) {
		categorySecondDao.update(categorySecond);
	}

	public List<CategorySecond> findAll() {
		return categorySecondDao.findAll();
	}

}
