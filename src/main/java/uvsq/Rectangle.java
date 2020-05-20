package uvsq;

import static java.lang.String.valueOf;

public class Rectangle implements Forme {

    private String name;
    private String coord;
    private int largeur;
    private int longueur;

    public Rectangle(String name, String coord, int largeur, int longueur){

        this.name = name;
        this.coord = coord;
        this.largeur = largeur;
        this.longueur = longueur;

    }

    public void move(String coord){

        this.coord = coord;

    }

    public String show(){

        return name+" Rectangle(Centre="+coord+",Largeur="+valueOf(largeur)+",Longueur="+valueOf(longueur)+")";
    }

    public String getCoord() {
        return coord;
    }

    public String getName() {
        return name;
    }

    public int getLargeur() {
        return largeur;
    }

    public int getLongueur(){
        return longueur;
    }
}
