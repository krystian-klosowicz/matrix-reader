package matrixtask.readerandwriter;

import matrixtask.ExampleMatrix;
import matrixtask.matrixoperations.Matrix;
import matrixtask.matrixreaderandwriter.SizeValidator;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse ;

public class SizeValidatorTest {
    private Matrix firstMatrix;
    private Matrix secondMatrix;

    private  boolean validate;
    private SizeValidator sizeValidator = new SizeValidator();
    @Test
    public void should_return_true_add_3X3_3X3(){
        firstMatrix = ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
        secondMatrix =ExampleMatrix.SIZE_3X3_ALL_4.getMatrix();
        validate = sizeValidator.couldBeAddedOrSub(firstMatrix,secondMatrix);
        assertTrue(validate);

    }

    @Test
    public void should_return_false_add_3X3_2X3(){
        firstMatrix = ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
        secondMatrix =ExampleMatrix.SIZE_2X3_ALL_2.getMatrix();
        validate = sizeValidator.couldBeAddedOrSub(firstMatrix,secondMatrix);
        assertFalse(validate);

    }

    @Test
    public void should_return_true_multiply_3X3_3X3(){
        firstMatrix = ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
        secondMatrix =ExampleMatrix.SIZE_3X3_ALL_4.getMatrix();
        validate = sizeValidator.couldBeMultiplied(firstMatrix, secondMatrix);

        assertTrue(validate);
    }

    @Test
    public void should_return_true_multiply_2X3_3X2(){
        firstMatrix = ExampleMatrix.SIZE_2X3_ALL_2.getMatrix();
        secondMatrix =ExampleMatrix.SIZE_3X2_ALL_2.getMatrix();
        validate = sizeValidator.couldBeMultiplied(firstMatrix, secondMatrix);

        assertTrue(validate);
    }

    @Test
    public void should_return_false_multiply_4X3_3X3(){
        firstMatrix = ExampleMatrix.SIZE_4X3_ALL_5.getMatrix();
        secondMatrix =ExampleMatrix.SIZE_3X3_ALL_4.getMatrix();
        validate = sizeValidator.couldBeMultiplied(firstMatrix, secondMatrix);

        assertFalse(validate);
    }

    @Test
    public void should_return_true_det_3X3(){
        firstMatrix = ExampleMatrix.SIZE_3X3_ALL_1.getMatrix();
        validate = sizeValidator.couldCalcDeterminant(firstMatrix);

        assertTrue(validate);
    }

    @Test
    public void should_return_false_det_2X3(){
        firstMatrix = ExampleMatrix.SIZE_2X3_ALL_2.getMatrix();
        validate = sizeValidator.couldCalcDeterminant(firstMatrix);

        assertFalse(validate);
    }




}

//    public boolean couldBeMultiplied(double[][] matrix1, double[][] matrix2){
//        return matrix1.length == matrix2[0].length;
//    }
////    public boolean couldCalcDeterminant(double[][] matrix1){
////        return matrix1.length == matrix1[0].length;
////    }