package hu.nive.ujratervezes.zarovizsga.words;

public class Words {
    public boolean hasMoreDigits(String s) {
        int digitCounter = 0;
        int otherCounter = 0;
        for(char c : s.toLowerCase().toCharArray()) {
            if(Character.isDigit(c)) {
                digitCounter++;
            } else {
                otherCounter++;
            }
        }
        return digitCounter > otherCounter;
    }

}
