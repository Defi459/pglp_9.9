package uvsq;

public class DAOFactory implements AbstractFactory {

    public DAO<Carre> createCarreDAO(){

        return new CarreDAO();
    }

    public DAO<Cercle> createCercleDAO(){

        return new CercleDAO();
    }

    public DAO<Dessin> createDessinDAO(){

        return new DessinDAO();
    }

    public DAO<Rectangle> createRectangleDAO(){

        return new RectangleDAO();
    }

    public DAO<Triangle> createTriangleDAO(){

        return new TriangleDAO();
    }

}
