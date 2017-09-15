package testcases;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class HttpClientExample {
	
/*	@SuppressWarnings("deprecation")
	HttpClient httpclient = new DefaultHttpClient();
	HttpGet httpget=new HttpGet("http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml");
	
	HttpResponse response = httpclient.execute(httpPost);
	String responseString = EntityUtils.toString(response.getEntity());
	String responseCode = String.valueOf(response.getStatusLine().getStatusCode());*/

	/*String url = "http://www.autobild.de/rss/feedburner/schlagzeilen_ohne_ms.xml";

	HttpClient client = HttpClientBuilder.create().build();
	HttpGet request = new HttpGet(url);
*/
	// add request header
	//request.addHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
	
	
}
