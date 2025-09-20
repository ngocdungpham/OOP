import java.util.Scanner;

public class Closest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x = Double.parseDouble(args[0]);
        double y = Double.parseDouble(args[1]);
        double z = Double.parseDouble(args[2]);

        double bestx = Double.NaN;
        double besty = Double.NaN;
        double bestz = Double.NaN;
        double bestDist2 = Double.POSITIVE_INFINITY;

        while (sc.hasNextDouble()) {
            double xi = sc.nextDouble();
            double yi = sc.nextDouble();
            double zi = sc.nextDouble();

            double dist2 = (x - xi)*(x - xi) + (y - yi)*(y - yi) + (z - zi)*(z - zi);

            if (dist2 < bestDist2) {
                bestx = xi;
                besty = yi;
                bestz = zi;
                bestDist2 = dist2;
            }
        }

        System.out.printf("Closest point = (%.2f, %.2f, %.2f)%n", bestx, besty, bestz);
    }
}
