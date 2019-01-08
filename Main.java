import java.io.*;

public class Main {
    public static void main(String[] args) {
        Brain parent = new Brain();
        parent.printNeurs();
        System.out.println("______________________");
        Brain child = new Brain();
        child.copyAndMutate(parentBrain);

    }
}