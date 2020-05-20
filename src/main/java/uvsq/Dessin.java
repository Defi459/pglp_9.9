package uvsq;

import java.util.ArrayList;
import java.util.List;

public class Dessin implements Forme {

    private List<Forme> childforms = new ArrayList<Forme>();

    @Override
    public void move(String coord){
        for (Forme forme : childforms){
            forme.move(coord);
        }
    }

    @Override
    public String show(){

        String s;
        s="";

        for (Forme forme : childforms){
            s=s+forme.show()+System.lineSeparator();
        }

        return s;
    }

    public void add(Forme f){
        childforms.add(f);
    }

    public void remove(Forme f){
        childforms.remove(f);
    }

}
