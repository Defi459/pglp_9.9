package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CercleDAO extends DAO<Cercle> {


    @Override
    public Cercle create(Cercle obj) {

        this.connect();

        try (PreparedStatement CercleStatement = this.connect.prepareStatement("INSERT INTO Cercle(name, coord, rayon) values(?, ?, ?)")) {
            CercleStatement.setString(1, obj.getName());
            CercleStatement.setString(2, obj.getCoord());
            CercleStatement.setInt(3, obj.getRayon());
            CercleStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return obj;
    }

    @Override
    public Cercle find(String id) {
        Cercle c = null;
        this.connect();
        try (PreparedStatement search = this.connect.prepareStatement("SELECT * FROM Cercle C WHERE C.name = ?")) {
            search.setString(1, id);
            try (ResultSet result = search.executeQuery()) {
                if (result.next()) {
                    c= new Cercle(result.getString("name"),result.getString("coord"),result.getInt("rayon"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return c;
    }

    @Override
    public void delete(String id) {

        this.connect();
        try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Cercle C WHERE C.name = ?")) {
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
