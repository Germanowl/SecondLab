package Model;

import java.util.ArrayList;

public class Object {

    private ArrayList<WorkObj> Struct = new ArrayList<WorkObj>();

    public Object(){}

    public Object(int amount){
        for (int i = 0; i < amount; i++) {
            this.Struct.add(null);
        }
    }

    public void add(WorkObj Inside){
        this.Struct.add(Inside);
    }

    public void add(int Num, WorkObj Inside){
        this.Struct.add(Num, Inside);
    }

    public int size() { return this.Struct.size();}

    public WorkObj get(int Number){return this.Struct.get(Number); }

    public void clear(){this.Struct.clear();}
}
