package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Test
    public void setBunsTest() {
Burger burger = new Burger();
        burger.setBuns(bun);
assertEquals("Название и цена булки не верные",bun,burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        assertEquals("Ингридиент не добавлен",1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        assertEquals("Ингридиент не удалён",0, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(new Ingredient(IngredientType.FILLING,"cutlet",100));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE,"hot sauce",100));
        burger.moveIngredient(0,1);
        assertEquals("Перемещение ингридиентов не выполнено","hot sauce", burger.ingredients.get(0).name);
    }

    @Test
    public void getPrice() {
        Mockito.when(bun.getPrice()).thenReturn(100.0F);
        Mockito.when(ingredient.getPrice()).thenReturn(100.0F);
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        float price = burger.getPrice();
        assertEquals("Цена бургера расчитана не верно",300.0,price,1);

    }

    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();
        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(bun.getPrice()).thenReturn(100F);
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(100F);
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        String result = String.format("%s%n%s%n%s%n%n%s%n","(==== black bun ====)", "= filling cutlet =", "(==== black bun ====)", "Price: 300,000000");
        assertEquals(result, burger.getReceipt());

    }
}