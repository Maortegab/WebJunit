package PagObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import MapObjectDemoQA.MapsObjectDemoQA;
import semilleros.MapsObjectInicio;
import utilidadesExcel.ReadExcelFile;

public class PagsObjectDemoQA extends MapsObjectDemoQA {

	// Crear constructor de la clase
	public PagsObjectDemoQA(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void IngresoDemoQA(ReadExcelFile leer, Properties propiedades,File rutaCarpeta) throws Exception {

		// Crear carpeta para almacenamiento de imágenes
		

		click(btnElements,rutaCarpeta);
		click(btnWebTablet, rutaCarpeta);
		click(btnAdd, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 2), txtFirstName,rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 3), txtLastName, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 4), txtEmail, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 5), txtAge, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 6), txtSalary, rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja1", 1, 7), txtDepartment, rutaCarpeta);
		click(btnSubmit, rutaCarpeta);
		
		
		click(btnDelete, rutaCarpeta);
		tiempoEspera(3000);
		//Regresamos a Home
		click(btnHome, rutaCarpeta);
		tiempoEspera(2000);
		
		//Finaliza el flujo y se cierra la ventana
//		driver.close();
	}
}
