import java.util.*;
import java.io.*;


public class Linkedtest{

    public static void main(String[] args) throws IOException{
        skrivare("ExponentialDistribution.txt", "LinkedExponentialResult.txt", 1000);
        skrivare("NormalDistribution.txt", "LinkedNormalResult.txt", 1000);
        skrivare("UniformDistribution.txt", "LinkedUniformResult.txt", 1000);
    }
    public static void skrivare(String inFile, String outFile, int N) throws IOException{
        LinkedList<Double> numbers = new LinkedList<Double>();
        Scanner scan = new Scanner(new File(inFile));
        while(scan.hasNextLine()){
            numbers.add(Double.parseDouble(scan.nextLine()));
        }
        scan.close();

        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Sorteringstid (ns)");

        for(int i = 1; i <= N; i++){
            LinkedList<Double> copy = new LinkedList<Double>(numbers);
            long start = System.nanoTime();
            Collections.sort(copy);
            long end = System.nanoTime();
            long time = end - start;
            writer.println(i + "," + time);
        }
        writer.close();
    }
}