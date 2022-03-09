package semilleros;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MapsObjectInicio extends ClasesBase {
	// constructor de la clase
	public MapsObjectInicio(WebDriver driver) {
		super(driver);
	}
	
	//elementos de la Pagina inical
	By txtBusquedaGoogle= By.name("q");
	By btnBuscar= By.name("btnK");
	By resultado =By.xpath("//h3[contains(text(),'Periferia IT Group – Somos innovación en tecnologí')]");
}
