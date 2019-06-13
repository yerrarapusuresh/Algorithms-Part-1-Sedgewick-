package com.suresh.algorithms.recursion;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {

  public static class Position {

    private int row;
    private int col;

    public Position(int row, int col) {
      this.row = row;
      this.col = col;
    }

    public boolean isItAttacking(int row, int col) {
      // check row
      if (this.row == row) {
        return true;
      }
      // check column
      if (this.col == col) {
        return true;
      }

      if (Math.abs(row - this.row) == Math.abs(col - this.col)) {
        return true;
      }
      return false;
    }

    public String toString() {
      return row + " " + col;
    }
  }

  public static void main(String[] args) throws Exception {
    int boardSize = 3;
    printBoard(boardSize, nQueenSolver(boardSize));
  }

  private static void printBoard(int boardSize, List<Position> nQueenSolver) {
    int[][] array = new int[boardSize][boardSize];
    nQueenSolver.stream().peek(p -> {
       System.out.println(p);
    }).close();

    for(Position p: nQueenSolver) {
      array[p.row][p.col] = 1;
    }
    for (int i = 0; i < boardSize; i++) {
      for (int j = 0; j < boardSize; j++) {
        System.out.print(String.format("%3d", array[i][j]));
      }
      System.out.println();
    }

  }

  public static List<Position> nQueenSolver(int boardSize) throws Exception {
    List<Position> list = new ArrayList<>();
    if (!nQueenSolverHelper(0, boardSize, list)) {
      throw new Exception("No feasable solution");
    }
    return list;
  }

  private static boolean nQueenSolverHelper(int currentRow, int boardLimit, List<Position> list) {
    if (currentRow == boardLimit) {
      return true;
    }
    for (int i = 0; i < boardLimit; i++) {
      if (!isItAttackingOtherQueens(currentRow, i, list)) {
        list.add(new Position(currentRow, i));
        if (nQueenSolverHelper(currentRow + 1, boardLimit, list)) {
          return true;
        } else {
          list.remove(currentRow);
        }
      }

    }
    return false;
  }

  private static boolean isItAttackingOtherQueens(int row, int col, List<Position> list) {

    for (Position p : list) {
      if (p.isItAttacking(row, col)) {
        return true;
      }
    }
    return false;
  }

}
