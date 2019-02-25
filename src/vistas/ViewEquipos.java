package vistas;

import java.util.List;
import modelos.Equipos;

public class ViewEquipos {
	
	
	public void viewEquipos(Equipos equipos) {
		System.out.println("Datos del Equipos: " +equipos);
	}
	
	public void viewTodosEquiposes(List<Equipos> all_equipos) {
		for (Equipos equipos: all_equipos) {
			System.out.println("Datos de los Equipos: "+ equipos);
		}
	}
}
