package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
public class BunTest {
private Bun bun;
    @Test
    public void getNameBunTest() {
     Bun bun = new Bun ("black bun",100);
     String result = bun.getName();
     assertEquals("black bun", result);
    }

    @Test
    public void getPriceBunTest() {
        Bun bun = new Bun ("black bun",100);
        Float result = bun.getPrice();
        assertEquals(100, result, 0);
    }
}