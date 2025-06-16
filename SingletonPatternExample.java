public class SingletonPatternExample {

    // Singleton Logger class
    static class Logger {
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger initialized.");
        }

        // Public method to get the single instance
        public static Logger getInstance() {
            if (instance == null) {
                instance = new Logger();
            }
            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("Log: " + message);
        }
    }

    // Main method to test the Singleton
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("First log message.");

        Logger logger2 = Logger.getInstance();
        logger2.log("Second log message.");

        // Check if both references are the same
        if (logger1 == logger2) {
            System.out.println("Only one instance of Logger exists.");
        } else {
            System.out.println("Multiple instances exist (incorrect implementation).");
        }
    }
}
