/**
 * 
 */
package resources;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

/**
 * @author thinksysuser
 *File Appender class has been extended and a new Appender with the name NewFileOnRebootAppender is created which is used in log4j properties.
 *Purpose: To create a new Log file on every execution and File name contaning Current date and time.
 */
public class NewFileOnRebootAppender extends FileAppender {
	
	//Date class obj to get the current date and time to be used in logger file name.
	
	 static DateFormat df = new SimpleDateFormat("dd-M-yyyy hh-mm-ss");
	 static Date dateobj = new Date();
	
	 public NewFileOnRebootAppender() {
	    }

	    @Override
	    public void setFile(String file) {
	        super.setFile(prependDate(file));
	    }

	    private static String prependDate(String filename) {
	    	
	        return filename+ " " +df.format(dateobj)+".log"  ;
	        
	    }

}
