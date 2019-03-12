package com.suresh.algorithms.sort.problemset.eightpuzzle;
/*
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Board {
  private int[] blocks;
  private int gridSize;
  private int manahattonDistance;
  private int hammingDistance;
  private String toString;
  private Stack<Board> board;
  private Board twinBoard;

  public Board(int[][] blocks) { // construct a board from an n-by-n array of blocks
    // (where blocks[i][j] = block in row i, column j)
    if (blocks == null) {
      throw new java.lang.IllegalArgumentException();
    }
    this.gridSize = blocks.length;
    this.manahattonDistance = -1;
    this.hammingDistance = -1;
    this.toString = null;
    this.board = null;
    this.twinBoard = null;
    this.blocks = new int[this.gridSize * this.gridSize];
    for (int i = 0; i < blocks.length; i++) {
      for (int j = 0; j < blocks.length; j++) {
        this.blocks[i * gridSize + j] = blocks[i][j];
      }
    }
  }

  public int dimension() { // board dimension n
    return gridSize;
  }

  public int hamming() { // number of blocks out of place
    if (this.hammingDistance != -1) {
      return this.hammingDistance;
    }
    int hammingCount = 0;
    for (int i = 0; i < this.gridSize * this.gridSize - 1; i++) {
      if (this.blocks[i] != i + 1) {
        hammingCount++;
      }
    }
    this.hammingDistance = hammingCount;
    return this.hammingDistance;
  }

  public int manhattan() { // sum of Manhattan distances between blocks and goal
    if (this.manahattonDistance != -1) {
      return this.manahattonDistance;
    }

    int manhattonDistance = 0;
    for (int i = 0; i < this.gridSize * this.gridSize; i++) {
      if (blocks[i] == 0) {
        continue;
      }
      int currentColumn = i % this.gridSize;
      int currentRow = i / this.gridSize;
      int elementRow = (this.blocks[i] - 1) / this.gridSize;
      int elementColumn = (this.blocks[i] - 1) % this.gridSize;
      manhattonDistance += (Math.abs(currentColumn - elementColumn)
          + Math.abs(currentRow - elementRow));
    }
    this.manahattonDistance = manhattonDistance;
    return this.manahattonDistance;
  }

  public boolean isGoal() { // is this board the goal board?
    for (int i = 0; i < this.gridSize * this.gridSize - 1; i++) {
      if (this.blocks[i] != i + 1) {
        return false;
      }
    }
    return true;
  }

  public Board twin() { // a board that is obtained by exchanging any pair of blocks
    if (this.twinBoard != null) {
      return this.twinBoard;
    }

    boolean isDone = false;
    int[][] auxArray = new int[this.gridSize][this.gridSize];
    for (int i = 0; i < this.gridSize * this.gridSize; i++) {
      if (this.blocks[i] != 0) {
        int column = i % this.gridSize;
        int row = i / this.gridSize;
        auxArray[row][column] = this.blocks[i];
        if (!isDone && column - 1 >= 0 && this.blocks[row * this.gridSize + (column - 1)] != 0) {
          swap(auxArray, row, column, row, column - 1);
          isDone = true;
        }
      }
    }
    this.twinBoard = new Board(auxArray);
    return this.twinBoard;
  }

  public boolean equals(Object y) { // does this board equal y?
    if (this == y) {
      return true;
    }
    if (y == null) {
      return false;
    }
    if (this.getClass() != y.getClass()) {
      return false;
    }

    Board that = (Board) y;
    if (this.gridSize != that.gridSize) {
      return false;
    }
    for (int i = 0; i < this.gridSize * this.gridSize; i++) {
      if (this.blocks[i] != that.blocks[i]) {
        return false;
      }
    }

    return true;
  }

  private void swap(int[][] arrayOne, int i, int j, int k, int l) {
    int temp = arrayOne[i][j];
    arrayOne[i][j] = arrayOne[k][l];
    arrayOne[k][l] = temp;
  }

  public Iterable<Board> neighbors() { // all neighboring boards
    if (this.board != null) {
      return this.board;
    }
    Stack<Board> stack = new Stack<>();
    int[][] auxBoard = new int[this.gridSize][this.gridSize];
    int currentZeroPosition = -1;
    for (int i = 0; i < this.gridSize * this.gridSize; i++) {
      if (this.blocks[i] == 0) {
        currentZeroPosition = i;
      }
      auxBoard[i / this.gridSize][i % this.gridSize] = this.blocks[i];
    }
    int row = currentZeroPosition / this.gridSize;
    int column = currentZeroPosition % this.gridSize;
    if (row - 1 >= 0) {
      swap(auxBoard, row, column, row - 1, column);
      stack.add(new Board(auxBoard));
      swap(auxBoard, row, column, row - 1, column);
    }
    if (row + 1 < this.gridSize) {

      swap(auxBoard, row, column, row + 1, column);
      stack.add(new Board(auxBoard));
      swap(auxBoard, row, column, row + 1, column);
    }
    if (column - 1 >= 0) {

      swap(auxBoard, row, column, row, column - 1);
      stack.add(new Board(auxBoard));
      swap(auxBoard, row, column, row, column - 1);
    }
    if (column + 1 < this.gridSize) {
      swap(auxBoard, row, column, row, column + 1);
      stack.add(new Board(auxBoard));
      swap(auxBoard, row, column, row, column + 1);
    }
    this.board = stack;
    return this.board;
  }

  public String toString() { // string representation of this board (in the output format specified
                             // below)
    if (this.toString != null) {
      return this.toString;
    }
    StringBuilder sb = new StringBuilder();
    sb.append(this.gridSize + "\n");
    for (int i = 0; i < this.gridSize; i++) {
      for (int j = 0; j < this.gridSize; j++) {
        sb.append(String.format(" " + this.blocks[i * this.gridSize + j]));
      }
      sb.append(String.format("\n"));
    }
    this.toString = sb.toString();
    return this.toString();

  }

  public static void main(String[] args) {// unit tests (not graded)
    int[][] blocks = new int[][] { { 5, 0, 4 }, { 2, 3, 8 }, { 7, 1, 6 } };
    Board b = new Board(blocks);
    System.out.println(b);
    for(Board board : b.neighbors()) {
      System.out.println(board);
    }

  }
} */
