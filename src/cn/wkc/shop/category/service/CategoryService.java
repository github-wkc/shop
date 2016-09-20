package cn.wkc.shop.category.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import cn.wkc.shop.category.dao.CategoryDao;
import cn.wkc.shop.category.model.Category;

@Transactional
@Component("categoryService")
public class CategoryService {
	
	private CategoryDao categoryDao;
	
	@Resource(name="categoryDao")
	public void setCategoryDao(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}

	public List<Category> findAll() {
		return categoryDao.findAll();
	}

	public void save(Category category) {
		categoryDao.save(category);
	}

	public void delete(Category category) {
		categoryDao.delete(category);
	}

	public Category findByCid(int cid) {
		
		return categoryDao.findByCid(cid);
	}

	public void update(Category category) {
		categoryDao.update(category);
		
	}
}
