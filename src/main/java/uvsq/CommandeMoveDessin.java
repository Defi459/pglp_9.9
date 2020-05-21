package uvsq;

public class CommandeMoveDessin implements Command{

    private DessinDAO dao;
    private Dessin d;
    private String coord;

    public CommandeMoveDessin(String name, String coord){

        this.d = this.dao.find("name");

        if (this.d == null){
            this.d = new Dessin(name);
        }

        this.coord = coord;
    }

    @Override
    public void execute() {
        this.d.move(this.coord);
    }
}
