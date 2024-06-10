package matrixtask.matrixoperations;

public class MatrixOperations {

    public static Matrix addMatrix(Matrix A, Matrix B) {
        double[][] result = new double[A.getRowsNum()][A.getColsNum()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < A.getColsNum(); j++) {
                result[i][j] = A.getValueAt(i, j) + B.getValueAt(i, j);
            }
        }

        return new Matrix(result);
    }

    public static Matrix substractMatrix(Matrix A, Matrix B) {
        double[][] result = new double[A.getRowsNum()][B.getColsNum()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < A.getColsNum(); j++) {
                result[i][j] = A.getValueAt(i, j) - B.getValueAt(i, j);
            }
        }

        return new Matrix(result);
    }

    public static Matrix multiplyMatrix(Matrix A, Matrix B) {
        double[][] result = new double[A.getRowsNum()][B.getColsNum()];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < A.getColsNum(); k++) {
                    result[i][j] += A.getValueAt(i, k) * B.getValueAt(k, j);
                }
            }
        }

        return new Matrix(result);
    }

    public static Matrix transposeMatrix(Matrix A) {
        double[][] result = new double[A.getColsNum()][A.getRowsNum()];

        for (int i = 0; i < A.getRowsNum(); i++) {
            for (int j = 0; j < A.getColsNum(); j++) {
                result[j][i] = A.getValueAt(i, j);
            }
        }
        return new Matrix(result);
    }

    public static double[][] reduce(int row, int column, Matrix matrix) {
        int n = matrix.getRowsNum();
        double[][] res = new double[n - 1][n - 1];
        int r = 0, c;
        for (int i = 0; i < n; i++) {
            c = 0;
            if (i == row)
                continue;
            for (int j = 0; j < n; j++) {
                if (j == column)
                    continue;
                res[r][c] = matrix.getValueAt(i, j);

                c++;
            }
            r++;
        }
        return res;
    }

    public static double det(Matrix matrix) {
        double value;
        int n = matrix.getRowsNum();
        if (n == 1) {
            value = matrix.getValueAt(0, 0);
        } else if (n == 2) {
            value = matrix.getValueAt(0, 0) * matrix.getValueAt(1, 1)
                    - matrix.getValueAt(0, 1) * matrix.getValueAt(1, 0);
            return value;
        } else {
            double[][] m11 = reduce(0, 0, matrix);
            double[][] m1n = reduce(0, n - 1, matrix);
            double[][] mn1 = reduce(n - 1, 0, matrix);
            double[][] mnn = reduce(n - 1, n - 1, matrix);
            double[][] m11nn = reduce(0, 0, new Matrix(reduce(n - 1, n - 1, matrix)));

            value = (det(new Matrix(m11)) * det(new Matrix(mnn)) - det(new Matrix(m1n)) * det(new Matrix(mn1))) / det(new Matrix(m11nn));

        }
        return value;
    }
}
