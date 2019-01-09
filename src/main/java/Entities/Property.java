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
public class Property {

    @XmlElement(name = "base")
    private String base;
    @XmlElement(name = "key")
    private String key;

    public Property()   {
    }
    public Property(String base, String key) {
        this.base = base;
        this.key = key;
    }
    public void setBase(String base) {
        this.base = base;
    }

    public void setkey(String key) {
        this.key = key;
    }


    public String getBase() {
        return this.base;
    }

    public String getKey() {
        return this.key;
    }

    public Property propertyLoader() throws JAXBException {
        String filePath = new File("").getAbsolutePath();
        JAXBContext jaxbContext = JAXBContext.newInstance(Property.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        File file = new File("src/main/resources/properties.xml");
        return (Property) jaxbUnmarshaller.unmarshal(file);
    }

}
