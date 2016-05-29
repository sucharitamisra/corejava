package com.flp.pms.dao;

import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public interface IProductDao {

	public List<Category> getAllCategory();

	public List<SubCategory> getAllSubCategory();

	public List<Supplier> getAllSuppliers();

	public List<Discount> getAllDiscounts();

	public void addProduct(Product product);

	public Map<Integer, Product> getAllProducts();

}
