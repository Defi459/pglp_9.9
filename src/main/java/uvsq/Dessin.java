package uvsq;

import java.util.ArrayList;
import java.util.List;

public class Dessin implements Forme {

    private String name ="default";
    private List<Forme> childforms = new ArrayList<Forme>();


    public Dessin(String name, List<Forme> childforms){
        this.name = name;
        this.childforms = childforms;
    }

    public Dessin(String name){
        this.name = name;
        this.childforms = new ArrayList<>();
    }

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

    public List<Forme> getChildforms() {
        return childforms;
    }

    public void setName(String n){
        this.name = n;
    }

    public String getName() {
        return name;
    }
}
