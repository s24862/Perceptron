import java.util.Objects;

public class Iris {
    double[] input;
    String name;

    int bool;
    //setosa=0,versicolor=1

    public Iris(double[] input,String name) {
        this.input=input;
        this.name = name;

        if (Objects.equals(name, "Iris-setosa"))
            this.bool=0;
        else
            this.bool=1;
    }
}
