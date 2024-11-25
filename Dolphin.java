import java.io.*;
import java.util.*;

public class DolphinDP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("dolphin.in"));
        PrintWriter pw = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim()); // Number of test cases

        for (int t = 1; t <= n; t++) {
            int m = Integer.parseInt(br.readLine().trim()); // Number of food pellets
            int[] altitudes = new int[m];

            for (int i = 0; i < m; i++) {
                altitudes[i] = Integer.parseInt(br.readLine().trim());
            }

            int maxPellets = findMaxPellets(altitudes);

            // Print output in the required format
            pw.println("Case " + t + ":");
            pw.println("Dynamo ate " + maxPellets + " food pellet(s).");
        }

        pw.close();
        br.close();
    }

    private static int findMaxPellets(int[] altitudes) {
        int n = altitudes.length;

        // Compute LIS values
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (altitudes[i] >= altitudes[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Compute LDS values
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (altitudes[i] >= altitudes[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        // Combine LIS and LDS to find the maximum bitonic subsequence length
        int maxPellets = 0;
        for (int i = 0; i < n; i++) {
            maxPellets = Math.max(maxPellets, lis[i] + lds[i] - 1);
        }

        return maxPellets;
    }
}
