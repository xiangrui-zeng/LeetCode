import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class SimpleLogin {

    public static void main(String[] args) throws ClientProtocolException, IOException {
        String user = "";
        String ps = "";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input UserName :");
        user = scanner.next();
        System.out.println("Input PassWord :");
        ps = scanner.next();

        CloseableHttpResponse res = login(user, ps);
        getlist(res.getHeaders("Set-Cookie")[0].getValue());
    }

    /**
     * Ping custom server by AuthInfo
     * @param contextUrl
     * @param authInfo
     * @return
     * @throws IOException 
     * @throws ClientProtocolException 
     */
    public static CloseableHttpResponse login(String user, String ps) throws ClientProtocolException,
            IOException {

        String pingURL = "http://hiyaku.tokyo.dreamarts.co.jp/hibiki/rest/1/session";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpPost post = new HttpPost(pingURL);

        ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
        NameValuePair pair1 = new BasicNameValuePair("loginid", user);
        NameValuePair pair2 = new BasicNameValuePair("password", ps);
        params.add(pair1);
        params.add(pair2);

        HttpEntity he;
        he = new UrlEncodedFormEntity(params, Consts.UTF_8);
        post.setEntity(he);
        CloseableHttpResponse response = httpClient.execute(post);
        return response;
    }

    public static boolean getlist(String cookie) throws ClientProtocolException, IOException {

        String pingURL = "http://hiyaku.tokyo.dreamarts.co.jp/hibiki/rest/1/binders";

        CloseableHttpClient httpClient = HttpClients.createDefault();

        HttpGet httpget = new HttpGet(pingURL);

        httpget.setHeader("Accept-Encoding", "gzip");
        httpget.setHeader("Accept", "application/json");
        httpget.addHeader("Cookie", cookie);

        CloseableHttpResponse response = httpClient.execute(httpget);

        HttpEntity entity = response.getEntity();

        if (entity != null) {
            //getResponse    
            BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        }

        return true;
    }
}
