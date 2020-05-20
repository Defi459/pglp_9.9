package uvsq;

public interface AbstractFactory {

    DAO<Carre> createCarreDAO();
    DAO<Cercle> createCercleDAO();
    DAO<Dessin> createDessinDAO();
    DAO<Triangle> createTriangleDAO();
    DAO<Rectangle> createRectangleDAO();

}
