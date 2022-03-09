package MapObjectDemoQA;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import semilleros.ClasesBase;

public class MapsObjectDemoQA extends ClasesBase {
	// constructor de la clase
	public MapsObjectDemoQA(WebDriver driver) {
		super(driver);
	}
	
	
	//Elementos para ingresar a DemoQA/elements/registroNuevo
	protected By btnElements= By.xpath("(//*[name()='svg'][@stroke='currentColor'])[1]");	
	protected By btnWebTablet= By.xpath("//span[normalize-space()='Web Tables']");
	protected By btnAdd = By.xpath("//button[@id='addNewRecordButton']");
	protected By txtFirstName= By.xpath(" //input[@id='firstName']");
	protected By txtLastName= By.xpath("//input[@id='lastName']");
	protected By txtEmail= By.xpath("//input[@id='userEmail']");
	protected By txtAge= By.xpath("(//input[@id='age'])[1]");
	protected By txtSalary= By.xpath("(//input[@id='salary'])[1]");
	protected By txtDepartment= By.xpath("(//input[@id='department'])[1]");
	protected By btnSubmit= By.xpath("(//button[normalize-space()='Submit'])[1]");
		
	//Elementos para eliminar un registro de la tabla en DemoQA/elements
	protected By btnDelete = By.xpath("(//*[name()='path'])[57]");

	protected By btnHome= By.xpath("(//img[@src='/images/Toolsqa.jpg'])[1]");
	
	
	
}