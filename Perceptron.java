import java.lang.reflect.Array;
import java.util.ArrayList;

public class Perceptron {

    double[] weights;

    double teta;

    int output;

    int whatWeWant;

    double guessed;

    public Perceptron(ArrayList<Iris> irises) {
        this.weights=new double[(irises.get(0).input.length)];
        int min=-1;
        int max=1;
        for (int i = 0; i < weights.length; i++) {
            this.weights[i]= (Math.random()*(max-min+1)+min);
        }
        this.guessed=0;
        teta=(Math.random()*(max-min+1)+min);

    }

    public void train(double[] input, double lerningRate){
        System.out.println("Wykonuję nauczanie");
        double[] newWeights = new double[weights.length];
        for (int i = 0; i < weights.length; i++) {
            newWeights[i]=weights[i]+(whatWeWant-output)*lerningRate*input[i];
        }
        weights=newWeights;
        teta=teta+(whatWeWant-output)*lerningRate*(-1);
    }
    public void predict(Iris iris,double lerningRate){
        double sum=0;

        for (int i = 0; i < weights.length; i++) {
            sum=sum+(iris.input[i]*weights[i]);
        }
        if(sum<teta){
            output=0;
        }
        else {
            output=1;
        }
        if (output!=iris.bool)
        {
            if (output==0) {
                whatWeWant = 1;
            }
            else {
                whatWeWant = 0;
            }
            train(iris.input,lerningRate);
        }




        }


    public void predictWithoutLearning(Iris iris){
        double sum=0;
        for (int i = 0; i < weights.length; i++) {
            sum=sum+(iris.input[i]*weights[i]);
        }

        if(sum<teta){
            output=0;
        }
        else {
            output=1;
        }
        if (output==iris.bool){
            System.out.println("Udało się zgadnąć gatunek irysa! Jej gatunek to "+ iris.name);
            guessed=guessed+1;
        }else {
            System.out.println("Nie udało się zgadnąć gatunku irysa.");
        }

    }


}
