package Controller;

import Service.Dialog;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DialogController extends HttpServlet {
    private HttpServletRequest req;
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        doProcess();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.req = req;
        doProcess();
    }

    private void doProcess(){
        try {
            if (req.getParameter("do").equals("open")) {
                Dialog dialog = new Dialog();
                dialog.showDialog(req.getSession().getId(), Integer.parseInt(req.getParameter("id")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
