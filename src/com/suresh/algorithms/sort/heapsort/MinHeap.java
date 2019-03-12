package com.suresh.algorithms.sort.heapsort;

public class MinHeap {

  private int heapSize;
  private int currentSize;
  private int[] items;

  public MinHeap(int heapSize) {
    this.heapSize = heapSize + 1;
    this.items = new int[heapSize + 1];
    this.currentSize = 0;
  }

  private void swim(int i) {
    while ((i / 2 > 0) && items[i / 2] > items[i]) {
      swap(i, i / 2);
      i /= 2;
    }
  }

  private void sink(int i) {
    while (i * 2 < currentSize) {
      int j = i * 2;
      int max = j;
      if (j + 1 <= currentSize && items[j + 1] < items[j]) {
        max = j + 1;
      }
      if (items[i] > items[max]) {
        swap(i, max);
        i = max;
      } else {
        break;
      }

    }
  }

  private void swap(int i, int j) {
    int temp = items[i];
    items[i] = items[j];
    items[j] = temp;
  }

  public void insert(int item) {
    if (currentSize + 1 > this.heapSize) {
      throw new ArrayIndexOutOfBoundsException("current size");
    }
    items[++currentSize] = item;
    swim(currentSize);
  }

  public int delMin() {
    if (isEmpty()) {
      throw new ArrayIndexOutOfBoundsException("current size");
    }
    swap(currentSize, 1);
    int item = items[currentSize--];
    sink(1);
    return item;
  }

  public boolean isEmpty() {
    return currentSize == 0;
  }

  public static void main(String[] args) {
    MinHeap minHeap = new MinHeap(10);
    minHeap.insert(6);
    minHeap.insert(7);
    minHeap.insert(8);
    minHeap.insert(9);
    minHeap.insert(10);
    //minHeap.insert();

    while (!minHeap.isEmpty()) {
      System.out.println(minHeap.delMin());
    }

  }

}
