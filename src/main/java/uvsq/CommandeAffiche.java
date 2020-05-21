package uvsq;

public class CommandeAffiche implements Command {

    private Forme f;
    private CarreDAO carre = new CarreDAO();
    private CercleDAO cercle = new CercleDAO();
    private RectangleDAO rectangle = new RectangleDAO();
    private TriangleDAO triangle = new TriangleDAO();

    public CommandeAffiche(String name){

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
    }


    @Override
    public void execute() {
        if(this.f != null) {
            this.f.show();
        }
        else{
            System.out.println("Form not found");
        }
    }
}
