package uvsq;

public class CommandeCreateCercle implements Command {

    private Cercle c;
    private CercleDAO dao = new CercleDAO();
    private String name;
    private String coord;
    private int rayon;

    public CommandeCreateCercle(String name, String coord, int rayon){
        this.name = name;
        this.coord = coord;
        this.rayon = rayon;
    }

    @Override
    public void execute(){
        this.c = new Cercle(this.name,this.coord,this.rayon);
        dao.create(c);
    }
}
