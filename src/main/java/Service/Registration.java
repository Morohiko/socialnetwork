package Service;

import DAO.ProcessDB;
import Model.Data;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Registration {
    public void doRegister(String sessionid, String username, String password){
        ProcessDB.addToUser(searchFreeID(), username, password);
        int id = searchFreeID();
        Data.getInstance().createPerson(sessionid, id, username, password);
    }

    private int searchFreeID(){
        int id = 1;
        ResultSet resultSet = ProcessDB.getFromUsers();
        try {
            while(resultSet.next())
            id = resultSet.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        id++;
        return id;
    }
}


