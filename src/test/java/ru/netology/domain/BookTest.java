package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

	@Test
	public void shouldCastFromBaseClass() {
		Product product = new Book();
		if (product instanceof Book) {
			Book book = (Book) product;
		}
	}

	@Test
	void getAuthor() {
	}

	@Test
	void setAuthor() {
	}
}