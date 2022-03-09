package MapObjectDemoQA;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import semilleros.ClasesBase;


public class MapObjectDatePicker extends ClasesBase {
	// constructor de la clase
	public MapObjectDatePicker(WebDriver driver) {
		super(driver);
	}
	
	
	// Ingreso a menu date picker
	protected By btnWidgets = By.xpath("(//h5[normalize-space()='Widgets'])[1]");
	protected By btnDatePicker = By.xpath("//div[@class='element-list collapse show']//li[@id='item-2']");
	// Select Day, month and day
	protected By btnSelectDate = By.xpath("(//input[@id='datePickerMonthYearInput'])[1]");
	protected By txtSelectDateYear = By.xpath("(//select[@class='react-datepicker__year-select'])[1]");
	protected By txtSelectDateMonth = By.xpath("(//select[@class='react-datepicker__month-select'])[1]");
	protected By txtSelectDateDay = By.xpath("(//div[@aria-label='Choose Friday, June 22nd, 1990'])[1]");

	// Ingreso a menu date and time
	protected By txtDateAndTime = By.xpath("(//input[@id='dateAndTimePickerInput'])[1]");
	public String rutaCss = ".react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown";
	protected By btnMontYearValDAT = By.className(".react-datepicker__current-month.react-datepicker__current-month--hasYearDropdown.react-datepicker__current-month--hasMonthDropdown");
	
	protected By btnNextMonthDAT = By.xpath("(//button[normalize-space()='Next Month'])[1]");
	protected By btnPreviousMonthDAT = By.xpath("(//button[normalize-space()='Previous Month'])[1]");
	protected By btnHome= By.xpath("(//img[@src='/images/Toolsqa.jpg'])[1]");


	
	
	
	

}