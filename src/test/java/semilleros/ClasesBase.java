package semilleros;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utilidadesExcel.ReadExcelFile;

public class ClasesBase {
	protected WebDriver driver;
	

	// Constructor de la clase
	public ClasesBase(WebDriver driver) {
		super();
	}

	// Método de navegador
	public static WebDriver chromeDriverConnection() {
		// Setear las opciones del navegador
		WebDriver _driver = null;
		try {
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		// Setear las propiedades del navegador
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");		 
		_driver = new ChromeDriver();
		
		// Maximiza el navegador		
		_driver.manage().window().maximize();
		return _driver;
	}catch (Exception e){
		System.out.println(e);			
	}
		return _driver;
	}
	// Método Click
	public void click(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).click();
		tiempoEspera(2000);
		captureScreen(rutaCarpeta);
	}

	// Método Borrar
	public void borrar(By locator, File rutaCarpeta) throws Exception {

		driver.findElement(locator).clear();
		captureScreen(rutaCarpeta);
	}

	// Método enviar texto
	public void sendKey(String inputText, By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).sendKeys(inputText);
		captureScreen(rutaCarpeta);
	}

	// Método enter Submit
	public void submit(By locator, File rutaCarpeta) throws Exception {
		driver.findElement(locator).submit();
		captureScreen(rutaCarpeta);
	}

	// Método tiempo de espera
	public void tiempoEspera(long tiempo) throws InterruptedException {
		Thread.sleep(tiempo);
	}

	public String fechaHora() {
		// TOMAMOS LA FECHA DEL SISTEMA
		LocalDateTime fechaSistema = LocalDateTime.now();
		// DEFINIR FORMATO FECHA
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
		// DAR FORMATO A LA FECHA DEL SITEMA
		String formatFecha = fecha.format(fechaSistema);
		return formatFecha;
	}

	public String horaSistema() {

		// Tomamos La fecha del sistema
		LocalTime horaSistema = LocalTime.now();

		// Definir formato de hora
		DateTimeFormatter fecha = DateTimeFormatter.ofPattern("HHmmss");

		// dar formato a la fecha del sistema
		String hora = fecha.format(horaSistema);
		return hora;

	}

	public void captureScreen(File rutaCarpeta) throws Exception {
		String hora = horaSistema();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Rectangle screenRectangle = new Rectangle(screenSize);
		Robot robot = new Robot();
		BufferedImage image = robot.createScreenCapture(screenRectangle);
		ImageIO.write(image, "png", new File(rutaCarpeta + "/" + hora + ".jpg"));
	}

	public File crearCarpeta(Properties propiedades, String nomTest) {

		// Almacenamos la fecha del sistema
		String fecha = fechaHora();

		// Creamos el nombre de la carpeta
		String nomCarpeta = nomTest + "-" + fecha;

		// Obtenemos la ruta de alojamiento de salida y el nombre dek test a ejecutar
		File directorio = new File("./output/" + nomCarpeta);

		// Creamos la carpeta
		directorio.mkdir();
		return directorio;
	}

	// Método inicial
	public void urlAcceso(String url) {
		driver.get(url);
	}

	protected int posicionEliminado = 53;

	
	//metodo Busqueda fecha
	
	public void busquedaFecha(ReadExcelFile leer, Properties propiedades) throws Exception{
		leer.getCellValue(propiedades.getProperty("filePathExcel"), "Hoja2", 1, 10);
	}

}