package Controller;

import Service.AnotherUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AnotherPage extends MainController {
    public void createAnotherPage(){
        int id;
        try{
            id = Integer.parseInt(req.getParameter("id"));
        }catch (Exception e){return;}
        AnotherUser anotherUser = new AnotherUser();
        anotherUser.createAnotherUser(id);
    }
}
