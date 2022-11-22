package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product1 = new Product(3, "Book 1", 120);
    Product product2 = new Product(8, "Book 2", 110);
    Product product3 = new Product(11, "Book 3", 115);
    Product product4 = new Product(12, "Book 4", 120);
    Product product5 = new Product(16, "Book 5", 95);

    @BeforeEach
    public void setup() {
        manager.add(product1);
        manager.add(product2);
        manager.add(product3);
    }

    @Test
    public void shouldFindAll() {

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch() {
        manager.add(product4);
        manager.add(product5);

        manager.searchBy("Book 4");

        Product[] expected = {product4};
        Product[] actual = manager.searchBy(product4.getName());

        Assertions.assertArrayEquals(expected, actual);
    }
}