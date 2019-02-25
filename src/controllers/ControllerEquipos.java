package controllers;

import java.util.ArrayList;
import java.util.List;

import daos.EquiposDaoMySQLImp;
import daos.JugadorDaoMongoDBImp;
import daos.JugadorDaoMySQLImp;
import daos.EquiposDaoMongoDBImp;

import idaos.EquiposDao;
import idaos.JugadorDao;
import modelos.Equipos;
import modelos.Jugador;
import vistas.ViewEquipos;

public class ControllerEquipos {

	private ViewEquipos vista = new ViewEquipos();
	
	
	public ControllerEquipos() {
	}
	
	public void create(Jugador jugador) {
		EquiposDao dao = new EquiposDaoMySQLImp();
		EquiposDao daoMongo = new EquiposDaoMongoDBImp();
		
	    //dao.create(jugador);
		daoMongo.create(equipos);
	}
}
