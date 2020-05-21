package uvsq;

public class CommandeCreateRectangle implements Command{

    private Rectangle r;
    private RectangleDAO dao = new RectangleDAO();
    private String name;
    private String coord;
    private int largeur;
    private int longueur;

    public CommandeCreateRectangle(String name, String coord, int largeur, int longueur){
        this.name = name;
        this.coord = coord;
        this.largeur = largeur;
        this.longueur = longueur;
    }

    @Override
    public void execute(){
        this.r = new Rectangle(this.name,this.coord,this.largeur,this.longueur);
        dao.create(r);
    }
}
