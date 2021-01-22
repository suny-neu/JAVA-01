package java0.nio01;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpClientDemo {

    public static void main(String[] args) throws IOException {
        //打开浏览器
        CloseableHttpClient httpClient= HttpClients.createDefault();
        //声明get请求
        HttpGet httpGet=new HttpGet("http://localhost:8801");
        //3.发送请求
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode()==200){
            HttpEntity entity=response.getEntity();
            String content = EntityUtils.toString(entity);
            System.out.println(content);
        }
        response.close();
        httpClient.close();

    }
    
}


