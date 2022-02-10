package com.audit.checklistauditmanagement.feignclient;


import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AuthResponseTest {

	@Mock
	AuthResponse authResponse=new AuthResponse();
	
	@Test
	public void testAuthResponseConstructor()
	{
		
		AuthResponse response=new AuthResponse("audit1", true);
		assertEquals( "audit1" ,  response.getUid() );
	}
	
	@Test
	public void testUid()
	{
		AuthResponse response=new AuthResponse();
		response.setUid("audit1");
		assertEquals("audit1" , response.getUid() );
	}
	

	@Test
	public void testIsValid()
	{
		AuthResponse response=new AuthResponse();
		response.setValid(false);
		assertEquals( false ,response.isValid());
	}
	
	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }

}
