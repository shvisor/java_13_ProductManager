package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product product1 = new Book(3, "Book 1", 120, "Author 1");
    Product product2 = new Book(8, "Book 2", 110, "Author 2");
    Product product3 = new Book(11, "Book 3", 115, "Author 3");
    Product product4 = new Smartphone(19, "Smartphone 1", 10000, "Producer 1");
    Product product5 = new Smartphone(25, "Smartphone 2", 9000, "Producer 2");
    Product product6 = new Smartphone(37, "Smartphone 3", 11500, "Producer 3");

    @BeforeEach
    public void setup() {
        repo.save(product1);
        repo.save(product2);
        repo.save(product3);
        repo.save(product4);
        repo.save(product5);
        repo.save(product6);
    }

    @Test
    public void shouldRemoveBiId() {
        repo.removeById(25);

        Product[] expected = {product1, product2, product3, product4, product6};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
