import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Product book1 = new Book(1, "Айвенго", 300, "Вальтер Скотт");
    Product book2 = new Book(2, "Гарри Поттер", 500, "Джоан Роулинг");
    Product smartphone1 = new Smartphone(3, "A51", 9000, "ZTE");
    Product smartphone2 = new Smartphone(4, "iPhone 13", 20_000, "Apple");
    Product smartphone3 = new Smartphone(5, "A51", 9000, "ZTE");

    @BeforeEach

    public void shouldAddProduct() {
        manager.add(book1);
        manager.add(book2);
        manager.add(smartphone1);
        manager.add(smartphone2);
        manager.add(smartphone3);
    }

    @Test

    public void shouldFindByName() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Гарри Поттер");

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test

    public void FindByAuthor() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Джоан Роулинг");

        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldFindMoreThanOneProductByName() {
        Product[] expected = {smartphone1, smartphone3};
        Product[] actual = manager.searchBy("A51");

        Assertions.assertArrayEquals(expected, actual);
    }





    @Test
    public void shouldFindWithoutName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Пусто");

        Assertions.assertArrayEquals(expected, actual);
    }
}

