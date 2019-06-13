package com.suresh.algorithms.greedy.stanford.problemsetone;

import java.io.BufferedReader;
import java.io.FileReader;

public class GraphUtils {

  public static Graph readEdgeWeightGraphFromPath(String path) throws Exception {

    Graph g = null;
    String tempString = null;
    String[] tempStringArray = null;
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      tempStringArray = br.readLine().split(" ");
      int vertices = Integer.parseInt(tempStringArray[0]);
      //int edges = Integer.parseInt(tempStringArray[1]);
      g = new Graph(vertices);
      int i = 0;
      while ((tempString = br.readLine()) != null) {
        tempStringArray = tempString.split(" ");
        for (int adjEdge = 0; adjEdge < tempStringArray.length;) {
          g.addEdge(new Edge((Integer.parseInt(tempStringArray[adjEdge])-1), (Integer.parseInt(tempStringArray[adjEdge+1])-1),
              Double.parseDouble(tempStringArray[adjEdge+2])));
          adjEdge += 3;
        }
      }

    } catch (Exception e) {
      e.printStackTrace();

    }

    return g;

  }
}
