package testcases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\thinksysuser\\Desktop\\SeleniumJar\\chromedriver.exe");
		boolean p=true;
		String Xml_With_NewFeed=null;
		WebElement ele3;
		
		while(p)
		{
		int i=0;
		String Title2="Title2";
		
		WebDriver d;
		d=new ChromeDriver();
		d.get("http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml");
		WebElement ele1= d.findElement(By.xpath("/html/body/rss/channel/item[1]/description/p[2]"));
		String Title1=ele1.getText();
		System.out.println("Title 1 is: "+Title1);
		d.quit();
		
		boolean cond=true;
	One:while(cond==true)
			
		{
			i=i+1;
			System.out.println(i);
		d=new ChromeDriver();
		d.get("http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml");
		WebElement ele2= d.findElement(By.xpath("/html/body/rss/channel/item[1]/description/p[2]"));
		Title2=ele2.getText();
		System.out.println("Title2 is: "+Title2);
		d.quit();
		
		  	if(!Title1.equals(Title2))
		  		{
		  		System.out.println("New Feed Inserted");
		    	Xml_With_NewFeed=d.getPageSource();
		  		cond=false;
		  		break One;
		  		}
		  	    else
		  		continue;
		}
		
		
		for (long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(10);stop>System.nanoTime();) {
			  System.out.println("In second loop which will run for 10 seconds");
			d=new ChromeDriver();
			d.get("http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml");
			try
			{
			ele3= d.findElement(By.xpath("/html/body/rss/channel/item[1]/description/p[2]"));
			}
			catch(Exception e)
			{
				d.get("http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml");
				ele3= d.findElement(By.xpath("/html/body/rss/channel/item[1]/description/p[2]"));
			}
			String Title3=ele3.getText();
			System.out.println(Title3);
			d.quit();
			
			if(!Title3.equals(Title2))
			{
				if(Title3.equals(Title1))
				{
					System.out.println("Feed Deleted");
					
					String Xml_With_NewFeed_Deleted=d.getPageSource();
					saveXmlFile(Xml_With_NewFeed,"Xml_With_NewFeed");
					saveXmlFile( Xml_With_NewFeed_Deleted,"Xml_With_NewFeed_Deleted");
					p=false;
				}	
			}
			}
	}

	}
	
	public static void saveXmlFile(String xmlString, String name)	
	{
		   BufferedWriter bufferedWriter = null;
	        try {
	            String strContent = xmlString;
	            File myFile = new File("C:/Users/thinksysuser/Desktop/XmlFiles/"+name+".txt");
	            // check if file exist, otherwise create the file before writing
	            if (!myFile.exists()) {
	                myFile.createNewFile();
	            }
	            
	            Writer writer = new FileWriter(myFile);
	            bufferedWriter = new BufferedWriter(writer);
	            bufferedWriter.write(strContent);
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally{
	            try{
	                if(bufferedWriter != null) bufferedWriter.close();
	            } catch(Exception ex){
	                 
	            }
	        }
	
		
	}
}

