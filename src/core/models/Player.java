/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import bstree.Node;

/**
 *
 * @author lcaba
 */
public class Player {
    //Atributes
    private String name;
    private Node location;
    
    //Constructor
    public Player(String name) {
        this.name = name;
        this.location = null;
    }
    
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node getLocation() {
        return location;
    }

    public void setLocation(Node location) {
        this.location = location;
    }
    
    
    
}
