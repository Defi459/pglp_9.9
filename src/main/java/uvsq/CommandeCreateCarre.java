package uvsq;

public class CommandeCreateCarre implements Command{

    private Carre c;
    private CarreDAO dao = new CarreDAO();
    private String name;
    private String coord;
    private int cote;

    public CommandeCreateCarre(String name, String coord, int cote){
        this.name = name;
        this.coord = coord;
        this.cote = cote;
    }

    @Override
    public void execute(){
        this.c = new Carre(this.name,this.coord,this.cote);
        dao.create(c);
    }
}
