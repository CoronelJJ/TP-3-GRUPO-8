package Ejercicio1;

public class Persona implements Comparable<Persona>{

	private String nombre;
    private String apellido;
    private String dni;
    
    public Persona() {
		
	}
    
	public Persona(String nombre, String apellido, String dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return nombre + "-" + apellido + "-" + dni;
	}
	
	 public int hashCode() {
	        return dni.hashCode();
	    }

	@Override
	   public boolean equals(Object obj) {
     if (obj == this) return true;
     if (!(obj instanceof Persona)) return false;
     Persona otraPersona = (Persona) obj;
     return this.dni.equals(otraPersona.getDni());
 }

	@Override
	public int compareTo(Persona p) {
		 int comparacion = this.apellido.compareToIgnoreCase(p.apellido);
		  
		    if (comparacion == 0) {
		        return 0;
		    }
		    return comparacion;
	}
	
	
	
	
	
}
