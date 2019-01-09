package Controllers;


import Entities.Property;
import Entities.Word;
import Entities.restApi;
import com.google.gson.Gson;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.net.URL;

public class Helpers {

    private String base;
    private String key;
    private Property property;
    private restApi api;
    {
        try {
            api= new restApi().apiLoader();
            property = new Property().propertyLoader();
            base = property.getBase();
            key = property.getKey();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private String wrapper(String s) {
        return "https://"+base+s;
    }

    public String requestHelper(String command,String type) {

        String def = "Error In TRY BLOCK - HELPERS requestHelper";
        String wrappedUrl = wrapper(command);
        URL url = null;
        HttpPost requestP = null;
        HttpGet requestG = null;

        HttpClient client = HttpClientBuilder.create().build();
        if (type.equals("GET")) {
            requestG = new HttpGet(wrappedUrl);
            requestG.setHeader("x-api-key", key);
        }
        if (type.equals("POST")) {
            requestP = new HttpPost(wrappedUrl);
            requestP.setHeader("x-api-key", key);
        }
        try {
            HttpResponse response = null;
            if (type.equals("GET"))
                response = client.execute(requestG);
            if (type.equals("POST"))
                response = client.execute(requestP);
            assert response != null;
            String responseString = new BasicResponseHandler().handleResponse(response);
            return responseString;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return def;
    }
    public String getRequest(String command) {
        return requestHelper(command,"GET");
    }

    public String postRequest(String command) {
        return requestHelper(command,"POST");
    }


}
