package Controllers;

import Entities.Word;

import java.net.ProtocolException;

public class Finder {
    ApiControllers api = new ApiControllers();

    /**
     * Reset Dictionary Location
     * @return Word
     * @throws ProtocolException
     */
    public Word reset() throws ProtocolException {
        api.firstPageFirstTerm();
        return api.wordWrapper(api.status());
    }

    public Word resetPage() {
        api.firtTermOfPage();
        return api.wordWrapper(api.status());
    }

    /**
     * Checks Pages and Turns
     * @param item: The Word to be searched
     * @return Word
     * @throws ProtocolException
     */
    public Word checkPage(String item) throws ProtocolException {
        Word lastTerm_word = api.wordWrapper(api.lastTermOfPage());
        Word firstTerm_Word = api.wordWrapper(api.firtTermOfPage());
        String lastTerm = lastTerm_word.getCurrentTerm();
        String firstTerm = firstTerm_Word.getCurrentTerm();

        if (item.compareToIgnoreCase(firstTerm) >= 0 && item.compareToIgnoreCase(lastTerm) <= 0) {
            return api.wordWrapper(api.firtTermOfPage());
        }
        if (item.compareToIgnoreCase(lastTerm) >=0) {
            System.out.println("Switching to Page: "+ (firstTerm_Word.getCurrentPageIndex()+1));
            return api.wordWrapper(api.nextPageFirstTerm());
        }
        System.out.println("Switching to Page: "+ (firstTerm_Word.getCurrentPageIndex()-1));
        return api.wordWrapper(api.prevPage());

        }

    /**
     * NOTE: Doesn't compare words, just checks pages.
     * @param item;
     * @return
     * @throws ProtocolException
     */
    public Word pageIncrementHandler(String item) throws ProtocolException {
        if (item.compareToIgnoreCase(api.wordWrapper(api.lastPageLastTerm()).getCurrentTerm())> 0 // greater than last term of last Page
                || item.compareToIgnoreCase(api.wordWrapper(api.firstPageFirstTerm()).getCurrentTerm())< 0) { //smaller than first term first Page
            System.out.println(" Word Doesn't Exist in dictionary");
            return null;
        }
        if (api.wordWrapper(api.lastPageLastTerm()).getCurrentTerm().equals(item))
            return api.wordWrapper(api.lastPageLastTerm());
        if (api.wordWrapper(api.firstPageFirstTerm()).getCurrentTerm().equals(item))
            return api.wordWrapper(api.firstPageFirstTerm());

        int prevPage = -1;
        Word w = null;
        while (true) {
            w = checkPage(item);
            if (w.getCurrentPageIndex()== prevPage) {
                break;
            }
            else
                prevPage = w.getCurrentPageIndex();
        }
        return w;
    }

    /**
     *
     * @param item;
     * @return Word: Final verdict and Word (Can be null if not found)
     * @throws ProtocolException
     */
    public Word resultPageHandler(String item) throws ProtocolException {
        reset(); //Start search, all the way from the beginning of the dictionary
        Word w = pageIncrementHandler(item); //Let Page Handler select the Page
        if (w==null) {
            return null;
        }
        resetPage(); // Handler's done. Reset the Page
        Word last = api.wordWrapper(api.lastTermOfPage());
        Word current = api.wordWrapper(api.firtTermOfPage());
        if (last.getCurrentTerm().equals(item))
            return last;
        while (!current.getCurrentTerm().equals(item) || current.getCurrentTerm().equals(last)) {
            current = api.wordWrapper(api.next());
        }
        return current;
    }

    /**
     * Presents the result
     */

    public void presenter(String item) throws ProtocolException {
        Word res = resultPageHandler(item);
        if (res==null || !res.getCurrentTerm().equals(item)) {
            System.out.println("Word Doesn't exist in Dictionary");
        }
        else {
            System.out.println();
            res.print();
            System.out.println();
        }
    }
    }
