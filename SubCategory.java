package com.flp.pms.domain;

public class SubCategory {
    //SubCategory Instance Variable
	private int sub_category_Id;
	private String sub_category_Name;
	private Category category;
   //No Argument Constructor
	public SubCategory() {
	}
   //Argument Constructor
	public SubCategory(int sub_category_Id, String sub_category_Name, Category category) {
		super();
		this.sub_category_Id = sub_category_Id;
		this.sub_category_Name = sub_category_Name;
		this.category = category;
	}
   //Public Getters And Setters
	public int getSub_category_Id() {
		return sub_category_Id;
	}

	public void setSub_category_Id(int sub_category_Id) {
		this.sub_category_Id = sub_category_Id;
	}

	public String getSub_category_Name() {
		return sub_category_Name;
	}

	public void setSub_category_Name(String sub_category_Name) {
		this.sub_category_Name = sub_category_Name;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
   //ToString Method
	@Override
	public String toString() {
		return "SubCategory [sub_category_Id=" + sub_category_Id + ", sub_category_Name=" + sub_category_Name
				+ ", category=" + category + "]";
	}
   //HashCode
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + sub_category_Id;
		result = prime * result + ((sub_category_Name == null) ? 0 : sub_category_Name.hashCode());
		return result;
	}
   //Equals Code
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SubCategory other = (SubCategory) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (sub_category_Id != other.sub_category_Id)
			return false;
		if (sub_category_Name == null) {
			if (other.sub_category_Name != null)
				return false;
		} else if (!sub_category_Name.equals(other.sub_category_Name))
			return false;
		return true;
	}

}
