package com.suresh.algorithms.string.tries;

public class NaryTrie<Value> {

  private static final int R = 256;

  public static void main(String[] args) {
    NaryTrie<Integer> trie = new NaryTrie<>();
    trie.put("suresh", 1);
    trie.put("siva", 2);
    trie.put("siva", 4);
    trie.put("chandu", 2);
    System.out.println(trie.get("suresh"));
    System.out.println(trie.get("siva"));
    System.out.println(trie.get("chandu"));

    trie.printTree();
  }

  private Node root;

  public NaryTrie() {
    this.root = new Node();
  }

  public void put(String s, Value v) {
    root = put(root, s, v, 0);
  }

  public Value get(String s) {
    Object o = get(root, s, 0);
    return o == null ? null : (Value) o;
  }

  private Object get(Node root, String s, int i) {
    if (root == null) {
      return null;
    }
    if (s.length() == i) {
      return root.value;
    }
    char c = s.charAt(i);

    return get(root.next[c], s, i + 1);
  }

  private Node put(Node root, String s, Value v, int currentIndex) {
    if (root == null) {
      root = new Node();
    }
    if (s.length() == currentIndex) {
      root.value = v;
      return root;
    }
    char c = s.charAt(currentIndex);
    root.next[c] = put(root.next[c], s, v, currentIndex + 1);
    return root;
  }

  public void printTree() {
    printTree(root, "");
  }

  public void printTree(Node root, String s) {
    if (root == null) {
      return;
    }
    if (root.value != null) {
      System.out.println("Key: " + s + " Value: " + root.value);
    }
    for (int i = 0; i < R; i++) {
      if (root.next[i] != null) {
        printTree(root.next[i], s +(char) i);

      }
    }
  }

  public static class Node {
    private Object value;
    Node[] next = new Node[R];
  }

}
