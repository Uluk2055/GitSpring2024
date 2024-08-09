package codingBat.string1;

public class Left2 {
    public String left2(String str) {
        String w1 = str.substring(0,2);
        String w2 = str.substring(2);
        return w2 + w1;
    }
}
