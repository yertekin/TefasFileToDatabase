package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author mysqltutorial.org
 */
public class MySqlJdbcUtil {

    public Connection getConnection() throws SQLException {
        Connection conn = null;
        InputStream is;

        try{
            is = getClass().getClassLoader().getResourceAsStream("config.properties");
            // load the properties file
            Properties pros = new Properties();
            pros.load(is);

            // assign db parameters
            String url = pros.getProperty("db.url");
            String user = pros.getProperty("db.user");
            String password = pros.getProperty("db.password");

            // create a connection to the database
            conn = DriverManager.getConnection(url, user, password);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
