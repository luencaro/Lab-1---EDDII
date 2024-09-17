/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import bstree.BSTree;
import core.models.QuestionBank;
import core.models.worlds.ComplexWorld;
import core.models.worlds.SimpleWorld;
import core.models.worlds.World;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lcaba
 */
public class Main {
    
    public static void main(String[] args) {
        
        Random random = new Random();
        
        // Crear 7 mundos aleatorios
        World[] worlds = new World[7];
        for (int i = 0; i < worlds.length; i++) {
            if (random.nextBoolean()) {
                // Crear mundos simples aleatorios
                String[] questionAnswer = QuestionBank.getRandomSimpleQuestion();
                worlds[i] = new SimpleWorld(i + 1, "Simple World " + (i + 1), questionAnswer[0], questionAnswer[1]);
            } else {
                // Crear mundos con opciones múltiples aleatorios
                String[] questionOptions = QuestionBank.getRandomMultipleChoiceQuestion();
                ArrayList<String> options = new ArrayList<>();
                for (int j = 1; j < questionOptions.length - 1; j++) {
                    options.add(questionOptions[j]);
                }
                worlds[i] = new ComplexWorld(i + 1, "MultipleChoice World " + (i + 1), questionOptions[0], options, questionOptions[questionOptions.length - 1]);
            }
        }

        // Mostrar la información de los mundos
        System.out.println("Original Worlds:");
        for (World world : worlds) {
            world.displayInfo();
            System.out.println(); // Línea en blanco para separar la información
        }
        
        System.out.println("=================================================================================");
        
        // Actualizar la información de algunos mundos con datos aleatorios
        for (int i = 0; i < worlds.length; i++) {
            if (worlds[i] instanceof SimpleWorld) {
                String[] randomQuestionAnswer = QuestionBank.getRandomReplacementSimpleQuestion();
                ((SimpleWorld) worlds[i]).updateInfo("Updated Simple World " + (i + 1), randomQuestionAnswer[0], randomQuestionAnswer[1]);
            } else if (worlds[i] instanceof ComplexWorld) {
                String[] randomQuestionOptions = QuestionBank.getRandomReplacementMultipleChoiceQuestion();
                ArrayList<String> options = new ArrayList<>();
                for (int j = 1; j < randomQuestionOptions.length - 1; j++) {
                    options.add(randomQuestionOptions[j]);
                }
                ((ComplexWorld) worlds[i]).updateInfo("Updated MultipleChoice World " + (i + 1), randomQuestionOptions[0], randomQuestionOptions[randomQuestionOptions.length - 1]);
                ((ComplexWorld) worlds[i]).setOptions(options);
            }
        }
        
        System.out.println("=================================================================================");

        // Mostrar la información actualizada de los mundos
        System.out.println("Updated Worlds:");
        for (World world : worlds) {
            world.displayInfo();
            System.out.println(); // Línea en blanco para separar la información
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        BSTree aTree = new BSTree();
        aTree.insert(worlds[3]);
        aTree.insert(worlds[1]);
        aTree.insert(worlds[5]);
        aTree.insert(worlds[0]);
        aTree.insert(worlds[2]);
        aTree.insert(worlds[4]);
        aTree.insert(worlds[6]);
        
        //aTree.TreePrinter();
        //----
            
        System.out.println("=================================================================================");
        
        
        
    }
}