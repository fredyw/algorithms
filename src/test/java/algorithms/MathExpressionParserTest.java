package algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MathExpressionParserTest {
    @Test
    public void test() {
        MathExpressionParser parser = new MathExpressionParser();
        assertEquals(2, parser.evaluate("(((1 + 1) * (4 - 2)) / 2)"));
    }
}
