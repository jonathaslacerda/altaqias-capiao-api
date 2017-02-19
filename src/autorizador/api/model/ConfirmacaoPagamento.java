package autorizador.api.model;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import altaqias.ragatanga.api.utils.CryptUtils;
import altaqias.ragatanga.model.Cliente;
import lombok.Getter;
import lombok.Setter;

public class ConfirmacaoPagamento {

	@Getter @Setter
	private Cliente cliente;
	
	@Getter @Setter
	private Date data;
	
	@Getter @Setter
	private BigDecimal valor;
	
	@Getter @Setter
	private String token;

	public void tokenizar() throws NoSuchAlgorithmException {
		String hashcodes = "" + this.cliente.hashCode() + "" + this.valor.hashCode() + "" + this.data.hashCode(); 
		this.token = CryptUtils.toMD5(hashcodes);
	}
}
