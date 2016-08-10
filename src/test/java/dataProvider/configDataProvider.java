package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configDataProvider {
	
	Properties p;
	public configDataProvider()
	{	
		
		File f =new File("C:/Users/pc/workspace1/com.primologic.mercury/Configutation/config.properties");
		
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
	
	public String getchromePath()
	{
		return p.getProperty("chromepath");
	}
	public String getIEPath()
	{
		return System.getProperty("User.dir")+p.getProperty("IEPath");
	}
	
}
