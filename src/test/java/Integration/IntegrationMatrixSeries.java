package Integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.jfree.data.xy.MatrixSeries;
import org.junit.Test;

public class IntegrationMatrixSeries {

	@Test
	public void getItemCount()
	{
		int colCount = 3;
		int rowCount = 4;
		MatrixSeries matrix = new MatrixSeries("matrix", rowCount, colCount);
		assertEquals(rowCount*colCount, matrix.getItemCount());
	}
	
	@Test
	public void getItemColumn() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		
		matrix.update(2, 1, 3);
		matrix.update(1, 2, 5);
		
		int item1Col = 7 % colCount;
		int item2Col = 5 %colCount;
		
		assertEquals(item1Col, matrix.getItemColumn(7));
		assertEquals(item2Col, matrix.getItemColumn(5));
	}
	
	@Test
	public void getItemRow() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		
		matrix.update(2, 1, 3);
		matrix.update(1, 2, 5);
		
		int item1Row = 7 / rowCount;
		int item2Row = 5 / rowCount;
		
		assertEquals(item1Row, matrix.getItemRow(7));
		assertEquals(item2Row, matrix.getItemRow(5));
	}
	
	@Test
	public void getItem() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		matrix.update(2, 1, 3);
		matrix.update(1, 2, 4);
		
		assertEquals(3.0, matrix.getItem(7));
		assertEquals(4.0, matrix.getItem(5));
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getItem_negativeIndex() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		matrix.update(2, 1, 3);
		
		double item = (Double) matrix.getItem(-1);
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void getItem_invalidIndex() {
		int colCount = 3;
		int rowCount = 3;
		
		MatrixSeries matrix = new MatrixSeries("matrix name", rowCount, colCount);
		matrix.update(2, 1, 3);
		
		double item = (Double) matrix.getItem(12);
	}
	@Test
	public void equals_equalArg() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix name", rowCount, colCount);
		MatrixSeries matrix2 = new MatrixSeries("matrix name", rowCount, colCount);
		
		assertTrue(matrix1.equals(matrix2));
	}
	
	@Test
	public void equals_rowCountDifferent() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix", rowCount, colCount);
		int rowCount2 = 4;
		MatrixSeries matrix2 = new MatrixSeries("matrix2", rowCount2, colCount);
		assertTrue(!matrix1.equals(matrix2));
	}
	
	@Test
	public void equals_colCountDifferent() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix1 = new MatrixSeries("matrix", rowCount, colCount);
		int colCount2 = 4;
		MatrixSeries matrix2 = new MatrixSeries("matrix2", rowCount, colCount);
		assertTrue(!matrix1.equals(matrix2));
	}
	
	@Test
	public void zeroAll_regularCase() {
		int colCount = 3;
		int rowCount = 3;
		MatrixSeries matrix = new MatrixSeries("matrix", rowCount, colCount);
		matrix.update(2, 2, 6);
		matrix.update(1, 1, 4);
		matrix.zeroAll();

		assertTrue(0 == matrix.get(2,2));
		assertTrue(0 == matrix.get(1,1));
	}
}
