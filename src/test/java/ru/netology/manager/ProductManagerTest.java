package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
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
	void shouldSearchBookByAuthorWhenOneBookInRepository() {

		Product first = new Book(1, "Book", 1000, "Author");

		repository.add(first);

		Product[] actual = manager.searchBy("Author");
		Product[] expected = new Product[]{first};
		assertArrayEquals(expected, actual);
	}

	@Test
	void shouldSearchBookByAuthorWhenSeveralBooksInRepository() {

		Product first = new Book(1, "Book1", 1000, "Author1");
		Product second = new Book(2, "Book2", 1000, "Author2");
		Product third = new Book(3, "Book3", 1000, "Author3");
		Product fourth = new Smartphone(4, "Smartphone1", 2000, "Manufacturer");


		repository.add(first);
		repository.add(second);
		repository.add(third);
		repository.add(fourth);

		Product[] actual = manager.searchBy("Author3");
		Product[] expected = new Product[]{third};
		assertArrayEquals(expected, actual);
	}

	@Test
	void shouldNotSearchBookByWrongAuthor() {

		Product first = new Book(1, "Book1", 1000, "Author1");
		Product second = new Book(2, "Book2", 1000, "Author2");
		Product third = new Book(3, "Book3", 1000, "Author3");

		repository.add(first);
		repository.add(second);
		repository.add(third);

		Product[] actual = manager.searchBy("Author4");
		Product[] expected = new Product[]{};
		assertArrayEquals(expected, actual);
	}

	@Test
	void shouldSearchSmartphoneByManufacturerWhenOneSmartphoneInRepository() {

		Product first = new Smartphone(1, "Smartphone", 2000, "Manufacturer");

		repository.add(first);

		Product[] actual = manager.searchBy("Manufacturer");
		Product[] expected = new Product[]{first};
		assertArrayEquals(expected, actual);
	}

	@Test
	void shouldSearchSmartphoneByManufacturerWhenSeveralSmartphones() {

		Product first = new Smartphone(1, "Smartphone1", 2000, "Manufacturer1");
		Product second = new Smartphone(2, "Smartphone2", 2000, "Manufacturer2");
		Product third = new Smartphone(3, "Smartphone3", 2000, "Manufacturer3");
		Product fourth = new Book(4, "Book", 1000, "Author");

		repository.add(first);
		repository.add(second);
		repository.add(third);
		repository.add(fourth);

		Product[] actual = manager.searchBy("Manufacturer3");
		Product[] expected = new Product[]{third};
		assertArrayEquals(expected, actual);
	}

	@Test
	void shouldNotSearchSmartphoneByWrongManufacturer() {

		Product[] actual = manager.searchBy("Manufacturer4");
		Product[] expected = new Product[]{};
		assertArrayEquals(expected, actual);
	}

	@Test
	void shouldNotSearchProductInEmptyRepository() {
		Product[] actual = manager.searchBy("Product");
		Product[] expected = new Product[]{};
		assertArrayEquals(expected, actual);
	}
}