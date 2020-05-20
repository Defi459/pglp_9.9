package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarreDAO extends DAO<Carre>{


    @Override
    public Carre create(Carre obj) {

        this.connect();

        try (PreparedStatement carreStatement = this.connect.prepareStatement("INSERT INTO Carre(name, coord, cote) values(?, ?, ?)")) {
            carreStatement.setString(1, obj.getName());
            carreStatement.setString(2, obj.getCoord());
            carreStatement.setInt(3, obj.getCote());
            carreStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return obj;
    }

    @Override
    public Carre find(String id) {
        Carre c = null;
        this.connect();
        try (PreparedStatement search = this.connect.prepareStatement("SELECT * FROM Carre C WHERE C.name = ?")) {
                search.setString(1, id);
                try (ResultSet result = search.executeQuery()) {
                    if (result.next()) {
                        c= new Carre(result.getString("name"),result.getString("coord"),result.getInt("cote"));
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
        try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Carre C WHERE C.name = ?")) {
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
