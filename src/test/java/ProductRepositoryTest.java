import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    ProductRepository repo = new ProductRepository();

    Product book1 = new Book(1, "Айвенго", 300, "Вальтер Скотт");
    Product book2 = new Book(2, "Гарри Поттер", 500, "Джоан Роулинг");
    Product smartphone1 = new  Smartphone(3, "A51", 9000, "ZTE");
    Product smartphone2 = new  Smartphone(4, "iPhone", 20_000, "Apple");
    Product smartphone3 = new  Smartphone(5, "A51", 9000, "ZTE");

    @Test
    public void shouldSaveProducts() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);

        Product[] expected = {book1, book2, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldRemovedById() {
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.removeById(2);

        Product[] expected = {book1, smartphone1};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void ShouldFindAll(){
        repo.save(book1);
        repo.save(book2);
        repo.save(smartphone1);
        repo.save(smartphone2);
        repo.save(smartphone3);

        Product[] expected = {book1, book2, smartphone1, smartphone2, smartphone3};
        Product[] actual = repo.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }
}
