package com.cg.omts.testing;

import static org.junit.Assert.assertEquals;

import java.sql.Date;

import org.junit.Test;

import com.cg.omts.dto.Customer;
import com.cg.omts.exceptions.OMTSException;
import com.cg.omts.service.AdminServiceImpl;
import com.cg.omts.service.IAdminService;

public class LoginTest {
	IAdminService adminService = new AdminServiceImpl();
	
	@Test
	public void loginTestUser() throws OMTSException
	{
		String validate ="usr";
		Customer user = new Customer(54321, "usr");
		String result= adminService.validateLogin(user);
		assertEquals(validate,result);
	}
	
	@Test
	public void registerTest() throws OMTSException
	{
		int rows=1;
		Date d=Date.valueOf("2001-12-12");
		Customer user = new Customer(2, "Ashutosh", "hi@123", d, 123456, "usr");
	}
	
	@Test
	public void loginTestAdmin() throws OMTSException
	{
		String validate ="adm";
		Customer user = new Customer(12345, "adm");
		String result= adminService.validateLogin(user);
		assertEquals(validate,result);
	}
}
