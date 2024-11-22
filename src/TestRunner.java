import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(OrderTest.class);
        System.out.println("Running tests... [Out Of Stock Item Order]");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("All tests successful: " + result.wasSuccessful());

        Result result2 = JUnitCore.runClasses(LoginTest.class);
        System.out.println("Running tests... [Invalid LOGIN]");
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println("All tests successful: " + result2.wasSuccessful());
    }
}
