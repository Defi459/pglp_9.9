package uvsq;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TriangleDAO extends DAO<Triangle> {

    @Override
    public Triangle create(Triangle obj) {

        this.connect();

        try (PreparedStatement TriangleStatement = this.connect.prepareStatement("INSERT INTO Triangle(name, coord, hypothenuse) values(?, ?, ?)")) {
            TriangleStatement.setString(1, obj.getName());
            TriangleStatement.setString(2, obj.getCoord());
            TriangleStatement.setInt(3, obj.getHypothenuse());
            TriangleStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return obj;
    }

    @Override
    public Triangle find(String id) {
        Triangle t = null;
        this.connect();
        try (PreparedStatement search = this.connect.prepareStatement("SELECT * FROM Triangle T WHERE T.name = ?")) {
            search.setString(1, id);
            try (ResultSet result = search.executeQuery()) {
                if (result.next()) {
                    t= new Triangle(result.getString("name"),result.getString("coord"),result.getInt("hypothenuse"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.disconnect();
        return t;
    }

    @Override
    public void delete(String id) {

        this.connect();
        try (PreparedStatement delete = this.connect.prepareStatement("DELETE FROM Triangle T WHERE T.name = ?")) {
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
