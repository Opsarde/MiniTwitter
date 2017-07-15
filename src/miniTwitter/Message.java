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
    
    public boolean contains(String... goodWords) {
        String temp = words.toLowerCase();
        for (String s  : goodWords) {
            if (temp.contains(s.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
