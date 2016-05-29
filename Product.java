package com.flp.pms.domain;

import java.util.Date;
import java.util.List;

public class Product {

	// product instance variables
	private int productId;
	private String productName;
	private String description;
	private Date manufacturing_date;
	private Date expiry_date;
	private double max_retail_price;
	private Category category;
	private SubCategory subCategory;
	private Supplier supplier;
	private List<Discount> discounts;
	private int quantity;
	private float ratings;

	// no arg constructor
	public Product() {
	}

	// full arg constructor

	public Product(int productId, String productName, String description, Date manufacturing_date, Date expiry_date,
			double max_retail_price, Category category, SubCategory subCategory, Supplier supplier,
			List<Discount> discounts, int quantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.manufacturing_date = manufacturing_date;
		this.expiry_date = expiry_date;
		this.max_retail_price = max_retail_price;
		this.category = category;
		this.subCategory = subCategory;
		this.supplier = supplier;
		this.discounts = discounts;
		this.quantity = quantity;
	}

	public Product(int productId, String productName, String description, Date manufacturing_date, Date expiry_date,
			double max_retail_price, Category category, SubCategory subCategory, Supplier supplier,
			List<Discount> discounts, int quantity, float ratings) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.manufacturing_date = manufacturing_date;
		this.expiry_date = expiry_date;
		this.max_retail_price = max_retail_price;
		this.category = category;
		this.subCategory = subCategory;
		this.supplier = supplier;
		this.discounts = discounts;
		this.quantity = quantity;
		this.ratings = ratings;
	}

	// public getters and setters
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getManufacturing_date() {
		return manufacturing_date;
	}

	public void setManufacturing_date(Date manufacturing_date) {
		this.manufacturing_date = manufacturing_date;
	}

	public Date getExpiry_date() {
		return expiry_date;
	}

	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}

	public double getMax_retail_price() {
		return max_retail_price;
	}

	public void setMax_retail_price(double max_retail_price) {
		this.max_retail_price = max_retail_price;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public List<Discount> getDiscounts() {
		return discounts;
	}

	public void setDiscounts(List<Discount> discounts) {
		this.discounts = discounts;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getRatings() {
		return ratings;
	}

	public void setRatings(float ratings) {
		this.ratings = ratings;
	}
    //HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((discounts == null) ? 0 : discounts.hashCode());
		result = prime * result + ((expiry_date == null) ? 0 : expiry_date.hashCode());
		result = prime * result + ((manufacturing_date == null) ? 0 : manufacturing_date.hashCode());
		long temp;
		temp = Double.doubleToLongBits(max_retail_price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + productId;
		result = prime * result + ((productName == null) ? 0 : productName.hashCode());
		result = prime * result + quantity;
		result = prime * result + Float.floatToIntBits(ratings);
		result = prime * result + ((subCategory == null) ? 0 : subCategory.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}
    //Equals Method
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discounts == null) {
			if (other.discounts != null)
				return false;
		} else if (!discounts.equals(other.discounts))
			return false;
		if (expiry_date == null) {
			if (other.expiry_date != null)
				return false;
		} else if (!expiry_date.equals(other.expiry_date))
			return false;
		if (manufacturing_date == null) {
			if (other.manufacturing_date != null)
				return false;
		} else if (!manufacturing_date.equals(other.manufacturing_date))
			return false;
		if (Double.doubleToLongBits(max_retail_price) != Double.doubleToLongBits(other.max_retail_price))
			return false;
		if (productId != other.productId)
			return false;
		if (productName == null) {
			if (other.productName != null)
				return false;
		} else if (!productName.equals(other.productName))
			return false;
		if (quantity != other.quantity)
			return false;
		if (Float.floatToIntBits(ratings) != Float.floatToIntBits(other.ratings))
			return false;
		if (subCategory == null) {
			if (other.subCategory != null)
				return false;
		} else if (!subCategory.equals(other.subCategory))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}
    //ToString Method
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", description=" + description
				+ ", manufacturing_date=" + manufacturing_date + ", expiry_date=" + expiry_date + ", max_retail_price="
				+ max_retail_price + ", category=" + category + ", subCategory=" + subCategory + ", supplier="
				+ supplier + ", discounts=" + discounts + ", quantity=" + quantity + ", ratings=" + ratings + "]";
	}

}
