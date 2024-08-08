package homework;

public class VarAndPrinting {
    public static void main(String[] args){

        String myName = "Zed A. Shaw";
        int myAge = 35;     //
        double myHeight = 74.5;  // inches
        double myWeight = 180.0; // lbs
        String myEyes = "Blue";
        String myTeeth = "White";
        String myHair = "Brown";

        System.out.println( "Let's talk about " + myName + ".");
        System.out.println( "He's " + myHeight + " inches tall." );
        System.out.println( "He's " + myWeight + " pounds heavy." );
        System.out.println( "Actually, that's not too heavy." );
        System.out.println( "He's got " + myEyes + " eyes and " + myHair + " hair." );
        System.out.println( "His teeth are usually " + myTeeth + " depending on the coffee." );

        System.out.println( "If I add " + myAge + ", " + myHeight + ", and " + myWeight
                + " I get " + (myAge + myHeight + myWeight) + "." );
    }
}
