package com.suresh.algorithms.string.tries;

public class ThreeWayTrie<Value> {

  private Node<Value> root;

  public static void main(String[] args) {
    ThreeWayTrie<Integer> trie = new ThreeWayTrie<>();
    trie.put("suresh", 1);
    trie.put("siva", 2);
    trie.put("siva", 4);
    trie.put("chandu", 2);
    System.out.println(trie.get("suresh"));
    System.out.println(trie.get("siva"));
    System.out.println(trie.get("chandu"));

    trie.printTrie();
  }

  public void printTrie() {
    printTrie(root, "");
  }

  public static class Node<Value> {
    private Value v;
    private char c;
    Node<Value> left, right, middle;

    public Node(char c) {
      this.c = c;
    }
  }

  public void put(String s, Value v) {
    this.root = put(root, s, v, 0);
  }

  public Value get(String s) {
    return get(root, s, 0);
  }

  private Value get(Node<Value> root, String s, int index) {
    if (root == null) {
      return null;
    }
    char c = s.charAt(index);
    if (c < root.c) {
      return get(root.left, s, index);
    } else if (c > root.c) {
      return get(root.right, s, index);
    } else if (index < s.length() - 1) {
      return get(root.middle, s, index + 1);
    } else {
      return root.v;
    }
  }

  private Node<Value> put(Node<Value> root, String s, Value v, int i) {
    char c = s.charAt(i);
    if (root == null) {
      root = new Node<Value>(c);
    }
    if (c < root.c) {
      root.left = put(root.left, s, v, i);
    } else if (c > root.c) {
      root.right = put(root.right, s, v, i);
    } else if (i < s.length() - 1) {
      root.middle = put(root.middle, s, v, i + 1);
    } else {
      root.v = v;
    }

    return root;
  }

  public void printTrie(Node<Value> root, String s) {
    if (root == null) {
      return;
    }
    printTrie(root.left, s);
    printTrie(root.middle, s + root.c);
    printTrie(root.right, s);
    if (root.v != null)
      System.out.println("Key : " + (s + root.c) + " Value: " + root.v);
  }
}
