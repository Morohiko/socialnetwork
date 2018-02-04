package Model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private int id;

    private List<AnotherUser> friendList = new ArrayList<AnotherUser>();

    public void setFriendList(ArrayList<AnotherUser> list){
        friendList = list;
    }

    public void addToFriendList(ArrayList<AnotherUser> list){
        friendList.addAll(list);
    }

    public List<AnotherUser> getFriendList(){
        return friendList;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(int id, String username) {
        this.username = username;
        this.id = id;
    }
}
