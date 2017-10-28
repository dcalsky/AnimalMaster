/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QueueReview;

/**
 *
 * @author 18359
 */
public interface Observer {
    public abstract void updateReadyAction(String actionName);
    public abstract void updateMoveAction(String actionName);
    public abstract void updateEndAction(String actionName);
}
