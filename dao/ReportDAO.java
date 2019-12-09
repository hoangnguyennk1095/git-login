package com.hiber.dao;

import java.util.List;

public interface ReportDAO {
	List<Object[]> inventoryByCategory();
	
	List<Object[]> revenueByCategory();
	List<Object[]> revenueByCustomer();
	List<Object[]> revenueByQuarter();
}
