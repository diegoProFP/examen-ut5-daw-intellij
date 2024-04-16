package spotify.beatrizruiz7;

import java.util.Objects;


public class Cancion {

    private String nombre;
    private int numSegundos;
    private String genero;
    private int annoCreacion;
    private boolean tieneLetra;
    
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNumSegundos() {
		return numSegundos;
	}
	public void setNumSegundos(int numSegundos) {
		this.numSegundos = numSegundos;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getAnnoCreacion() {
		return annoCreacion;
	}
	public void setAnnoCreacion(int annoCreacion) {
		this.annoCreacion = annoCreacion;
	}
	public boolean isTieneLetra() {
		return tieneLetra;
	}
	public void setTieneLetra(boolean tieneLetra) {
		this.tieneLetra = tieneLetra;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(nombre, other.nombre);
	}

    

}