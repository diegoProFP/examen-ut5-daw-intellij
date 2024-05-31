package spotify.adrian.duenas;

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5
/**
 * Esta es la clase playlist en la que su constructor  almacenara el nombre de la cancion , los segundos totales y una lista de la cancion
 * @author adrianduenas
 * @version 1.5
 * */

public class Playlist {

	private String nombre;
	private int totalSegundos;
	private List<Cancion> canciones;

	
	// Poner descripcion, valor de retorno.
	//En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.
	/**
	 * Con este método obtendremos la duracion total de la cancion mediante dividir el total de los segundos entre 60
	 * @return  Devolvera el total de segundos entre 60 y es de tipo double
	 * */
	public double obtenerDuracionTotal() {
		return (double) totalSegundos / 60;
	}
		
		
		
	// Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
	// referenciar tanto a las clases Cancion y DatosInvalidosException
	//Existe desde la version 1.0

	/**
	 * Con este método vamos a intruducir una nueva canción
	 * @param  nueva Es un valor de tipo Cancion lo usaremos para saber que cancion es
	 * @throws spotify.RicardoVillarroelMiranda.DatosInvalidosException lanza esta excepcion
	 * @see Cancion vamos a utilizar el constructor de la clase cancion
	 * @see  Exception es la clase de donde proviene la excepcion lanzada
	 * @return  Exito nos devolvera si ha sido posible o no agregar la cancion mediante un boolean
	 * @since  1.0
	 * */

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
	 * Este método nos va a servir para encontrar la cancion deseada , sabiendo el nombre de la canción que el usuario a puesto
	 * @param  nombre valor que representa el nombre de la cancion de tipo String
	 * @return encontrado nos devolvera si ha sido posible encontrar la cancion o  no
	 * @since  1.5
	 * */
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
	 * Este método esta obsoleto porque se ha hecho el método encontrarCancionPorNombre(String nombre) que sustitye a este
	 * @deprecated
	 * @since 1.0
	 * */
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