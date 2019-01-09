import Controllers.Finder;

import javax.xml.bind.JAXBException;
import java.net.ProtocolException;

public class TestApp {
    Finder finder= new Finder();
    public static void main (String [] args) throws JAXBException, ProtocolException {
        TestApp d = new TestApp();
        d.finder.presenter("A");
        d.finder.presenter("ALKALOID");


    }
}