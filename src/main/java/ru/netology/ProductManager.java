package ru.netology;

import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

public class ProductManager {
    private ProductRepository repo;

    public ProductManager(ProductRepository repo) {
        this.repo = repo;
    }

    public void add(Product product) {
        repo.save(product);
    }

    public Product[] searchBy(String text) {
        Product[] result = new Product[0]; // тут будем хранить подошедшие запросу продукты
        Product[] tmp = new Product[result.length + 1];
        for (Product product : repo.findAll()) {
            if (matches(product, text)) { // "добавляем в конец" массива result продукт product
                tmp[tmp.length - 1] = product;
            }
        }
        result = tmp;
        return result;
    }

    public boolean matches(Product product, String search) { // метод определения соответствия товара product запросу search
        if (product.matches(search)) {
            return true;
        } else {
            return false;
        }
        // или в одну строку:
        // return product.getName().contains(search);
    }
}
