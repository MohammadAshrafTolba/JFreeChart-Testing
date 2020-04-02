package Integration;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;

import org.jfree.data.DataUtils;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.Test;
import org.mockito.Mockito;

public class IntegrationDataUtils {

	@Test
	public void testCalculateColumnTotal() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateColumnTotal(data,2);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateColumnTotalLower() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateColumnTotal(data,0);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateColumnTotalUpper() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateColumnTotal(data,3);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateColumnTotalOutOfBound() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateColumnTotal(data,-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateColumnTotalOutOfBound2() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateColumnTotal(data,4);
	}
	
	@Test
	public void testCalculateRowTotal() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateRowTotal(data,2);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateRowTotalUpper() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateRowTotal(data,3);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test
	public void testCalculateRowTotalLower() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateRowTotal(data,0);
		
		
		assertTrue(n == 4.0);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testCalculateRowTotalOutOfBound() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateRowTotal(data,-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCalculateRowTotalOutOfBound2() {
		DefaultKeyedValues2D data = new DefaultKeyedValues2D();
		
		data.addValue(1.0, "row0", "col0");
		data.addValue(1.0, "row0", "col1");
		data.addValue(1.0, "row0", "col2");
		data.addValue(1.0, "row0", "col3");
		data.addValue(1.0, "row1", "col0");
		data.addValue(1.0, "row1", "col1");
		data.addValue(1.0, "row1", "col2");
		data.addValue(1.0, "row1", "col3");
		data.addValue(1.0, "row2", "col0");
		data.addValue(1.0, "row2", "col1");
		data.addValue(1.0, "row2", "col2");
		data.addValue(1.0, "row2", "col3");
		data.addValue(1.0, "row3", "col0");
		data.addValue(1.0, "row3", "col1");
		data.addValue(1.0, "row3", "col2");
		data.addValue(1.0, "row3", "col3");
		
		double n = DataUtils.calculateColumnTotal(data,4);
	}
	
	@Test
	public void testgetCumulativePercentagesUpper() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("key1", 1.0);
		data.addValue("key2", 1.0);
		data.addValue("key3", 1.0);
		data.addValue("key4", 1.0);
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(3);
		
		assertTrue(n == 1.0);
	}
	
	@Test
	public void testgetCumulativePercentagesNormal() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("key1", 1.0);
		data.addValue("key2", 1.0);
		data.addValue("key3", 1.0);
		data.addValue("key4", 1.0);
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(1);
		
		assertTrue(n == 0.5);
	}
	
	@Test
	public void testgetCumulativePercentagesLower() {
		DefaultKeyedValues data = new DefaultKeyedValues();
		data.addValue("key1", 1.0);
		data.addValue("key2", 1.0);
		data.addValue("key3", 1.0);
		data.addValue("key4", 1.0);
		
		DefaultKeyedValues d = new DefaultKeyedValues();
		
		d = (DefaultKeyedValues) DataUtils.getCumulativePercentages(data);
		
		Double n = (Double) d.getValue(0);
		
		assertTrue(n == 0.25);
	}

}