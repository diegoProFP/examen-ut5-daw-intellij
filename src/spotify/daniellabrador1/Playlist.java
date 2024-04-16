package spotify.daniellabrador1;

import java.util.ArrayList;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5


/**
 * 	Esta clase se encarga de obtener canciones comprobar si existen y añadirlas o no a una Playlist con sus respectivas características
 * @autor daniel.labrador1@educa.madrid.org
 * @version 1.5
 */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.


	/**
	 * Método para obtener a duracion total de la canción.
	 * Se obtiene el total en Segundos siendo Double totalSegundos y se divide entre 60 para obtener la duracion en minutos y segundos.
	 * @return el total de minutos y segundos de la canción.
	 */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}



	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0

	/**
	 * Constructor para añadir la Cancion y agregar una nueva, siendo nueva la cancion y exito si se añade la cancion correctamente
	 * @see Cancion
	 * @param  nueva la nueva cancion
	 * @return exito Se ha llevado a cabo el metodo correctamente
	 * @throws  DatosInvalidosException Muestra: La cancion o su nombre es vacía, si ha sido incorrecta la cancion intruducida
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


	
	// Poner descripcion, parametros de entrada, valor de retorno.
	//Existe desde la version 1.5

	/**
	 * Este método se encarga de encontrar la cancion por su nombre sin ser afectado por las mayusculas y minusculas ayudandose de un while y un contador
	 *
	 * @param nombre nombre de la cancion
	 * @return encontrado Si la cancion coincide con el nombre introducido
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
	 * @param nombreCancion
	 * @return encontrado
	 * @deprecated Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el encontrarCancionPorNombre(String nombre)
	 * @since 1.0
	 */
	@Deprecated
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