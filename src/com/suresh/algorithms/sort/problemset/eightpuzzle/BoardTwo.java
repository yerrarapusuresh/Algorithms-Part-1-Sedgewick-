package com.suresh.algorithms.sort.problemset.eightpuzzle;

import java.util.Arrays;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class BoardTwo {
  private int N;
  private int[][] tiles;

  // construct a board from an N-by-N array of blocks
  // (where blocks[i][j] = block in row i, column j)
  public BoardTwo(int[][] blocks) {
    N = blocks.length;
    tiles = new int[N][N];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        tiles[i][j] = blocks[i][j];
      }
    }
  }

  // board dimension N
  public int dimension() {
    return N;
  }

  // number of blocks out of place
  public int hamming() {
    int distance = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (i == N - 1 && j == N - 1) {
          continue;
        }

        if (tiles[i][j] != i * N + j + 1) {
          distance++;
        }
      }
    }

    return distance;
  }

  // sum of Manhattan distances between blocks and goal
  public int manhattan() {
    int distance = 0;

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (tiles[i][j] == 0) {
          continue;
        }

        int expectedi = (tiles[i][j] - 1) / N;
        int expectedj = (tiles[i][j] - 1) % N;

        distance += Math.abs(i - expectedi);
        distance += Math.abs(j - expectedj);
      }
    }

    return distance;
  }

  // is this board the goal board?
  public boolean isGoal() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (tiles[i][j] == 0) {
          if (i != N - 1 && j != N - 1) {
            return false;
          }
        } else if (tiles[i][j] != i * N + j + 1) {
          return false;
        }
      }
    }
    return true;
  }

  // a board obtained by exchanging two adjacent blocks in the same row
  public BoardTwo twin() {
    // return the first possible twin
    BoardTwo twin = new BoardTwo(tiles);

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N - 1; j++) {
        if (tiles[i][j] != 0 && tiles[i][j + 1] != 0) {
          twin.tiles[i][j] = tiles[i][j + 1];
          twin.tiles[i][j + 1] = tiles[i][j];

          return twin;
        }
      }
    }

    assert false;
    return twin;
  }

  // does this board equal y?
  public boolean equals(Object y) {
    if (y == this) {
      return true;
    }

    if (y == null) {
      return false;
    }

    if (y.getClass() != this.getClass()) {
      return false;
    }

    BoardTwo that = (BoardTwo) y;

    if (this.N != that.N) {
      return false;
    }

    return Arrays.deepEquals(this.tiles, that.tiles);
  }

  // all neighboring boards
  public Iterable<BoardTwo> neighbors() {
    int emptyi = -1;
    int emptyj = -1;

    // find empty tile
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        if (tiles[i][j] == 0) {
          emptyi = i;
          emptyj = j;
          break;
        }
      }
    }

    assert emptyi != -1;
    assert emptyj != -1;

    Queue<BoardTwo> neighbors = new Queue<BoardTwo>();

    // swap with left
    if (emptyi - 1 >= 0) {
      BoardTwo neighbor = new BoardTwo(tiles);
      neighbor.tiles[emptyi][emptyj] = tiles[emptyi - 1][emptyj];
      neighbor.tiles[emptyi - 1][emptyj] = 0;
      neighbors.enqueue(neighbor);
    }

    // swap with right
    if (emptyi + 1 < N) {
      BoardTwo neighbor = new BoardTwo(tiles);
      neighbor.tiles[emptyi][emptyj] = tiles[emptyi + 1][emptyj];
      neighbor.tiles[emptyi + 1][emptyj] = 0;
      neighbors.enqueue(neighbor);
    }

    // swap with up
    if (emptyj - 1 >= 0) {
      BoardTwo neighbor = new BoardTwo(tiles);
      neighbor.tiles[emptyi][emptyj] = tiles[emptyi][emptyj - 1];
      neighbor.tiles[emptyi][emptyj - 1] = 0;
      neighbors.enqueue(neighbor);
    }

    // swap with down
    if (emptyj + 1 < N) {
      BoardTwo neighbor = new BoardTwo(tiles);
      neighbor.tiles[emptyi][emptyj] = tiles[emptyi][emptyj + 1];
      neighbor.tiles[emptyi][emptyj + 1] = 0;
      neighbors.enqueue(neighbor);
    }

    return neighbors;
  }

  // string representation of the board (in the output format specified below)
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(N + "\n");
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        s.append(String.format("%2d ", tiles[i][j]));
      }
      s.append("\n");
    }
    return s.toString();
  }

  public static void main(String[] args) {
    int[][] blocks = new int[][] { { 5, 0, 4 }, { 2, 3, 8 }, { 7, 1, 6 } };
    BoardTwo b = new BoardTwo(blocks);
    System.out.println(b);
    for (BoardTwo board : b.neighbors()) {
      System.out.println(board);
    }

  }
}