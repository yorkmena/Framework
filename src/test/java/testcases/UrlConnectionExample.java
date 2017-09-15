package testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

//import javax.net.ssl.HttpsURLConnection;

public class UrlConnectionExample {
	public static void main(String args[]) throws Exception
	{
	
	 
		String url = "http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml";
	  URL obj = new URL(url);
	
	  HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	  con.setRequestMethod("GET");

		//add request header
		con.setRequestProperty("User-Agent", "Mozilla/5.0");

		int responseCode = con.getResponseCode();
		System.out.println(responseCode);
		
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		
		String Response_String=response.toString();
		saveXml(Response_String, "bcd_"+System.currentTimeMillis());
		parseXmlFile();
	}
	
	public static void saveXml(String xmlString, String name)	
	{
		   BufferedWriter bufferedWriter = null;
	        try {
	            String strContent = xmlString;
	            File myFile = new File("C:/Users/thinksysuser/Desktop/XmlFiles/"+name+".xml");
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
	
	//parse XML file saved Above
	private static void parseXmlFile(){
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		Document dom=null; 
		try {

			
			DocumentBuilder db = dbf.newDocumentBuilder();	
			dom = db.parse("C:\\Users\\thinksysuser\\Desktop\\XmlFiles\\abc.xml");
		}
		
		catch(ParserConfigurationException pce) 
		{
			pce.printStackTrace();
		}catch(SAXException se) {
			se.printStackTrace();
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
		//get the root element(parse Document)
		
				Element docEle = dom.getDocumentElement();

				//get a nodelist of elements
				String links1;
				NodeList nl = docEle.getElementsByTagName("item");
				if(nl != null && nl.getLength() > 0) {
					for(int i = 0 ; i < nl.getLength();i++) 
					{

				        //get the employee element
						Element el = (Element)nl.item(i);
						//add it to list\
						NodeList nodeList= el.getChildNodes() ;
						Node node = nodeList.item(1) ;
						links1= node.getFirstChild().toString();
						System.out.println(links1);
						getID(links1);
						
						
				     }		
					
					
		}
		}
	
	public static String getID(String link1)
	
	{
		String id=null;
		Pattern p = Pattern.compile("(\\w*).html", Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(link1);
		if (m.find()) 
		{
		id =m.group(1);
		System.out.println(id);	
		
		}
		return id;
  }
}
