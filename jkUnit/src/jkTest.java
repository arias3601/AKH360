import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

public class jkTest {
    player fatJoe, sushi, jar, blimmy, noName, ditto;

    @Before
    public void setUp() throws Exception {
        fatJoe = new player("Fat Joe", 64, true);
        sushi = new player("Sushi Zushi", 77, true);
        jar = new player("Jar", 0, false);
        blimmy = new player("Blimmy", 33, true);
        noName = new player(null, 50, true);
    }

    @Test
    public void testHP() {
        assertEquals(64, fatJoe.getHp());
        assertEquals(77, sushi.getHp());
        assertEquals(0, jar.getHp());
        assertEquals(33, blimmy.getHp());
        assertEquals(50, noName.getHp());
    }

    @Test
    public void testNull(){
        assertNull(noName.getName());
    }

    @Test
    public void testTrue(){
        assertTrue(fatJoe.isAlive());
        assertTrue(sushi.isAlive());
        assertTrue(blimmy.isAlive());
        assertTrue(noName.isAlive());
    }

    @Test
    public void testFalse(){
        assertFalse(jar.isAlive());
    }

    @Test
    public void testSame(){
        ditto = sushi;
        assertSame(ditto, sushi);
    }

    @Test
    public void testFail(){
        try {
            ditto.setHp((Integer)null);
            fail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
