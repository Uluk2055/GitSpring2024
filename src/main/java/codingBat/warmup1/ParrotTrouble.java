package codingBat.warmup1;

public class ParrotTrouble {
    public boolean parrotTrouble(boolean talking, int hour) {
        if(hour <7 || hour > 20){
            if(talking){
                return true;
            }else{
                return false;
            }
        }return false;
    }

}
