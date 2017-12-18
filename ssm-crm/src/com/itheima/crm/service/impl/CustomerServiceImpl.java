package com.itheima.crm.service.impl;

import java.util.List;

import javax.crypto.CipherInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public Page<Customer> getCustomerList(CustomerInfo customerInfo, int curPage) {
		// 1、根据curPage计算start。（curPage - 1）* rows
		int start = (curPage-1)*customerInfo.getRows();
		// 2、把start设置到CustomerInfo对象中
		customerInfo.setStart(start);
		// 3、执行查询，得到一个客户列表
		List<Customer> list = customerMapper.getCustomerList(customerInfo);
		// 4、取查询结果总记录数。
		int tatol = customerMapper.getCustomerListCount(customerInfo);
		// 5、把结果封装到Page对象中。
		Page<Customer> result = new Page<>();
		result.setRows(list);
		result.setTotal(tatol);
		result.setPage(curPage);
		//当前页的条数
		result.setSize(customerInfo.getRows());
		return result;
	}

	@Override
	public Customer getCustomerById(long id) {
		Customer customer = customerMapper.getCustomerById(id);
		return customer;
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateCustomer(customer);
	}

	@Override
	public void deleteCustomer(Long id) {
		customerMapper.deleteCustomer(id);
	}

}
