package com.example.DadataInnCriteria;

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
	}

}
