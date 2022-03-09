package PagObject;

import java.io.File;
import java.util.Properties;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MapObjectDemoQA.MapObjectAlerts;
import utilidadesExcel.ReadExcelFile;

public class PagObjectAlerts extends MapObjectAlerts {

	// Crear constructor de la clase
	public PagObjectAlerts(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// Método inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// Método para escribir en buscador
	public void IngresoDemoQA(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {

		
		
		
		//Inicio flujo
		click(btnAlertsFrameWindows, rutaCarpeta);
		click(btnAlerts, rutaCarpeta);
		
		//Interacción con botones
		click(btnSeeAlert, rutaCarpeta);
		driver.switchTo().alert().accept();		
		tiempoEspera(1000);
		
		click(btnSTimeAlert, rutaCarpeta);	
		tiempoEspera(6000);
		driver.switchTo().alert().accept();		
		tiempoEspera(1000);
		
		click(btnConfirmAlert, rutaCarpeta);
		driver.switchTo().alert().accept();		
		tiempoEspera(1000);
		
		click(btnConfirmAlert, rutaCarpeta);
		driver.switchTo().alert().dismiss();		
		tiempoEspera(1000);
		
		
		click(btnTextBoxAlert, rutaCarpeta);			
		Alert alerta = driver.switchTo().alert();
		alerta.sendKeys(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja3", 1, 2));		
		alerta.accept();
		
		tiempoEspera(1000);
		click(btnHome, rutaCarpeta);	
	}
	
}
