import org.example.Calculator;
import org.junit.Test;

/**
 * @author gaols
 * @version 1.0
 * @date 2022/12/7 16:29
 */
public class TestCalculator {
    Calculator demo =new Calculator();
    @Test
    public void testAdd(){
        int sum = demo.add(1, 2);
        System.out.println(sum);
    }
    @Test
    public void testSubtract(){
        int result = demo.subtract(1, 2);
        System.out.println(result);
    }
    @Test
    public void testMultiply(){
        int result = demo.multiply(1, 2);
        System.out.println(result);
    }
    @Test
    public void testDivision(){
        int sum = demo.division(1, 2);
        System.out.println(sum);
    }
}
