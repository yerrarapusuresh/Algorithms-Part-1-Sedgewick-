package com.suresh.algorithms.sort.problemset.collinearpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {

  private Point[] copiedPointsArray;
  private List<LineSegment> segments;

  /**
   * This constructor computes the collinear points.
   * 
   * @param points
   *          Input Argument.
   */
  public BruteCollinearPoints(Point[] points) { // finds all line segments containing 4 points
    if (points == null) {
      throw new java.lang.IllegalArgumentException();
    }
    copiedPointsArray = new Point[points.length];
    segments = new ArrayList<LineSegment>();
    for (int i = 0; i < points.length; i++) {
      if (points[i] == null) {
        throw new java.lang.IllegalArgumentException();
      }
      copiedPointsArray[i] = points[i];
    }
    compute(copiedPointsArray);

  }

  private void compute(Point[] copiedPointsArray2) {
    Arrays.sort(copiedPointsArray2);
    int dupCount = removeDuplicates(copiedPointsArray2);
    int arraySizeAfterUpdate = copiedPointsArray2.length - dupCount;
    for (int i = 0; i < arraySizeAfterUpdate; i++) {
      for (int j = i + 1; j < arraySizeAfterUpdate; j++) {
        for (int k = j + 1; k < arraySizeAfterUpdate; k++) {
          for (int l = k + 1; l < arraySizeAfterUpdate; l++) {
            if (copiedPointsArray2[i].slopeTo(copiedPointsArray2[j]) == copiedPointsArray2[j]
                .slopeTo(copiedPointsArray2[k])
                && copiedPointsArray2[j].slopeTo(copiedPointsArray2[k]) == copiedPointsArray2[k]
                    .slopeTo(copiedPointsArray2[l])) {
          
              segments.add(new LineSegment(copiedPointsArray2[i], copiedPointsArray2[l]));

            }
          }
        }
      }

    }
  }

  private int removeDuplicates(Point[] copiedPointsArray2) {
    int dupCount = 0;
    for (int i = 1, j = 0; i < copiedPointsArray2.length; i++) {
      if (copiedPointsArray2[i].compareTo(copiedPointsArray2[j]) != 0) {
        copiedPointsArray2[++j] = copiedPointsArray2[i];
      } else {
        dupCount++;
        throw new java.lang.IllegalArgumentException();
      }
    }
    return dupCount;
  }

  public int numberOfSegments() { // the number of line segments
    return segments.size();
  }

  public LineSegment[] segments() {
    return segments.toArray(new LineSegment[segments.size()]);
  }

  /**
   * main method.
   * 
   * @param args
   *          command line arguments.
   */
  public static void main(String[] args) {
    Point[] p = new Point[5];
    p[0] = new Point(1, 1);
    p[1] = new Point(2, 2);
    p[2] = new Point(3, 3);
    p[3] = new Point(4, 4);
    p[4] = new Point(5, 5);
    BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(p);
    System.out.println(bruteCollinearPoints.numberOfSegments());
    System.out.println(Arrays.toString(bruteCollinearPoints.segments()));

  }

}
