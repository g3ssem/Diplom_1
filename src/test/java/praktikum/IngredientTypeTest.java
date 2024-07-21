package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void ingredientTypeSauceTest () {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf(("SAUCE")));

    }

    @Test
    public void ingredientTypeFillingTest () {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf(("FILLING")));

    }
}