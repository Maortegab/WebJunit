package MapObjectDemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import semilleros.ClasesBase;

public class MapObjectAlerts extends ClasesBase {
	
	// constructor de la clase
		public MapObjectAlerts(WebDriver driver) {
			super(driver);
		} 

	//Ingresamos al menú alerts
	protected By btnAlertsFrameWindows = By.xpath("//div[3]//div[1]//div[2]//*[name()='svg']");
	protected By btnAlerts = By.xpath("//span[normalize-space()='Alerts']");
	
	//Botones de alerta
	
	//See alert
	protected By btnSeeAlert = By.xpath("(//button[@id='alertButton'])[1]");
	//Time alert
	protected By btnSTimeAlert = By.xpath("//button[@id='timerAlertButton']");
	//Confirm alert
	protected By btnConfirmAlert = By.xpath("(//button[@id='confirmButton'])[1]");
	//TextBox
	protected By btnTextBoxAlert = By.xpath("(//button[@id='promtButton'])[1]");	
	protected By btnHome= By.xpath("(//img[@src='/images/Toolsqa.jpg'])[1]");
	
	
}
