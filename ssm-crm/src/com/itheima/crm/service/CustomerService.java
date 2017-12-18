package com.itheima.crm.service;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
	
	Page<Customer> getCustomerList(CustomerInfo customerInfo,int curPage);
	
	Customer getCustomerById(long id);
	
	void updateCustomer(Customer customer);
	
	void deleteCustomer(Long id);
 	 
}
