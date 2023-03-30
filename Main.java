import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Podaj nazwe pliku, z którego mam pobrać zbiór treningowy");
        Scanner scanner = new Scanner(System.in);
        String trainSetName = scanner.nextLine();
        File trainSetFile = new File(trainSetName);
        Scanner readFile = new Scanner(trainSetFile);
        ArrayList<Iris> irisList = new ArrayList<>();

        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            String[] partsString = line.split(",");
            double[] partsDouble = new double[partsString.length];
            for (int i = 0; i < partsString.length - 1; i++) {
                partsDouble[i] = Double.valueOf(partsString[i]);
            }
            Iris newIris = new Iris(partsDouble, partsString[partsDouble.length-1]);
            irisList.add(newIris);
        }
        System.out.println("Podaj nazwe pliku, z ktorego mam pobrac zbior testowy");
        ArrayList<Iris> testIrises = new ArrayList<>();

        String testSetName = scanner.nextLine();
        File testSetFile = new File(testSetName+".txt");
        readFile = new Scanner(testSetFile);
        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            String[] partsString = line.split(",");
            double[] partsDouble = new double[partsString.length];
            for (int i = 0; i < partsString.length - 1; i++) {
                partsDouble[i] = Double.parseDouble(partsString[i]);
            }

            Iris newIris = new Iris(partsDouble, partsString[partsDouble.length-1]);
            testIrises.add(newIris);
        }
        Perceptron perceptron = new Perceptron();
        System.out.println("Podaj stałą uczenia");
        int lerningRate = Integer.parseInt(scanner.nextLine());
        int guessed=0;
        for (int i = 0; i < testIrises.size(); i++) {
            for (int j = 0; j < irisList.size(); j++) {
                perceptron.predict(testIrises.get(i),guessed,lerningRate);
            }
        }







    }
}