/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.worlds;

import core.models.worlds.World;

/**
 *
 * @author lcaba
 */
public class SimpleWorld extends World{
    public SimpleWorld(int ID, String name, String question, String answer) {
        super(ID, name, question, answer);
    }
    
    @Override
    public void displayInfo() {
        System.out.println("SimpleWorld ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Question: " + getQuestion());
        System.out.println("Answer: " + getAnswer());
    }
    
    @Override
    public void updateInfo(String name, String question, String answer) {
        setName(name);
        setQuestion(question);
        setAnswer(answer);
    }
    
    public void updateInfo(String question, String answer) {
        setQuestion(question);
        setAnswer(answer);
    }
}
