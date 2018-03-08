package Model;

public class Message {
    public Message(int id, String text, String who, String time) {
        this.text = text;
        this.who = who;
        this.time = time;
    }

    private int id;
    private String text;
    private String who;
    private String time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
