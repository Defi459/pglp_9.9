package uvsq;

public class CommandeCreateTriangle implements Command{

    private Triangle t;
    private TriangleDAO dao = new TriangleDAO();
    private String name;
    private String coord;
    private int hypothenuse;

    public CommandeCreateTriangle(String name, String coord, int hypothenuse){
        this.name = name;
        this.coord = coord;
        this.hypothenuse = hypothenuse;
    }

    @Override
    public void execute(){
        this.t = new Triangle(this.name,this.coord,this.hypothenuse);
        dao.create(t);
    }
}
