package Controller;

import Service.Authorization;
import Service.Registration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Validation extends MainController{
    private String sessionID;

    protected void doProcess(){
        sessionID = req.getSession().getId();
        try {
            if (req.getParameter("btnReg").equals("reg")) reg();
            if (req.getParameter("btnReg").equals("signin")) signin();
        }catch (Exception ignored){}
    }

    private void reg() throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(validReg(username, password)) {
            Registration registration = new Registration();
            registration.doRegister(sessionID, username, password);
            resp.sendRedirect("myPage.jsp");
        }else
            resp.sendRedirect("resultRegistration/failedRegistration.jsp");
    }

    private void signin() throws IOException{
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        validReg(username, password);
        Authorization authorization = new Authorization();
        if(authorization.doAuth(sessionID, username, password)){
            resp.sendRedirect("myPage.jsp");
        }else {
            resp.sendRedirect("resultRegistration/failedSignin.jsp");
        }
    }

    private boolean validReg(String username, String password){
        if (username.length() < 5 || password.length() < 5)
            return false;
        return true;
    }
}
