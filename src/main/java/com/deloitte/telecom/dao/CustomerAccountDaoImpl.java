package com.deloitte.telecom.dao;

import java.util.*;

import com.deloitte.telecom.entities.CustomerAccount;
import com.deloitte.telecom.exceptions.CustomerAccountNotFoundException;
import com.deloitte.telecom.exceptions.MobileNumberAlreadyExistsException;

public class CustomerAccountDaoImpl implements ICustomerAccountDao{
	
	Map<String,CustomerAccount> store=new HashMap<>();
	
	@Override
	public Map<String, CustomerAccount> getStore() {
		return store;
	}

	public void setStore(Map<String, CustomerAccount> store) {
		this.store = store;
	}

	@Override
	public CustomerAccount findByMobileNo(String mobileNo) {
		CustomerAccount c=store.get(mobileNo);
		if(c==null)
		{
			throw new CustomerAccountNotFoundException("Account not found for mobile no="+mobileNo);
		}
		return c;
	}

	@Override
	public void rechargeAccount(CustomerAccount c, double amount) {
		
		c.addBalance(amount);
		
	}

	@Override
	public CustomerAccount createAccount(String mobileNo, String name, String accountType, double initialBalance)
	{
		if(store.containsKey(mobileNo))
		{
			throw new MobileNumberAlreadyExistsException("Mobile no is already in store.");
		}
		CustomerAccount c=new CustomerAccount(mobileNo, name, accountType, initialBalance);
		store.put(mobileNo, c);
		return c;
	}

}
