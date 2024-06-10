package matrixtask.matrixoperations;

import matrixtask.ExampleMatrix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MatrixOperationsTest {
    private Matrix firstMatrix;
    private Matrix secondMatrix;
    private Matrix resultMatrix;

    @Test
    public void should_add_and_return_4X4_all_4() {
         firstMatrix = ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
         secondMatrix = ExampleMatrix.SIZE_3X3_ALL_3.getMatrix();
         resultMatrix = MatrixOperations.addMatrix(firstMatrix, secondMatrix);

         assertEquals(resultMatrix,ExampleMatrix.SIZE_3X3_ALL_4.getMatrix());
    }
    @Test
    public void should_sub_and_return_4X4_all_3() {
        firstMatrix = ExampleMatrix.SIZE_3X3_ALL_4.getMatrix();
        secondMatrix = ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
        resultMatrix = MatrixOperations.substractMatrix(firstMatrix, secondMatrix);

        assertEquals(resultMatrix,ExampleMatrix.SIZE_3X3_ALL_3.getMatrix());
    }


    @Test
    public void should_multiply_and_return_3X3_all_8() {
        firstMatrix = ExampleMatrix.SIZE_3X2_ALL_2.getMatrix();
        secondMatrix = ExampleMatrix.SIZE_2X3_ALL_2.getMatrix();
        resultMatrix = MatrixOperations.multiplyMatrix(firstMatrix, secondMatrix);

        assertEquals(resultMatrix,ExampleMatrix.SIZE_3X3_ALL_8.getMatrix());
    }

    @Test
    public void should_calc_det_equals_0(){
        firstMatrix =ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
        Double det = MatrixOperations.det(firstMatrix);
        Double correctDet = 0.0;

        assertEquals(det,correctDet);
    }

    @Test
    public void should_transpose_and_return_2X3_ALL_8(){
        firstMatrix =ExampleMatrix.SIZE_2X3_ALL_2.getMatrix();
        resultMatrix = MatrixOperations.transposeMatrix(firstMatrix);

        assertEquals(resultMatrix,ExampleMatrix.SIZE_3X2_ALL_2.getMatrix());
    }



}
