package com.powermock.demo.Getting_Started;

import static org.powermock.api.mockito.PowerMockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.powermock.demo.Getting_Started.CollaboratorForPartialMocking")
public class CollaboratorForPartialMockingTest {
	
	@Test
	public void firstTest() throws Exception {
		
		String returnValue;
		
		spy(CollaboratorForPartialMocking.class);
		when(CollaboratorForPartialMocking.staticMethod()).thenReturn("I am a static mock method.");
		
		returnValue = CollaboratorForPartialMocking.staticMethod();
		
		verifyStatic();
		CollaboratorForPartialMocking.staticMethod();
		
		assertEquals("I am a static mock method.", returnValue);
		
		
		CollaboratorForPartialMocking collaborator = new CollaboratorForPartialMocking();
		CollaboratorForPartialMocking mock = spy(collaborator);
		
		when(mock.finalMethod()).thenReturn("I am a final mock method.");
		returnValue = mock.finalMethod();
		
		Mockito.verify(mock).finalMethod();
		
		assertEquals("I am a final mock method.", returnValue);
		
		when(mock, "privateMethod").thenReturn("I am a private mock method.");
		returnValue = mock.privateMethodCaller();
		
		verifyPrivate(mock).invoke("privateMethod");
		
		assertEquals("I am a private mock method. Welcome to the Java world.", returnValue);
		
	}
	

}
