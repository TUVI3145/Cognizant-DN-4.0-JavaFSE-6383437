public class FinancialForecast {
    public static double futureValueRecursive(double initialAmount, double growthRate, int years) {
        if (years == 0) {
            return initialAmount;
        }
        return futureValueRecursive(initialAmount, growthRate, years - 1) * (1 + growthRate);
    }
    public static double futureValueIterative(double initialAmount, double growthRate, int years) {
        double result = initialAmount;
        for (int i = 1; i <= years; i++) {
            result *= (1 + growthRate);
        }
        return result;
    }
    public static void main(String[] args) {
        double initialAmount = 10000; 
        double annualGrowthRate = 0.08; 
        int years = 5;
        double fvRecursive = futureValueRecursive(initialAmount, annualGrowthRate, years);
        double fvIterative = futureValueIterative(initialAmount, annualGrowthRate, years);
        System.out.printf("Future Value (Recursive): ?%.2f%n", fvRecursive);
        System.out.printf("Future Value (Iterative): ?%.2f%n", fvIterative);
    }
}
