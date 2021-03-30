package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

	@Test
	public void shouldCastFromBaseClass() {
		Product product = new Smartphone();
		if (product instanceof Smartphone) {
			Smartphone smartphone = (Smartphone) product;
		}
	}

	@Test
	void getManufacturer() {
	}

	@Test
	void setManufacturer() {
	}
}