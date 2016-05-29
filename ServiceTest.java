package com.flp.pms.test.services;

import org.junit.BeforeClass;

import com.flp.pms.service.IProductService;
import com.flp.pms.service.ProductServiceImpl;
public class ServiceTest{
	static IProductService iProductService;
	

	@BeforeClass
	public static void setUp() {
	iProductService = new ProductServiceImpl();

	}

	@Test
	public void testCountAllCategoriesWithAllOptions() {
	List<Category> categories = iProductService.getAllCategory();
	assertThat(categories.size(), allOf(is(5), instanceOf(Integer.class)));
	}

	@Test
	public void testGetAllCategory() {
	assertEquals(false, iProductService.getAllCategory().isEmpty());
	}

	@Test
	public void testGetAllSubCategory() {
	assertEquals(false, iProductService.getAllSubCategory().isEmpty());
	}

	@Test
	public void testGetAllDiscount() {
	assertEquals(false, iProductService.getAllDiscounts().isEmpty());
	}

}
