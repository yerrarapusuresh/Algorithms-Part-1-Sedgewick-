package com.suresh.algorithms.sort.problemset.eightpuzzle;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class SolverTwo {
  private boolean solvable;
  private MinPQ<Node> pq1;
  private MinPQ<Node> pq2;
  private Queue<BoardTwo> solution;
  private int moves;

  // find a solution to the initial BoardTwo (using the A* algorithm)
  public SolverTwo(BoardTwo initial) {
    solvable = false;
    pq1 = new MinPQ<Node>();
    pq2 = new MinPQ<Node>(); // twin
    solution = new Queue<BoardTwo>();
    moves = 0;

    Node initialNode = new Node(initial, 0, null);
    pq1.insert(initialNode);

    Node initialTwin = new Node(initial.twin(), 0, null);
    pq2.insert(initialTwin);

    int step = 0;

    while (true) {
      /*
       * StdOut.println("Step: " + step); for (Node n : pq) { StdOut.println(n); } step++;
       */

      Node node = pq1.delMin();
      solution.enqueue(node.BoardTwo);

      Node twin = pq2.delMin();

      // check node isGoal
      if (node.BoardTwo.isGoal()) {
        solvable = true;
        moves = node.moves;
        break;
      } else if (twin.BoardTwo.isGoal()) {
        solvable = false;
        moves = -1;
        solution = null;
        break;
      } else {
        for (BoardTwo BoardTwo : node.BoardTwo.neighbors()) {
          Node neighborNode = new Node(BoardTwo, node.moves + 1, node);

          if (node.prev == null || !neighborNode.BoardTwo.equals(node.prev.BoardTwo)) {
            pq1.insert(neighborNode);
          }
        }

        // twin path
        for (BoardTwo BoardTwo : twin.BoardTwo.neighbors()) {
          Node neighborNode = new Node(BoardTwo, twin.moves + 1, twin);

          if (twin.prev == null || !neighborNode.BoardTwo.equals(twin.prev.BoardTwo)) {
            pq2.insert(neighborNode);
          }
        }
      }
    }
  }

  // is the initial BoardTwo solvable?
  public boolean isSolvable() {
    return solvable;
  }

  // min number of moves to solve initial BoardTwo; -1 if no solution
  public int moves() {
    return moves;
  }

  // sequence of BoardTwos in a shortest solution; null if no solution
  public Iterable<BoardTwo> solution() {
    return solution;
  }

  private class Node implements Comparable<Node> {
    private final BoardTwo BoardTwo;
    private final int moves;
    private final Node prev;
    private final int manhattan;
    private final int priority;

    public Node(BoardTwo initial, int moves, Node prev) {
      this.BoardTwo = initial;
      this.moves = moves;
      this.prev = prev;
      this.manhattan = this.BoardTwo.manhattan();
      this.priority = this.moves + this.manhattan;
    }

    public int compareTo(Node that) {
      return this.priority - that.priority;
    }

    public int priority() {
      assert priority == manhattan + moves;
      return priority;
    }

    public String toString() {
      String s = "";
      s += "priority  = " + priority + "\n";
      s += "moves     = " + moves + "\n";
      s += "manhattan = " + manhattan + "\n";
      s += BoardTwo;

      return s.toString();
    }
  }

  // solve a slider puzzle (given below)
  public static void main(String[] args) {
    // create initial BoardTwo from file
    In in = new In("C:\\Users\\syerrarapu\\Downloads\\Music\\puzzle\\puzzle3x3-10.txt");
    int N = in.readInt();
    int[][] blocks = new int[N][N];
    for (int i = 0; i < N; i++)
      for (int j = 0; j < N; j++)
        blocks[i][j] = in.readInt();
    BoardTwo initial = new BoardTwo(blocks);

    // solve the puzzle
    SolverTwo solver = new SolverTwo(initial);

    // print solution to standard output
    if (!solver.isSolvable())
      StdOut.println("No solution possible");
    else {
      StdOut.println("Minimum number of moves = " + solver.moves());
      for (BoardTwo BoardTwo : solver.solution())
        StdOut.println(BoardTwo);
    }
  }
}