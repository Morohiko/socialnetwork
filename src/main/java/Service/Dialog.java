package Service;

import DAO.ProcessDB;
import Model.Data;
import Model.Message;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dialog {
    public void showDialog(String sessionId, int idUser2){
        int idUser1 = Data.getInstance().getUser(sessionId).getId();
        int idDiag = getIdDialog(idUser1, idUser2);
        if (idDiag == 0) createNewDiag(idUser1, idUser2, searchFreeIDDiag());
        Data.getInstance().getUser(sessionId).setMessages(generateMsgsLisr(idDiag));
    }

    public void sendMessage(String sessionId, int idUser2, String text){
        int idUser1 = Data.getInstance().getUser(sessionId).getId();
        int idDiag = getIdDialog(idUser1, idUser2);
        if (idDiag == 0) {
            idDiag = searchFreeIDDiag();
            createNewDiag(idUser1, idUser2, idDiag);
        }
        System.out.println("idDiag = " + idDiag + " text = " + text);

        ProcessDB.addToDiag(Integer.toString(idDiag), text, Utils.getDataTime(),
                Data.getInstance().getUser(sessionId).getUsername());
    }

    private ArrayList<Message> generateMsgsLisr(int idDiag){
        ResultSet rs = ProcessDB.getFromDialogs(idDiag);
        ArrayList<Message> list = new ArrayList<Message>();
        list.add(new Message(0, "0", "0", "0"));
        try {
            while (rs.next()){
                Message message = new Message(idDiag, rs.getString("text"),
                        rs.getString("who"), rs.getString("datatime"));
                list.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void createNewDiag(int user1, int user2, int freeID){
        ProcessDB.addToDialogList(user1, user2, freeID);
        ProcessDB.createTableDialog(freeID);
    }

    private int searchFreeIDDiag(){
        ResultSet rs = ProcessDB.getFromDiagList();
        ArrayList<Integer> list = new ArrayList<Integer>();
        try {
            while(rs.next()){
                list.add(Integer.parseInt(rs.getString("idDiag")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        int num = 1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).intValue() == num) {
                num++;
                continue;
            }
            return num;
        }
        return num;
    }

    private int getIdDialog(int idUser1, int idUser2){
        ResultSet rs = ProcessDB.getFromDiagList();
        System.out.println("while 12");
        try{
            while(rs.next()){
                int id1 = Integer.parseInt(rs.getString("user1"));
                int id2 = Integer.parseInt(rs.getString("user2"));
                if((id1==idUser1&&id2==idUser2)||(id1==idUser2&&id2==idUser1)){
                    return Integer.parseInt(rs.getString("idDiag"));
                }
            }
        }catch(Exception e) {e.printStackTrace();}
        return 0;
    }
}
