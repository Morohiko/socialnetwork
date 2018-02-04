package Controller;

import Model.Data;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class UserInformation extends HttpServlet {
    private HttpServletRequest req;
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        req = request;
        doProcess();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        req = request;
        doProcess();
    }
    private String sessionID;

    private void doProcess(){
            sessionID = req.getSession().getId();
    }

    public String getUserId(){
        return Integer.toString(Data.getInstance().getUser(sessionID).getId());
    }

    public String getUserName(){
        return Data.getInstance().getUser(sessionID).getUsername();
    }

    public String getUserPassword(){
        return Data.getInstance().getUser(sessionID).getPassword();
    }
}
