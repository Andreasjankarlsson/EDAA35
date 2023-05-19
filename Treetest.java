import java.util.*;



import java.io.*;

public class Treetest{
    private static Comparator<E> comp;
    public static void main(String[] args) throws IOException {
        test("ExponentialDistribution.txt", "TreeExponentialResult.txt", 1000);
        test("NormalDistribution.txt", "TreeNormalResult.txt", 1000);
        test("UniformDistribution.txt", "TreeUniformResult.txt", 1000);
    }

    public static void test(String inFile, String outFile, int N){
        comp = (e1,e2) -> ((Comparable<E>)e1).compareTo(e2);
        TreeMap<Double, Integer> map = new TreeMap<>(comp);
        Scanner scan = new Scanner(new File(inFile));
        int a = 0;
        PrintWriter writer = new PrintWriter(new FileWriter(outFile));
        for(int i = 0; i < N; i++){
        long startTime = System.nanoTime();
        while(scan.hasNextLine()){
            map.put(Double.parseDouble(scan.nextLine(), i));
            i+=1;
        }
        scan.close();
        long endTime = System.nanoTime();
        long resultingTime = endTime - startTime;
        writer.println(iterations + ", " + resultingTime);
        }
        writer.close();
    }
}