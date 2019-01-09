package Controllers;
import Entities.Word;
import Entities.restApi;
import com.google.gson.Gson;

import javax.xml.bind.JAXBException;
import java.net.ProtocolException;

public class ApiControllers {
    private Helpers helpers = new Helpers();
    private restApi api;

    {
        try {
            api = new restApi().apiLoader();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public String status()  {
        return helpers.getRequest(api.getStatus());
    }

    /**
     * Get First and Last Page Jumpers
     * @return String
     */
    public String firtPage() {
        return helpers.postRequest(api.getFirstPage());
    }
    public String lastPage()   {
        return helpers.postRequest(api.getLastPage());
    }

    /**
     * First and Last Term in page Jumpers
     * @return String
     */
    public String firtTermOfPage()  {
        return helpers.postRequest(api.getFirstTerm());
    }
    public String lastTermOfPage()  {
        return helpers.postRequest(api.getLastTerm());
    }

    /**
     * next page and Previous Page Jumpers
     * @return String
     */
    public String nextPage() {
        return helpers.postRequest(api.getNextPage());
    }

    public String prevPage() {
        return helpers.postRequest(api.getPrevPage());
    }

    /**
     * First Page first and Last
     * @return String
     */
    public String firstPageFirstTerm() throws ProtocolException {
        helpers.postRequest(api.getFirstPage());
        return helpers.postRequest(api.getFirstTerm());
    }

    public String firstPageLastTerm() throws ProtocolException {
        helpers.postRequest(api.getFirstPage());
        return helpers.postRequest(api.getLastTerm());
    }

    /**
     * last Page first AND last
     * @return String
     */

    public String lastPageFirstTerm() {
        helpers.postRequest(api.getLastPage());
        return helpers.postRequest(api.getLastTerm());
    }

    public String lastPageLastTerm() {
        helpers.postRequest(api.getLastPage());
        return helpers.postRequest(api.getLastTerm());
    }

    public String nextPageFirstTerm() {
        helpers.postRequest(api.getNextPage());
        return helpers.postRequest(api.getFirstTerm());
    }

    public String next() {
       return helpers.postRequest(api.getNextTerm());
    }
    public String prev() {
        return helpers.postRequest(api.getPrevTerm());
    }

    public Word wordWrapper(String s) {
        Gson gson = new Gson();
        Word w= gson.fromJson(s, Word.class);
        return w;
    }
}