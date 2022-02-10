package com.audit.jwtauditmanagement.model;

import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@ExtendWith(SpringExtension.class)
@SpringBootTest

public class AuthResponseTest {

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
		
		authResponse.setUid("audit1");
		assertEquals("audit1" , authResponse.getUid() );
		
	}

	@Test
	public void testIsValid()
	{
		authResponse.setValid(true);
		assertEquals( true , authResponse.isValid());
	}

	@Test
	public void testtoString() 
	{
        String s = authResponse.toString();
        assertEquals( s , authResponse.toString());
    }

}
