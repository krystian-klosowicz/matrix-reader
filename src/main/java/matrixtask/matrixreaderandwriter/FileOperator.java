package matrixtask.matrixreaderandwriter;

import matrixtask.matrixoperations.Matrix;
import org.apache.log4j.Logger;

import java.io.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class FileOperator {

    static Logger log = Logger.getLogger(FileOperator.class.getName());
    public Matrix readFromFile(String fileName) throws NoFileFoundExistException {

        List<double[]> matrixList = new ArrayList<>();
        String[] strArray;
        double[] numbArray;
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            while ((line = br.readLine()) != null) {
                strArray = line.split(" ");
                numbArray = Arrays.stream(strArray)
                        .mapToDouble(Double::parseDouble)
                        .toArray();
                matrixList.add(numbArray);
            }
            br.close();
        } catch (FileNotFoundException e) {
            log.debug(e.getMessage());
            throw new NoFileFoundExistException();
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return convertListToMatrix(matrixList);


    }

    public static Matrix convertListToMatrix(List<double[]> matrixList) {
        return new Matrix(matrixList.stream()
                .map(row -> Arrays.stream(row)
                        .boxed()
                        .mapToDouble(Double::doubleValue).toArray())
                .toArray(double[][]::new));
    }

    public static void saveResult(double[][] matrix, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (double[] row : matrix) {
                for (double element : row) {
                    writer.print(roundToTwoDec(element) + " ");
                }
                writer.println();
            }
            System.out.println("Macierz zapisana do pliku " + filename + "\n");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }

    }

    public void saveResult(double determinant, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.print(roundToTwoDec(determinant));
            System.out.println("Wyznacznik zapisany do pliku " + filename + "\n");
        } catch (IOException e) {
            System.out.println("Wystąpił błąd podczas zapisu do pliku.");
            e.printStackTrace();
        }
    }

    public static String roundToTwoDec(double num) {
        DecimalFormatSymbols ds = new DecimalFormatSymbols(Locale.ENGLISH);
        DecimalFormat df = new DecimalFormat("00.00");
        df.setDecimalFormatSymbols(ds);

        return df.format(num);
    }
}

