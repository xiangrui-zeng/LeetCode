import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class SimpleLogin {

    public void main(String[] args) {
        ping();
    }

    /**
     * Ping custom server by AuthInfo
     * @param contextUrl
     * @param authInfo
     * @return
     */
    public static boolean ping() {

        // ping url
        String pingURL = "http://chura.dreamarts.co.jp/hibiki/rest/1/session/";

        // client
        CloseableHttpClient httpClient = HttpClients.createDefault();

        // post method
        HttpGet get = new HttpGet(pingURL);
        get.setHeader("Connection", "close");

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(get);
            int status = response.getStatusLine().getStatusCode();
            System.out.println(status);
        } catch (Exception e) {
            get.abort();
            return false;
        }

        return true;
    }
}
