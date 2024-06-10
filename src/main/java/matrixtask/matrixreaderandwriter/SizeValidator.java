package matrixtask.matrixreaderandwriter;

import matrixtask.matrixoperations.Matrix;

public class SizeValidator {
    public boolean couldBeAddedOrSub(Matrix matrix1, Matrix matrix2){
        return (matrix1.getRowsNum() == matrix2.getRowsNum() && matrix1.getColsNum()==matrix2.getColsNum());
    }
    public boolean couldBeMultiplied(Matrix matrix1, Matrix matrix2){
        return matrix1.getRowsNum() == matrix2.getColsNum();
    }
    public boolean couldCalcDeterminant(Matrix matrix){
        return matrix.getRowsNum() == matrix.getColsNum();
    }

}
