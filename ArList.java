import java.util.*;
import java.io.*;
public class ArList {
    public static void main(String[] args) throws IOException{
        writeToFile("ExponentialDistribution.txt", "./ArrayListResultat/ArrayListExponentialResult.txt", 30000);
        writeToFile("NormalDistribution.txt", "./ArrayListResultat/ArrayListNormalResult.txt", 30000);
        writeToFile("UniformDistribution.txt", "./ArrayListResultat/ArrayListUniformResult.txt", 30000);
    }
    public static void writeToFile(String inFile, String outFile, int N) throws IOException{
        List<Double> list = new ArrayList<>();
        Scanner scan = new Scanner(new File(inFile));
        while(scan.hasNextLine()){
            list.add(Double.parseDouble(scan.nextLine()));
        }
        scan.close();
        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Sorteringstid (ns)");

        for(int i = 0; i< N; i+=200){
            List<Double> copy = new ArrayList<>();
            
            long start = System.nanoTime();
            for(int j = 0; j<=i; j++){
                copy.add(list.get(j));
            }
            Collections.sort(copy);
            long end = System.nanoTime();
            long result = end - start;
            writer.println(i + "," + result);
            System.out.println(i);
        }
        writer.close();
    }
}
