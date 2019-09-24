package com.powermock.demo.Getting_Started;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.RunWith;

import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;


import static org.mockito.Mockito.verify;
import static org.powermock.api.mockito.PowerMockito.*;



@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "com.powermock.demo.Getting_Started.*")
public class CollaboratorWithFinalMethodsTest {
	
	
	@Test
	public void firstTest() throws Exception {
		CollaboratorWithFinalMethods mock = mock(CollaboratorWithFinalMethods.class);
        whenNew(CollaboratorWithFinalMethods.class).withNoArguments().thenReturn(mock);

        CollaboratorWithFinalMethods collaborator = new CollaboratorWithFinalMethods();
        verifyNew(CollaboratorWithFinalMethods.class).withNoArguments();

        when(collaborator.helloMethod()).thenReturn("Hello Baeldung!");
        String welcome = collaborator.helloMethod();
        verify(collaborator).helloMethod();
        assertEquals("Hello Baeldung!", welcome);
	}
	

}
