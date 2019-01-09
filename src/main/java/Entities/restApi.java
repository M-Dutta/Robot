package Entities;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="RestInfo")
public class restApi {

    @XmlElement(name = "status")
    private String status;

    @XmlElement(name = "nextPage")
    private String nextPage;
    @XmlElement(name = "prevPage")
    private String prevPage;
    @XmlElement(name = "firstPage")
    private String firstPage;
    @XmlElement(name = "lastPage")
    private String lastPage;

    @XmlElement(name = "nextTerm")
    private String nextTerm;
    @XmlElement(name = "prevTerm")
    private String prevTerm;
    @XmlElement(name = "firstTerm")
    private String firstTerm;
    @XmlElement(name = "lastTerm")
    private String lastTerm;


    public restApi() {
    }

    public String getStatus() {
        return status;
    }

    public String getFirstPage() {
        return firstPage;
    }

    public String getLastPage() {
        return lastPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public String getPrevPage() {
        return prevPage;
    }

    public String getFirstTerm() {
        return firstTerm;
    }

    public String getLastTerm() {
        return lastTerm;
    }

    public String getNextTerm() {
        return nextTerm;
    }

    public String getPrevTerm() {
        return prevTerm;
    }

    public restApi apiLoader() throws JAXBException {
        String filePath = new File("").getAbsolutePath();
        JAXBContext jaxbContext = JAXBContext.newInstance(restApi.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("src/main/resources/properties.xml");
        return (restApi) jaxbUnmarshaller.unmarshal(file);
    }
}
