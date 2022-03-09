package PagObject;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import MapObjectDemoQA.MapObjectDatePicker;
import utilidadesExcel.ReadExcelFile;

public class PagObjectDatePicker extends MapObjectDatePicker {

	// Crear constructor de la clase
	public PagObjectDatePicker(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	// M�todo inicial Abrir link

	public void urlAcceso(String url) {
		driver.get(url);
	}

	// M�todo para escribir en buscador
	public void IngresoDemoQA(ReadExcelFile leer, Properties propiedades, File rutaCarpeta) throws Exception {

		

		// Inicio flujo
		click(btnWidgets, rutaCarpeta);
		click(btnDatePicker, rutaCarpeta);
		click(btnSelectDate, rutaCarpeta);		
		
		String mesDP = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 3);
		String a�oDP = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 2);
		String diaDP = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 5);
		String numDiaDP = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 4);
		// Seleccionar mes y a�o
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 2), txtSelectDateYear,rutaCarpeta);
		sendKey(leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 3), txtSelectDateMonth,rutaCarpeta);
		driver.findElement(By.xpath("(//div[@aria-label='Choose "+diaDP+", "+mesDP+" "+numDiaDP+", "+a�oDP+"'])[1]")).click();
		tiempoEspera(2000);
		click(txtDateAndTime, rutaCarpeta);

		// Seleccionar mes y a�o
		String mesDAT = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 6);
		String a�oDAT = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 9);
		String diaDAT = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 7);
		String numDiaDAT = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 8);
		String horaDAT = leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 10);;

		// traer el valor del titulo del calendario para identificar mes y a�o
		String monthYearValue = driver.findElement(By.cssSelector(rutaCss)).getText();
		
		// Asigno el valor de mes y a�o segun el formato recibido //February 2022
		String month = monthYearValue.split(" ")[0].trim();
		String year = monthYearValue.split(" ")[1].trim();
		//M�todo para validar si el a�o es igual o mayor al presente
		if (Integer.parseInt(a�oDAT) >= Integer.parseInt(year)) {
			while (!month.equals(mesDAT) && year.equals(a�oDAT)) {
				click(btnNextMonthDAT, rutaCarpeta);
//				monthYearValue = driver.findElement(By.cssSelector(".react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown")).getText();
				monthYearValue = driver.findElement(By.cssSelector(rutaCss)).getText();
				

				month = monthYearValue.split(" ")[0].trim();
				year = monthYearValue.split(" ")[1].trim();
			}
			while (!month.equals(mesDAT) && year.equals(a�oDAT)) {
				click(btnPreviousMonthDAT, rutaCarpeta);
				monthYearValue = driver.findElement(By.cssSelector(rutaCss)).getText();
				

				month = monthYearValue.split(" ")[0].trim();
				year = monthYearValue.split(" ")[1].trim();
			}
			driver.findElement(By.xpath("(//div[@aria-label='Choose "+diaDAT+", "+mesDAT+" "+numDiaDAT+", "+a�oDAT+"'])[1]")).click();
			driver.findElement(By.xpath("(//li[normalize-space()='"+horaDAT+"'])[1]")).click();
		}else if (Integer.parseInt(a�oDAT) > Integer.parseInt(year)) {
			while (!month.equals(mesDAT) && year.equals(a�oDAT)) {
				click(btnNextMonthDAT, rutaCarpeta);
				monthYearValue = driver.findElement(By.cssSelector(rutaCss)).getText();
				

				month = monthYearValue.split(" ")[0].trim();
				year = monthYearValue.split(" ")[1].trim();
			}
			driver.findElement(By.xpath("(//div[@aria-label='Choose "+diaDAT+", "+mesDAT+" "+numDiaDAT+", "+a�oDAT+"'])[1]")).click();
			driver.findElement(By.xpath("(//li[normalize-space()='"+horaDAT+"'])[1]")).click();
		}else{
			while (!month.equals(mesDAT) && !year.equals(a�oDAT)) {
				
				click(btnPreviousMonthDAT, rutaCarpeta);
				monthYearValue = driver.findElement(By.cssSelector(rutaCss)).getText();
				

				month = monthYearValue.split(" ")[0].trim();
				year = monthYearValue.split(" ")[1].trim();
			
			}
			driver.findElement(By.xpath("(//div[@aria-label='Choose "+diaDAT+", "+mesDAT+" "+numDiaDAT+", "+a�oDAT+"'])[1]")).click();
			driver.findElement(By.xpath("(//li[normalize-space()='"+horaDAT+"'])[1]")).click();
		}
		
		click(btnHome, rutaCarpeta);
		tiempoEspera(2000);

	}
}