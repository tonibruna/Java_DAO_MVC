//esta clase define las interfaces

package idaos;

import java.util.List;

import modelos.Jugador;

public interface JugadorDao {
	
	public boolean create(Jugador jugador);
	public List<Jugador>read();
	public boolean update(Jugador jugador);
	public boolean delete(Jugador jugador);
	
}
