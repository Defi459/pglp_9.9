package uvsq;

import static java.lang.String.valueOf;

public class Carre implements Forme {

    private String name;
    private String coord;
    private int cote;

    public Carre(String name,String coord, int cote){

        this.name = name;
        this.coord = coord;
        this.cote = cote;

    }

    public void move(String coord){

        this.coord = coord;

    }

    public String show(){

        return name+" Carre(Centre="+coord+",Cote="+valueOf(cote)+")";
    }

    public String getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public int getCote() {
        return cote;
    }
}
