/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import bstree.BSTree;
import core.models.worlds.*;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lcaba
 */
public class Game {
    private Player player;
    private BSTree tree;

    public Game(Player player) {
        this.player = player;
        this.tree = new BSTree();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BSTree getTree() {
        return tree;
    }

    public void setTree(BSTree tree) {
        this.tree = tree;
    }
    
    public void movePlayer(boolean choice) {
        if(choice) {
            player.setLocation(player.getLocation().right);
        }else {
            player.setLocation(player.getLocation().left);
        }     
    }
    
    public void createTree(int value) {
        Random random = new Random();

        // Crear 7 mundos aleatorios
        World[] worlds = new World[7];
        for (int i = 0; i < worlds.length; i++) {
            if (random.nextBoolean()) {
                // Crear mundos simples aleatorios
                String[] questionAnswer = QuestionBank.getRandomSimpleQuestion(value);
                worlds[i] = new SimpleWorld(i + 1, "Simple World " + (i + 1), questionAnswer[0], questionAnswer[1]);
            } else {
                // Crear mundos con opciones múltiples aleatorios
                String[] questionOptions = QuestionBank.getRandomMultipleChoiceQuestion(value);
                ArrayList<String> options = new ArrayList<>();
                for (int j = 1; j <= questionOptions.length - 1; j++) {
                    options.add(questionOptions[j]);
                }
                worlds[i] = new ComplexWorld(i + 1, "MultipleChoice World " + (i + 1), questionOptions[0], options, questionOptions[1]);
            }
        }
        
        tree.insert(worlds[3]);
        tree.insert(worlds[1]);
        tree.insert(worlds[5]);
        tree.insert(worlds[0]);
        tree.insert(worlds[2]);
        tree.insert(worlds[4]);
        tree.insert(worlds[6]);
        
        player.setLocation(tree.root);
    }
    
    
    public void resetWorld() {
        World world = player.getLocation().data;
        
        if (world instanceof SimpleWorld) {
            String[] newQuestionAnswer = QuestionBank.getRandomReplacementSimpleQuestion();
            ((SimpleWorld) world).updateInfo(newQuestionAnswer[0], newQuestionAnswer[1]);
        } else if (world instanceof ComplexWorld) {
            String[] newQuestionOptions = QuestionBank.getRandomReplacementMultipleChoiceQuestion();
            ArrayList<String> options = new ArrayList<>();
            for (int j = 1; j <= newQuestionOptions.length - 1; j++) {
                options.add(newQuestionOptions[j]);
            }
            ((ComplexWorld) world).updateInfo(newQuestionOptions[0], newQuestionOptions[1]);
            ((ComplexWorld) world).setOptions(options);
        }
    }
    
    public void reset() {
        player.setLocation(tree.root);
    }
}
