

package spotify.rafaelgaln;

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5
/**
 * Clase Playlist para el programa Spotify que contiene métodos para visualizar información
 * de la playlist o manipularla
 * @author rafael.galn@educa.madrid.org
 * @version 1.5
 */
public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.

	/**
	 * Devuelve los minutos que dura la playlist con valor double
	 * Los minutos se obtienen diviendo la variable totalSegundos de esta clase entre 60
	 * @return totalSegundos/60
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}

	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0

	/**
	 * Devuelve true si al intentar añadir la canción, no está ya la canción y existe como tal
	 * Devuelve excepción si el string proporcionado está vacio
	 * @param nueva
	 * @return exito
	 * @throws DatosInvalidosException
	 * @since 1.0
	 * @see Cancion
	 * @see DatosInvalidosException
	 */
	public boolean agregarCancion(Cancion nueva) throws DatosInvalidosException {

		boolean exito = false;
		if (canciones == null) {
			this.canciones = new ArrayList<>();
		}
		if (nueva == null || nueva.getNombre() == null) {
			throw new DatosInvalidosException("La cancion o su nombre es vacía");
		}

		boolean existeCancion = this.encontrarCancionPorNombre(nueva.getNombre());
		if (!existeCancion) {
			exito = canciones.add(nueva);
		}

		return exito;
	}


	
	// Poner descripcion, parametros de entrada, valor de retorno.
	//Existe desde la version 1.5

	/**
	 * Devuelve true si consigue encontrar la canción mediante el nombre proporcionado
	 * @param nombre
	 * @return encontrado
	 * @since 1.5
	 */
	public boolean encontrarCancionPorNombre(String nombre) {
		boolean encontrado = false;
		int contador = 0;
		while (!encontrado && contador < canciones.size()) {

			// Si el nombre de la cancion obtenida en cada vuelta es igual a la que se
			// quiere
			if (canciones.get(contador).getNombre().equalsIgnoreCase(nombre)) {
				encontrado = true;
			}

			contador++;
		}

		return encontrado;
	}
	
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0

	/**
	 * Devuelve true si encuentra la canción mediante el nombre proporcionado
	 * @deprecated
	 * @since 1.0
	 * @param nombreCancion
	 * @return encontrado
	 */
	public boolean encontrarCancion(String nombreCancion) {
		boolean encontrado = false;

		for (int cont = 0; cont < canciones.size(); cont++) {
			Cancion cancionExtraida = this.canciones.get(cont);
			if (cancionExtraida.getNombre().equals(nombreCancion)) {
				encontrado = true;
				break;
			}
			
		}
		return encontrado;
	}

	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTotalSegundos() {
		return totalSegundos;
	}

	public void setTotalSegundos(int totalSegundos) {
		this.totalSegundos = totalSegundos;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
}