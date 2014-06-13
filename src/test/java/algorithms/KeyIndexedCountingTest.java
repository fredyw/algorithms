package algorithms;

import static org.junit.Assert.*;

import org.junit.Test;

import algorithms.KeyIndexedCounting.Element;

public class KeyIndexedCountingTest {
    @Test
    public void testSort() {
        Element[] elements = new Element[20];
        elements[0] = new Element("Anderson", 2);
        elements[1] = new Element("Brown", 3);
        elements[2] = new Element("Davis", 3);
        elements[3] = new Element("Garcia", 4);
        elements[4] = new Element("Harris", 1);
        elements[5] = new Element("Jackson", 3);
        elements[6] = new Element("Johnson", 4);
        elements[7] = new Element("Jones", 3);
        elements[8] = new Element("Martin", 1);
        elements[9] = new Element("Martinez", 2);
        elements[10] = new Element("Miller", 2);
        elements[11] = new Element("Moore", 1);
        elements[12] = new Element("Robinson", 2);
        elements[13] = new Element("Smith", 4);
        elements[14] = new Element("Taylor", 3);
        elements[15] = new Element("Thomas", 4);
        elements[16] = new Element("Thompson", 4);
        elements[17] = new Element("White", 2);
        elements[18] = new Element("Williams", 3);
        elements[19] = new Element("Wilson", 4);
        
        KeyIndexedCounting.sort(elements, 6);
        
        for (Element e : elements) {
            System.out.println(e);
        }
    }
}
