import Controllers.Finder;
import Entities.Messages;
import org.junit.Test;
import java.net.ProtocolException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class TestApp {
    Finder finder= new Finder();
    Messages msg = new Messages();
    @Test
    public void matchTest() throws ProtocolException {
        assertTrue(finder.uiPresenter("A").contains("TERM: A"));
    }
    @Test
    public void caseTest() throws ProtocolException {

        assertTrue(finder.uiPresenter("a").contains("TERM: A"));
        assertTrue(finder.uiPresenter("Alkaloid").contains("TERM: ALKALOID"));
    }
    @Test
    public void pageTurnMatchCaseTest() throws ProtocolException {
        assertTrue(finder.uiPresenter("Alkaloid").contains("TERM: ALKALOID"));
    }

    @Test
    public void nonExistentTest() throws ProtocolException {
        assertEquals(finder.uiPresenter("-2"),(msg.getNotPresent()));
    }
}
