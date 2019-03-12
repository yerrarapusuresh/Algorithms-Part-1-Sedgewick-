package com.suresh.algorithms.sort.problemset.collinearpoints;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FastCollinearPoints {

  private Point[] copiedPointsArray;
  private List<LineSegment> segments;

  /**
   * constructor to compute collinear points.
   * 
   * @param points
   *          input points to compute collinear points.
   */
  public FastCollinearPoints(Point[] points) { // finds all line segments containing 4 or more
                                               // points
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
  //  Arrays.sort(copiedPointsArray2);
    int removedCount = removeDuplicates(copiedPointsArray2);
    int updatedSizeOfPoints = copiedPointsArray2.length - removedCount;
    for (int i = 0; i < updatedSizeOfPoints; i++) {
      Point[] clonedPoints = copiedPointsArray2.clone();
      Arrays.sort(clonedPoints);
      Arrays.sort(clonedPoints, copiedPointsArray2[i].slopeOrder());
      int count = 0;
      for (int j = i + 1, k = j; j < updatedSizeOfPoints; j++) {
        if (clonedPoints[i].slopeTo(clonedPoints[j]) == clonedPoints[i]
            .slopeTo(clonedPoints[k])) {
          count++;
        } 
      }
      if (count >= 3) {

        segments.add(new LineSegment(copiedPointsArray2[i], copiedPointsArray2[i + count]));
        i += count;
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

  public LineSegment[] segments() { // the line segments
    return segments.toArray(new LineSegment[segments.size()]);
  }

  public static void main(String[] args) {

  }

}
