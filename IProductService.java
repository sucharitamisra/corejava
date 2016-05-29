package com.flp.pms.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public interface IProductService {
	public List<Category> getAllCategory();

	public List<SubCategory> getAllSubCategory();

	public List<Supplier> getAllSupplier();

	public List<Discount> getAllDiscounts();

	public void addProduct(Product product);

	public Map<Integer, Product> getAllProducts();

	public Product searchByProductName(String productName);

	public Product searchBySupplierName(String supplierName);

	public Product searchByCategoryName(String categoryName);

	public Product searchBySubCategoryName(String subCategoryName);

	public Product searchByRating(float rating);

	public List<Product> getAllProductsList();

	public boolean removeProduct(Product productToRemove);

	public Product searchProductId(int productId);

	public boolean updateProductName(Product p, String pName);

	public boolean updateProductMaxRetailPrice(Product p, double max);

	public boolean updateProductExpDate(Product p, Date expiryD);

	public boolean updateProductRating(Product p, float rating);

	public boolean updateProductCategory(Product p, Category category);
}
