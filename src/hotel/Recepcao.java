package hotel;

import java.util.ArrayList;
import java.util.Iterator;

public class Recepcao {
	private ArrayList<Estadia> estadias;

	public void checkIn(String nome, String tipo, int idade, int dias, double valor) {
		Estadia novaEstadia = new Estadia(nome, tipo, idade, dias, valor);
		estadias.add(novaEstadia);
	}

	public void checkOut(String nome) {
		Iterator<Estadia> i = estadias.iterator();
		while (i.hasNext()) {
			Estadia estadia = i.next();
			if (estadia.getNome().equals(nome)) {
				i.remove();
			}
		}
	}

	public int getNumDeHospedes() {
		return estadias.size();
	}

	public double getLucroTotal() {
		double lucroTotal = 0;

		for (int i = 0; i < estadias.size(); i++) {
			lucroTotal += estadias.get(i).getValor();
		}
	}

	@Override
	public String toString() {
		String hospedes = "Estadias: ";
		Iterator<Estadia> i = estadias.iterator();
		while (i.hasNext()) {
			Estadia estadia = i.next();
			hospedes += estadia.getNome() + "(" + estadia.getTipo() + ") : " + estadia.getDias()
					+ " dias com o preço de R$ " + estadia.getValor() + "\n";
		}

		return hospedes;
	}

}
