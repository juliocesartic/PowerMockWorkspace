package com.powermock.demo.Getting_Started;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.powermock.demo.Getting_Started.CollaboratorWithStaticMethods")
public class CollaboratorWithStaticMethodsTest {

	@Test(expected = RuntimeException.class)
	public void test() {
		mockStatic(CollaboratorWithStaticMethods.class);
		
		when(CollaboratorWithStaticMethods.firstMethod(Mockito.anyString())).thenReturn("Hello");
		
		when(CollaboratorWithStaticMethods.secondMethod())
		.thenReturn("Nothing special");
		
		doThrow(new RuntimeException()).when(CollaboratorWithStaticMethods.class);
		CollaboratorWithStaticMethods.thirdMethod();
		
		
		String firstWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");
		String secondWelcome = CollaboratorWithStaticMethods.firstMethod("Whatever");
		
		assertEquals("Hello", firstWelcome);
		assertEquals("Hello", secondWelcome);
		
		verifyStatic(Mockito.times(2));
		CollaboratorWithStaticMethods.firstMethod(Mockito.anyString());
		
		verifyStatic(Mockito.never());
		CollaboratorWithStaticMethods.secondMethod();
		
		CollaboratorWithStaticMethods.thirdMethod();
	}
	
	

}
