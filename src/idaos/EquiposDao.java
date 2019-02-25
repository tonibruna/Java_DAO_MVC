package idaos;

import java.util.List;

import modelos.Equipos;

public interface EquiposDao {
	
	public boolean create(Equipos equipos);
	public List<Equipos>read();
	public boolean update(Equipos equipos);
	public boolean delete(Equipos equipos);
	
}
