public class PowerOfThreeSolution {
    public boolean isPowerOfThree(int n) {
        return Integer.toString(n, 3).matches("10*");
    }
}