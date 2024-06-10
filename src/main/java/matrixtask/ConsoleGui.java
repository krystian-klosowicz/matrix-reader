package matrixtask;

import matrixtask.matrixreaderandwriter.FileOperator;
import matrixtask.matrixreaderandwriter.WrongMatrixSizeException;
import matrixtask.matrixservice.MatrixCalculatorService;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;


public class ConsoleGui {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        MatrixCalculatorService matrixCalculatorService = new MatrixCalculatorService();
        Scanner scanner = new Scanner(System.in);
        String input;
        boolean flag = true;
        Logger log = Logger.getLogger(FileOperator.class.getName());
        try {
            while (flag) {
                System.out.println("Wybierz operacje: \n" +
                        "1. Dodawanie \n" +
                        "2. Odejmowanie \n" +
                        "3. Mnożenie \n" +
                        "4. Transpozycja \n" +
                        "5. Wyznacznik \n" +
                        "6. Wyjście");
                input = scanner.nextLine();

                switch (input) {
                    case "1":
                        matrixCalculatorService.add();
                        break;
                    case "2":
                        matrixCalculatorService.substract();
                        break;
                    case "3":
                        matrixCalculatorService.multiply();
                        break;
                    case "4":
                        matrixCalculatorService.transpose();
                        break;
                    case "5":
                        matrixCalculatorService.determinant();
                        break;
                    case "6":
                        flag = false;
                        break;
                    default:
                        System.out.println("Podałeś niepoprawny numer.");
                        break;
                }



            }
        }catch (NumberFormatException | ArrayIndexOutOfBoundsException | WrongMatrixSizeException| InputMismatchException | FileNotFoundException e){
            log.debug(e.getMessage());
        }
    }
}
