package Repository;

import java.util.ArrayList;

public interface IRepo {
    public void addObject(Object o);
    public void deleteObject(int id);
    public void updateObject(int id, Object o);
    ArrayList<Object> getAll();
    public boolean existObject(int id);
    public int findObjectId(int id);
    public int count();
}
