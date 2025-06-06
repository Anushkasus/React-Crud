public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 10; // Number of Fibonacci numbers to generate
        long[] fibonacciSeries = new long[n];

        // First two numbers in the Fibonacci series
        fibonacciSeries[0] = 0;
        fibonacciSeries[1] = 1;

        // Generate the Fibonacci series using a loop
        for (int i = 2; i < n; i++) {
            fibonacciSeries[i] = fibonacciSeries[i - 1] + fibonacciSeries[i - 2];
        }

        // Print the Fibonacci series
        System.out.println("Fibonacci Series up to " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciSeries[i] + " ");
        }
    }
}
