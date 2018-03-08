package Controller.message;

import Controller.MainController;
import Service.Dialog;

public class ViewMessage extends MainController {
    @Override
    protected void doProcess() {
        try {
            if (req.getParameter("do").equals("open"))
                req.setAttribute("idUs", req.getParameter("id"));
            Dialog dialog = new Dialog();
            int idUser2 = Integer.parseInt(req.getAttribute("idUs").toString());
            System.out.println("idUs1 = " + idUser2);
            dialog.showDialog(req.getSession().getId(), idUser2);
        }catch (Exception e){
            System.out.println("getTdoProcessEx0");
        }
    }
}
