package subjectobserver;

public interface Subject {

    void registerObserver(Observer observer);
    
    void unregisterObserver(Observer observer);
    
    void notifyObserver();
    
}
