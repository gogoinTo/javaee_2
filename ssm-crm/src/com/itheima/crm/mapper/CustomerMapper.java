package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;

public interface CustomerMapper {
	
	List<Customer> getCustomerList(CustomerInfo customerInfo);
	int getCustomerListCount(CustomerInfo customerInfo);
	
	Customer getCustomerById(Long id);
	
	void updateCustomer(Customer Customer);
	
	void deleteCustomer(Long id);
}
