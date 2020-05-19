package uvsq;

public class Cercle implements Forme {

    private String coord;
    private String name;
    private int rayon;

    public Cercle(String coord, String name, int rayon){
        this.coord = coord;
        this.name = name;
        this.rayon = rayon;
    }

    public String show(){

        return name+" Cercle(Centre="+ coord + ",Rayon=" + rayon+")";
    }

    public void move(String coord){

        this.coord = coord;
    }
}
