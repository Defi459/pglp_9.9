package uvsq;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void CercleTest(){

        Cercle c1 = new Cercle("(10,10)","c1",1);
        c1.move("(5,5)");
        assertEquals(c1.getCoord(),"(5,5)");
        assertEquals(c1.show(),"c1 Cercle(Centre=(5,5),Rayon=1)");

    }

    @Test
    public void TriangleTest(){
        Triangle t1 = new Triangle("t1","(10,10)",1);
        t1.move("(5,5)");
        assertEquals(t1.getCoord(),"(5,5)");
        assertEquals(t1.show(),"t1 Triangle(Centre=(5,5),Hypothenuse=1)");
    }

    @Test
    public void RectangeTest(){
        Rectangle r1 = new Rectangle("r1","(10,10)",1,1);
        r1.move("(5,5)");
        assertEquals(r1.getCoord(),"(5,5)");
        assertEquals(r1.show(),"r1 Rectangle(Centre=(5,5),Largeur=1,Longueur=1)");
    }

    @Test
    public void CarreTest(){
        Carre c1 = new Carre("c1","(10,10)",1);
        c1.move("(5,5)");
        assertEquals(c1.getCoord(),"(5,5)");
        assertEquals(c1.show(),"c1 Carre(Centre=(5,5),Cote=1)");
    }

    @Test
    public void CompositeTest(){
        Carre c1 = new Carre("c1","(10,10)",4);
        Triangle t1 = new Triangle("t1","(5,5)",1);
        Dessin g1 = new Dessin("g1");

        g1.add(c1);
        g1.add(t1);
        g1.move("(4,4)");
        assertEquals(c1.getCoord(),"(4,4)");
        assertEquals(t1.getCoord(),"(4,4)");
        g1.remove(t1);
        g1.move("(3,3)");
        assertEquals(c1.getCoord(),"(3,3)");
        assertEquals(t1.getCoord(),"(4,4)");
    }
}
