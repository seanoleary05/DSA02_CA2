package org.example.ca2_dsa2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Routes {

   /* public static void main(String[] args) {
        String filePath = "vienna_subway.csv"; // path to your CSV
        ArrayList<int[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                int[] row = new int[values.length];

                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i].trim());
                }

                dataList.add(row);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Convert ArrayList to a 2D array
        int[][] array = dataList.toArray(new int[0][]);

        // Print array to verify
        for (int[] row : array) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    */
           /* CustomNode<String> a = new CustomNode<>("Oberlaa");
        CustomNode<String> b = new CustomNode<>("Neulaa");
        CustomNode<String> c = new CustomNode<>("Alaudagasse");
        CustomNode<String> d = new CustomNode<>("Altes Landgut");
        CustomNode<String> e = new CustomNode<>("Troststrasse");

        a.connectToNodeUndirected(b);
        a.connectToNodeUndirected(c);
        b.connectToNodeUndirected(c);
        c.connectToNodeUndirected(d);
        d.connectToNodeUndirected(e);

        CustomGraph.traverseGraphDepthFirst(b,null);

        */

}
