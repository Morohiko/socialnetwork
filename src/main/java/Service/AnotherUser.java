package Service;

import DAO.ProcessDB;
import Model.Data;
import Model.User;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AnotherUser {
    public void createAnotherUser(int id){
        ResultSet resultSet = ProcessDB.getFromUsersByID(id);
        try {
            while (resultSet.next()){
                Data.getInstance().createAnotherPerson(resultSet.getInt("id"),
                        resultSet.getString("login"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
