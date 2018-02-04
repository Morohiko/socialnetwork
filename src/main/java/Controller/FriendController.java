package Controller;

import Model.Data;
import Service.FriendList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FriendController extends HttpServlet {
    private HttpServletRequest req;

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        doProcess();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        doProcess();
    }

    private void doProcess(){
        try {
            if (req.getParameter("do").equals("remove")) {
                removeFriend(req.getSession().getId(), Integer.parseInt(req.getParameter("id")));
            }
        }catch (Exception e){}
    }

    private void removeFriend(String sessionID, int id){
        FriendList friendList = Data.getInstance().getFriendList();
        friendList.removeFriend(sessionID, id);
    }
}
