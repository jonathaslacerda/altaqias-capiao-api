package altaqias.ragatanga.api.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GeralUtil {

	public static final String FORMATO_NOME_ARQUIVO_SELO = "yyyyMMddHHmmss";

	public static String dataAtual(String formato) {
		Calendar agora = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(agora.getTime());
	}

	public static String convertData(Calendar data, String formato) {
		SimpleDateFormat sdf = new SimpleDateFormat(formato);
		return sdf.format(data.getTime());
	}
}

