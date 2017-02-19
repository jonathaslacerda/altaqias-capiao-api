package autorizador.api.controller;

import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Calendar;

import altaqias.ragatanga.model.Cliente;
import autorizador.api.exception.AutorizacaoException;
import autorizador.api.model.ConfirmacaoPagamento;

public class Processador {
	
	public static ConfirmacaoPagamento autorizar(Cliente cliente, BigDecimal valor) throws AutorizacaoException{
		ConfirmacaoPagamento autorizacao = new ConfirmacaoPagamento();
		try {
			validarAutorizacao(cliente, valor);
			autorizacao.setCliente(cliente);
			autorizacao.setValor(valor);
			autorizacao.setData(Calendar.getInstance().getTime());
			autorizacao.tokenizar();
			return autorizacao;
		} catch (NoSuchAlgorithmException e){
			throw new AutorizacaoException("Erro ao autorizar valor: " + e.getMessage());
		} catch (AutorizacaoException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	private static void validarAutorizacao(Cliente cliente, BigDecimal valor) throws AutorizacaoException {
		if(cliente == null){
			throw new AutorizacaoException("Nenhum cliente foi informado");
		}
		if(valor == null || valor.equals(0)){
			throw new AutorizacaoException("Nenhum valor foi informado");
		}
	}
}
