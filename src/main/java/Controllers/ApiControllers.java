package Controllers;
import Entities.Word;
import Entities.restApi;
import com.google.gson.Gson;

import javax.xml.bind.JAXBException;
import java.net.ProtocolException;

public class ApiControllers {
    Helpers helpers = new Helpers();
    restApi api;

    {
        try {
            api = new restApi().apiLoader();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    public String status() throws ProtocolException {
        return helpers.getRequest(api.getStatus());
    }

    /**
     * Get First and Last Page Jumpers
     * @return
     * @throws ProtocolException
     */
    public String firtPage() throws ProtocolException {
        return helpers.postRequest(api.getFirstPage());
    }
    public String lastPage() throws ProtocolException {
        return helpers.postRequest(api.getLastPage());
    }

    /**
     * First and Last Term in page Jumpers
     * @return
     * @throws ProtocolException
     */
    public String firtTermOfPage() throws ProtocolException {
        return helpers.postRequest(api.getFirstTerm());
    }
    public String lastTermOfPage() throws ProtocolException {
        return helpers.postRequest(api.getLastTerm());
    }

    /**
     * next page and Previous Page Jumpers
     * @return
     * @throws ProtocolException
     */
    public String nextPage() throws ProtocolException {
        return helpers.postRequest(api.getNextPage());
    }

    public String prevPage() throws ProtocolException {
        return helpers.postRequest(api.getPrevPage());
    }

    /**
     * First Page first and Last
     * @return
     * @throws ProtocolException
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
     * @return
     * @throws ProtocolException
     */

    public String lastPageFirstTerm() throws ProtocolException {
        helpers.postRequest(api.getLastPage());
        return helpers.postRequest(api.getLastTerm());
    }

    public String lastPageLastTerm() throws ProtocolException {
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

    public static int testing (int a) {
        return a++;
    }


}