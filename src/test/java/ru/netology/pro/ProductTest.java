package ru.netology.pro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class ProductTest {
    private ProductRepository repo = new ProductRepository();
    private ProductManager manager = new ProductManager(repo);

    Product one = new Book(1, "Приключения Тома Сойера и Гекельберри Финна", 201, "Марк Твен");
    Product two = new Book(2, "Девочка со спичками", 999, "Ганс Христиан Андерсен");
    Product tree = new Book(3, "Малыш и Карлсон", 537, "Астрид Линдгрен");
    Product four = new Smartphone(4, "Iphone14ProMax", 250000, "Apple");
    Product fife = new Smartphone(5, "Iphone10", 11111, "Apple");
    Product six = new Smartphone(6, "Redmi", 36599, "Xiaomi");
    Product seven = new Product(7, "SOS", 5);

    @BeforeEach
    public void addProducts() {
        manager.add(one);
        manager.add(two);
        manager.add(tree);
        manager.add(four);
        manager.add(fife);
        manager.add(six);
        manager.add(seven);
    }

    @Test
    public void addProductsAndGetIts() {

        Product[] expected = new Product[]{one, two, tree, four, fife, six, seven};
        Product[] actual = repo.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void SearchBySmartphoneFewName() {
        Product[] results = manager.searchBy("Iphone");

        Product[] expected = new Product[]{four, fife};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByNoExistingSmartphoneName() {
        Product[] results = manager.searchBy("One Plus");

        Product[] expected = new Product[0];
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByExistingBookName() {
        Product[] results = manager.searchBy("Астрид Линдгрен");

        Product[] expected = new Product[]{tree};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByNoExistingBookName() {
        Product[] results = manager.searchBy("Домик у реки");

        Product[] expected = new Product[0];
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByTextName() {
        Product[] results = manager.searchBy("SOS");

        Product[] expected = new Product[]{seven};
        Assertions.assertArrayEquals(expected, results);
    }

    @Test
    public void SearchByAuthor() {
        Product[] results = manager.searchBy("Марк Твен");

        Product[] expected = {one};
        Assertions.assertArrayEquals(expected, results);
    }


}
