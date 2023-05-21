import java.util.*;



import java.io.*;

public class Treetest{
    
    public static void main(String[] args) throws IOException {
        treeTime("ExponentialDistribution.txt", "TreeExponentialResult.txt", 1000);
        treeTime("NormalDistribution.txt", "TreeNormalResult.txt", 1000);
        treeTime("UniformDistribution.txt", "TreeUniformResult.txt", 1000);
    }

    public static void treeTime(String inFile, String outFile, int N) throws IOException{
       TreeMap<String, Double> map = new TreeMap<>();
       Scanner scan = new Scanner(new File(inFile));
       int i = 0;
       while(scan.hasNextLine()){
        map.put(String.valueOf(i), Double.parseDouble(scan.nextLine()));
        i++;
       }
       scan.close();

       PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Sorteringstid (ns)");

        for(int j= 1; j<=N ; j++){
            TreeMap<String, Double> sortedTreeMap = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String key1, String key2) {
                    Double value1 = map.get(key1);
                    Double value2 = map.get(key2);
                    return Double.compare(value1, value2);
                }
            });
            Long startTime = System.nanoTime();
            sortedTreeMap.putAll(map);
            Long endTime = System.nanoTime();
            Long resultingTime = endTime - startTime;
            writer.println(j + "," + resultingTime);
        }   
    writer.close();
    }
}