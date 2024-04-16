package spotify.josedos4;

import java.util.ArrayList;
import java.util.List;


/**
 * Clase Playlist que almacena el nombre,total de segundos de la cancion y una lista privada de canciones
 * @autor jose.dos4@educa.madrid.org
 * @version 1.5
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	/**
	 * Se obtiene los minutos calculando totalSegundos entre 60
	 * @return el valor en minutos
	 */

	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}


	/**
	 *
	 * @param nueva recibe el parametro de la clase Cancion
	 * @return devuelve si se puede añadir la cancion o no
	 * @throws DatosInvalidosException
	 * @since 1.0
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


	/**
	 *
	 * @param nombre parametro de entrada usado en este metodo.
	 * @return devuelve la pposicion en la que esta la cancion si existe.
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
	/**
	 * @deprecated Este metodo esta obsoleto porque se ha hecho uno mejor {@link #encontrarCancionPorNombre(String)}
	 * @param nombreCancion parametro de entrada usado en este metodo.
	 * @return devueleve si se ha encontrado la canción.
	 * @since 1.0
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