package br.com.biblioteca.utils;

public class FormatadorUtils {

	public static String manterApenasNumero(String value) {
		return value.replaceAll("[^0-9]", "");
	}
}
