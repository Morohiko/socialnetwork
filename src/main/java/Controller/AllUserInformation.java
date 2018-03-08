package Controller;

import Service.AllUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllUserInformation extends MainController{
    public void getList(){
        AllUser allUser = new AllUser();
        try {
            if (req.getParameter("searchBtn").equals("searchUsername")) {
                allUser.getUsers(req.getSession().getId(), req.getParameter("searchUsername"));
                return;
            }
        }catch (Exception e){}
        allUser.getAllUser(req.getSession().getId());
    }
}
