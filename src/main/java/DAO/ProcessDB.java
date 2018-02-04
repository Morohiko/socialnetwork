package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProcessDB {
    public static void addToUser(int id, String login, String pass){
        try {
            MetaData.getInstance().getStatement().executeUpdate("INSERT INTO socnetdb.users(id, login, password) " +
                    "VALUES ("+id+", '"+login+"', '"+pass+"');");
            MetaData.getInstance().closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addToFriends(int idUser, int idFriend){
        try{
            MetaData.getInstance().getStatement().executeUpdate("INSERT INTO socnetdb.friends(id_user, id_friend) " +
            "VALUES ("+idUser+", "+idFriend+");");
            MetaData.getInstance().closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void addToDialogList(int user1, int user2, int idDiag){
        try{
            MetaData.getInstance().getStatement().executeUpdate("INSERT INTO socnetdb.dialoglist(user1, user2, idDiag) " +
                    "VALUES ("+user1+", "+user2+", "+idDiag+");");
            MetaData.getInstance().closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }



    public static ResultSet getFromUsers(){
        try {
            ResultSet rs = MetaData.getInstance().getStatement().executeQuery("SELECT * FROM socnetdb.users;");
            MetaData.getInstance().closeConn();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUsernameFromUserByID(int id){
        ResultSet resultSet;
        String username = "lala";
        try {
            resultSet = MetaData.getInstance().getStatement().executeQuery("SELECT * FROM socnetdb.users WHERE id=" + id + ";");
            while(resultSet.next()){
                username = resultSet.getString("login");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        MetaData.getInstance().closeConn();
        return username;
    }

    public static ResultSet getFromUsersByID(int id){
        try {
            ResultSet rs =  MetaData.getInstance().getStatement().executeQuery("SELECT * FROM socnetdb.users WHERE id=" + id + ";");
            MetaData.getInstance().closeConn();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ResultSet getFromFriends(int id){
        try {
            ResultSet rs = MetaData.getInstance().getStatement().executeQuery("SELECT * FROM " +
                    "socnetdb.friends WHERE id_user=" + id + ";");
            MetaData.getInstance().closeConn();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteFromFriend(int idUser, int idFriend){
        try{
            MetaData.getInstance().getStatement().executeUpdate("DELETE QUICK FROM socnetdb.friends WHERE id_user="+idUser+" " +
                    "AND id_friend = "+idFriend+";");
            MetaData.getInstance().closeConn();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void createTableDialog(int idDialog){
        try {
            System.out.println("idDiag = " + idDialog);
            MetaData.getInstance().getStatement().executeUpdate("CREATE TABLE dialogs.diag" + idDialog +
                    "(" +
                    "text VARCHAR(512) NOT NULL, " +
                    "datatime VARCHAR(16) NOT NULL, " +
                    "who VARCHAR(128) NOT NULL " +
                    ")");
            MetaData.getInstance().closeConn();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getFromDiagList(){
        try {
            ResultSet rs = MetaData.getInstance().getStatement().executeQuery("SELECT * FROM " +
                    "socnetdb.dialogList;");
            MetaData.getInstance().closeConn();
            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static ResultSet getFromDiagList(int idUser1, int idUser2){
        System.out.println("while 0 idUser1 = " + idUser1 + " idUser2 = " + idUser2);
        try {
            ResultSet rs = MetaData.getInstance().getStatement().executeQuery("SELECT * FROM " +
                    "socnetdb.dialoglist WHERE user1=" + idUser1 + " AND user2=" + idUser2 + ";");
            MetaData.getInstance().closeConn();
            return rs;
        } catch (SQLException e) {e.printStackTrace();}
        System.out.println("while 1");
        try {
            ResultSet rs = MetaData.getInstance().getStatement().executeQuery("SELECT * FROM " +
                    "socnetdb.dialoglist WHERE user2=" + idUser1 + " AND user1=" + idUser2 + ";");
            MetaData.getInstance().closeConn();
            return rs;
        } catch (SQLException e) {e.printStackTrace();}
        System.out.println("while2");
        return null;
    }

}
