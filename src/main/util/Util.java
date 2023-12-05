package main.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import main.exceptions.AumentoException;

public class Util {

	public static String formatDataToString(LocalDate data) {
		String dataFormatada = null;
		if (data != null) {
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d/MM/uuuu");
			dataFormatada = formatters.format(data);
		}
		return dataFormatada;
	}

	public static LocalDate StringToLocalDate(String data) {
		LocalDate dataFormatada = null;
		if (data.isBlank() == false) {
			DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd/MM/uuuu");
			dataFormatada = LocalDate.parse(data, formatters);
		}
		return dataFormatada;
	}

	public static String FormatSalario(BigDecimal salario) {
		String salarioFormatado = null;
		if (salario != null) {
			salarioFormatado = NumberFormat.getCurrencyInstance().format(salario);
		}
		return salarioFormatado;
	}

	public static BigDecimal stringToBigDecimal(String valor) throws Exception {
		if (valor.isBlank()) {
			throw new Exception("Salário está nulo ou em branco.");
		}
		return BigDecimal.valueOf(Double.valueOf(valor));
	}

	public static BigDecimal calcularAumento(BigDecimal salario, BigDecimal aumento) throws AumentoException {
		if (salario == null || BigDecimal.ZERO.equals(salario) || salario.compareTo(BigDecimal.ZERO) < 0) {
			throw new AumentoException("Salário nulo, Igual a zero ou menor que zero. Não é possivel dar aumento.");
		}
		BigDecimal salarioAumentado = (salario.multiply(aumento)).divide(BigDecimal.valueOf(100));
		return salarioAumentado.add(salario);
	}
}
