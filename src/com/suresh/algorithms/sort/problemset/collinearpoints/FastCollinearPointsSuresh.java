package com.suresh.algorithms.sort.problemset.collinearpoints;

import java.util.ArrayList;
import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by CtheSky on 2016/9/9.
 */
public class FastCollinearPointsSuresh {
  private ArrayList<LineSegment> segmentList = new ArrayList<>();

  public FastCollinearPointsSuresh(Point[] points) {
    // finds all line segments containing 4 or more points
    if (points == null)
      throw new NullPointerException();
    Point[] aux = Arrays.copyOf(points, points.length);
    for (int i = 0; i < points.length; i++) {
      Point p = points[i];
      Arrays.sort(aux);
      Arrays.sort(aux, p.slopeOrder());

      int min = 0;
      while (min < aux.length && p.slopeTo(aux[min]) == Double.NEGATIVE_INFINITY)
        min++;
      if (min != 1)
        throw new IllegalArgumentException();// check duplicate points
      int max = min;
      while (min < aux.length) {
        while (max < aux.length && p.slopeTo(aux[max]) == p.slopeTo(aux[min]))
          max++;
        if (max - min >= 3) {
          Point pMin = aux[min].compareTo(p) < 0 ? aux[min] : p;
          Point pMax = aux[max - 1].compareTo(p) > 0 ? aux[max - 1] : p;
          if (p == pMin)
            segmentList.add(new LineSegment(pMin, pMax));
        }
        min = max;
      }
    }
  }

  public int numberOfSegments() {
    // the number of line segments
    return segmentList.size();
  }

  public LineSegment[] segments() {
    // the line segments
    LineSegment[] segments = new LineSegment[segmentList.size()];
    return segmentList.toArray(segments);
  }

  public static void main(String[] args) {
    // read the n points from a file
    In in = new In("C:\\Users\\syerrarapu\\Downloads\\Music\\input10.txt");
    int n = in.readInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i++) {
      int x = in.readInt();
      int y = in.readInt();
      points[i] = new Point(x, y);
    }

    // draw the points
    StdDraw.enableDoubleBuffering();
    StdDraw.setXscale(0, 32768);
    StdDraw.setYscale(0, 32768);
    for (Point p : points) {
      p.draw();
    }
    StdDraw.show();

    // print and draw the line segments
    FastCollinearPointsSuresh collinear = new FastCollinearPointsSuresh(points);
    for (LineSegment segment : collinear.segments()) {
      StdOut.println(segment);
      segment.draw();
    }
    StdDraw.show();
  }

}