package Model;

import Service.FriendList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Data {
    private static Data instance;
    public static Data getInstance(){
        if (instance == null)
            instance = new Data();
        return instance;
    }
    private Map<String, User> userMap = new HashMap<String, User>();

    private AnotherUser anotherUser;
    private List<User> userList;
    private FriendList friendList = new FriendList();

    public FriendList getFriendList() {
        return friendList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void createPerson(String sessionID, int id, String username, String password){
        userMap.put(sessionID, new User(id, username, password));
    }

    public User getUser(String sessionID){
        User user = null;
        try {
            user = userMap.get(sessionID);
        }catch (Exception ex){
        }
        if (user != null)
            return user;
        throw new NullPointerException();
    }

    public void createAnotherPerson(int id, String username){
        anotherUser = new AnotherUser(id, username);
    }

    public AnotherUser getAnotherUser() {
        if(anotherUser!=null) {
            return anotherUser;
        }
        throw new NullPointerException();
    }

    public void removeUser(String sessionID){
        userMap.remove(sessionID);
    }

}