import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShopRepositoryTest {

    ShopRepository repo = new ShopRepository(); //создался новый объект

    Product product1 = new Product(1, "бассейн", 30_000);  // создали три новых товара
    Product product2 = new Product(2, "машина", 2_000_000);
    Product product3 = new Product(3, "вода", 50);

    @Test
    public void shouldAddProductInRepository() {
        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = { product1, product2, product3 };
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  shouldDeleteProductInRepository(){ //удаление продукта из репозитория


        repo.add(product1);  // добавили товары
        repo.add(product2);
        repo.add(product3);
        repo.remove(2); // удаление товара с id=2

        Product[] actual = repo.findAll();
        Product[] expected = {product1, product3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void  shouldDeleteNonExistentProductFromRepository(){ //удаление несуществующего продукта

        repo.add(product1);  // добавили товары
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () -> repo.remove(27));   // лямбда функции
    }
}