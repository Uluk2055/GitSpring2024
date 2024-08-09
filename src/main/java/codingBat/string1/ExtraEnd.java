package codingBat.string1;

public class ExtraEnd {
    public String extraEnd(String str) {
        int lastTwo = str.length() - 2;
        String secondPart = str.substring(lastTwo);
        return secondPart + secondPart + secondPart;
    }
}
