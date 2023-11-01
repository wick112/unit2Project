public class LinearEquation{
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int simplified;


    public LinearEquation(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance(){
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        distance = roundedToHundreth(distance);
        return distance;
    }

    public double slope(){
        int yChange = y2 - y1;
        int xChange = x2 - x1;
        double slope = roundedToHundreth((double)yChange / xChange);
        return slope;

    }

    public double yIntercept(){
        double b = y1 - (slope() * x1);
        b = roundedToHundreth(b);
        return b;
    }

    public String equation(){
        if (y1 == y2){
            return "y = " + yIntercept();
        }
        if ((y2 - y1) % (x2 - x1) == 0){
            simplified = (y2 - y1) / (x2 - x1);
            return "y = " + simplified + "x + " + yIntercept();
        }else{
            return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + yIntercept();
        }
    }

    public String coordinateForX(double x){
        double y = slope() * x + yIntercept();
        return "(" + x + ", " + y + ")";
    }

    public String lineInfo(){
        if (x1 != x2){
            String str = "The points are (" + x1 + ", " + y1 + ") and " + "(" + x2 + ", " + y2 + ")" + "\n";
            str += "The equation of the line is: " + equation() + "\n";
            str += "The slope of this line is: " + slope() + "\n";
            str += "The y-intercept of this line is: " + yIntercept() + "\n";
            str += "The distance between these points is: " + distance() + "\"" + "\n";
            return str;
        }else if(x1 == x2){
            return "These points are on a vertical line: x = " + x1;
        }
        return "";

    }
    private double roundedToHundreth(double toRound){
        return Math.round(toRound * 100.00)/100.00;
    }
}
