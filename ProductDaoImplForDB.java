package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public class ProductDaoImplForDB implements IProductDao {

	static {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Connection getConnection() {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}

	@Override
	public Statement getStatement() {
		Statement st = null;

		try {
			st = getConnection().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return st;
	}

	@Override
	public PreparedStatement getPreparedStatement(String query) {
		PreparedStatement pst = null;

		try {
			pst = getConnection().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pst;
	}

	// Central Repository
	Map<Integer, Product> products = new HashMap<Integer, Product>();

	// List Of Categories
	public List<Category> getAllCategory() {

		List<Category> categories = new ArrayList<Category>();
		Category category = null;
		ResultSet rs = null;

		try {
			rs = getPreparedStatement("select * from category").executeQuery();

			while (rs.next()) {
				category = new Category();

				category.setCategory_Id(rs.getInt(1));
				category.setCategory_Name(rs.getString(2));
				category.setDescription(rs.getString(3));

				categories.add(category);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categories;
	}

	// List Of SubCategories
	public List<SubCategory> getAllSubCategory() {
		Category category = null;
		List<SubCategory> subcategories = new ArrayList<SubCategory>();
		List<Category> categories = getAllCategory();
		ResultSet rs = null;
		SubCategory subCategory = null;

		try {
			rs = getPreparedStatement("select * from subcategory").executeQuery();
			while (rs.next()) {
				subCategory = new SubCategory();
				subCategory.setSub_category_Id(rs.getInt(1));
				subCategory.setSub_category_Name(rs.getString(2));
				int catId = rs.getInt(3);
				for (Category c : categories)
					if (c.getCategory_Id() == catId)
						category = c;
				subCategory.setCategory(category);

				subcategories.add(subCategory);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return subcategories;

	}

	// List Of Supplier
	public List<Supplier> getAllSupplier() {

		List<Supplier> supplier = new ArrayList<Supplier>();
		Supplier suppliers = null;
		ResultSet rs = null;

		try {
			rs = getPreparedStatement("select * from Supplier").executeQuery();

			while (rs.next()) {
				suppliers = new Supplier();

				suppliers.setSupplierId(rs.getInt(1));
				suppliers.setFirstName(rs.getString(2));
				suppliers.setLastName(rs.getString(3));
				suppliers.setAddress(rs.getString(4));
				suppliers.setCity(rs.getString(5));
				suppliers.setState(rs.getString(6));
				suppliers.setPincode(rs.getString(7));
				suppliers.setContactno(rs.getString(8));

				supplier.add(suppliers);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return supplier;
	}

	// List Of Discount
	public List<Discount> getAllDiscount() {

		List<Discount> discounts = new ArrayList<Discount>();
		Discount discount = null;
		ResultSet rs = null;

		try {
			rs = getPreparedStatement("select * from Discount").executeQuery();

			while (rs.next()) {
				discount = new Discount();

				discount.setDiscountId(rs.getInt(1));
				discount.setDiscountName(rs.getString(2));
				discount.setDescription(rs.getString(3));
				discount.setDiscount_percentage(rs.getDouble(4));
				discount.setValidThru(rs.getDate(5));

				discounts.add(discount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return discounts;
	}

	// Add Product Confirmation
	public boolean addProduct(Product product) {
		int productId = 0;
		ResultSet rs = null;
		PreparedStatement pst = null;
		try {
			pst = getPreparedStatement("insert into product (productName,description,manufacturingDate,expiryDate,"
					+ "maximumRetailPrice,categoryId,subCategoryId,supplierId,quantity,rating) "
					+ "values (?,?,?,?,?,?,?,?,?,?)");
			pst.setString(1, product.getProductName());
			pst.setString(2, product.getDescription());
			java.util.Date utilManufacturingDate = product.getManufacturing_date();
			java.sql.Date sqlManufacturingDate = new java.sql.Date(utilManufacturingDate.getTime());
			pst.setDate(3, sqlManufacturingDate);
			java.util.Date utilExpiryDate = product.getExpiry_date();
			java.sql.Date sqlExpiryDate = new java.sql.Date(utilExpiryDate.getTime());
			pst.setDate(4, sqlExpiryDate);
			pst.setDouble(5, product.getMax_retail_price());
			pst.setInt(6, product.getCategory().getCategory_Id());
			pst.setInt(7, product.getSubCategory().getSub_category_Id());
			pst.setInt(8, product.getSupplier().getSupplierId());
			pst.setInt(9, product.getQuantity());
			pst.setFloat(10, product.getRatings());

			pst.executeUpdate();

			rs = getPreparedStatement("select * from product").executeQuery();
			while (rs.next())
				productId = rs.getInt(1);

			pst = getPreparedStatement("insert into product_Discount values(?,?)");
			for (Discount d : product.getDiscounts()) {
				pst.setInt(1, productId);
				pst.setInt(2, d.getDiscountId());
				pst.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;

	}

	// Get All products
	public List<Product> getAllProducts() {
		List<Product> listProducts = new ArrayList<>();
		ResultSet rs=null;
		Product product=null;
		Category category=null;
		SubCategory subCategory =null;
		Supplier supplier=null;
		PreparedStatement pst=null;
		ResultSet rs1=null;
		try {
			rs=getPreparedStatement("select * from product").executeQuery();
			
			while(rs.next()){
				product=new Product();
				
				product.setProductId(rs.getInt(1));
				product.setProductName(rs.getString(2));
				product.setDescription(rs.getString(3));
				product.setManufacturing_date(rs.getDate(4));
				product.setExpiry_date(rs.getDate(5));
				product.setMax_retail_price(rs.getDouble(6));
				int categoryId=rs.getInt(7);
				for(Category c:getAllCategory())
					if(c.getCategory_Id()==categoryId)
						category=c;
				product.setCategory(category);
				int subCategoryId=rs.getInt(8);
				for(SubCategory sc:getAllSubCategory())
					if(sc.getSub_category_Id()==subCategoryId)
						subCategory=sc;
				product.setSubCategory(subCategory);
				int supplierId=rs.getInt(9);
				for(Supplier sup:getAllSupplier())
					if(sup.getSupplierId()==supplierId)
						supplier=sup;
				product.setSupplier(supplier);
				product.setQuantity(rs.getInt(10));
				product.setRatings(rs.getFloat(11));
				
				
			
				pst=getPreparedStatement("select * from product_discount where productId=?");
				pst.setInt(1, product.getProductId());
				rs1=pst.executeQuery();
				while(rs1.next())
					int productId=rs.getInt(1);
					for(Discount discount:productI.getAllDiscount())
						if(discount.getPgetDiscountId()==)
					
					
					
					
				}
				
				
				
				
				
				
				
				listProducts.add(product);
				
			}
			
		}catch(

	SQLException e)

	{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	return listProducts;

}

}