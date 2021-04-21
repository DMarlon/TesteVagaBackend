package br.com.biblioteca.utils;

import java.util.InputMismatchException;
import java.util.Objects;

public class ValidatorUtils {
	private static final Long LONG_ONE = Long.valueOf(1);
	private static final Integer INTEGER_ONE = Integer.valueOf(1);

	public static boolean ehNullOuMenorQueUm(Long value) {
		return Objects.isNull(value) || LONG_ONE > value;
	}

	public static boolean ehNullOuMenorQueUm(Integer value) {
		return Objects.isNull(value) || INTEGER_ONE > value;
	}

	public static boolean ehNullOuBranco(String value) {
		return Objects.isNull(value) || value.isEmpty();
	}

	public static boolean isCPFValido(String federalregistration) {
		return cpf(federalregistration);
	}

	private static boolean cpf(String cpf) {

		cpf = FormatadorUtils.manterApenasNumero(cpf);

		if (cpf.length() != 11 || ehNumeroRepetidoDeCPF(cpf))
			return false;

		try {
			int dig10 = verificarDigitoCPF(10, cpf);
			int dig11 = verificarDigitoCPF(11, cpf);

			return (dig10 == cpf.charAt(9) && (dig11 == cpf.charAt(10)));
		} catch (InputMismatchException erro) {
			return false;
		}
	}

	private static boolean ehNumeroRepetidoDeCPF(String cpf) {
		return cpf.equals("00000000000") || cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") || cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999");
	}

	private static char verificarDigitoCPF(int digit, String cpf) {
		int result;
		int num = 0;
		int sum = 0;
		int limit = digit-1;

		for (int i = 0; i < limit; i++) {
			num = cpf.charAt(i) - 48;
			sum = sum + (num * digit);
			digit = digit - 1;
		}

		result = 11 - (sum % 11);
		if ((result == 10) || (result == 11))
			return '0';
		else
			return (char) (result + 48);
	}

	public static boolean ehApenasNumero(String value) {
		return value == null ? false : value.matches("^[0-9]+$");
	}
}
