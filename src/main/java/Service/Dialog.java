package Service;

import DAO.ProcessDB;
import Model.Data;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Dialog {
//    private ResultSet rs;
    public void showDialog(String sessionId, int idUser2){
        System.out.println("while new dialog");
        int idUser1 = Data.getInstance().getUser(sessionId).getId();
        System.out.println("while 1");
        int id = getIdDialog(idUser1, idUser2);
        System.out.println("while 2");
        if (id == 0) createNewDiag(idUser1, idUser2, searchFreeIDDiag());
        System.out.println("while zayebok");
    }

    private void createNewDiag(int user1, int user2, int freeID){
        System.out.println("whileCreateNewDiag freeid = " + freeID);

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
        System.out.println("while listsize = " + list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println("while:  listid = " + list.get(i).intValue() + " num = " + num);
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
        }catch(Exception e) {e.printStackTrace();};
        return 0;
    }
}
