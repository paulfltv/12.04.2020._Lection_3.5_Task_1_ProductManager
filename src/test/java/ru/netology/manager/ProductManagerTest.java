package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

	ProductRepository repository = new ProductRepository();
	ProductManager manager = new ProductManager(repository);

	@Test
	void ShouldSearchByAuthor() {

		Product first = new Book(1, "coreJava", 1000, "Author");
		Product second = new Smartphone(2, "xCover4S", 2000, "Samsung");

		repository.add(first);
		repository.add(second);

		Product[] actual = manager.searchBy("Author");
		Product[] expected = new Product[]{first};
		assertArrayEquals(expected, actual);
	}

	@Test
	void ShouldNotSearchByWrongAuthor() {

		Product first = new Book(1, "coreJava", 1000, "Author");
		Product second = new Smartphone(2, "xCover4S", 2000, "Samsung");

		repository.add(first);
		repository.add(second);

		Product[] actual = manager.searchBy("Author1");
		Product[] expected = new Product[]{};
		assertArrayEquals(expected, actual);
	}

	@Test
	void searchByManufacturer() {

		Product first = new Book(1, "coreJava", 1000, "Author");
		Product second = new Smartphone(2, "xCover4S", 2000, "Samsung");

		repository.add(first);
		repository.add(second);

		Product[] actual = manager.searchBy("Samsung");
		Product[] expected = new Product[]{second};
		assertArrayEquals(expected, actual);
	}

	@Test
	void ShouldNotSearchByWrongManufacturer() {

		Product first = new Book(1, "coreJava", 1000, "Author");
		Product second = new Smartphone(2, "xCover4S", 2000, "Samsung");

		repository.add(first);
		repository.add(second);

		Product[] actual = manager.searchBy("Samsung1");
		Product[] expected = new Product[]{};
		assertArrayEquals(expected, actual);
	}
}