package pr05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = buffReader.readLine().split(" ");

        double circle1X = Double.valueOf(tokens[0]);
        double circle1Y = Double.valueOf(tokens[1]);
        double circle1Radius = Double.valueOf(tokens[2]);

        tokens = buffReader.readLine().split(" ");

        double circle2X = Double.valueOf(tokens[0]);
        double circle2Y = Double.valueOf(tokens[1]);
        double circle2Radius = Double.valueOf(tokens[2]);

        Circle circle1 = new Circle(circle1X, circle1Y, circle1Radius);
        Circle circle2 = new Circle(circle2X, circle2Y, circle2Radius);

        boolean isCirclesIntersects = intersect(circle1, circle2);
        System.out.println(isCirclesIntersects ? "Yes" : "No");
    }

    private static boolean intersect(Circle c1, Circle c2) {
        double xDistance = Math.pow((c2.getCenter().getX() - c1.getCenter().getX()), 2);
        double yDistance = Math.pow((c2.getCenter().getY() - c1.getCenter().getY()), 2);

        double centersDistance = Math.sqrt(xDistance + yDistance);

        if (centersDistance > (c1.getRadius() + c2.getRadius())) {
            return false;
        }

        return true;
    }
}
