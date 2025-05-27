
package Model;
import java.sql.*;

public class Connector {
    //menghubungkan ke database yg namanya upnvybaru
    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String namaDB = "upnvybaru";
    private static String urlDB = "jdbc:mysql://localhost:3306/" + namaDB;
    private static String usernameDB = "root";
    private static String passwordDB = "";
    
    static Connection conn;
    
    public static Connection Connect(){
        try{
            //1. Register driver yang akan dipakai
            Class.forName(jdbc_driver);
            
            //2. Koneksi ke db
            conn = DriverManager.getConnection(urlDB, usernameDB, passwordDB);
            
            //3. Menampilkan pesan "Connection Success" jika berhasil terhubung ke db
            System.out.println("MySQL Connected");
        }catch(ClassNotFoundException | SQLException exception){
            //menampilkan pesan error jika gagal terhubung
            System.out.println("Connection Failed : " + exception.getLocalizedMessage());
        }
        return conn;
    }
}
