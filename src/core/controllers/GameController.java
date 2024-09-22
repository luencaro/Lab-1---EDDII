/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.controllers;

import core.controllers.utils.Response;
import core.controllers.utils.Status;
import core.models.Game;

/**
 *
 * @author lcaba
 */
public class GameController {
    
    public static Response createTree(Game game, int option) {
        try {
            game.createTree(option);
            return new Response("Tree made successfully", Status.OK);
        }catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response movePlayer(Game game, boolean choice) {
        try {
            //We verify that the fields are not empty
//            if (choice == null) {
//                return new Response("answer field is empty", Status.BAD_REQUEST);
//            }
            game.movePlayer(choice);
            return new Response("Player moved successfully", Status.OK);
        } catch (Exception ex){
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response makeRestart(Game game) {
        try {
            game.reset();
            return new Response("Game has been restarted", Status.OK);
        }catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response makeUpdate(Game game, String answer) {
        try {
            //We verify that the fields are not empty
            if (answer.equals("") || answer == null) {
                return new Response("Answer field is empty", Status.BAD_REQUEST);
            }
            
            if(answer.equals(game.getPlayer().getLocation().data.getAnswer())) {
                return new Response("The answer is correct", Status.OK);
            }
            
            game.resetWorld();
            return new Response("The answer is wrong", Status.BAD_REQUEST);
        } catch (Exception ex){
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    public static Response makeUpdate(Game game, boolean[] array, String[] answer) {
        try {
            if(isOnlyOneTrue(array) == -1) {
                return new Response("Select only one answer", Status.BAD_REQUEST);
            }
            
            if(answer[isOnlyOneTrue(array)].equals(game.getPlayer().getLocation().data.getAnswer())) {
                return new Response("The answer is correct", Status.OK);
            }
            
            game.resetWorld();
            return new Response("The answer is wrong", Status.BAD_REQUEST);           
        } catch (Exception ex) {
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
    
    private static int isOnlyOneTrue (boolean[] array) {
        int count = 0; // Contador de elementos 'true'
        int position = -1; // Variable para almacenar la posición del true
        for (int i = 0; i < array.length; i++) {
            if (array[i]) {
                count++;
                position = i; // Almacena la posición del true
            }
            if (count > 1) {
                return -1; // Si hay más de un true, retornamos -1
            }
        }
        return (count == 1) ? position : -1; // Si hay un único true, retorna la posición, si no, -1 
    }
}
