package DAO;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

class MetaData {
    private Connection connection = null;
    private Statement statement = null;

    Statement getStatement() {
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statement;
    }

    private MetaData(){
        try {
            meta();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static MetaData instance = null;
    static MetaData getInstance(){
        try {
            while(instance == null || instance.connection.isClosed() || instance.connection == null){
                instance = new MetaData();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return instance;
    }

    void closeConn(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void meta() throws SQLException {
        try {
            InitialContext ic = new InitialContext();
            DataSource dataSource  = (DataSource) ic.lookup("jdbc/users");
            connection = dataSource.getConnection();
            ic.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
