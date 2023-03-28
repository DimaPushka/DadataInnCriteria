package com.example.DadataInnCriteria;

import com.example.DadataInnCriteria.test.Container;

import java.io.File;
import java.util.Scanner;


public class DadataInnCriteriaApplication {

	public static void main(String[] args) {
		Scanner str = new Scanner(System.in);
		String first;
		System.out.print("Введите ИНН: ");
		first = str.nextLine();
		String token = "5aca1b4081ef5604ffa22a187a4dcd34a8327a62";
		Dadata provider = new Dadata(token);
		provider.PrintSortedByRegistrationDateAsc("" + first);

//		Scanner scanner = new Scanner(System.in);
//		boolean quit = false;
//		do {
//			System.out.println("Выберите действие:");
//			System.out.println("1 - Найти организацию по инн");
//			System.out.println("2 - Завершить");
//			int choice = scanner.nextInt();
//			scanner.nextLine();
//			switch (choice) {
//				case 1:
//					System.out.println("Введите ИНН для поиска:");
//					run(scanner.nextLine());
//					break;
//				case 2:
//					quit = true;
//					break;
//				default:
//					System.out.println("Некорректный пункт меню, попробуйте еще раз");
//			}
//		} while (!quit);
//		scanner.close();
	}

	public static void run(String query) {
		Container instance = Container.getInstance();
		Response companiesSuggestions = instance.getCompanyService().findCompaniesSuggestions(query);
		File resultFile = instance.getWriterService().write("output.json", companiesSuggestions);
		System.out.println("Результат записан в файл по адресу: " + resultFile.getAbsolutePath());
	}

}
