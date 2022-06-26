package model.application;
//solucção muito ruim de validação
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.entities.Hotel;

public class Programa {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		
		//String d1 = "30/01/2022";
		//String d2 = "29/01/2022";
		
		List<Hotel> lista = new ArrayList<>();
		
		try {
			System.out.print("Número do quarto:  ");
			int quarto = sc.nextInt();
			
			System.out.print("Check-in date (dd/mm/yyyy): " );
			sc.nextLine();
			Date vinicio = sdf.parse(sc.nextLine());
			
			System.out.print("Check-out date (dd/mm/yyyy): " );
			Date vfim = sdf.parse(sc.nextLine());
			
			
			if(vinicio.after(vfim)) {
				System.out.println("A data inicial deve ser menor do que a data final.");
			}else {
				Hotel h = new Hotel(quarto, vinicio, vfim);
				lista.add(h);
				System.out.println(h.dadosReserva());

				//para atualizar
				System.out.println();
				System.out.println("Alteração de reserva");
				System.out.print("Check-in date (dd/mm/yyyy): " );
				sc.nextLine();
				vinicio = sdf.parse(sc.nextLine());
				
				System.out.print("Check-out date (dd/mm/yyyy): " );
				vfim = sdf.parse(sc.nextLine());
				
				String valida = h.updateDates(vinicio, vfim);
				if(valida == null) {
					  h.updateDates(vinicio, vfim);
					  System.out.println(h.dadosReserva());
				}else {
					System.out.println(valida);
				}
			}
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		finally {
			sc.close();
		}
	}

}
