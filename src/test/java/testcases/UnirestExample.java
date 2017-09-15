package testcases;



import org.testng.annotations.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class UnirestExample {
	
	
	/*HttpClient httpclient = new DefaultHttpClient();
	HttpPost httpPost = new HttpPost("http://52.66.86.97/sellerbuyer/login");
	
	String responseCode = String.valueOf(response.getStatusLine().getStatusCode());
	*/
public static void main(String[] args) throws UnirestException {
	

	HttpResponse<String> TextResponse = Unirest.get("http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml").asString();
	System.out.println(TextResponse.getBody());
	
	String Title=TextResponse.getBody();
	
/*	
	Pattern p = Pattern.compile(<p style="float: left;">(.+?)</p>]]></description>);//. represents single character  
	Matcher m = p.matcher(Title);  
	boolean b = m.matches();  
	  
	*/
	
	
	
	
	
}
}