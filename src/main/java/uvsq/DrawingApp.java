package uvsq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DrawingApp {

    private Connection connect;
    private Statement st;
    private DrawingTUI ui;
    private Command c;

    public DrawingApp(){

        this.ui = new DrawingTUI();
        try {
            String driver = "org.apache.derby.jdbc.EmbeddedDriver";
            Class.forName(driver);
            connect = DriverManager.getConnection("jdbc:derby:DrawingApp;create=true");
            st = connect.createStatement();

            st.execute("CREATE TABLE Carre( name varchar(50) PRIMARY KEY NOT NULL, coord varchar(50), cote int)");
            st.execute("CREATE TABLE Cercle( name varchar(50) PRIMARY KEY NOT NULL, coord varchar(50), rayon int)");
            st.execute("CREATE TABLE Triangle( name varchar(50) PRIMARY KEY NOT NULL, coord varchar(50), hypothenuse int)");
            st.execute("CREATE TABLE Rectange( name varchar(50) PRIMARY KEY NOT NULL, coord varchar(50), largeur int, longueur int)");
            st.execute("CREATE TABLE Dessin( name varchar(50) PRIMARY KEY NOT NULL,namef varchar(50)," +
                    " coord varchar(50), value1 int, value2 int)");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        try {
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public void run(){

        c=this.ui.nextCommand();
        if (c != null) {
            c.execute();
        }
    }

}
