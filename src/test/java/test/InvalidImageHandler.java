package test;

import java.util.List;

import steps.InvalidImages;
import steps.WebDriverMethods;

public class InvalidImageHandler{

	public static void main(String[] args) 
	{
		InvalidImages objInvalidImages=new InvalidImages();
		WebDriverMethods objWebDriverMethods=new WebDriverMethods();
		objWebDriverMethods.launchChromeBrowser();
		List<String> imageList=objInvalidImages.getAllImageFromPage();
		objInvalidImages.displayBrokenAndUnbrokenImages(imageList);
		objWebDriverMethods.closebrowser();
	}
}
