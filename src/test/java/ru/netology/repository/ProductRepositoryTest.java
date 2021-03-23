package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
	private ProductRepository repository = new ProductRepository();
	private Book coreJava = new Book();
	private Smartphone xCover4S = new Smartphone();

	@Test
	public void shouldSaveOneItem() {
		repository.save(coreJava);

		Product[] expected = new Product[]{coreJava};
		Product[] actual = repository.findAll();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldSaveTwoItems() {
		repository.save(coreJava);
		repository.save(xCover4S);

		Product[] expected = new Product[]{coreJava, xCover4S};
		Product[] actual = repository.findAll();
		assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldRemoveIfExists() {
		int idToRemove = 1;
		Product first = new Book(1, "coreJava", 1000, "Author");
		Product second = new Smartphone (2, "xCover4S", 2000, "Samsung");
		repository.add(first);
		repository.add(second);

		repository.removeById(idToRemove);

		Product[] expected = new Product[]{second};
		Product[] actual = repository.getAll();

		assertArrayEquals(expected, actual);
	}

	@Test
	public void shouldRemoveIfExists() {
		int idToRemove = 3;
		Product first = new Book(1, "coreJava", 1000, "Author");
		Product second = new Smartphone (2, "xCover4S", 2000, "Samsung");
		repository.add(first);
		repository.add(second);

		repository.removeById(idToRemove);

		Product[] expected = new Product[]{second, first};
		Product[] actual = repository.getAll();

		assertArrayEquals(expected, actual);
	}

	@Test
	void findAll() {
	}
}