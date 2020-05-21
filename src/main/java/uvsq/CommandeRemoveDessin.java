package uvsq;

public class CommandeRemoveDessin implements Command{

    private Dessin d;
    private Forme f;
    private DessinDAO dessinDAO = new DessinDAO();
    private CarreDAO carre = new CarreDAO();
    private CercleDAO cercle = new CercleDAO();
    private RectangleDAO rectangle = new RectangleDAO();
    private TriangleDAO triangle = new TriangleDAO();

    public CommandeRemoveDessin(String namedessin, String namef){

        this.d = dessinDAO.find("namedessin");

        if ( d == null){
            this.d = new Dessin("namedessin");
        }

        if (carre.find("namef") != null){
            this.f = carre.find("namef");
        }
        else if (triangle.find("namef") != null){
            this.f = triangle.find("namef");
        }
        else if (cercle.find("namef") != null){
            this.f = cercle.find("namef");
        }
        else if (rectangle.find("namef") != null){
            this.f = rectangle.find("namef");
        }

    }

    @Override
    public void execute() {
        if(this.f != null) {
            this.d.remove(this.f);
        }
        else{
            System.out.println("Form not found");
        }
    }
}
