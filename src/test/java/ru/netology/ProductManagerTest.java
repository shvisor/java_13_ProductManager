package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Book(3, "Book 1", 120, "Author 1");
    Product product2 = new Book(8, "Book 2", 110, "Author 2");
    Product product3 = new Book(11, "Book 3", 115, "Author 3");
    Product product4 = new Book(12, "Book 4", 120, "Author 4");
    Product product5 = new Book(16, "Book 5", 95, "Author 5");
    Product product6 = new Smartphone(19, "Smartphone 1", 10000, "Producer 1");
    Product product7 = new Smartphone(25, "Smartphone 2", 9000, "Producer 2");
    Product product8 = new Smartphone(37, "Smartphone 3", 11500, "Producer 3");
    Product product9 = new Smartphone(48, "Smartphone 4", 9500, "Producer 4");
    Product product10 = new Smartphone(64, "Smartphone 5", 12000, "Producer 5");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product6);
        manager.add(product7);
        manager.add(product8);
    }

    @Test
    public void shouldFindAll() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByName() {
        manager.add(product4);
        manager.add(product5);
        manager.add(product9);
        manager.add(product10);

        manager.searchBy("Book 4");

        Product[] expected = {product4};
        Product[] actual = manager.searchBy(product4.getName());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {
        manager.add(product4);
        manager.add(product5);
        manager.add(product9);
        manager.add(product10);

        manager.searchBy("Author 3");

        Product[] expected = {product3};
        Product[] actual = manager.searchBy(product3.getName());

        Assertions.assertArrayEquals(expected, actual);
    }
}