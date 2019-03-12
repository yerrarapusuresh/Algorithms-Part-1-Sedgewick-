package com.suresh.algorithms.sort.binarysearchtrees;

import java.util.stream.Stream;

public class RedBlackTrees<T extends Comparable<T>> {

  private static final boolean RED = true;
  private static final boolean BLACK = false;
  private Node root;

  public RedBlackTrees() {
    this.root = null;
  }

  public static void main(String[] args) {
    RedBlackTrees<Integer> rbt = new RedBlackTrees<>();
    /*
     * Stream.generate(Math::random).map(n -> (int) (n * 100)).limit(10).forEach(n -> {
     * rbt.insert(n); });
     * 
     */
    for (int i = 0; i < 1000000000; i++)
      rbt.insert(i);

    System.out.println("--------------------- size " + rbt.depthOfTree() + " -------------");

   // rbt.printInOrderTraversal();
  }

  public void insert(T t) {
    root = insert(root, t);
  }

  private Node insert(Node item, T t) {
    if (item == null) {
      return new Node(t, null, null, 1, RED);
    }
    int cmp = item.key.compareTo(t);
    if (cmp < 0) {
      item.right = insert(item.right, t);
    } else if (cmp > 0) {
      item.left = insert(item.left, t);
    } else {
      item.key = t;
    }
    if (!isRed(item.left) && isRed(item.right)) {
      item = rotateLeft(item);
    }
    if (isRed(item.left) && isRed(item.left.left)) {
      item = rotateRight(item);
    }
    if (isRed(item.right) && isRed(item.left)) {
      item = colorChange(item);
    }
    return item;
  }

  private RedBlackTrees<T>.Node colorChange(RedBlackTrees<T>.Node item) {
    item.right.color = BLACK;
    item.left.color = BLACK;
    item.color = RED;

    return item;
  }

  private RedBlackTrees<T>.Node rotateRight(RedBlackTrees<T>.Node item) {
    Node x = item.left;
    item.left = x.right;
    x.right = item;
    x.color = item.color;
    item.color = RED;
    return item;
  }

  private Node rotateLeft(Node item) {
    Node x = item.right;
    item.right = x.left;
    x.left = item;
    x.color = item.color;
    item.color = RED;
    return x;
  }

  private boolean isRed(Node n) {
    if (n == null) {
      return BLACK;
    }
    return n.color == RED ? true : false;
  }

  public void printInOrderTraversal() {
    printInOrderTraversal(root);
  }

  private void printInOrderTraversal(Node n) {
    if (n == null) {
      return;
    }
    printInOrderTraversal(n.left);
    System.out.println(n.key + " ");
    printInOrderTraversal(n.right);
  }

  public int depthOfTree() {
    return depthOfTree(root);
  }

  private int depthOfTree(RedBlackTrees<T>.Node root) {
    if (root == null) {
      return 0;
    }
    int left = depthOfTree(root.left);
    int right = depthOfTree(root.right);
    return Math.max(left, right) + 1;
  }

  class Node {
    private T key;
    private Node left;
    private Node right;
    private int size;
    private boolean color;

    Node(T key, Node left, Node right, int size, boolean color) {
      this.key = key;
      this.left = left;
      this.right = right;
      this.size = size;
      this.color = color;
    }
  }

}
