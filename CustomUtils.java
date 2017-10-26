package com.custom;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

/**
 * @author kingshuk.nandy
 *
 */

public class CustomUtils {

	/**
	 * @param driver
	 * @param element
	 * @param fingers
	 * @param duration
	 */
	public static void tabByCoordinates(AppiumDriver driver, WebElement element,int fingers,int duration){
		driver.tap(fingers, element, duration);
	}
	
	/**
	 * @param driver
	 * @param element
	 * @param fingers
	 * @param duration
	 */
	public static void tabByElement(AppiumDriver driver, WebElement element,int fingers,int duration){
		Point point=element.getLocation();
		driver.tap(fingers, point.x, point.y, duration);
		
	}
	
	public static void scrollToNativeElement1(AppiumDriver driver, WebElement element){

		driver.scrollTo(element.getText().toString());
		//driver.scrollToExact(arg0)
		
	}
	
	
	/**
	 * @Description if we get any exception while clicking
	 * @param element
	 * @throws InterruptedException
	 */
	public static void clickWebelement(WebElement element) throws InterruptedException{
		try {
			element.click();
		} catch (Exception e) {
			//If Exception Occured
			//Handle the exception
			Thread.sleep(2000);
			element.click();
		}
	}
	
	
	
	/**
	 * @Description if no exception is generated while clicking but the element is not clicked
	 * @param elementToBeClicked
	 * @param elementNextPage
	 * @throws InterruptedException
	 */
	public static void clickWebelementOther(AppiumDriver driver,WebElement elementToBeClicked, WebElement elementNextPage) throws InterruptedException{
			elementToBeClicked.click();
			if(!elementNextPage.isDisplayed()){
				Thread.sleep(2000);
				/*JavascriptExecutor js= JavascriptExecutor(driver);
				js.executeScript("Argument[0].setAttribute('visible','true')", elementToBeClicked);*/
				elementToBeClicked.click();
			}
		}

	/**
	 * @Description By JS we are making the Clickable property true and then click on the WebElement
	 * @param driver
	 * @param elementToBeClicked
	 */
	public static void clickOnElement(AppiumDriver driver,WebElement elementToBeClicked){
		
		if ((boolean)elementToBeClicked.getAttribute("clickable").equalsIgnoreCase("false")) {
			JavascriptExecutor js=(JavascriptExecutor) driver;
			js.executeScript("Argument[0].setAttribute('clickable','true')", elementToBeClicked);
			}
		elementToBeClicked.click();
	}
	
	public static void scrollToNativeElement(AppiumDriver driver, WebElement element){

		driver.scrollTo(element.getText().toString());
		//driver.scrollToExact(arg0)
		
	}

	
	/**
	 * @Description Start swiping 
	 * @param driver
	 * @param startx
	 * @param starty
	 * @param endx
	 * @param endy
	 * @param duration
	 */
	public static void scrollToHalfScreensize(AppiumDriver driver,int startx, int starty, int endx, int endy, int duration){
		
		driver.swipe(startx, starty, endx, endy, duration);
	}
	
	 //Swipe from Bottom to Top.
	public static void swipeFromBottomToTop(AppiumDriver driver) throws InterruptedException{
		Dimension size=driver.manage().window().getSize();
		System.out.println("Size:"+size);
		
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.80);
		  
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		
		  //Swipe from Bottom to Top.
		  driver.swipe(startx, starty, startx, endy, 1000);
		  Thread.sleep(2000);
		
	}
	
	 //Swipe from Bottom to Top.
	public static void swipeFromTopToBottom(AppiumDriver driver) throws InterruptedException{
		Dimension size=driver.manage().window().getSize();
		System.out.println("Size:"+size);
		
		  //Find starty point which is at bottom side of screen.
		  int starty = (int) (size.height * 0.80);
		  
		  //Find endy point which is at top side of screen.
		  int endy = (int) (size.height * 0.20);
		  
		  //Find horizontal point where you wants to swipe. It is in middle of screen width.
		  int startx = size.width / 2;
		
		  //Swipe from Bottom to Top.
		  driver.swipe(startx, endy, startx, starty, 1000);
		  Thread.sleep(2000);
		
	}
	
	

	/**
	 *  * @Description Horizontal Scroll and Vertical scroll
	 * @param driver
	 * @param elementStart
	 * @param elementEnd
	 * @param duration
	 */
	public static void swipeToNativeElement(AppiumDriver driver, WebElement elementStart,WebElement elementEnd,int duration ){
		int startx=driver.scrollTo(elementStart.getText()).getLocation().getX();
		int starty=driver.scrollTo(elementStart.getText()).getLocation().getY();;
		
		int endx=driver.scrollTo(elementEnd.getText()).getLocation().getX();
		int endy=driver.scrollTo(elementEnd.getText()).getLocation().getY();
		driver.swipe(startx, starty, endx, endy, duration);
		}
}
