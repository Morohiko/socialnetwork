package Service;

import DAO.ProcessDB;
import Model.AnotherUser;
import Model.Data;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AllUser {

    public void getUsers(String thisUserID, String username) {
        List<User> list;
        getAllUser(thisUserID);
        list = Data.getInstance().getUserList();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getUsername().equals(username)) {
                list.remove(i);
                i--;
            }
        }
        Data.getInstance().setUserList(list);
    }

    public void getAllUser(String thisUserID){
        List<User> list = new ArrayList<User>();
        ResultSet resultSet = ProcessDB.getFromUsers();
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                if (isFriend(id, thisUserID, login)) continue;
                User user = new User(id, login);
                list.add(user);
            }
            Data.getInstance().setUserList(list);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private List <Model.AnotherUser>friendList = null;
    private boolean isFriend(int id, String thisUserID, String login){
        if (id == Data.getInstance().getUser(thisUserID).getId()) return true;
        if (friendList == null) {
            try {
                Data.getInstance().getUser(thisUserID).getFriendList();
            } catch (Exception e) {
                FriendList friendList1 = new FriendList();
                friendList1.generateFriendList(thisUserID);
            }
            friendList = Data.getInstance().getUser(thisUserID).getFriendList();
        }
        for (AnotherUser aFriendList : friendList)
            if (aFriendList.getUsername().equals(login)) return true;
        return false;
    }


}
