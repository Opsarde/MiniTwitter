package miniTwitter;

import java.util.List;

public abstract class CustomObservable {
    private List<CustomObserver> observers;
    
    public void notifyMessagePanel() {
        for (CustomObserver observer : observers) {
            observer.update();
        }
    }
}
