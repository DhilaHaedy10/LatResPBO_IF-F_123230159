
package Model.Dosen;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTable extends AbstractTableModel{
    //utk menyimpan daftar dosen
    List<ModelDosen> daftarDosen;
    
    //nama kolom tabel disimpan dlm var namaKolom dg tipe data Array String
    String kolom[] = {"ID", "Nama", "NIDN"};
    
    //krn daftarDosen tipe data Array list, maka hra diubah ke Array objek biar bisa masuk table
    public ModelTable(List<ModelDosen> daftarDosen){
        this.daftarDosen = daftarDosen;
    }
    
    //method utk ambil jml baris dr table
    @Override
    public int getRowCount(){
        return daftarDosen.size();
    }
    
    //method utk ambil jml kolom dlm tabel
    @Override
    public int getColumnCount(){
        return kolom.length;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex){
        switch(columnIndex){
            case 0:
                return daftarDosen.get(rowIndex).getId();
            case 1:
                return daftarDosen.get(rowIndex).getNama();
            case 2:
                return daftarDosen.get(rowIndex).getNidn();
            default:
                return null;    
        }
    }
    
    @Override
    public String getColumnName(int columnIndex){
        return kolom[columnIndex];
    }
}
