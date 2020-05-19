package uvsq;

import static java.lang.String.valueOf;

public class Triangle implements Forme {

    String name;
    String coord;
    int hypothenuse; //On utilise seulement la mesure de l'hypothénuse pour créer un triangle

    public Triangle(String name, String coord, int hypothenuse){

        this.name = name;
        this.coord = coord;
        this.hypothenuse = hypothenuse;

    }

    public void move(String coord){
        this.coord = coord;
    }

    public String show(){

        return name+" Triangle(Centre="+coord+",Hypothenuse="+valueOf(this.hypothenuse)+")";
    }

    public String getCoord() {
        return coord;
    }

    public int getHypothenuse() {
        return hypothenuse;
    }
}

