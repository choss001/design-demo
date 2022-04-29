package com.example.demo.persistentDataStructure.tree;

public class Tree {
  private String key;
  private int val;
  private Tree left, right;

  public Tree(String k, int v, Tree l, Tree r) {
    key = k;
    val = v;
    left = l;
    right = r;
  }

  class TreeProcessor{
//    public static int lookup(String k, int defaultval, Tree tree) {
    public int lookup(String k, int defaultval, Tree tree) {
      if ( tree == null) return defaultval;
      if (k.equals(tree.key)) return tree.val;
      return lookup(k, defaultval, k.compareTo(tree.key) < 0 ? tree.left : tree.right);
    }
  }
}
