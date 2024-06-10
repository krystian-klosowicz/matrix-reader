package matrixtask.matrixoperations;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
//@Getter
@Setter
public class Matrix {
    private double[][] matrix;

    public static Matrix crate(double[][] matrix){
        return new Matrix(matrix);
    }

    public Matrix(double[][] a) {
        this.matrix = a;
    }

    public int getRowsNum() { return matrix.length; }

    public int getColsNum(){ return matrix[0].length; }

    public double getValueAt(int row, int col) {
        return matrix[row][col];
    }

    void show() {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
