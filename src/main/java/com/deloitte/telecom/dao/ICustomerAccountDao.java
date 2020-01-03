package com.deloitte.telecom.dao;

import java.util.Map;

import com.deloitte.telecom.entities.CustomerAccount;

public interface ICustomerAccountDao {
	
	CustomerAccount findByMobileNo(String mobileNo);
	
	void rechargeAccount(CustomerAccount c,double amount);

	
	CustomerAccount createAccount(String mobileNo, String name, String accountType, double initialBalance);

	Map<String, CustomerAccount> getStore();

}
