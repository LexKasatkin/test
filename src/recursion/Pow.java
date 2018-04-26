package recursion;

public class Pow {
    public static void main(String[] args) {
        int result = pow(2, 7);

    }

    private static int pow(int x, int y) {
        if (y == 1)
            return x;
        else {
            if (y % 2 == 0) {
                y = y / 2;
                x = x * x;
                return pow(x, y);
            } else {
                y = y / 2;
                x = x * x;
                x = x * x;
                return pow(x, y);
            }
        }
    }
}
