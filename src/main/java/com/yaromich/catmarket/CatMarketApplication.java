package com.yaromich.catmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CatMarketApplication {
	// Домашнее задание: +
	// Доработайте корзину: +
	// 1. Отображение корзины на фронте +
	// 2. Для корзины и айтемов корзины пропишите ДТО +
	// 3. Реализуйте очистку корзины с фронта +
	// 4. Реализуйте возможность на фронте добавлять продукты в корзину +
	// *. С помощью кнопок +/- менять количество товаров в одной записи +


	// Домашнее задание:
	// 1. Разобраться с логикой работы с токенами +
	// 2. * Сделайте endpoint /get_my_email, который должен вернуть в ответ email текущего пользователя +
	// ВОЗНИКЛА СЛЕДУЮЩАЯ ПРОБЛЕМА: на фронте не получается вывести email пользователя.
	// 3. Если п. 2 совсем не получился, то напишите про какие варианты решения вы думали


	public static void main(String[] args) {
		SpringApplication.run(CatMarketApplication.class, args);
	}
}
