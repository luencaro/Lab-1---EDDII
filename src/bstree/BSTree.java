/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bstree;

import core.models.worlds.World;

/**
 *
 * @author lcaba
 */
public class BSTree {
    public Node root;

    public BSTree() {
        this.root = null;
    }
    
    //funcion para insertar un node
    public void insert(World world) {
        root = insertRe(root, world);
    }
    
    //Funcion recursiva para insertar un node
    public Node insertRe(Node root, World world) {
        if (root == null) {
            root = new Node(world);
            return root;
        }

        if (world.getID() < root.data.getID()) {
            root.left = insertRe(root.left, world);
        } else if (world.getID() > root.data.getID()) {
            root.right = insertRe(root.right, world);
        }

        return root;
    }
    
    //Funcion para buscar un node
    public boolean search(World world) {
        return searchRe(root, world);
    }
    
    //Funcion recursiva para buscar un node
    public boolean searchRe(Node root, World world) {
        if (root == null) {
            return false;
        }
        if (world.getID() == root.data.getID()) {
            return true;
        }

        if (world.getID() > root.data.getID()) {
            return searchRe(root.right, world);
        }

        return searchRe(root.left, world);
    }
    
    public void update(World old, World New) {
        delete(old);
        insert(New);
    }
    
    //Funcion para eleiminar un node
    public void delete(World world) {
        root = deleteRe(root, world);
    }
    
    //Funcion recursiva para eliminar un node
    public Node deleteRe(Node root, World world) {
        if (root == null) {
            return null;
        }

        if (world.getID() < root.data.getID()) {
            root.left = deleteRe(root.left, world);
        } else if (world.getID() > root.data.getID()) {
            root.right = deleteRe(root.right, world);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            Node temp = minimum(root.right);
            root.data = temp.data;
            root.right= deleteRe(root.right, temp.data);
        }

        return root;
    }
    
    //Funcion para encontrar el valor minimo en un node
    public Node minimum(Node root) {
        Node actual = root;
        while (actual.left != null) {
            actual = actual.left;
        }
        return actual;
    }
    
    public int alturaArbol(Node node) {
        if (node == null) {
            return 0;
        }
        int alturaIzquierda = alturaArbol(node.left);
        int alturaDerecha = alturaArbol(node.right);
        return Math.max(alturaIzquierda, alturaDerecha) + 1;
    }
    
    public static int getcol(int h) {
        if (h == 1) {
            return 1;
        }
        return getcol(h - 1) + getcol(h - 1) + 1;
    }
    
    public static void printTree(int[][] M, Node root, int col, int row, int height) {
        if (root == null) {
            return;
        }
        M[row][col] = root.data.getID();
        printTree(M, root.left, col - (int) Math.pow(2, height - 2), row + 1, height - 1);
        printTree(M, root.right, col + (int) Math.pow(2, height - 2), row + 1, height - 1);
    }
    
    public void TreePrinter() {
        int h = alturaArbol(this.root);
        int col = getcol(h);
        int[][] M = new int[h][col];
        printTree(M, this.root, col / 2, 0, h);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < col; j++) {
                if (M[i][j] == 0) {
                    System.out.print("  ");
                } else {
                    System.out.print(M[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
