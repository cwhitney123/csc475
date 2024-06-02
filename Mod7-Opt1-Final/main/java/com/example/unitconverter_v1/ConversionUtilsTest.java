package com.example.unitconverter_v1;
import org.junit.Test;
import static org.junit.Assert.*;

public class ConversionUtilsTest {

    @Test
    public void testKgToPoundsConversion() {
        // Test1: Convert of 0 kg
        assertEquals(0, ConversionUtils.convertKgToPounds(0), 0.001);

        // Test2: Convert of 1 kg
        assertEquals(2.20462, ConversionUtils.convertKgToPounds(1), 0.001);

    }
}
