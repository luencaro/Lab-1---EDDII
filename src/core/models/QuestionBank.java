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
    
    public static final String[][] SIMPLE_QUESTIONS_ADDITIONAL_1 = {
        {"What is the square root of 64?", "8"},
        {"Who discovered penicillin?", "Alexander Fleming"},
        {"In which year did World War II end?", "1945"},
        {"What is the smallest prime number?", "2"}
    };

    public static final String[][] SIMPLE_QUESTIONS_ADDITIONAL_2 = {
        {"What is the capital of Canada?", "Ottawa"},
        {"Who was the first president of the United States?", "George Washington"},
        {"How many continents are there?", "7"},
        {"What is the chemical symbol for Oxigen?", "O"}
    };


    public static final String[][] MULTIPLE_CHOICE_QUESTIONS = {
        {"What is the largest planet in our solar system?", "Jupiter", "Mars", "Saturn", "Earth"},
        {"What is the capital of Japan?", "Tokyo", "Beijing", "Kyoto", "Seoul"},
        {"Which element is a noble gas?", "Neon", "Oxygen", "Gold", "Nitrogen"}
    };
    
    public static final String[][] MULTIPLE_CHOICE_QUESTIONS_ADDITIONAL_1 = {
        {"Which is the longest river in the world?", "Nile", "Amazon", "Yangtze", "Mississippi"},
        {"Which country is known as the Land of the Rising Sun?", "Japan", "China", "South Korea", "Thailand"},
        {"Which gas is most abundant in Earth's atmosphere?", "Nitrogen", "Oxygen", "Carbon Dioxide", "Hydrogen"}
    };

    public static final String[][] MULTIPLE_CHOICE_QUESTIONS_ADDITIONAL_2 = {
        {"Which planet is closest to the Sun?", "Mercury", "Venus", "Earth", "Mars"},
        {"Which country won the FIFA World Cup in 2018?", "France", "Brazil", "Germany", "Argentina"},
        {"Which color is on the top of a rainbow?", "Red", "Orange", "Yellow", "Blue"}
    };
 
    private static final String[][] REPLACEMENT_SIMPLE_QUESTIONS = {
        {"What is the largest ocean on Earth?", "Pacific Ocean"},
        {"Which element has the chemical symbol 'Au'?", "Gold"},
        {"Who is known as the Father of Computers?", "Charles Babbage"},
        {"What is the longest river in the world?", "Nile"},
        {"What is the capital of Italy?", "Rome"},
        {"Which planet is closest to the Sun?", "Mercury"},
        {"Who wrote '1984'?", "George Orwell"},
        {"What is the hardest natural substance on Earth?", "Diamond"},
        {"How many bones are in the adult human body?", "206"},
        {"What is the smallest country in the world?", "Vatican City"},
        {"In which year did the Titanic sink?", "1912"},
        {"Which gas do plants absorb from the atmosphere?", "Carbon Dioxide"}
    };


    private static final String[][] REPLACEMENT_MULTIPLE_CHOICE_QUESTIONS = {
        {"Which planet is known as the Red Planet?", "Mars", "Earth", "Venus", "Mercury"},
        {"What is the chemical symbol for Sodium?", "Na", "O", "K", "Mg"},
        {"Who discovered penicillin?", "Alexander Fleming", "Louis Pasteur", "Barack Obama", "Robert Koch"},
        {"What is the capital of Australia?", "Canberra", "Sydney", "New York", "Melbourne"},
        {"Which country has the most population?", "China", "India", "USA", "Russia"},
        {"What is the fastest land animal?", "Cheetah", "Lion", "Horse", "Elephant"},
        {"Which is the largest mammal?", "Blue Whale", "Elephant", "Giraffe", "Shark"},
        {"What is the hardest natural substance on Earth?", "Diamond", "Gold", "Iron", "Platinum"},
        {"Which gas makes up most of Earth's atmosphere?", "Nitrogen", "Oxygen", "Carbon Dioxide", "Hydrogen"},
        {"What is the tallest mountain in the world?", "Mount Everest", "K2", "Kangchenjunga", "Lhotse"},
        {"Who painted the Sistine Chapel ceiling?", "Michelangelo", "Leonardo da Vinci", "Raphael", "Donatello"},
        {"Which element is a noble gas?", "Neon", "Oxygen", "Hydrogen", "Carbon"}
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
    
    public static String[] getRandomSimpleQuestion(int option) {
        
        switch(option) {
            case 1:
                return SIMPLE_QUESTIONS[random.nextInt(SIMPLE_QUESTIONS.length)];
            case 2:
                return SIMPLE_QUESTIONS_ADDITIONAL_1[random.nextInt(SIMPLE_QUESTIONS_ADDITIONAL_1.length)];
            case 3:
                return SIMPLE_QUESTIONS_ADDITIONAL_2[random.nextInt(SIMPLE_QUESTIONS_ADDITIONAL_2.length)];
            default:
                return SIMPLE_QUESTIONS[random.nextInt(SIMPLE_QUESTIONS.length)];
        }
    }

    public static String[] getRandomMultipleChoiceQuestion(int option) {
        switch(option) {
            case 1:
                return MULTIPLE_CHOICE_QUESTIONS[random.nextInt(MULTIPLE_CHOICE_QUESTIONS.length)];
            case 2:
                return MULTIPLE_CHOICE_QUESTIONS_ADDITIONAL_1[random.nextInt(MULTIPLE_CHOICE_QUESTIONS_ADDITIONAL_1.length)];
            case 3:
                return MULTIPLE_CHOICE_QUESTIONS_ADDITIONAL_2[random.nextInt(MULTIPLE_CHOICE_QUESTIONS_ADDITIONAL_2.length)];
            default:
                return MULTIPLE_CHOICE_QUESTIONS[random.nextInt(MULTIPLE_CHOICE_QUESTIONS.length)];
        }
    }
    
    // Métodos para obtener preguntas de repuesto
    public static String[] getRandomReplacementSimpleQuestion() {
        return REPLACEMENT_SIMPLE_QUESTIONS[random.nextInt(REPLACEMENT_SIMPLE_QUESTIONS.length)];
    }

    public static String[] getRandomReplacementMultipleChoiceQuestion() {
        return REPLACEMENT_MULTIPLE_CHOICE_QUESTIONS[random.nextInt(REPLACEMENT_MULTIPLE_CHOICE_QUESTIONS.length)];
    }
}
