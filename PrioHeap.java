import java.io.*;

import java.util.PriorityQueue;
import java.util.Scanner;


public class PrioHeap{
    public static void main(String[] args) {
        tester("ExponentialDistribution.txt", "HeapExponentialResult.txt", 30000);
        tester("NormalDistribution.txt", "HeapNormalResult.txt", 30000);
        tester("UniformDistribution.txt", "HeapUniformResult.txt", 30000);
    }
    public static void tester(String inFile, String outFile, int iterations){
        
        PriorityQueue<Double> queue = new PriorityQueue<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                double number = Double.parseDouble(line.trim());
                queue.add(number);
            }
        } catch (IOException e) {
            System.out.println("Fel läsning av fil: " + inFile);
            return;
        }
        try(PrintWriter writer = new PrintWriter(new FileWriter(outFile))){
            Scanner scan = new Scanner(new File(inFile));
            writer.println("Iteration: , Time(ns)");
            int temp = iterations;
            while(scan.hasNext() && iterations > 0){
                int current = temp-iterations;
                long startTime = System.nanoTime();
                queue.offer(Double.parseDouble(scan.nextLine()));
                long endTime = System.nanoTime();
                long time = endTime - startTime;
                iterations--;
                writer.println(current + ", " + time);
            }
            writer.close();

            
        }catch(IOException e){
            System.out.println("Fel vid skrivning till fil: " + outFile);
            return;
        }
    }

}