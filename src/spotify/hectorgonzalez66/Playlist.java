package spotify.hectorgonzalez66;

import java.util.ArrayList;
import java.util.List;

/**clase que permite obtener la duracion de una playlist, agregar una cancion a una playlist y/o buscar una cancion segun su nombre
 * @author hector.gonzalez66@educa.madrid.org
 * @version 1.5
 * */
//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5


public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	/**los minutos se obtienen dividiendo totalSegundos entre 60
	 * @return totalSegundos/60
	 * */
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		/** se cmprueba si se puede añadir una cancion comprobando si ya existe una (en ese caso no se puede)
		 * @see Cancion
		 * @see DatosInvalidosException
		 * @param nueva
		 * @return exito
		 * @exception DatosInvalidosException
		 * @version 1.0*/
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0
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


	/**se comprueba si se comprueban todas las canciones por si coincide con el nombre que se desea
	 * @param nombre
	 * @return encontrado
	 * @version 1.5*/
	// Poner descripcion, parametros de entrada, valor de retorno.
	//Existe desde la version 1.5
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
	 * @deprecated encontrarCancionPorNombre(String nombre)
	 * @since 1.0*/
	// Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
	// encontrarCancionPorNombre(String nombre)
	//Existe desde la version 1.0
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