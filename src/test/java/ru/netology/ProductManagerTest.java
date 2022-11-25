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
    Product product4 = new Smartphone(19, "Smartphone 1", 10000, "Producer 1");
    Product product5 = new Smartphone(25, "Smartphone 2", 9000, "Producer 2");
    Product product6 = new Smartphone(37, "Smartphone 3", 11500, "Producer 3");

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
        manager.add(product4);
        manager.add(product5);
        manager.add(product6);
    }

    @Test
    public void shouldFindAll() {

        Product[] expected = {product1, product2, product3, product4, product5, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameBook() {

        Product[] expected = {product2};
        Product[] actual = manager.searchBy("Book 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByNameSmartphone() {

        Product[] expected = {product4};
        Product[] actual = manager.searchBy("Smartphone 1");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByAuthor() {

        Product[] expected = {product3};
        Product[] actual = manager.searchBy("Author 3");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchBySmartphone() {

        Product[] expected = {product5};
        Product[] actual = manager.searchBy("Producer 2");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMultipleAuthor() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = manager.searchBy("Author");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByMultipleSmartphone() {

        Product[] expected = {product4, product5, product6};
        Product[] actual = manager.searchBy("Producer");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByWhenNull() {

        Product[] expected = {};
        Product[] actual = manager.searchBy("Butterfly");

        Assertions.assertArrayEquals(expected, actual);
    }
}