import java.io.*;
import java.util.ArrayList;

import java.util.PriorityQueue;
import java.util.Scanner;



public class PrioHeap{
    public static void main(String[] args) throws IOException {
        tester("ExponentialDistribution.txt", "HeapExponentialResult.txt", 30000);
        tester("NormalDistribution.txt", "HeapNormalResult.txt", 30000);
        tester("UniformDistribution.txt", "HeapUniformResult.txt", 30000);
    }
    public static void tester(String inFile, String outFile, int iterations) throws IOException{
        
        PriorityQueue<Double> queue = new PriorityQueue<>();
        Scanner scan = new Scanner(new File(inFile));
        
        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Iteration, Sorteringstid (ns)");
        for(int j = 1; j<= iterations; j+=200){
            int i = 0;
            ArrayList<Double> list = new ArrayList<>();
            while(scan.hasNextLine()){
                list.add(Double.parseDouble(scan.nextLine()));
            }
            Long startTime = System.nanoTime();
            while(i < j){
                queue.add(list.get(i));
                i++;
            }
            Long endTime = System.nanoTime();
            Long resultTime = endTime - startTime;
            writer.println(j + ", " + resultTime);
            
        }
        writer.close();
    }

}