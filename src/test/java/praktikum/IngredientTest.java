package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


import static org.junit.Assert.*;
import static praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
Ingredient ingredient;
private IngredientType type;
private String name;
private float price;
public IngredientTest (IngredientType type, String name, float price) {
    this.type = type;
    this.name = name;
    this.price = price;
}
@Parameterized.Parameters
public static Object[][] ingredientData() {
        return new Object[][]{
                {SAUCE, "hot sauce", 100},
                {SAUCE, "sour cream", 200},
                {SAUCE, "chili sauce", 300},
                {FILLING, "cutlet", 100},
                {FILLING, "dinosaur", 200},
                {FILLING, "sausage", 300}
        };
        }
    @Before
    public void setUp() {
    ingredient = new Ingredient(type,name, price);
    }
    @Test
    public void getPrice() {
     assertEquals("Неверная цена", price, ingredient.getPrice(),0);
    }

    @Test
    public void getName() {
    assertEquals("Неверное название ингридиента", name, ingredient.getName());
    }

    @Test
    public void getType() {
        assertEquals("Неверное название типа ингридиента", type, ingredient.getType());
    }
}