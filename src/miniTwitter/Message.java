package miniTwitter;

/**
 * 
 * Class: Message
 * Description: A string represents message.
 * 
 * @author shun
 */
public abstract class Message {
    protected String words;
    
    public String toString() {
        return words;
    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    };

}
