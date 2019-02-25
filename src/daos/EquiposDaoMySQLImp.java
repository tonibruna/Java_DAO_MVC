package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import driverMySQL.MySQLConnection;
import idaos.EquiposDao;
import modelos.Equipos;

public class EquiposDaoMySQLImp implements EquiposDao{
	
	@Override
	public boolean create(Equipos equipos) {
		
	boolean created = false;
		
		Statement stm= null;
		Connection con=null;
		
		String sql="INSERT INTO Equiposes values ("+equipos.getNombre()+"','"+equipos.getConferencia()+""
				+ "','"+equipos.getDivision()+"','"+equipos.getCiudad()+"')";
		
		try {			
			con=MySQLConnection.conectar();
			stm= con.createStatement();
			stm.execute(sql);
			created=true;
			stm.close();
			con.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase EquiposDaoMySQLImp, método create");
			e.printStackTrace();
		}
		return created;
	}

	@Override
	public List<Equipos> read() {
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		
		String sql="SELECT * FROM equipos ORDER BY codigo";
		
		List<Equipos> listaEquipos= new ArrayList<Equipos>();
		
		try {			
			co= MySQLConnection.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				
				Equipos e = new Equipos();
				e.setNombre(rs.getString(1));
				e.setConferencia(rs.getString(2));
				e.setDivision(rs.getString(3));
				e.setCiudad(rs.getString(6));
				listaEquiposes.add(e);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase EquiposDaoMySQLImp, método read");
			e.printStackTrace();
		}
		
		return listaEquipos;
	}

	@Override
	public boolean update(Equipos equipos) {
		
		Connection connect= null;
		Statement stm= null;
		
		boolean updated=false;
		
		String sql="UPDATE Equiposes SET nombre='"+equipos.getNombre()+"', procedencia='"+equipos.getConferencia()+"', altura='"+Equipos.getAltura()+"', peso=" + Equipos.getPeso()+", posicion='" + Equipos.getPosicion()+"', nombre_equipo='"+Equipos.getNombre_equipo() +"' WHERE codigo="+Equipos.getCodigo();
		
		try {
			connect=MySQLConnection.conectar();
			stm=connect.createStatement();
			stm.execute(sql);
			updated=true;
		} catch (SQLException e) {
			System.out.println("Error: EquiposDaoMySQLImp, método actualizar");
			e.printStackTrace();
		}		
		return updated;
	}

	@Override
	public boolean delete(Equipos Equipos) {
		Connection con = null;
		Statement stm = null;
		
		boolean removed = false;
		String sql = "DELETE FROM Equiposes WHERE codigo = "+Equipos.getCodigo();
		
		try {
			con = MySQLConnection.conectar();
			stm = con.createStatement();
			stm.execute(sql);
			removed = true;
		} catch (SQLException e) {
			System.out.println("Error: Clase EquiposDaoMySQLImp, método delete");
			e.printStackTrace();
		}
		
		
		return removed;
	}

}
