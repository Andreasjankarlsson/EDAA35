import java.util.*;
import java.io.*;
public class ArList {
    public static void main(String[] args) throws IOException{
        
    }
    public void writeToFile(String inFile, String outFile, int N) throws IOException{
        List<Double> list = new ArrayList<>();
        Scanner scan = new Scanner(new File(inFile));
        while(scan.hasNextLine()){
            list.add(Double.parseDouble(scan.nextLine()));
        }
        scan.close();
        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Sorteringstid (ns)");

        for(int i = 0; i< N; i++){
            List<Double> copy = new ArrayList<>(list);
            long start = System.nanoTime();
            Collections.sort(copy);
            long end = System.nanoTime();
            long result = end - start;
            writer.println("Iteration: " + i + ", Time: " + result);
        }
        writer.close();
    }
}
