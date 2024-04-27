package spotify.sergiogago2;

import java.util.ArrayList;
import java.util.List;

//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5

/**
 * Clase que contiene la lista donde agregaremos las canciones controlando no repetirlas.
 *
 * @author sergio.gago2
 * @version 1.5
 */
public class Playlist {

    private String nombre;
    private int totalSegundos;
    private List<Cancion> canciones;


    // Poner descripcion, valor de retorno.
    //En los comentarios describir cómo se obtienen los minutos y a partir de qué dato de la clase.

    /**
     * Calcula la duración total en minutos a partir de el atributo totalSegundos de la clase
     *
     * @return valor double con duración total en minutos.
     */
    public double obtenerDuracionTotal() {
        return (double) totalSegundos / 60;
    }


    // Poner descripcion, parametros de entrada, valor de retorno, y excepción. Además que pueda
    // referenciar tanto a las clases Cancion y DatosInvalidosException
    //Existe desde la version 1.0

    /**
     * Método para agregar canciones comprobando primero si existe la lista canciones, sino la crea y luego comprueba si existe la canción que queremos agregar.
     *
     * @param nueva de tipo Cancion que especifica un objeto creado de Cancion
     * @return Devuelve true si se ha añadido nueva canción o false en caso contrario.
     * @throws DatosInvalidosException Devuelve error en caso de cancion nula o nombre de cancion nulo
     * @see Cancion
     * @see DatosInvalidosException
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
     * Método utilizado para encontrar canciones por nombre.
     *
     * @param nombre de tipo String que especifica el nombre que queremos buscar
     * @return Devuelve true si se ha encontrado la canción por nombre o false en caso contrario.
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
     * Método utilizado para encontrar canciones por nombre.
     *
     * @param nombreCancion de tipo String que especifica el nombre de la canción que queremos buscar.
     * @return Devuelve true si ha encontrado la canción y false en caso contrario.
     * @since 1.0
     * @deprecated método remplazado por {@link #encontrarCancionPorNombre(String)}
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