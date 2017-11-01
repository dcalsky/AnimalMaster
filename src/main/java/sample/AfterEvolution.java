package sample;

/*
 * Animals after evolution
 */
public class AfterEvolution {
    private String newType;

    public AfterEvolution(String m) {
        newType = m;
    }

    public void introduce() {
        System.out.println("Now I have evolved into a " + newType);
        System.out.println("Behave like a " + newType);
    }

    public void intelligence() {
        System.out.println("And I can jump like people now!");
    }
}
