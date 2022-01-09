package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.base.BaseClass;

public class ListenerEx extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
		test= report.createTest(result.getName());
		log.info("testcase is started for execution");
	}
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, "testcase passed successfully");
		
	}
	public void onTestFailure(ITestResult result) {
		test.addScreenCaptureFromPath(getScreenshot(result.getName()));
		test.log(Status.FAIL, "testcase is failed");
		test.log(Status.FAIL, result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "testcase is skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		log.info("test module started");
		
	}

	public void onFinish(ITestContext context) {
		log.info("test module finished");
		report.flush();
		
	}

}
