import java.util.*;



import java.io.*;

public class Treetest{
    
    public static void main(String[] args) throws IOException {
        treeTime("ExponentialDistribution.txt", "./TreeResultat/LinkedExponentialResult222.txt", 30000);
        treeTime("NormalDistribution.txt", "./TreeResultat/TreeNormalResult.txt", 30000);
        treeTime("UniformDistribution.txt", "./TreeResultat/TreeUniformResult.txt", 30000);
    }   

    public static void treeTime(String inFile, String outFile, int N) throws IOException{
       TreeMap<String, Double> map = new TreeMap<>();
       Scanner scan = new Scanner(new File(inFile));
       int i = 0;
       /*
       while(scan.hasNextLine()){
        map.put(String.valueOf(i), Double.parseDouble(scan.nextLine()));
        i++;
       }
       */
      //Linked list for timecomplexity(0);
        LinkedList<Double> numbers = new LinkedList<Double>();
        while(scan.hasNextLine()){
            numbers.add(Double.parseDouble(scan.nextLine()));
        }
        scan.close();

        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        writer.println("Sorteringstid (ns)");

        for(int j= 1; j<=N ; j+=200){
            ArrayList<Double> iterationNumbers = new ArrayList<Double>();
            for(int k =0; k<=j; k++){
                iterationNumbers.add(numbers.get(k));
            }

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
            System.out.println(j);
        }   
    writer.close();
    }
}