package com.yaromich.catmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CatMarketApplication {
	// Домашнее задание:
	// 1. Разобраться с кодом. +
	// 2. Создать бин корзина с листом продуктов. ?
	// 3. Добавить на фронте к каждому продукту кнопку добавить в корзину. +
	// 4. Кнопка добавить в корзину должна складывать в бин корзина указанный продукт
	// (продукт может быть добален несколько раз, группировать продукты в корзине пока не надо). +
	// 5. Под таблице с продуктами отрисуйте таблицу корзина. +
	public static void main(String[] args) {
		SpringApplication.run(CatMarketApplication.class, args);
	}
}
