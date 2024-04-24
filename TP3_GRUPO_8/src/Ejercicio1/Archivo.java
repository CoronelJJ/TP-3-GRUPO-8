package Ejercicio1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;





public class Archivo {

	private String ruta;
	private TreeSet<Persona> listaPersonas;
	
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public boolean creaArchivo()
	{
		FileWriter escritura;
		try {
			escritura = new FileWriter(ruta, true);
			escritura.write("");
			escritura.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
			
	}
	
	public void EscribirArchivoResultado(Persona persona) 
	{
		
		try 
		{	
			FileWriter entrada = new FileWriter("src/Resultado.txt", true);
			BufferedWriter miBuffer = new BufferedWriter(entrada);
			miBuffer.write(persona.toString());
			miBuffer.newLine();
			miBuffer.close();
			entrada.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void rellenarListaPersonas() {		
		
		FileReader archivo;
		
		try {
			archivo = new FileReader(ruta);
			BufferedReader lectorLinea = new BufferedReader(archivo);
			
			listaPersonas = new TreeSet<>();
			
			String linea = "";
			
			while ((linea=lectorLinea.readLine()) != null) {
					
					String[] datosLinea = new String[3];
					datosLinea = linea.split("-", 3);
										
				try {
					if(datosLinea.length==3) {
						
						DNI.verificarDniInvalido(datosLinea[2]);
						
						Persona auxPersona = new Persona(datosLinea[0],datosLinea[1],datosLinea[2]);					
						listaPersonas.add(auxPersona);
					}
				}
					catch(DniInvalido e) {
						System.out.println("DNI invalido detectado");
					}
					
			}
			archivo.close();
			lectorLinea.close();
		}
		
		catch(IOException e){
			System.out.println("No se pudo leer el archivo");
		}				
		
	}
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	
}
