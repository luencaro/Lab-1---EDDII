/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.models;

import core.models.worlds.ComplexWorld;
import core.models.worlds.SimpleWorld;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author lcaba
 */
public class QuestionBank {
    public static final String[][] SIMPLE_QUESTIONS = {
        {"What is the capital of France?", "Paris"},
        {"What is 2 + 2?", "4"},
        {"Who wrote 'To Kill a Mockingbird'?", "Harper Lee"},
        {"What is the chemical symbol for water?", "H2O"}
    };

    public static final String[][] MULTIPLE_CHOICE_QUESTIONS = {
        {"What is the largest planet in our solar system?", "Jupiter", "Jupiter", "Saturn", "Earth"},
        {"What is the capital of Japan?", "Tokyo", "Beijing", "Tokyo", "Seoul"},
        {"Which element is a noble gas?", "Neon", "Oxygen", "Neon", "Nitrogen"}
    };
    
    private static final String[][] REPLACEMENT_SIMPLE_QUESTIONS = {
        {"What is the largest ocean on Earth?", "Pacific Ocean"},
        {"Which element has the chemical symbol 'Au'?", "Gold"},
        {"Who is known as the Father of Computers?", "Charles Babbage"},
        {"What is the longest river in the world?", "Nile"}
    };

    private static final String[][] REPLACEMENT_MULTIPLE_CHOICE_QUESTIONS = {
        {"Which planet is known as the Red Planet?", "Mars", "Mars", "Venus", "Mercury"},
        {"What is the chemical symbol for Sodium?", "Na", "Na", "K", "Mg"},
        {"Who discovered penicillin?", "Alexander Fleming", "Louis Pasteur", "Alexander Fleming", "Robert Koch"},
        {"What is the capital of Australia?", "Canberra", "Sydney", "Canberra", "Melbourne"}
    };
    
    public static SimpleWorld createSimpleWorld(int id, int index) {
        String[] questionAnswer = SIMPLE_QUESTIONS[index];
        return new SimpleWorld(id, "Simple World " + id, questionAnswer[0], questionAnswer[1]);
    }

    public static ComplexWorld createMultipleChoiceWorld(int id, int index) {
        String[] questionOptions = MULTIPLE_CHOICE_QUESTIONS[index];
        ArrayList<String> options = new ArrayList<>();
        for (int i = 1; i < questionOptions.length - 1; i++) {
            options.add(questionOptions[i]);
        }
        return new ComplexWorld(id, "MultipleChoice World " + id, questionOptions[0], options, questionOptions[questionOptions.length - 1]);
    }
    
    private static Random random = new Random();

    public static SimpleWorld createRandomSimpleWorld(int id) {
        int index = random.nextInt(SIMPLE_QUESTIONS.length);
        String[] questionAnswer = SIMPLE_QUESTIONS[index];
        return new SimpleWorld(id, "Simple World " + id, questionAnswer[0], questionAnswer[1]);
    }

    public static ComplexWorld createRandomMultipleChoiceWorld(int id) {
        int index = random.nextInt(MULTIPLE_CHOICE_QUESTIONS.length);
        String[] questionOptions = MULTIPLE_CHOICE_QUESTIONS[index];
        ArrayList<String> options = new ArrayList<>();
        for (int i = 1; i < questionOptions.length - 1; i++) {
            options.add(questionOptions[i]);
        }
        return new ComplexWorld(id, "MultipleChoice World " + id, questionOptions[0], options, questionOptions[questionOptions.length - 1]);
    }
    
    public static String[] getRandomSimpleQuestion() {
        return SIMPLE_QUESTIONS[random.nextInt(SIMPLE_QUESTIONS.length)];
    }

    public static String[] getRandomMultipleChoiceQuestion() {
        return MULTIPLE_CHOICE_QUESTIONS[random.nextInt(MULTIPLE_CHOICE_QUESTIONS.length)];
    }
    
    // Métodos para obtener preguntas de repuesto
    public static String[] getRandomReplacementSimpleQuestion() {
        return REPLACEMENT_SIMPLE_QUESTIONS[random.nextInt(REPLACEMENT_SIMPLE_QUESTIONS.length)];
    }

    public static String[] getRandomReplacementMultipleChoiceQuestion() {
        return REPLACEMENT_MULTIPLE_CHOICE_QUESTIONS[random.nextInt(REPLACEMENT_MULTIPLE_CHOICE_QUESTIONS.length)];
    }
}
