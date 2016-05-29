
package com.flp.pms.view;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.flp.pms.domain.Category;
import com.flp.pms.domain.Product;
import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;

public class BootClass {

	public static void main(String[] args) {
		menuSelection();

	}
    //Menu Selection
	public static void menuSelection() {
		int option;
		String choice = null;
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		UserInteraction userInteraction = new UserInteraction();
		IProductService iProductService = new ProductServiceImpl();
		do {
			System.out.println("1.Create Product" + "\n2.Modify Product" + "\n3.Remove Product" + "\n4.View All Product"
					+ "\n5.Search Product" + "\n6.Exit");
			System.out.println("Enter your option:");
			option = sc.nextInt();

			switch (option) {
			case 1:
				Product product = userInteraction.addProduct(iProductService.getAllCategory(),
						iProductService.getAllSubCategory(), iProductService.getAllSupplier(),
						iProductService.getAllDiscounts());

				iProductService.addProduct(product);

				break;
			case 2:
				int pId = userInteraction.getProductId();
				Product p = iProductService.searchProductId(pId);
				if (p != null) {
					System.out.println("1.By Product Name" + "\n2.By Expiry Date" + "\n3. By Maximum Retail Price"
							+ "\n4.By Rating" + "\n5.By Category");
					System.out.println("Enter your option:");
					option = sc.nextInt();
					switch (option) {
					case 1:
						String pName = userInteraction.getProductNameForUpdate();
						iProductService.updateProductName(p, pName);
						break;
					case 2:
						Date expiryD = userInteraction.getProductExDateForUpdate();
						iProductService.updateProductExpDate(p, expiryD);
						break;
					case 3:
						double max = userInteraction.getProductMaxRetailPriceForUpdate();
						iProductService.updateProductMaxRetailPrice(p, max);
						break;

					case 4:
						float rating = userInteraction.getProductRatingForUpdate();
						iProductService.updateProductRating(p, rating);
						break;
					case 5:
						Category category = userInteraction.getCategory(iProductService.getAllCategory());
						iProductService.updateProductCategory(p, category);
						break;
					}
				} else {
					System.out.println("Product Id not found");
				}

				break;
			case 3:
				
					
               int productId = userInteraction.getProductId();
				Product productToRemove = iProductService.searchProductId(productId);
				if (productToRemove != null) {
					userInteraction.getDeleteStatus(iProductService.removeProduct(productToRemove));
					
				}
				
				
				else {
					System.out.println("Product Id not found");
				}

				break;
			case 4:
				List<Product> listOfProducts = iProductService.getAllProductsList();
				userInteraction.viewAllProduts(listOfProducts);
				break;
			case 5:
				System.out.println("1.By Name" + "\n2.By Supplier/Producer" + "\n3.By Category" + "\n4.By SubCategory"
						+ "\n5.By Ratings");
				System.out.println("Enter your option");
				option = sc.nextInt();
				Product searchedProduct = null;
				switch (option) {
				case 1:
					String productName = userInteraction.getProductName();
					searchedProduct = iProductService.searchByProductName(productName);
					userInteraction.showSearchedProduct(searchedProduct);
					break;
				case 2:
					String supplierName = userInteraction.getSupplierName();
					searchedProduct = iProductService.searchBySupplierName(supplierName);
					userInteraction.showSearchedProduct(searchedProduct);
					break;

				case 3:
					String categoryName = userInteraction.getCategoryName();
					searchedProduct = iProductService.searchByCategoryName(categoryName);
					userInteraction.showSearchedProduct(searchedProduct);
					break;
				case 4:
					String subCategoryName = userInteraction.getSubCategoryName();
					searchedProduct = iProductService.searchBySubCategoryName(subCategoryName);
					userInteraction.showSearchedProduct(searchedProduct);
					break;
				case 5:

					float rating = userInteraction.getRating();
					searchedProduct = iProductService.searchByRating(rating);
					userInteraction.showSearchedProduct(searchedProduct);
					break;
				default:
					System.out.println("Invalid input");
					break;

				}

				break;
			case 6:
				System.exit(0);
			}
			System.out.println("You wish to continue?[Y|N]");
			choice = sc.next();
		} while (choice.charAt(0) == 'y' || choice.charAt(0) == 'Y');
	}
    //User Confirmation For Remove The Product
	public static boolean userConfirmationForDelete() {
		return UserInteraction.getUserConfirmationForDelete();
	}
    //User Confirmation For Update The Product	
    public static boolean userConfirmationForUpdate() {
		return UserInteraction.getUserConfirmationForUpdate();
	}

}
