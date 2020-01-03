package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.ICustomerAccountDao;
import com.deloitte.telecom.entities.CustomerAccount;

public interface ICustomerAccountService {
	
	CustomerAccount findByMobileNo(String mobileNo);
	
	void rechargeAccount(CustomerAccount c,double amount);
	
	CustomerAccount createAccount(String mobileNo, String name, String accountType, double initialBalance);

	ICustomerAccountDao getDao();
	

}
