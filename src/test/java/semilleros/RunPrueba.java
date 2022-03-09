package semilleros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PagObject.PagObjectAlerts;
import PagObject.PagObjectDatePicker;
import PagObject.PagsObjectDemoQA;
import utilidadesExcel.ReadExcelFile;
import utilidadesExcel.WriteExcelFile;

public class RunPrueba {

	private static WebDriver driver;
	PagObjectDatePicker datePicker;
	PagObjectAlerts alerts;
	Properties propiedades;
	ReadExcelFile leer;
	WriteExcelFile escribir;
	PagsObjectDemoQA demoQA;
	String url = "";
	ClasesBase claseBase;

	@Before
	public void setUp() throws IOException {

		// Instanciar la clase propiedades de javca util
		propiedades = new Properties();

		// Instanciar las lases de excel
		leer = new ReadExcelFile();
		escribir = new WriteExcelFile();
		driver =ClasesBase.chromeDriverConnection();
		// Instanciar la clase pagsObject
		demoQA = new PagsObjectDemoQA(driver);
		datePicker = new PagObjectDatePicker(driver);
		// Instanciar la clase pagsObject
		alerts = new PagObjectAlerts(driver);
		claseBase = new ClasesBase(driver);
		
		// Crear variable tipo InputString
		InputStream entrada = null;

		// Validar si genera error al no encontrar el archivo
		try {
			entrada = new FileInputStream("./Properties/datos.propierties");
			propiedades.load(entrada);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println(e);
		}

	}


	@Test
	public void testDemoQAWebTables() throws Exception {
		// Valida si en la celda de excel se debe ejecutar la prueba
		if (leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 0).equals("Si")) {
			
			// Crear carpeta para almacenamiento de imágenes
			String nomTest = Thread.currentThread().getStackTrace()[1].getMethodName();
			File rutaCarpeta = claseBase.crearCarpeta(propiedades , nomTest);
			
			// Almaceno propiedades en url
			url = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 1);
			// Acceder al método de abrir pagina mercadolibre
			demoQA.urlAcceso(url);			
			// Acceder al metodo de ejecución de cada funcionalidad
			demoQA.IngresoDemoQA(leer, propiedades,rutaCarpeta);
			datePicker.IngresoDemoQA(leer, propiedades,rutaCarpeta);
			alerts.IngresoDemoQA(leer, propiedades, rutaCarpeta);
		}

	}
	
	@After
	public void cerrar() {
		// cerrar proceso
		driver.quit();
	}
}
