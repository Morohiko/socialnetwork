package Service;

import DAO.ProcessDB;
import Model.Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Authorization {

    public boolean doAuth(String sessionid, String username, String password){
        int id = searchForLogin(username);
        if (password.equals(pass)){
            Data.getInstance().createPerson(sessionid, id, username, password);
            return true;
        }
        return false;
    }

    private String pass;

    private ResultSet resultSet = null;
    private int searchForLogin(String login){
        resultSet = ProcessDB.getFromUsers();
        String log;
        try {
            while (resultSet.next()){
                log = resultSet.getString("login");
                if (log.equals(login)) {
                    pass = resultSet.getString("password");
                    return resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
