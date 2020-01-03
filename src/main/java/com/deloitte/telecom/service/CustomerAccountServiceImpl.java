package com.deloitte.telecom.service;

import com.deloitte.telecom.dao.ICustomerAccountDao;
import com.deloitte.telecom.entities.CustomerAccount;
import com.deloitte.telecom.exceptions.IncorrectMobileNoException;
import com.deloitte.telecom.exceptions.MobileNumberAlreadyExistsException;

public class CustomerAccountServiceImpl implements ICustomerAccountService {
	
	private ICustomerAccountDao dao;
	

	public CustomerAccountServiceImpl(ICustomerAccountDao dao) {
		super();
		this.dao = dao;
	}
	
	
	@Override
	public ICustomerAccountDao getDao() {
		return dao;
	}



	public void setDao(ICustomerAccountDao dao) {
		this.dao = dao;
	}



	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		if(mobileNo.length()!=10 || mobileNo==null)
		{
			throw new IncorrectMobileNoException("Incorrect Mobile No.");
		}
		return dao.findByMobileNo(mobileNo);
	}

	@Override
	public void rechargeAccount(CustomerAccount c, double amount) {
		dao.rechargeAccount(c, amount);
		
	}

	@Override
	public CustomerAccount createAccount(String mobileNo, String name, String accountType, double initialBalance) {
		if(mobileNo==null ||mobileNo.length()!=10)
		{
			throw new IncorrectMobileNoException("Please enter a valid mobile number.");
		}
		return dao.createAccount(mobileNo, name, accountType, initialBalance);
	}
	

}
