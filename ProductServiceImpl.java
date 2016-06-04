package com.flp.pms.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForDB;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.view.BootClass;

public class ProductServiceImpl implements IProductService {

	private IProductDao iProductDao = new ProductDaoImplForDB();
    //Get The Category List
	public List<Category> getAllCategory() {
		return iProductDao.getAllCategory();
	}
    //Get The Sub Category List
	public List<SubCategory> getAllSubCategory() {
		return iProductDao.getAllSubCategory();
	}
    //Get The Supplier List
	public List<Supplier> getAllSupplier() {
		return iProductDao.getAllSupplier();
	}
    //Get The Discount List
	public List<Discount> getAllDiscounts() {

		return iProductDao.getAllDiscount();
	}
    //Add The Products 
	public boolean addProduct(Product product) {
		return iProductDao.addProduct(product);
	}
    
    //Get All Product List
	public List<Product> getAllProducts() {
		
		List<Product> listProducts = new ArrayList<>();
		listProducts=iProductDao.getAllProducts();
		return listProducts;
	}
    //Search Product Based on Product Name
	public Product searchByProductName(String productName) {
		List<Product> products = getAllProducts();
		Product searchedProduct = null;
		for (Product product : products) {
			if (product.getProductName().equalsIgnoreCase(productName)) {
				searchedProduct = product;
			}
		}
		return searchedProduct;
	}
    //Search Product Based On Supplier Name
	public Product searchBySupplierName(String supplierName) {
		List<Product> products = getAllProducts();
		Product searchedProduct = null;
		for (Product product : products) {
			if (product.getSupplier().getFirstName().equalsIgnoreCase(supplierName)
					|| product.getSupplier().getLastName().equalsIgnoreCase(supplierName)) {
				searchedProduct = product;
			}
		}
		return searchedProduct;
	}
    //Search The Product Based On Category Name
	@Override
	public Product searchByCategoryName(String categoryName) {
		List<Product> products = getAllProducts();
		Product searchedProduct = null;
		for (Product product : products) {
			if (product.getCategory().getCategory_Name().equalsIgnoreCase(categoryName)) {
				searchedProduct = product;
			}
		}
		return searchedProduct;
	}
    //Search The Product Based on SubCategory Name
	@Override
	public Product searchBySubCategoryName(String subCategoryName) {
		List<Product> products = getAllProducts();
		Product searchedProduct = null;
		for (Product product : products) {
			if (product.getSubCategory().getSub_category_Name().equalsIgnoreCase(subCategoryName)) {
				searchedProduct = product;
			}
		}
		return searchedProduct;
	}
    //Search The product Based On Ratings
	@Override
	public Product searchByRating(float rating) {
		List<Product> products = getAllProducts();
		Product searchedProduct = null;
		for (Product product : products) {
			if (product.getRatings() == rating) {
				searchedProduct = product;
			}
		}
		return searchedProduct;
	}
    //Remove The Product
	public boolean removeProduct(Product productToRemove) {

		if (BootClass.userConfirmationForDelete()) {
			
			return true;
		} else

			return false;

	}
    //Search The product Id
	@Override
	public Product searchProductId(int productId) {

		List<Product> products = getAllProducts();
		Product searchedProduct = null;
		for (Product product : products) {
			if (product.getProductId() == productId) {
				searchedProduct = product;
			}
		}
		return searchedProduct;

	}
    //Update The Product Name
	@Override
	public boolean updateProductName(Product p, String pName) {
		if (BootClass.userConfirmationForUpdate()){
		
		return true;

		}else
			
			return false;
	}
    //Update The Product MRP
	@Override
	public boolean updateProductMaxRetailPrice(Product p, double max) {
		if (BootClass.userConfirmationForUpdate()){
		
		return true;
		}else
			return false;

	}
    //Update The Product ExpiryDate
	@Override
	public boolean updateProductExpDate(Product p, Date expiryD) {
		if (BootClass.userConfirmationForUpdate()){
		
		return true;
		}else
			return false;
	}
    //Update The Product Ratings
	@Override
	public boolean updateProductRating(Product p, float rating) {
		if (BootClass.userConfirmationForUpdate()){
		
		return true;
		}else
			return false;
	}
    //Update The Category
	@Override
	public boolean updateProductCategory(Product p, Category category) {
		if (BootClass.userConfirmationForUpdate()){
		
		return true;
		}else
			return false;

	}
	
}