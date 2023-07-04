import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {

	public static void main(String args[]) {

		// Exemplos de instâncias de data e horário atual
		// O toString() das classes utilizadas considera o formato ISO8601
		LocalDate date01 = LocalDate.now();
		LocalDateTime date02 = LocalDateTime.now();
		Instant date03 = Instant.now();

		System.out.println("Data local (obj date01)): " + date01);
		System.out.println("Data-hora local (obj date02): " + date02);
		System.out.println("Data-hora global GMT (obj date03): " + date03);
		System.out.println();

		// Exemplos de instâncias a partir de texto ISO 8601
		LocalDate date04 = LocalDate.parse("2023-07-23");
		LocalDateTime date05 = LocalDateTime.parse("2023-07-23T12:35:02.350");
		Instant date06 = Instant.parse("2023-07-23T15:35:02.350Z");

		System.out.println("Data local (obj date04): " + date04);
		System.out.println("Data-hora local com (obj date05): " + date05);
		System.out.println("Data-hora global GMT (obj date06): " + date06);
		System.out.println();

		// Exemplos de instâncias a partir de texto com datas formatadas.
		// Documentação de formatação:
		// https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html
		LocalDate date07 = LocalDate.parse("23/07/2023", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDateTime date08 = LocalDateTime.parse("23/07/2023 12:35", DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		System.out.println("Data Local (obj date07): " + date07);
		System.out.println("Data-hora local (obj date08): " + date08);
		System.out.println();

		// Exemplos de instâncias a partir de dados isolados.
		LocalDate date09 = LocalDate.of(2023, 07, 23);
		LocalDateTime date10 = LocalDateTime.of(2023, 07, 23, 12, 35, 02);
		System.out.println("Data local (obj date09): " + date09);
		System.out.println("Data-hora local (obj date10): " + date10);
		System.out.println();

		// Exemplo de instâncias a partir de texto ISO 8601 considerando fuso horário
		try {
			Instant date11 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss").parse("2023-07-23T12:35:02.350-03:00")
					.toInstant();
			System.out.println("Data-hora global GMT (obj date11): " + date11);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		// Imprimindo os dados de uma instância de forma customizada
		LocalDate date12 = LocalDate.parse("2023-07-23");
		LocalDateTime date13 = LocalDateTime.parse("2023-07-23T12:35:02");

		System.out.println(
				"Dados da data local (obj date12): " + date12.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		System.out.println(
				"Dados da data local (obj date12): " + DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date12));
		System.out.println("Dados da data-hora local (obj date13): "
				+ date13.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")));
		System.out.println();

		// Imprimindo os dados de uma instância em formatos padrão
		System.out.println("Dados da data-hora local (obj date13): " + date13.format(DateTimeFormatter.ISO_DATE_TIME));
		System.out.println("Dados da data-hora local (obj date13): " + date13.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println("Dados da data-hora local (obj date13): " + date13.format(DateTimeFormatter.ISO_LOCAL_DATE));
		System.out.println(
				"Dados da data-hora local (obj date13): " + date13.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
		System.out.println();

		// Imprimindo os dados de uma instância de data-hora global de forma customizada
		// considerando o fuso horário local
		Instant date14 = Instant.parse("2023-07-23T12:35:02Z");
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
		System.out.println("Data-hora global em fuso local (obj date14): " + fmt1.format(date14));
		System.out.println();

		// Convertendo uma data-hora global para data-hora local considerando diferentes
		// fusos horários
		Instant date15 = Instant.parse("2023-07-23T12:35:02Z");

		System.out.println("Data-hora global convertida em data local considerando o fuso local (obj date15): "
				+ LocalDate.ofInstant(date15, ZoneId.systemDefault()));
		System.out.println("Data-hora global convertida em data local considerando o fuso de Portugal (obj date15): "
				+ LocalDate.ofInstant(date15, ZoneId.of("Portugal")));
		System.out.println("Data-hora global convertida em data-hora local considerando o fuso local (obj date15): "
				+ LocalDateTime.ofInstant(date15, ZoneId.systemDefault()));
		System.out
				.println("Data-hora global convertida em data-hora local considerando o fuso de Portugal (obj date15): "
						+ LocalDateTime.ofInstant(date15, ZoneId.of("Portugal")));
		System.out.println(
				"Data-hora global convertida em data-hora local considerando o fuso da Ásia/Hebron (obj date15): "
						+ LocalDateTime.ofInstant(date15, ZoneId.of("Asia/Hebron")));

		// Visualizando todas as ZoneIds
		for (String zoneId : ZoneId.getAvailableZoneIds())
			System.out.println(zoneId);
		System.out.println();

		// Visualizando dados específicos de uma instância LocalDate e LocalDateTime
		LocalDate date16 = LocalDate.parse("2023-07-23");
		LocalDateTime date17 = LocalDateTime.parse("2023-07-23T12:35:02");

		System.out.println("Dia (obj date16): " + date16.getDayOfMonth());
		System.out.println("Mês (obj date16): " + date16.getMonthValue());
		System.out.println("Ano (obj date16): " + date16.getYear());

		System.out.println("Dia (obj date17): " + date17.getDayOfMonth());
		System.out.println("Mês (obj date17): " + date17.getMonthValue());
		System.out.println("Ano (obj date17): " + date17.getYear());
		System.out.println("Hora (obj date17): " + date17.getHour());
		System.out.println("Minuto (obj date17): " + date17.getMinute());
		System.out.println("Segundo (obj date17): " + date17.getSecond());
		System.out.println();

		// Fazendo operações com datas e horas
		LocalDateTime date18 = LocalDateTime.parse("2023-07-23T12:35:02");
		Instant date19 = Instant.parse("2023-07-23T12:35:02Z");

		System.out.println("Data-hora local 7 dias antes (obj 18): " + date18.minusDays(7));
		System.out.println("Data-hora local 7 dias depois (obj 18): " + date18.plusDays(7));
		System.out.println("Data-hora local 12 horas antes (obj 18): " + date18.minusHours(12));
		System.out.println("Data-hora local 12 horas depois (obj 18): " + date18.plusHours(12));

		System.out.println("Data-hora global 7 dias antes (obj 19): " + date19.minus(7, ChronoUnit.DAYS));
		System.out.println("Data-hora global 7 dias depois (obj 19): " + date19.plus(7, ChronoUnit.DAYS));
		System.out.println("Data-hora global 12 horas antes (obj 19): " + date19.minus(12, ChronoUnit.HOURS));
		System.out.println("Data-hora global 12 horas depois (obj 19): " + date19.plus(12, ChronoUnit.HOURS));
		System.out.println();

		// Fazendo operações de duração entre duas datas-horas
		LocalDateTime date20 = LocalDateTime.parse("2023-07-23T12:35:02");
		LocalDateTime date21 = LocalDateTime.parse("2024-08-12T00:30:08");
		Duration duration1 = Duration.between(date20, date21);
		System.out.println("Duração em dias entre duas datas-hora local: " + duration1.toDays());
		System.out.println("Duração em horas entre duas datas-hora local: " + duration1.toHours());

	}
}
