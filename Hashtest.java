import java.util.*;
import java.io.*;

public class Hashtest {

    public static void main(String[] args) {
        test("ExponentialDistribution.txt", "ExponentialResult.txt", 1000);
        test("NormalDistribution.txt", "NormalResult.txt", 1000);
        test("UniformDistribution.txt", "UniformResult.txt", 1000);
    }

    public static void test(String inFile, String outFile, int N){
    
        HashMap<Double, Integer> map = new HashMap<>();






        PrintWriter writer = new PrintWriter(new FileWriter(outFile));


        long startTime = System.nanoTime();

        long endTime = System.nanoTime();
        long resultingTime = endTime - startTime;
        writer.println(N + ", " + resultingTime);
    }

}