package Model;

import java.util.ArrayList;
import java.util.List;

public class AnotherInfo {

    public ArrayList<Object> Objects = new ArrayList<>();

    public ArrayList<Object> getObjects() {
        return Objects;
    }

    public Object getObject(int i) {
        return this.Objects.get(i);
    }

    public void setObjects(ArrayList<Object> Objects) {
        this.Objects = Objects;
    }

    public void setObject(Object Obj) {
        Objects.add(Obj);
    }

}
