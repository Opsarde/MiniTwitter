package miniTwitter;

public class UtilityButton implements Utility {

    @Override
    public void accept(Visitor vis) {
        vis.visitButton(this);
    }
    
}
