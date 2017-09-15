package testcases;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class temp5 {

		public static void main(String[] args) throws FileNotFoundException {
			
			 DateFormat df = new SimpleDateFormat("dd MMMM-HH_mm_ss");
			 Date dateobj = new Date();
			 System.out.println("Analysis Start Time: "+df.format(dateobj));
		}
	}

