
package Model.Dosen;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAODosen implements InterfaceDAODosen {
    
    @Override
    public void insert(ModelDosen dosen){
        try{
            //perintah query insert
            String query = "INSERT INTO dosen (nama, nidn) VALUES (?, ?);";
            
            //Memasukkan nama dan nidn dr input user ke dlm query
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            
            //Menjalankan query utk memasukkan data dosen baru
            statement.executeUpdate();
            
            //Menutup koneksi utk menghemat penggunaan memory
            statement.close();
        } catch(SQLException e){
            //pesan eror klo gagal input data
            System.out.println("Input Failed : " + e.getLocalizedMessage());
        }
    }
    
    @Override
    public void update(ModelDosen dosen){
        try{
            //perintah query update
            String query = "UPDATE dosen SET nama=?, nidn=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNidn());
            statement.setInt(3, dosen.getId());
            
            //menjalankan query
            statement.executeUpdate();
            
            //Menutup koneksi utk hemat memori
            statement.close();
        } catch(SQLException e){
            //menampilkan pesan eror klo gagal update data
            System.out.println("Update Failed! (" + e.getMessage() + ")");
        }
    }
    
    @Override
    public void delete(int id){
        try{
            //perintah query delete
            String query = "DELETE FROM dosen WHERE id=?;";
            
            //memasukkan id berdasarkan data yang mau dihapus
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            //menjalankan query
            statement.executeUpdate();
            
            //Menutup koneksi
            statement.close();
        } catch(SQLException e){
            //tampil pesan eror ketika gagal hapus
            System.out.println("Delete Failed : " + e.getLocalizedMessage());
        }
    }
    
    @Override
    public List<ModelDosen> getAll(){
        List<ModelDosen> listDosen = null;
        
        try{
            //var list dgn tipe data list utk menyimpan daftar dosen
            listDosen = new ArrayList<>();
            
            //membuat objek statement yg digunakan utk melakukan query
            Statement statement = Connector.Connect().createStatement();
            
            //var query utk mengambil seluruh data dosen
            String query = "SELECT * FROM dosen;";
            
            //mengeksekusi query dan menyimpannya dlm var "resultSet"
            ResultSet resultSet = statement.executeQuery(query);
            
            //melakukan perulangan supaya bisa mencetak semua data hasil query yg tipe data list
            while(resultSet.next()){
                //membuat objek dosen utk simpan data tiap dosen
                ModelDosen dsn = new ModelDosen();
                
                //memasukkan hasil query ke objek dosen
                dsn.setId(resultSet.getInt("id"));
                dsn.setNama(resultSet.getString("nama"));
                dsn.setNidn(resultSet.getString("nidn"));
                
                //menambahkan dsn ke dlm daftar dosen
                listDosen.add(dsn);
            }
            
            //menutup koneksi 
            statement.close();
        }catch(SQLException e){
            //menampilkan pesan error ketika gagal mengambil data
            System.out.println("Error : " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}
