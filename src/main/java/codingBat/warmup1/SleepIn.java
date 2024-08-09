package codingBat.warmup1;

public class SleepIn {
    public boolean sleepIn(boolean weekday, boolean vacation) {
        if(weekday == false && vacation == false || weekday == true && vacation == true  ){
            return true;
        }else if(weekday == true || vacation == false) {
            return false;
        }else{
            return true;
        }
    }
}
