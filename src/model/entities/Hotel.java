package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Hotel {
	private Integer quarto;
	private Date inicio;
	private Date fim;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public Hotel() {}

	public Hotel(Integer quarto, Date inicio, Date fim) throws DomainException {
		 Date agora = new Date();
		 if(inicio.before(agora)|| fim.before(agora)) {
			throw new DomainException("Erro na reserva. Deve ser datas futuras");
		 }
		if(fim.before(inicio)) {
			throw new DomainException( "A data final deve ser maior que a inicial");
		}
		this.quarto = quarto;
		this.inicio = inicio;
		this.fim = fim;
	}
	/**
	 * @return the quarto
	 */
	public Integer getQuarto() {
		return quarto;
	}

	/**
	 * @param quarto the quarto to set
	 */
	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}




	/**
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @return the fim
	 */
	public Date getFim() {
		return fim;
	}

	
	
	public long duracao() {
		Date d1 = inicio;
		Date d2 =  fim;
		//em milisengudos
		Long periodo = d2.getTime() - d1.getTime();
		//converter para dias. 
		return TimeUnit.DAYS.convert(periodo, TimeUnit.MILLISECONDS);
		//return periodo/(1000*60*60*24);//calculo de dias 
	}
	
	
	public String updateDates_Retorno_String(Date inicio, Date fim) {
		Date agora = new Date();
		 if(inicio.before(agora)|| fim.before(agora)) {
			return "Erro na reserva. Deve ser datas futuras";
		 }
		if(fim.before(inicio)) {
			return "A data final deve ser maior que a inicial";
		}
		this.inicio = inicio;
		this.fim = fim;
		return null;
	}
	
	//o metodo update lança a exceção e propaga ou seja, não é aqui que vai ser tratada
	public void updateDates(Date inicio, Date fim) throws DomainException {
		Date agora = new Date();
		 if(inicio.before(agora)|| fim.before(agora)) {
			throw new DomainException("Erro na reserva. Deve ser datas futuras");
		 }
		if(fim.before(inicio)) {
			throw new DomainException( "A data final deve ser maior que a inicial");
		}
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public String dadosReserva() {
		StringBuilder sb = new StringBuilder();
		sb.append("Reservation quarto:  ");
		sb.append(this.quarto + ",  ");
		sb.append(" check-in:  " + sdf.format(inicio));
		sb.append("   check- out: "+ sdf.format(fim));
		sb.append(", " + this.duracao() + "  noites.");
		return sb.toString();
	}
	
	
	
	
	
	

}
