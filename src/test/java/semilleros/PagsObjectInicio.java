package semilleros;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import utilidadesExcel.ReadExcelFile;

public class PagsObjectInicio extends MapsObjectInicio {

//Crear constructor de la clase
	public PagsObjectInicio(WebDriver driver) {
		super(driver);
	}

	// Metodo primera prueba
	public void busquedaInicial(ReadExcelFile leer, Properties propiedades) throws Exception {

		// Crear carpeta para almacenamiento de imágenes
		File rutaCarpeta = crearCarpeta(propiedades,"ingresar String");
		// Enviamos el valor de busqueda al navegador
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 1), txtBusquedaGoogle,rutaCarpeta);
		submit(txtBusquedaGoogle, rutaCarpeta);
		tiempoEspera(2000);
		click(resultado, rutaCarpeta);
		tiempoEspera(2000);
		driver.close();
	}

}
