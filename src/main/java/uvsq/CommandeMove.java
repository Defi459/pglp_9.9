package uvsq;

public class CommandeMove implements Command{

    private CarreDAO carre = new CarreDAO();
    private CercleDAO cercle = new CercleDAO();
    private RectangleDAO rectangle = new RectangleDAO();
    private TriangleDAO triangle = new TriangleDAO();

    private Forme f;
    private String coord;

    public CommandeMove(String name, String coord){

        if (carre.find("namef") != null){
            this.f = carre.find("namef");
        }
        else if (triangle.find("namef") != null){
            this.f = triangle.find("namef");
        }
        else if (cercle.find("namef") != null){
            this.f = cercle.find("namef");
        }
        else if (rectangle.find("namef") != null) {
            this.f = rectangle.find("namef");
        }

        this.coord = coord;
    }

    @Override
    public void execute(){
        this.f.move(this.coord);
    }
}
