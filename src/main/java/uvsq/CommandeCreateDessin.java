package uvsq;

public class CommandeCreateDessin implements Command{

    private Dessin d;
    private DessinDAO dao = new DessinDAO();
    private String name;

    public CommandeCreateDessin(String name){
        this.name = name;
    }

    @Override
    public void execute(){
        this.d = new Dessin(this.name);
        this.dao.create(d);
    }
}
