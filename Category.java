package com.flp.pms.domain;

public class Category {
	//Category Instance Variable
	private int category_Id;
	private String category_Name;
	private String description;
    //No Argument Constructor
	public Category() {
	}
    //Argument Constructor
	public Category(int category_Id, String category_Name, String description) {
		super();
		this.category_Id = category_Id;
		this.category_Name = category_Name;
		this.description = description;
	}
    //Getters And Setters
	public int getCategory_Id() {
		return category_Id;
	}

	public String getCategory_Name() {
		return category_Name;
	}

	public String getDescription() {
		return description;
	}

	public void setCategory_Id(int category_Id) {
		this.category_Id = category_Id;
	}

	public void setCategory_Name(String category_Name) {
		this.category_Name = category_Name;
	}

	public void setDescription(String description) {
		this.description = description;
	}
    //ToString Method
	@Override
	public String toString() {
		return "Category [category_Id=" + category_Id + ", category_Name=" + category_Name + ", description="
				+ description + "]";
	}
    //Hash code 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + category_Id;
		result = prime * result + ((category_Name == null) ? 0 : category_Name.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		Category other = (Category) obj;
		if (category_Id != other.category_Id)
			return false;
		if (category_Name == null) {
			if (other.category_Name != null)
				return false;
		} else if (!category_Name.equals(other.category_Name))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		return true;
	}

}
