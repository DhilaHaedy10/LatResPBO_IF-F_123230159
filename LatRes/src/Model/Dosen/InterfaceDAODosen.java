
package Model.Dosen;

import java.util.List;

public interface InterfaceDAODosen {
    //method utk memasukkan suatu data dosen
    public void insert(ModelDosen dosen);
    
    //method utk update (edit) suatu data dosen
    public void update(ModelDosen dosen);
    
    //method utk hapus suatu data dosen
    public void delete(int id);
    
    //method utk mengambil data dosen
    public List<ModelDosen> getAll();
}
