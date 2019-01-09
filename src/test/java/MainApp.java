import Controllers.Finder;
import Entities.Word;

import java.net.ProtocolException;
import java.util.Scanner;

public class MainApp {

    Word answer =null;
    Finder finder = new Finder();
    public boolean queryCheck(String s) {
        if (s.length()>0)
            return true;
        System.out.println("Bad Query.Recheck Again [Query]: " +s);
        return false;
    }

    public void sendQuery(String query) throws ProtocolException {
        if (queryCheck(query))
        finder.presenter(query);

    }
    public static void main (String [] args) throws ProtocolException {
        MainApp m = new MainApp();
        while (true) {
            System.out.println("Insert your Query Word below:");
            Scanner scanner = new Scanner(System.in);
            String query = scanner.nextLine();
            if (m.queryCheck(query)) {
                if (m.queryCheck("-1"))
                        break;
                m.sendQuery(query);
            }
        }
        System.out.println("End of Program\n");
    }
}

