import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OperandTest {

    private static String dataFilePath = "src/test/resouces/data.txt";

    @Parameters(name = "{index}: {0} {2} {1} = {3}")
    public static Collection<Object[]> data() {
        List<Object[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(dataFilePath)))) {
            String line = reader.readLine();
            while (line != null) {
                data.add(line.replaceAll(" ", "").split(";"));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    private final int operand1;
    private final int operand2;
    private final String operation;
    private final int result;

    public OperandTest(String operand1, String operand2, String operation, String result) {
        this.operand1 = Integer.valueOf(operand1);
        this.operand2 = Integer.valueOf(operand2);
        this.operation = operation;
        this.result = Integer.valueOf(result);
    }

    @Test
    public void operationsTest() {
        assertEquals(result, new Calculator().getResult(operand1, operand2, operation));
    }

}
