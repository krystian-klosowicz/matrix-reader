package matrixtask.matrixservice;

import matrixtask.matrixoperations.Matrix;
import matrixtask.matrixoperations.MatrixOperations;
import matrixtask.matrixreaderandwriter.FileOperator;
import matrixtask.matrixreaderandwriter.NoFileFoundExistException;
import matrixtask.matrixreaderandwriter.SizeValidator;
import matrixtask.matrixreaderandwriter.WrongMatrixSizeException;
import org.apache.log4j.Logger;


public class MatrixCalculatorService {
    private static final String FIRST_MATRIX_FILE_NAME = "matrix1.txt";
    private static final String SECOND_MATRIX_FILE_NAME = "matrix2.txt";
    private static final String RESULT_MATRIX_FILE_NAME = "result.txt";

    private final FileOperator fileOperator = new FileOperator();
    private final SizeValidator sizeValidator = new SizeValidator();

    static Logger log = Logger.getLogger(FileOperator.class.getName());
    private Matrix firstMatrix = null;
    private Matrix secondMatrix = null;

    private Matrix getFirtsMatrix() throws NoFileFoundExistException {
        if (firstMatrix == null) {
            try {
                firstMatrix =  fileOperator.readFromFile(FIRST_MATRIX_FILE_NAME);
            } catch (NoFileFoundExistException e) {
                log.debug("Nie znaleziono pliku.");
            }
        }
         return firstMatrix;
    }

    private Matrix getSecondMatrix() throws NoFileFoundExistException{
        if (secondMatrix == null) {
            try {
                secondMatrix = fileOperator.readFromFile(SECOND_MATRIX_FILE_NAME);
            } catch (NoFileFoundExistException e) {
                log.info("Nie znaleziono pliku.");
            }
        }
        return secondMatrix;
    }

    private void save(double[][] matrix) {
        FileOperator.saveResult(matrix, RESULT_MATRIX_FILE_NAME);

    }

    private void saveDeterminant(double determinant) {
        fileOperator.saveResult(determinant, RESULT_MATRIX_FILE_NAME);

    }


    public void add() throws WrongMatrixSizeException, NoFileFoundExistException {
        Matrix m1 = getFirtsMatrix();
        Matrix m2 = getSecondMatrix();
        if(m1 != null && m2 != null) {
            if (sizeValidator.couldBeAddedOrSub(m1, m2)) {
                Matrix resultMatrix = MatrixOperations.addMatrix(m1, m2);
                save(resultMatrix.getMatrix());

            } else {
                //throw new WrongMatrixSizeException();
            }
        }
    }

    public void substract() throws WrongMatrixSizeException, NoFileFoundExistException {
        if (sizeValidator.couldBeAddedOrSub(getFirtsMatrix(), getSecondMatrix())) {
            Matrix resultMatrix = MatrixOperations.substractMatrix(getFirtsMatrix(), getSecondMatrix());
            save(resultMatrix.getMatrix());

        } else {
            //throw new WrongMatrixSizeException();
        }
    }

    public void multiply() throws WrongMatrixSizeException, NoFileFoundExistException {
        if (sizeValidator.couldBeMultiplied(getFirtsMatrix(), getSecondMatrix())) {
            Matrix resultMatrix = MatrixOperations.multiplyMatrix(getFirtsMatrix(), getSecondMatrix());
            save(resultMatrix.getMatrix());

        } else {
            //throw new WrongMatrixSizeException();
        }
    }

    public void determinant() throws WrongMatrixSizeException, NoFileFoundExistException {
        if (sizeValidator.couldCalcDeterminant(getFirtsMatrix())) {
            double determinant = MatrixOperations.det(getFirtsMatrix());
            fileOperator.saveResult(determinant, RESULT_MATRIX_FILE_NAME);
        } else {
            //throw new WrongMatrixSizeException();
        }
    }

    public void transpose() throws NoFileFoundExistException {
        Matrix matrx = MatrixOperations.transposeMatrix(getFirtsMatrix());
        save(matrx.getMatrix());
    }


}
