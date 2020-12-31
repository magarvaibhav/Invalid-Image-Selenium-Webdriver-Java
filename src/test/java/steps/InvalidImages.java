package steps;

import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class InvalidImages extends WebDriverMethods {

	List<String> imageList=null;
	HttpURLConnection huc;
	
	public List<String> getAllImageFromPage() {
		imageList=new ArrayList<String>();
		System.out.println(driver);
		List<WebElement> allImage=driver.findElements(By.xpath("//img"));
		System.out.println("Total Links "+allImage.size());
		for(WebElement element:allImage)
		{
			String srcValue=element.getAttribute("src");
			  if(srcValue == null || srcValue.isEmpty())
			  {
				  System.out.println("Src is null or Empty");
				  continue;  
			  }
			  else
			  {
				  imageList.add(srcValue);
			  }
		}
		return imageList;
	}

	public void displayBrokenAndUnbrokenImages(List<String> imageList) {
		int invalidImageCount=0,counter=0,validImageCount=0;
		for(String image:imageList)
		{
			try
			{
				counter++;
				HttpClient client = (HttpClient) HttpClientBuilder.create().build();
				HttpGet request = new HttpGet(image);
				HttpResponse response = client.execute(request);
				if (response.getStatusLine().getStatusCode() != 200)
				{
					invalidImageCount++;
					System.out.println("Image "+counter+ ": Invalid ");
				}
				else
				{
					validImageCount++;
					System.out.println("Image "+counter+ ": Valid ");
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		}
		
		System.out.println("Valid Images Number "+validImageCount);
		System.out.println("InValid Images Number "+invalidImageCount);

	}
	
	

}
