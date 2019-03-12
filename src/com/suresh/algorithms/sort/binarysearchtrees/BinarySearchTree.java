
package com.suresh.algorithms.sort.binarysearchtrees;

import java.util.stream.Stream;

public class BinarySearchTree<T extends Comparable<T>> {
  private Node root = null;

  public static void main(String[] args) {
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    int randomeSize = Stream.generate(Math::random).limit(1).map(n -> (int) (n * 10)).findFirst()
        .get();
    System.out.println("Tree random size will be " + randomeSize);
    Stream.generate(Math::random).limit(randomeSize).forEach((b) -> {
      bst.insert((int) (b * 10));
    });

    int randomFloor = Stream.generate(Math::random).limit(1).map(n -> (int) (n * 10)).findFirst()
        .get();
    bst.inOrderTraversal();
    System.out.println("min -> " + bst.getMin());
    System.out.println("min -> " + bst.getMax());
    System.out.println("Tree size " + bst.getSize());
    System.out.println(
        "Floor for random element for " + randomFloor + " is " + bst.getFloor(randomFloor));
    System.out
        .println("Ceil for random element for " + randomFloor + " is " + bst.getCeil(randomFloor));
    System.out.println(
        "Nth Item for random element for " + randomFloor + " is " + bst.getNthItem(randomFloor));

  }

  public void insert(T t) {
    root = insert(root, t);
  }

  public void inOrderTraversal() {
    inOrderTraversal(root);
  }

  private Node insert(Node item, T t) {
    if (item == null) {
      return new Node(t, null, null, 1);
    }
    int compare = item.key.compareTo(t);
    if (compare < 0) {
      item.right = insert(item.right, t);
    } else {
      item.left = insert(item.left, t);
    }
    item.size = getSize(item.left) + getSize(item.right) + 1;
    return item;

  }

  private void inOrderTraversal(Node item) {
    if (item == null) {
      return;
    }
    inOrderTraversal(item.left);
    System.out.println(item.key + " ");
    inOrderTraversal(item.right);
  }

  public T getMin() {
    if (root == null) {
      return null;
    }
    return min(root).key;
  }

  private Node min(Node root) {
    while (root.left != null) {
      root = root.left;
    }
    return root;
  }

  public T getMax() {
    if (root == null) {
      return null;
    }
    return max(root).key;
  }

  private Node max(Node root) {
    while (root.right != null) {
      root = root.right;
    }
    return root;
  }

  private class Node {
    private T key = null;
    private Node left = null;
    private Node right = null;
    private Integer size = null;

    public Node(T t, Node left, Node right, Integer size) {
      this.key = t;
      this.left = left;
      this.right = right;
      this.size = size;
    }

  }

  private int getSize(Node n) {
    return n == null ? 0 : n.size;
  }

  public int getSize() {
    return getSize(root);
  }

  public T getFloor(T t) {
    Node res = getFloor(root, t);
    if (res == null) {
      return null;
    }
    return res.key;
  }

  private Node getFloor(Node root, T t) {
    if (root == null) {
      return null;
    }
    int cmp = root.key.compareTo(t);
    if (cmp == 0) {
      return root;
    } else if (cmp > 0) {
      return getFloor(root.left, t);
    } else {
      Node floorFromRight = getFloor(root.right, t);
      if (floorFromRight == null) {
        return root;
      }
      return floorFromRight;
    }
  }

  public T getCeil(T t) {
    Node res = getCeil(root, t);
    if (res == null) {
      return null;
    }
    return res.key;

  }

  private Node getCeil(Node root, T t) {
    if (root == null) {
      return null;
    }
    int cmp = root.key.compareTo(t);
    if (cmp == 0) {
      return root;
    } else if (cmp < 0) {
      return getCeil(root.right, t);
    } else {
      Node floorFromLeft = getCeil(root.left, t);
      if (floorFromLeft == null) {
        return root;
      }
      return floorFromLeft;
    }
  }

  public T getNthItem(int n) {
    Node res = getNthItem(root, n);
    if (res == null) {
      return null;
    }
    return res.key;
  }

  private Node getNthItem(Node root, int n) {
    if (root == null) {
      return null;
    }
    int leftSubTreeSize = getSize(root.left);
    if (leftSubTreeSize == n) {
      return root;
    } else if (n < leftSubTreeSize) {
      return getNthItem(root.left, n);
    } else {
      return getNthItem(root.right, n - (leftSubTreeSize + 1));
    }

  }
}