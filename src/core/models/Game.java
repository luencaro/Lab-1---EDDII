/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import bstree.BSTree;
import core.models.worlds.*;
import java.util.ArrayList;

/**
 *
 * @author lcaba
 */
public class Game {
    private Player player;
    private BSTree tree;

    public Game(Player player, BSTree tree) {
        this.player = player;
        this.tree = tree;
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
    
    public void resetWorld(String answer) {
        World world = player.getLocation().data;
        
        if (world instanceof SimpleWorld) {
            String[] newQuestionAnswer = QuestionBank.getRandomReplacementSimpleQuestion();
            ((SimpleWorld) world).updateInfo(newQuestionAnswer[0], newQuestionAnswer[1]);
        } else if (world instanceof ComplexWorld) {
            String[] newQuestionOptions = QuestionBank.getRandomReplacementMultipleChoiceQuestion();
            ArrayList<String> options = new ArrayList<>();
            for (int j = 1; j < newQuestionOptions.length - 1; j++) {
                options.add(newQuestionOptions[j]);
            }
            ((ComplexWorld) world).updateInfo(newQuestionOptions[0], newQuestionOptions[newQuestionOptions.length - 1]);
            ((ComplexWorld) world).setOptions(options);
        }
    }
    
    public void reset() {
        player.setLocation(tree.root);
    }
}
