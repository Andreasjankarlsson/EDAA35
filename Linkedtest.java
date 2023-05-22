import java.util.*;
import java.io.*;


public class Linkedtest{

    public static void main(String[] args) throws IOException{
        skrivare("ExponentialDistribution.txt", "./LinkedResultat/LinkedExponentialResult.txt", 30000);
        skrivare("NormalDistribution.txt", "./LinkedResultat/LinkedNormalResult.txt", 30000);
        skrivare("UniformDistribution.txt", "./LinkedResultat/LinkedUniformResult.txt", 30000);
    }
    public static void skrivare(String inFile, String outFile, int N) throws IOException{
        LinkedList<Double> numbers = new LinkedList<Double>();
        Scanner scan = new Scanner(new File(inFile));
        while(scan.hasNextLine()){
            numbers.add(Double.parseDouble(scan.nextLine()));
        }
        scan.close();

        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Iteration, Sorteringstid (ns)");

        for(int i = 1; i <= N; i+=200){
            LinkedList<Double> copy = new LinkedList<>();
            for(int j = 0; j<=i; j++){
                copy.add(numbers.get(j));
            }
            //LinkedList<Double> copy = new LinkedList<Double>(numbers);
            long start = System.nanoTime();
            Collections.sort(copy);
            long end = System.nanoTime();
            long time = end - start;
            writer.println(i + "," + time);
            System.out.println(i);
        }
        writer.close();
    }
}