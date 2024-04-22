package Ejercicio1;

public class DNI {
	private String dni;
	
	public DNI() {
		
	}
	public DNI(String dni) {
		this.dni=dni;
	}
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	public static boolean verificarDniInvalido(String dni) throws DniInvalido { 
		boolean dniInvalido=false;
		for(int i=0;i<dni.length();i++){
			if(!Character.isDigit(dni.charAt(i))) {
				dniInvalido=true;
				break;
			}
		}
		if(dniInvalido) {
			throw new DniInvalido();
		}
		return true;
	}
	
}
