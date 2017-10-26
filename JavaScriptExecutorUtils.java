package com.custom;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/**
 * @author kingshuk.nandy
 *
 */
/**
 * @author kingshuk.nandy
 *
 */
public class JavaScriptExecutorUtils {

	public static void demo(AppiumDriver driver){
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeAsyncScript("", "");
		js.executeScript("", "");
		
		//Perform Click on LOGIN button using JavascriptExecutor
		WebElement button = null;
        js.executeScript("arguments[0].click();", button);
	}
}
