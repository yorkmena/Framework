package Factory;

import dataProvider.ExcelDataProvider;
import dataProvider.configDataProvider;


public class DataProviderFactory {
	
	
	public static configDataProvider getConfig()
	{
		configDataProvider config=new configDataProvider();
		return config;
	}
	
	public static ExcelDataProvider getExcel()
	{
	    ExcelDataProvider excel=new ExcelDataProvider();
	    return excel;
	}

}
