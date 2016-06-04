package com.flp.pms.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Discount;
import com.flp.pms.domain.Product;
import com.flp.pms.domain.SubCategory;
import com.flp.pms.domain.Supplier;
import com.flp.pms.util.Validate;

public class UserInteraction {

	// Prompting the fields for adding product
	@SuppressWarnings("deprecation")
	public Product addProduct(List<Category> categories, List<SubCategory> subCategories, List<Supplier> suppliers,
			List<Discount> discounts) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		Product product = new Product();

		// prompt valid productName
		String productName;
		do {
			System.out.println("Enter ProductName:");
			productName = sc.nextLine();
			flag = Validate.isValidProductName(productName);
			if (!flag)
				System.out.println("* Invalid ProductName!");
		} while (!flag);
		product.setProductName(productName);

		System.out.println("Enter Product Description:");
		String description = sc.nextLine();
		product.setDescription(description);

		// prompt ManufacturingDate
		String manufact_Date;
		do {
			System.out.println("Enter Manufacturing Date:[dd-MMM-yyyy]");
			manufact_Date = sc.next();
			flag = Validate.isValidDate(manufact_Date);
			if (!flag)
				System.out.println("* Invalid Date Format!");

		} while (!flag);
		product.setManufacturing_date(new Date(manufact_Date));

		// prompt ExpiryDate
		String expiry_Date;
		boolean ex_flag = false;

		// Check valid Expiry Date
		do {

			// Validate Date Format
			do {
				System.out.println("Enter Expiry Date:[dd-MMM-yyyy]");
				expiry_Date = sc.next();
				flag = Validate.isValidDate(expiry_Date);
				if (!flag)
					System.out.println("* Invalid Date Format!");

			} while (!flag);

			ex_flag = Validate.isValidExpiryDate(new Date(expiry_Date));

			if (!ex_flag)
				System.out.println("* Expiry Date must be future Date!");
		} while (!ex_flag);
		product.setExpiry_date(new Date(expiry_Date));

		// prompt Maximum Retail Price
		System.out.println("Enter Maximum Retail Price:");
		double price = sc.nextDouble();
		product.setMax_retail_price(price);

		// prompt Quantity
		int quantity = 0;
		do {
			System.out.println("Enter Product Quantity:");
			quantity = sc.nextInt();
			flag = Validate.isValidQuantity(quantity);
			if (!flag)
				System.out.println("* Qunaity Should be positive integer!");
		} while (!flag);
		product.setQuantity(quantity);

		// prompt Ratings
		float ratings = 0.0f;
		do {
			System.out.println("Enter Product Ratings:");
			ratings = sc.nextFloat();
			flag = Validate.isValidRatings(ratings);
			if (!flag)
				System.out.println("* Ratings Should be between 1.0 and 5.0!");
		} while (!flag);
		product.setRatings(ratings);

		// prompt valid category Details
		Category category = getCategory(categories);
		product.setCategory(category);

		// Prompt SubCategory Details
		SubCategory subCategory = getSubCategory(subCategories, category);
		product.setSubCategory(subCategory);

		// Prompt Supplier Details
		Supplier supplier = getSupplier(suppliers);
		product.setSupplier(supplier);

		// Prompt Discount Details
		List<Discount> discounts2 = getDiscounts(discounts);
		product.setDiscounts(discounts2);

		return product;
	}

	// Choose Category
	public Category getCategory(List<Category> categories) {
		// Choose Category
		Category category = null;
		boolean flag = false;

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Choose Catgeory Id:");
			for (Category category1 : categories)
				System.out.println(category1.getCategory_Id() + "\t" + category1.getCategory_Name() + "\t"
						+ category1.getDescription());
			choice = sc.nextInt();

			// Validate the Category
			for (Category category1 : categories) {
				if (choice == category1.getCategory_Id()) {
					category = category1;
					flag = true;
					break;
				}
			}
			if (!flag)
				System.out.println("* Please choose Valid Category ID!");
		} while (!flag);

		return category;
	}

	// Choose Sub Category
	public SubCategory getSubCategory(List<SubCategory> categories, Category category) {
		SubCategory subCategory = null;
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int option;
		boolean flag = false;

		do {
			System.out.println("Choose Product Sub Category:");
			for (SubCategory subCategory2 : categories) {
				if (subCategory2.getCategory().getCategory_Id() == category.getCategory_Id())
					System.out.println(subCategory2.getSub_category_Id() + "\t" + subCategory2.getSub_category_Name());
			}
			option = scanner.nextInt();

			// Check Valid SubCategory
			for (SubCategory subCategory2 : categories) {
				if (option == subCategory2.getSub_category_Id()) {
					subCategory = subCategory2;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("* Please choose valid Sub category!");

		} while (!flag);

		return subCategory;
	}
    //choose Supplier
	public Supplier getSupplier(List<Supplier> suppliers) {
		Supplier supplier = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean flag = false;

		flag = false;
		do {
			System.out.println("Choose Supplier");
			for (Supplier supplier1 : suppliers) {

				System.out.println(supplier1.getSupplierId() + "\t" + supplier1.getFirstName() + "\t"
						+ supplier1.getLastName() + "\t" + supplier1.getAddress() + "\t" + supplier1.getCity() + "\t"
						+ supplier1.getState() + "\t" + supplier1.getPincode() + "\t" + supplier1.getContactno());
			}
			option = sc.nextInt();

			// Check Valid Supplier
			for (Supplier supplier1 : suppliers) {
				if (option == supplier1.getSupplierId()) {
					supplier = supplier1;
					flag = true;
					break;
				}
			}

			if (!flag)
				System.out.println("* Please choose valid Sub category!");

		} while (!flag);

		return supplier;

	}
    //Choose Discount
	public List<Discount> getDiscounts(List<Discount> discounts) {
		List<Discount> discounts2 = new ArrayList<Discount>();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int option = 0;
		boolean flag = false;
		String choice = null;

		do {
			flag = false;
			do {
				System.out.println("Choose Dicounts for the Product:");
				for (Discount discount : discounts) {
					// check valid discounts
					if (discount.getValidThru().after(new Date())) {
						// System.out.println(discount.getValidThru());
						System.out.println(discount.getDiscountId() + "\t" + discount.getDiscountName() + "\t"
								+ discount.getDescription() + "\t" + discount.getDiscount_percentage());
					}

				}
				option = sc.nextInt();

				// Validate Discount
				L3: for (Discount discount : discounts) {
					if (discount.getDiscountId() == option) {
						discounts2.add(discount);
						flag = true;
						break L3;
					}
				}

				if (!flag)
					System.out.println("* Choose Valid Discount Id!");

			} while (!flag);

			System.out.println("You wish to add more discounts for this product?[Y|N]");
			choice = sc.next();

		} while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');

		return discounts2;
	}
    //Show The Searched Product
	public void showSearchedProduct(Product searchedProduct) {
		if (searchedProduct != null)
			System.out.println(searchedProduct);
		else
			System.out.println("Product not found.");

	}
    //Get The Product Name From User
	public String getProductName() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product name: ");
		String productName = sc.nextLine();
		return productName;
	}
    //Get The supplier Name From User
	public String getSupplierName() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter supplier name: ");
		String supplierName = sc.nextLine();
		return supplierName;
	}
    //Get The Category Name from User
	public String getCategoryName() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter category name: ");
		String categoryName = sc.nextLine();
		return categoryName;
	}
    //Get The SubCategory Name From User
	public String getSubCategoryName() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter sub-category name: ");
		String subCategoryName = sc.nextLine();
		return subCategoryName;
	}
    //Get The Ratings From User
	public float getRating() {
		float rating = 0.0f;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("Enter Product Ratings:");
			rating = sc.nextFloat();
			flag = Validate.isValidRatings(rating);
			if (!flag)
				System.out.println("* Ratings Should be between 1.0 and 5.0!");
		} while (!flag);
		return rating;
	}
    //View All Products
	public void viewAllProduts(List<Product> listOfProducts) {
		if (!listOfProducts.isEmpty()) {
			for (Product product : listOfProducts)
				System.out.println(product);
		} else {
			System.out.println("No produts available to show.");
		}

	}
    //Get Product Id 
	public int getProductId() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product Id: ");
		int productId = sc.nextInt();
		return productId;
	}
    //Give The Status For Remove Product
	public void getDeleteStatus(boolean removeProduct) {

		if (removeProduct)
			System.out.println("Product removed.");
		else
			System.out.println("Product not removed.");
	}
    //Get The Product Name From User For Update
	public String getProductNameForUpdate() {
		String productName;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		boolean flag = false;
		do {
			System.out.println("Enter ProductName:");
			productName = sc.nextLine();
			flag = Validate.isValidProductName(productName);
			if (!flag)
				System.out.println("* Invalid ProductName!");
		} while (!flag);
		return productName;
	}
    //Get The Product ExpiryDate From User For Update 
	@SuppressWarnings("deprecation")
	public Date getProductExDateForUpdate() {
		String expiry_Date;
		boolean flag = false;
		boolean ex_flag = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {

			// Validate Date Format
			do {
				System.out.println("Enter Expiry Date:[dd-MMM-yyyy]");
				expiry_Date = sc.next();
				flag = Validate.isValidDate(expiry_Date);
				if (!flag)
					System.out.println("* Invalid Date Format!");

			} while (!flag);

			ex_flag = Validate.isValidExpiryDate(new Date(expiry_Date));

			if (!ex_flag)
				System.out.println("* Expiry Date must be future Date!");
		} while (!ex_flag);
		return new Date(expiry_Date);
	}
    //Get The Product MRP From User For Update
	public double getProductMaxRetailPriceForUpdate() {
		double price;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Maximum Retail Price:");
		price = sc.nextDouble();
		return price;
	}
    //Get The Product Rating From User For Update
	public float getProductRatingForUpdate() {
		float ratings = 0.0f;
		boolean flag = false;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Enter Product Ratings:");
			ratings = sc.nextFloat();
			flag = Validate.isValidRatings(ratings);
			if (!flag)
				System.out.println("* Ratings Should be between 1.0 and 5.0!");
		} while (!flag);
		return ratings;
	}
    //Get The Confirmation From User For Remove The Product
	public static boolean getUserConfirmationForDelete() {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Do you really want to delete this product? Y/N");
		String userConfirmation = sc.next();
		if (userConfirmation.equalsIgnoreCase("y"))
			return true;
		else
			return false;
	}
    //Get The User Confirmation To Update The Product
	public static boolean getUserConfirmationForUpdate() {
		@SuppressWarnings("resource")
		Scanner scn=new Scanner(System.in);
		System.out.println("Do You Really want to update the product? Y/N");
		String userconfirmation=scn.next();
		if (userconfirmation.equalsIgnoreCase("y"))
			return true;
		else
			return false;
		}

	public void showAddingStatus(boolean flag) {
		
		if(flag)
			System.out.println("Product added.");
		else
			System.out.println("Product not added.");
		
	}
}