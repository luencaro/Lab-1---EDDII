/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.worlds;

import core.models.worlds.World;
import java.util.ArrayList;

/**
 *
 * @author lcaba
 */
public class ComplexWorld extends World{
    private ArrayList<String> options;

    public ComplexWorld(int ID, String name, String question, ArrayList<String> options, String answer) {
        super(ID, name, question, answer);
        this.options = options;
    }

    public ArrayList<String> getOptions() { 
        return options;
    }

    public void setOptions(ArrayList<String> options) { 
        this.options = new ArrayList<>(options); // Copia la lista para evitar cambios externos
    }

    @Override
    public void displayInfo() {
        System.out.println("MultipleChoiceWorld ID: " + getID());
        System.out.println("Name: " + getName());
        System.out.println("Question: " + getQuestion());
        System.out.println("Options: " + options);
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
