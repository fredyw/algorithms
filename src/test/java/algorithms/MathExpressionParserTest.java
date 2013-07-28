package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

public class MathExpressionParserTest {
    @Test
    public void test() {
        MathExpressionParser parser = new MathExpressionParser();
        assertEquals(2, parser.evaluate("(((1 + 1) * (4 - 2)) / 2)"));
    }
}
