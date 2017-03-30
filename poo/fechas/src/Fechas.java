import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Fechas {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//una forma de obtener la fecha actual con Date
		Date fechaActual = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		String cadenaFecha = formato.format(fechaActual);
		//System.out.println(cadenaFecha);
		
		GregorianCalendar miCal = new GregorianCalendar();
		miCal.set(1972, 1, 15);
		cadenaFecha = formato.format(miCal.getTime());
		System.out.println(cadenaFecha);
		
		//una forma de obtener la fecha actual con GregorianCalendar
		GregorianCalendar calendario = new GregorianCalendar();
		cadenaFecha = formato.format(calendario.getTime());
		//System.out.println(cadenaFecha);
		
		//una forma de restar fechas GregorianCalendar
		int numeroDias = 10;
		fechaActual = new Date();
		calendario.add(Calendar.DATE, -numeroDias);		
		cadenaFecha = formato.format(calendario.getTime());
		System.out.println(cadenaFecha);
		calendario = new GregorianCalendar();
		calendario.add(Calendar.DATE, -numeroDias);		
		cadenaFecha = formato.format(calendario.getTime());
		System.out.println(cadenaFecha);

	}

}
