package com.flp.pms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;

public interface IProductDao {

	String DRIVER = "com.mysql.jdbc.Driver";
	String URL = "jdbc:mysql://localhost:3306/pmsdb";
	String USER = "root";
	String PASSWORD = "India123";

	public Connection getConnection();

	public Statement getStatement();

	public PreparedStatement getPreparedStatement(String query);

	public List<Category> getAllCategory();

	public List<SubCategory> getAllSubCategory();

	public List<Supplier> getAllSupplier();

	public List<Discount> getAllDiscount();

	public boolean addProduct(Product product);

	public List<Product> getAllProducts();

}