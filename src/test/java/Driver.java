import Controllers.Finder;

import javax.xml.bind.JAXBException;
import java.net.ProtocolException;

public class Driver {
    Finder finder= new Finder();
    public static void main (String [] args) throws JAXBException, ProtocolException {
        Driver d = new Driver();
        d.finder.presenter("A");
        d.finder.presenter("ALKALOID");


    }
}
