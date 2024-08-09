package codingBat.string1;

public class TheEnd2 {
    public String theEnd(String str, boolean front) {
        if(front == true){
            return str.substring(0, 1);
        }
        return str.substring(str.length() - 1);

    }
}
