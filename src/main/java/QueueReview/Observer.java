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
