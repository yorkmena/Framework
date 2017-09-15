/**
 * 
 */
package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import resources.NewFileOnRebootAppender;
import dataProvider.configDataProvider;

/**
 * @author thinksysuser
 *
 */
public class temp extends TestBase {
	
	
	@Test
	public void sampleTest()

	{
		log.info("Sample TestCase Executed-1");
		log.info("Sample TestCase Executed-2");
		Assert.assertTrue(true);
		log.info("Test Case Failed");
		
		/*configDataProvider dataProvider=null;
		System.out.println(dataProvider.getvalue("ExcelFilePath"));*/
	}

}
