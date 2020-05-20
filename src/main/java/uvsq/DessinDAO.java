package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DessinDAO extends DAO<Dessin> {

    @Override
    public Dessin create(Dessin obj) {

        this.connect();

        try (PreparedStatement dessinStatement = this.connect.prepareStatement("INSERT INTO Dessin(name, type, namef, coordf, cote, longueur) values(?, ?, ?, ?, ?, ?)")) {
            dessinStatement.setString(1, obj.getName());

            for (Forme f : obj.getChildforms()){

                if( f instanceof Cercle){
                    CercleDAO cercle = new CercleDAO();
                    Cercle tmp=cercle.create((Cercle) f);
                    dessinStatement.setString(2, "cercle");
                    dessinStatement.setString(3, tmp.getName());
                    dessinStatement.setString(4, tmp.getCoord());
                    dessinStatement.setInt(5, tmp.getRayon());
                    dessinStatement.setString(6, null);
                }
                if( f instanceof Carre){
                    CarreDAO carre = new CarreDAO();
                    Carre tmp=carre.create((Carre) f);
                    dessinStatement.setString(2, "carre");
                    dessinStatement.setString(3, tmp.getName());
                    dessinStatement.setString(4, tmp.getCoord());
                    dessinStatement.setInt(5, tmp.getCote());
                    dessinStatement.setString(6, null);
                }
                if( f instanceof Triangle){
                    TriangleDAO triangle = new TriangleDAO();
                    Triangle tmp=triangle.create((Triangle) f);
                    dessinStatement.setString(2, "triangle");
                    dessinStatement.setString(3, tmp.getName());
                    dessinStatement.setString(4, tmp.getCoord());
                    dessinStatement.setInt(5, tmp.getHypothenuse());
                    dessinStatement.setString(6, null);
                }
                if( f instanceof Rectangle){
                    RectangleDAO rectangle = new RectangleDAO();
                    Rectangle tmp=rectangle.create((Rectangle) f);
                    dessinStatement.setString(2, "rectangle");
                    dessinStatement.setString(3, tmp.getName());
                    dessinStatement.setString(4, tmp.getCoord());
                    dessinStatement.setInt(5, tmp.getLongueur());
                    dessinStatement.setInt(5, tmp.getLargeur());
                }
            }

            dessinStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return obj;
    }

    @Override
    public Dessin find(String id) {
        Dessin d = null;
        this.connect();
        try (PreparedStatement search = this.connect.prepareStatement("SELECT * FROM Dessin D WHERE D.name = ?")) {
            search.setString(1, id);
            try (ResultSet result = search.executeQuery()) {
                if (result.next()) {
                    d= new Dessin(result.getString("name"));
                    while(result.next()){
                        if (result.getString("type").equals("carre")){
                            CarreDAO tmp= new CarreDAO();
                            d.add(tmp.find(result.getString("fname")));
                        }
                        if (result.getString("type").equals("triangle")){
                            TriangleDAO tmp= new TriangleDAO();
                            d.add(tmp.find(result.getString("fname")));
                        }
                        if (result.getString("type").equals("cercle")){
                            CercleDAO tmp= new CercleDAO();
                            d.add(tmp.find(result.getString("fname")));
                        }
                        if (result.getString("type").equals("rectangle")){
                            RectangleDAO tmp= new RectangleDAO();
                            d.add(tmp.find(result.getString("fname")));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return d;
    }

    @Override
    public void delete(String id) {

        this.connect();
        try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Dessin D WHERE D.name = ?")) {
            delete.setString(1, id);
            delete.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void close() throws Exception {

        super.connect.close();
    }
}
