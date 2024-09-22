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
public class Node {
    public World data;
    public Node right;
    public Node left;

    public Node(World world) {
        this.data = world;
        this.left = null;
        this.right = null;
    }
       
}
