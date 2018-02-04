package Service;

import DAO.ProcessDB;
import Model.AnotherUser;
import Model.Data;
import Model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FriendList {
    public void generateFriendList(String sessionID){
        int id = Data.getInstance().getUser(sessionID).getId();
        ResultSet resultSet = ProcessDB.getFromFriends(id);
        int idFriend;
        ArrayList <AnotherUser> listFriend = new ArrayList<Model.AnotherUser>();
        try {
            while (resultSet.next()){
                idFriend = Integer.parseInt(resultSet.getString("id_friend"));
                listFriend.add(new Model.AnotherUser(idFriend, ProcessDB.getUsernameFromUserByID(idFriend)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        filterFriendList(listFriend);
        Data.getInstance().getUser(sessionID).setFriendList(listFriend);
    }

    private void filterFriendList(ArrayList list){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getClass() == User.class) {
                list.remove(i);
                i--;
            }
        }
    }

    public void addFriend(String sessionID, int idFriend){
        ProcessDB.addToFriends(Data.getInstance().getUser(sessionID).getId(), idFriend);
    }

    public void removeFriend(String sessionID, int idFriend){
        ProcessDB.deleteFromFriend(Data.getInstance().getUser(sessionID).getId(), idFriend);
    }

}
