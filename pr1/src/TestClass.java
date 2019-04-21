import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestClass {
    Operations operations = new Operations();

    @Test
    public void divisionTests(){
        //Positive numbers
        assertEquals("Basic division", operations.division(4,2),2);

        assertEquals("Basic division with large numbers", operations.division(50000000,10000000),5);

        assertEquals("Basic division with <1 result", operations.division(5,6),0);

        assertEquals("Zero division", operations.division(0,10),0);

        assertEquals("Basic division by one", operations.division(235,1),235);

        //Negative numbers
        assertEquals("Basic division", operations.division(4,-2),-2);

        assertEquals("Basic division with large numbers", operations.division(-50000000,-10000000),5);

        assertEquals("Basic division with <1 result", operations.division(-5,6),0);

        assertEquals("Zero division", operations.division(0,-10),0);

        assertEquals("Basic division by one", operations.division(-235,1),-235);

        //Large numbers
        assertEquals("Divide largest possible number by smallest",operations.division(Integer.MAX_VALUE,Integer.MIN_VALUE+1),-1);
    }
    @Test(expected=java.lang.ArithmeticException.class)
    public void divisionByZeroTest(){
        operations.division(5,0);
    }

    @Test
    public void multiplicationTest(){

        //Positive numbers
        assertEquals("Basic multiplication",operations.multiplication(5,3),15);

        assertEquals("Basic multiplication with large numbers",operations.multiplication(400000,1000),400000000);

        assertEquals("Multiplication by 0",operations.multiplication(30,0),0);

        assertEquals("Multiplication by 1", operations.multiplication(15,1),15);

        //Negative numbers
        assertEquals("Basic multiplication",operations.multiplication(5,-3),-15);

        assertEquals("Basic multiplication with large numbers",operations.multiplication(400000,-1000),-400000000);

        assertEquals("Multiplication by 0",operations.multiplication(-30,0),0);

        assertEquals("Multiplication by 1", operations.multiplication(-15,1),-15);

        //Large numbers
        assertEquals("Multiplication between max positive value and min value",operations.multiplication(Integer.MAX_VALUE,Integer.MIN_VALUE),-2147483648);

        assertEquals("Multiplication between max positive value and max positive value", operations.multiplication(Integer.MAX_VALUE,Integer.MAX_VALUE),1);

        assertEquals("Multiplication between min value and min value", operations.multiplication(Integer.MIN_VALUE,Integer.MIN_VALUE),0);
    }

}
