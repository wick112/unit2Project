import java.util.Scanner;
public class LinearEquationLogic{
    private int yCoord;
    private boolean keepGoing = true;

    public void start(){
        getCoordinate();
    }


    private void getCoordinate(){
        while(keepGoing){
            String x1 = "";
            String x2 = "";
            String y1 = "";
            String y2 = "";
            Scanner myScanner = new Scanner(System.in);
            System.out.println("Welcome. Please enter a coordinate point (eg. (4, 6) ): ");
            String point1 = myScanner.nextLine();
            String[] pnt = point1.split(", ");
            if (pnt[0].length() == 3){
                x1 = pnt[0].substring(1, 3);
            }else{
                x1 = pnt[0].substring(1, 2);
            }
            if (pnt[1].length() == 3){
                y1 = pnt[1].substring(0, 2);
            }else if (pnt[1].length() == 4){
                y1 = pnt[1].substring(0, 3);
            }else{
                y1 = pnt[1].substring(0, 1);
            }

            int x1Val = Integer.parseInt(x1);
            int y1Val = Integer.parseInt(y1);

            System.out.println();
            System.out.println("Please enter another coordinate point (eg. (4, 6) ): ");
            String point2 = myScanner.nextLine();
            String[] pnt2 = point2.split(", ");
            if (pnt2[0].length() == 3){
                x2 = pnt2[0].substring(1, 3);
            }else{
                x2 = pnt2[0].substring(1, 2);
            }

            if (pnt2[1].length() == 3){
                y2 = pnt2[1].substring(0, 2);
            } else if (pnt2[1].length() == 4){
                y2 = pnt2[1].substring(0, 3);
            }else{
                y2 = pnt2[1].substring(0, 1);
            }


            int x2Val = Integer.parseInt(x2);
            int y2Val = Integer.parseInt(y2);

            LinearEquation obj = new LinearEquation(x1Val, y1Val, x2Val, y2Val);
            String info = obj.lineInfo();
            System.out.println();
            System.out.println(info);
            if (x1Val != x2Val){
                System.out.println("Enter an X value: ");
                double xCoord = myScanner.nextDouble();
                System.out.println();
                String xInfo = obj.coordinateForX(xCoord);
                System.out.println("The point "  + xInfo + " is on the line");
            }
            keepGoing();

        }
        if (keepGoing == false){
            System.out.println();
            System.out.println("Thank you for using my program!");
        }
    }

    private void keepGoing(){
        System.out.println();
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like to keep going? (yes/ no)");
        String yesOrNo = scan.nextLine();
        System.out.println();
        if (yesOrNo.equals("yes")){
            keepGoing = true;
        }else if(yesOrNo.equals("no")) {
            keepGoing = false;
        }
    }


}
