public class Perceptron {

    double[] weights;

    double teta;

    int output;

    int whatWeWant;

    public void train(double[] input,double lerningRate){
        double[] newWeights = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            newWeights[i]=weights[i]+(whatWeWant-output)*lerningRate*input[i];
        }
        weights=newWeights;
        teta=teta+(whatWeWant-output)*lerningRate*(-1);
    }
    public void predict(Iris iris,int accuracy,double lerningRate){
        double sum=0;

        for (int i = 0; i < iris.input.length; i++) {
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
            accuracy=accuracy+1;
        }else {
            System.out.println("Nie udało się zgadnąć gatunku irysa. Rozpoczynam proces trenowania");
            train(iris.input,lerningRate);
            if (output==0){
                whatWeWant=1;
            }
            else {
                whatWeWant=0;
            }
        }

    }


}
