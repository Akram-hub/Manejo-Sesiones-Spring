package org.amoumni.practicaSesiones.model;

import java.util.LinkedHashMap;

public class Colecciones {
	
	public static LinkedHashMap<String,String[]> datosNavegacion = new LinkedHashMap<String,String[]>();

	static {
		
		datosNavegacion.put("1", new String[]{"uno", "numero1.jpg", "/paso/uno"});
		datosNavegacion.put("2", new String[]{"dos", "numero2.jpg", "/paso/dos"});
		datosNavegacion.put("3", new String[]{"tres", "numero3.jpg", "/paso/tres"});	
		datosNavegacion.put("4", new String[]{"cuatro", "final.jpg", "/paso/cuatro"});
	
	}

}
