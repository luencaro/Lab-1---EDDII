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
    
    public static Response makeUpdate(Game game, String answer) {
        try {
            //We verify that the fields are not empty
            if (answer.equals("") || answer == null) {
                return new Response("answer field is empty", Status.BAD_REQUEST);
            }
            game.resetWorld(answer);
            return new Response("Update made successfully", Status.OK);
        } catch (Exception ex){
            return new Response("Unexpected error", Status.INTERNAL_SERVER_ERROR);
        }
    }
}
