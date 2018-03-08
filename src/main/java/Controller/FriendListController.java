package Controller;

import Model.AnotherUser;
import Model.Data;
import Service.FriendList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class FriendListController extends MainController{
    private String sessionID;

    protected void doProcess(){
        sessionID = req.getSession().getId();
        try {
            if(req.getParameter("do").equals("add")){//
                addToFriend(Integer.parseInt(req.getParameter("id")));
            }
        }catch (Exception e){}
    }

    public List<AnotherUser> getFriendList(){
        Service.FriendList friendList = new FriendList();
        friendList.generateFriendList(req.getSession().getId());
        return Data.getInstance().getUser(req.getSession().getId()).getFriendList();
    }

    private void addToFriend(int idFriend){
        FriendList friendList = Data.getInstance().getFriendList();
        friendList.addFriend(sessionID, idFriend);
    }
}
