package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Hotel {
	private Integer quarto;
	private Date inicio;
	private Date fim;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	private static StringBuilder sb = new StringBuilder();
	
	public Hotel() {}

	public Hotel(Integer quarto, Date inicio, Date fim) {
		super();
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
	
	public void updateDates(Date inicio, Date fim) {
		this.inicio = inicio;
		this.fim = fim;
	}
	
	public void validaDatas() {
		Date atual = new Date();
		if( (this.inicio).before(atual)) {
			 System.out.print("Verifique se a data informada é menor do que a data Atual"); 
		}
		else if(this.inicio.after(this.fim)) {
			System.out.print("Data inicial não pode ser maior do que a final"); 
		}
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
