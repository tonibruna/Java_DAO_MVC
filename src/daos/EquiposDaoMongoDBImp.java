package daos;

import java.util.List;

import driverMongoDB.MongoDBConnection;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

import com.mongodb.MongoClient;
import com.mongodb.client.*;


import com.mongodb.client.FindIterable; 
import com.mongodb.client.MongoCollection; 
import com.mongodb.client.MongoDatabase;  
import org.bson.Document;

import java.util.ArrayList;
import java.util.Iterator; 



import idaos.EquiposDao;
import modelos.Equipos;

public class EquiposDaoMongoDBImp implements EquiposDao {

	@Override
	public boolean create(Equipos equipos) {
		
		boolean created = false;
		
		try {			
			
			MongoDBConnection mdbc = new MongoDBConnection();
			MongoCollection coleccion= mdbc.getCollection("equipos");
			
			Document doc = new Document();
			
			doc.append("nombre",equipos.getNombre());
			doc.append("ciudad",equipos.getCiudad());
			doc.append("conferencia", equipos.getConferencia());
			doc.append("division", equipos.getDivision());
	
			coleccion.insertOne(doc);
			created = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Equipos> read() {
		
		MongoDBConnection mdbc = new MongoDBConnection();
		MongoCollection coleccion= mdbc.getCollection("equipos");
		MongoCursor<Document> cursor = coleccion.find().iterator();
		
		List<Equipos> listaequipos= new ArrayList<Equipos>();
		
		try {
		    while (cursor.hasNext()) {   
		    	
		        Document dbObj = cursor.next();
		        
		        String nombre = dbObj.getString("Nombre");
		        String conferencia = dbObj.getString("conferencia");
		        String ciudad = dbObj.getString("ciudad");
		        String division = dbObj.getString("division");
		        Equipos e = new Equipos(nombre, ciudad, conferencia, division);
		        
		        listaequipos.add(e);
		    }
		} finally {
		    cursor.close();
		}
		
		return listaequipos;
	}

	@Override
	public boolean update(Equipos equipos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Equipos equipos) {
		// TODO Auto-generated method stub
		return false;
	}

}
