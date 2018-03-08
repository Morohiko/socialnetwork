package Controller.message;

import Controller.MainController;
import Service.Dialog;

public class SendMessage extends MainController {
    @Override
    protected void doProcess() {
        try{
            String text = "";
            System.out.println("idDiag sendMsg = " + req.getParameter("sendMsg"));
            if (req.getParameter("sendMsg").equals("yes")) {
                System.out.println("idDiag message = " + req.getParameter("message"));
                text = req.getParameter("message");
            }
            if (!text.equals("")){
                Dialog dialog = new Dialog();
                //int idUs = Integer.parseInt(req.getAttribute("idUs").toString());
                //System.out.println("idUs = " + idUs);
                int idUs1 = Model.Data.getInstance().getUser(req.getSession().getId()).getId();
                dialog.sendMessage(req.getSession().getId(), idUs1, text);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
