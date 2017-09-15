package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class configDataProvider {
	
	Properties p;
	File f;
	public configDataProvider()
	{	
		
		f =new File("./Configutation/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(f);
			
			p=new Properties();
			p.load(fis);
			
		} 
		catch (Exception e)
		{
		System.out.println("Custom Exception- cannot load properties file"+e.getMessage());
		}		
	}
	
	public String getvalue(String key)	
	{
		return p.getProperty(key);
	}
	
	public String getUrl()
	{
		return p.getProperty("url");	
	}
	
	public String getUrl1()
	{
		return p.getProperty("url1");	
	}
	
	public String getchromePath()
	{
		return p.getProperty("chromepath");
	}
	public String getIEPath()
	{
		return System.getProperty("User.dir")+p.getProperty("IEPath");
	}
	
	public void setPro(String key, String value) throws FileNotFoundException, IOException
	{
		p.setProperty(key, value);
		p.store(new FileOutputStream(f), "New property saved");
		
	}
	
}
