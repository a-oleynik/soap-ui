package com.dataart.api.listeners;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.model.support.TestRunListenerAdapter;
import com.eviware.soapui.model.testsuite.TestCaseRunContext;
import com.eviware.soapui.model.testsuite.TestCaseRunner;
import com.eviware.soapui.model.testsuite.TestRunListener;
import com.eviware.soapui.plugins.ListenerConfiguration;
import com.eviware.soapui.support.listener.SoapUIListenerRegistry;

@ListenerConfiguration
public class MyListener extends TestRunListenerAdapter {
	
	private long startTime;
	
	static
	{
		final SoapUIListenerRegistry registry =SoapUI.getSoapUICore().getListenerRegistry();
		registry.addListener(TestRunListener.class, MyListener.class, null);
	}

    @Override
    public void beforeRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
		startTime = System.nanoTime();
        SoapUI.log("Test " + testRunner.getTestCase().getName() + " starting...");
    }

    @Override
    public void afterRun(TestCaseRunner testRunner, TestCaseRunContext runContext) {
		long endTime = System.nanoTime();
        SoapUI.log("Test " + testRunner.getTestCase().getName() + " stopping...");
		SoapUI.log( "TestCase [" + testRunner.getTestCase().getName() + "] took " + (endTime-startTime) + " nanoseconds." );
    }
}