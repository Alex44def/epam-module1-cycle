package ru.epam.jonline.module1.cycle;

import static java.lang.Math.*;

import java.util.Scanner;


public class Tasks {

//	Напишите программу, где пользователь вводит любое целое положительное число. 
//	А программа суммирует все числа от 1 до введенного пользователем числа

	public static void firstTask() {
		System.out.println("Answer firstTask: ");

		int a;
		
		do {
			a = enterFromConsole("Введите любое целое положительное число: ");
		} while (a < 1);

		int sum = 0;
		for (int i = 1; i <= a; i++) {
			sum += i;
		}

		System.out.printf("Сумма чисел от 1 до %d равна: %d%n", a, sum);
	}

//	Вычислить значения функции на отрезке [а,b] c шагом h

	public static void secondTask(int a, int b, int h) {
		System.out.println("Answer secondTask: ");

		for (int x = a; x <= b; x += h) {
			if (x > 2) {
				System.out.printf("x: %d  y: %d %n", x, x);
			} else {
				System.out.printf("x: %d  y: %d %n", x, -x);
			}
		}
	}

//  Найти сумму квадратов первых ста чисел

	public static void thirdTask() {
		System.out.println("Answer thirdTask: ");

		long sum = 0;

		for (int i = 1; i <= 100; i++) {
			sum += pow(i, 2);
		}

		System.out.println("Сумма квадратов первых ста чисел равна: " + sum);
	}

//  Составить программу нахождения произведения квадратов первых двухсот чисел

	public static void fourthTask() {
		System.out.println("Answer fourthTask: ");

		double p = 1;

		for (int i = 1; i <= 200; i++) {
			p = p * pow(i, 2);
		}

		System.out.println("Произведение квадратов первых двухсот чисел равно: " + p);
	}

//  Даны числовой ряд и некоторое число е.
//  Найти сумму тех членов ряда, модуль которых больше или равен заданному числу

	public static void fifthTask(double e) {
		System.out.println("Answer fifthTask: ");

		int n = 0;
		double elem = 2;
		double sum = 0;

		while (abs(elem) >= e) {
			n++;
			sum = sum + elem;
			elem = 1 / pow(2, n) + 1 / pow(3, n);
		}

		System.out.printf("Сумма членов ряда, чей модуль >= %f равна: %f%n", e, sum);
	}

//  Вывести на экран соответствий между символами и их численными обозначениями в памяти компьютера

	public static void sixthTask() {
		System.out.println("Answer sixthTask: ");

		for (int i = 33; i < 256; i++) {
			System.out.println((char) i + "   " + i);
		}
	}

//  Для каждого натурального числа в промежутке от m до n вывести все делители,
//  кроме единицы и самого числа. m и n вводятся с клавиатуры

	public static void seventhTask() {
		System.out.println("Answer seventhTask: ");

		int m = enterFromConsole("Введите стартовы индекс: ");
		int n = enterFromConsole("Введите конечный индекс: ");

		if (n < m) {
			int a = m;
			m = n;
			n = a;
		}

		boolean ch;
		for (int i = m; i < n; i++) {
			ch = true;
			System.out.println("\nДелители для числа: " + i);
			for (int j = 2; j <= i - 1; j++) {
				if (i % j == 0) {
					ch = false;
					System.out.print(j + " ");
				}
			}
			if (ch) {
				System.out.print("Простое число");
			}
		}
		System.out.println();
	}

//  Даны два числа. Определить цифры, входящие в запись как первого так и второго числа

	public static void eighthTask(int a, int b) {
		System.out.println("Answer eighthTask: ");

		int maxValue;
		int minValue;
		int tempMinValue;
		int checkNumber = 0;
		int tempCheckNumber = 0;
		int numder;
		boolean check = true;

		if (a > b) { // определение самого длинного числа
			maxValue = a;
			minValue = b;
			tempMinValue = b;
		} else {
			maxValue = b;
			minValue = a;
			tempMinValue = a;
		}

		System.out.printf("Цифры, входящие в запись чисел %d и %d %n", a, b);

		while (maxValue != 0) {
			numder = maxValue % 10; // берём цифру из большего числа
			maxValue = maxValue / 10;
			minValue = tempMinValue;
			check = true;

			while (minValue != 0) {
				int n = minValue % 10; // берём цифру из меньшего числа
				minValue = minValue / 10;

				while (checkNumber != 0) { // проверка, что число ещё не выводилось
					int m = checkNumber % 10;
					checkNumber = checkNumber / 10;

					if (m == numder) {
						check = false;
						break;
					}
				}

				checkNumber = tempCheckNumber;
				if (n == numder && check) {
					System.out.print(numder + " ");
					checkNumber = (int) ((checkNumber + numder / 10.0) * 10);
					tempCheckNumber = checkNumber;
					break;
				}
			}
		}
		System.out.println();
	}
	
	
	/*--------------------------------------*/
	
	@SuppressWarnings("resource")
	public static int enterFromConsole(String str) {
		Scanner in = new Scanner(System.in);
		System.out.print(str);
		while (!in.hasNextInt()) {
			in.next();
			System.out.print(str);
		}
		return in.nextInt();

	}

}
