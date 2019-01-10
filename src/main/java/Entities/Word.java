package Entities;

public class Word {

    String status;
    int currentPageIndex;
    int currentTermIndex;
    String currentTerm;
    String currentTermDefinition;
    boolean hasNextPage;
    boolean hasNextTerm;
    boolean hasPreviousPage;
    boolean hasPreviousTerm;

    public String getStatus() {
        return status;
    }

    public boolean HasNextTerm() {
        return hasNextTerm;
    }

    public boolean HasPreviousPage() {
        return hasPreviousPage;
    }

    public boolean HasNextPage() {
        return hasNextPage;
    }

    public int getCurrentPageIndex() {
        return currentPageIndex;
    }

    public boolean HasPreviousTerm() {
        return hasPreviousTerm;
    }

    public int getCurrentTermIndex() {
        return currentTermIndex;
    }

    public String getCurrentTerm() {
        return currentTerm;
    }

    public String getCurrentTermDefinition() {
        return currentTermDefinition;
    }

    public void print() {
        System.out.println("TERM: " +this.getCurrentTerm());
        System.out.println("DEFINITION: " +this.getCurrentTermDefinition());
        System.out.println("PAGE: "+this.getCurrentPageIndex()+"-"+ this.getCurrentTermIndex());

    }

    public String details() {

        return "TERM: " +this.getCurrentTerm()+"\n======\n"+"DEFINITION:\n" +this.getCurrentTermDefinition()+
                "\n======\n"+"PAGE: "+this.getCurrentPageIndex()+"-"+ this.getCurrentTermIndex()+"\n";


    }
}
