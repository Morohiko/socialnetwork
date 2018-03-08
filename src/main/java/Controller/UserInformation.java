package Controller;

import Model.Data;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class UserInformation extends MainController {
    private String sessionID;

    protected void doProcess(){
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
