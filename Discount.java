package com.flp.pms.domain;

import java.util.Date;

public class Discount {
	//Discount Instance Variable
	private int discountId;
	private String discountName;
	private String description;
	private double discount_percentage;
	private Date validThru;
    //No Argument Constructor
	public Discount() {
	}
    //Argument Constructor
	public Discount(int discountId, String discountName, String description, double discount_percentage,
			Date validThru) {
		super();
		this.discountId = discountId;
		this.discountName = discountName;
		this.description = description;
		this.discount_percentage = discount_percentage;
		this.validThru = validThru;
	}
    //Getters And Setters
	public int getDiscountId() {
		return discountId;
	}

	public void setDiscountId(int discountId) {
		this.discountId = discountId;
	}

	public String getDiscountName() {
		return discountName;
	}

	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getDiscount_percentage() {
		return discount_percentage;
	}

	public void setDiscount_percentage(double discount_percentage) {
		this.discount_percentage = discount_percentage;
	}

	public Date getValidThru() {
		return validThru;
	}

	public void setValidThru(Date validThru) {
		this.validThru = validThru;
	}
    //ToString method
	@Override
	public String toString() {
		return "Discount [discountId=" + discountId + ", discountName=" + discountName + ", description=" + description
				+ ", discount_percentage=" + discount_percentage + ", validThru=" + validThru + "]";
	}
    //HashCode Method
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + discountId;
		result = prime * result + ((discountName == null) ? 0 : discountName.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount_percentage);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((validThru == null) ? 0 : validThru.hashCode());
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
		Discount other = (Discount) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (discountId != other.discountId)
			return false;
		if (discountName == null) {
			if (other.discountName != null)
				return false;
		} else if (!discountName.equals(other.discountName))
			return false;
		if (Double.doubleToLongBits(discount_percentage) != Double.doubleToLongBits(other.discount_percentage))
			return false;
		if (validThru == null) {
			if (other.validThru != null)
				return false;
		} else if (!validThru.equals(other.validThru))
			return false;
		return true;
	}

}
