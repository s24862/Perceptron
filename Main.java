import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Objects;
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
            Iris newIris = new Iris(partsDouble, partsString[partsDouble.length - 1]);
            irisList.add(newIris);
        }
        System.out.println("Podaj nazwe pliku, z ktorego mam pobrac zbior testowy");
        ArrayList<Iris> testIrises = new ArrayList<>();

        String testSetName = scanner.nextLine();
        File testSetFile = new File(testSetName);
        readFile = new Scanner(testSetFile);
        while (readFile.hasNext()) {
            String line = readFile.nextLine();
            String[] partsString = line.split(",");
            double[] partsDouble = new double[partsString.length];
            for (int i = 0; i < partsString.length - 1; i++) {
                partsDouble[i] = Double.parseDouble(partsString[i]);
            }

            Iris newIris = new Iris(partsDouble, partsString[partsDouble.length - 1]);
            testIrises.add(newIris);
        }

        Perceptron perceptron = new Perceptron(testIrises);
        System.out.println("Podaj stałą uczenia");
        double lerningRate = Double.parseDouble(scanner.nextLine());
        boolean turnOn = true;
        while (turnOn) {
            perceptron.guessed = 0;
            for (Iris iris : irisList) {
                perceptron.predict(iris, lerningRate);
            }

            for (Iris iris : testIrises) {

                perceptron.predictWithoutLearning(iris);

            }
            double accuracy = perceptron.guessed / testIrises.size() * 100;
            System.out.println("Dokładność wynosi: " + accuracy + "%");
            System.out.println("Wagi: ");
            for (int i = 0; i < perceptron.weights.length; i++) {
                System.out.println(perceptron.weights[i]);
            }
            System.out.println(perceptron.teta);


            System.out.println("Czy chcesz wykonać kolejną epokę uczenia? Wpisz Y lub N");
            String answer = scanner.nextLine();
            if (Objects.equals(answer, "N")||Objects.equals(answer, "n")) {
                System.out.println("Wyłączam system. Końcowa dokładność wynosi: "+accuracy+"%");
                System.exit(0);
            }


        }

    }
}