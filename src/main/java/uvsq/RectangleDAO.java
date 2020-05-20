package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RectangleDAO extends DAO<Rectangle> {

    @Override
    public Rectangle create(Rectangle obj) {

        this.connect();

        try (PreparedStatement RectangleStatement = this.connect.prepareStatement("INSERT INTO Rectangle(name, coord, largeur, longueur) values(?, ?, ?, ?)")) {
            RectangleStatement.setString(1, obj.getName());
            RectangleStatement.setString(2, obj.getCoord());
            RectangleStatement.setInt(3, obj.getLargeur());
            RectangleStatement.setInt(4, obj.getLongueur());
            RectangleStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return obj;
    }

    @Override
    public Rectangle find(String id) {
        Rectangle r = null;
        this.connect();
        try (PreparedStatement search = this.connect.prepareStatement("SELECT * FROM Rectangle R WHERE R.name = ?")) {
            search.setString(1, id);
            try (ResultSet result = search.executeQuery()) {
                if (result.next()) {
                    r= new Rectangle(result.getString("name"),result.getString("coord"),result.getInt("largeur"),result.getInt("longueur"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return r;
    }

    @Override
    public void delete(String id) {

        this.connect();
        try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Rectangle R WHERE R.name = ?")) {
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
