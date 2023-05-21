import java.util.Objects;

public class Iris {
    double[] input;
    String name;

    int bool;
    //setosa=0,versicolor=1

    public Iris(double[] input,String name) {
        this.input=new double[input.length-1];
        for (int i = 0; i < input.length-1; i++) {
            this.input[i]=input[i];
        }
        this.name = name;

        if (Objects.equals(name, "Iris-setosa"))
            this.bool=0;
        else
            this.bool=1;


    }
}
