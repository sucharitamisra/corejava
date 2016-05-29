package com.flp.pms.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.flp.pms.dao.IProductDao;
import com.flp.pms.dao.ProductDaoImplForMap;
import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.view.BootClass;

public class ProductServiceImpl implements IProductService {

	private IProductDao iProductDao = new ProductDaoImplForMap();
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
		return iProductDao.getAllSuppliers();
	}
    //Get The Discount List
	public List<Discount> getAllDiscounts() {

		return iProductDao.getAllDiscounts();
	}
    //Add The Products 
	public void addProduct(Product product) {
		Map<Integer, Product> maps = iProductDao.getAllProducts();
		boolean flag = false;
		Set<Integer> product_IDS = maps.keySet();
		int product_id_generated = generateProductId();

		// Generate unique Product Id
		if (!maps.isEmpty()) {
			do {

				product_id_generated = generateProductId();
				for (Integer product_Id : product_IDS) {
					if (product_Id == product_id_generated) {
						flag = true;
						break;
					}
				}
			} while (flag);

		}
		product.setProductId(product_id_generated);

		iProductDao.addProduct(product);
	}
    //Generate The Product Id
	public int generateProductId() {
		return (int) (Math.random() * 10000);
	}
    //Get All The Products
	public Map<Integer, Product> getAllProducts() {

		return iProductDao.getAllProducts();
	}
    //Get All Product List
	public List<Product> getAllProductsList() {
		Collection<Product> collectionProduct = getAllProducts().values();
		List<Product> listProducts = new ArrayList<>();
		for (Product product : collectionProduct)
			listProducts.add(product);
		return listProducts;
	}
    //Search Product Based on Product Name
	public Product searchByProductName(String productName) {
		List<Product> products = getAllProductsList();
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
		List<Product> products = getAllProductsList();
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
		List<Product> products = getAllProductsList();
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
		List<Product> products = getAllProductsList();
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
		List<Product> products = getAllProductsList();
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
			Map<Integer, Product> productMap = getAllProducts();
			productMap.remove(productToRemove.getProductId(), productToRemove);
			return true;
		} else

			return false;

	}
    //Search The product Id
	@Override
	public Product searchProductId(int productId) {

		List<Product> products = getAllProductsList();
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
		Map<Integer, Product> map = getAllProducts();
		p.setProductName(pName);
		map.put(p.getProductId(), p);
		System.out.println("Successfully Updated");
		return true;

		}else
			
			return false;
	}
    //Update The Product MRP
	@Override
	public boolean updateProductMaxRetailPrice(Product p, double max) {
		if (BootClass.userConfirmationForUpdate()){
		Map<Integer, Product> map = getAllProducts();
		p.setMax_retail_price(max);
		map.put(p.getProductId(), p);
		System.out.println("Successfully Updated");
		return true;
		}else
			return false;

	}
    //Update The Product ExpiryDate
	@Override
	public boolean updateProductExpDate(Product p, Date expiryD) {
		if (BootClass.userConfirmationForUpdate()){
		Map<Integer, Product> map = getAllProducts();
		p.setExpiry_date(expiryD);
		map.put(p.getProductId(), p);
		System.out.println("Successfully Updated");
		return true;
		}else
			return false;
	}
    //Update The Product Ratings
	@Override
	public boolean updateProductRating(Product p, float rating) {
		if (BootClass.userConfirmationForUpdate()){
		Map<Integer, Product> map = getAllProducts();
		p.setRatings(rating);
		map.put(p.getProductId(), p);
		System.out.println("Successfully Updated");
		return true;
		}else
			return false;
	}
    //Update The Category
	@Override
	public boolean updateProductCategory(Product p, Category category) {
		if (BootClass.userConfirmationForUpdate()){
		Map<Integer, Product> map = getAllProducts();
		p.setCategory(category);
		map.put(p.getProductId(), p);
		System.out.println("Successfully Updated");
		return true;
		}else
			return false;

	}
}
