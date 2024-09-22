/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models.worlds;

/**
 *
 * @author lcaba
 */
public abstract class World {
    protected int ID;
    protected String name;
    protected String question;
    protected String answer;

    public World(int ID, String name, String question, String answer) {
        this.ID = ID;
        this.name = name;
        this.question = question;
        this.answer = answer;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    // Método abstracto para ser implementado por las clases hijas
    public abstract void displayInfo();
    
    // Método abstracto para actualizar la información, excluyendo ID
    public abstract void updateInfo(String name, String question, String answer);
        
}
