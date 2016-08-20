package br.com.barcard.util;

import java.text.DateFormat;
import java.text.Normalizer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

@SuppressWarnings("deprecation")
public class DataUtil {

	public static void main(String[] args) {
		
		System.out.println(somarDia(new Date(), 2));
	}

	public static long intervaloDias(Date dtIni,Date dtFim){
		return (dtFim.getTime() - dtIni.getTime()) / (1000*60*60*24);
	}

	public static Date somarDia(Date data,Integer qtdDias){
		if(data != null && qtdDias != null){
			Calendar cal = Calendar.getInstance();  
	        
	        cal.setTime(data);
	        cal.add(Calendar.DAY_OF_MONTH, qtdDias);
	        
			return cal.getTime();
		}
		return null;
	}
	
	public static String removeAcentos(String str) {
		  str = Normalizer.normalize(str, Normalizer.Form.NFD);
		  str = str.replaceAll("[^\\p{ASCII}]", "");
		  return str;
	}
	
	public static Date getDataSomarDiasUteis(Date dataInicial,int qtdDias){
		Date data = new Date();
		int qtdDiasUteisSoma = 0;
		
		Calendar cal = Calendar.getInstance();  
		cal.setTime(data);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		for (int i = 0; i < qtdDias; i++) {
			day++;
			if(day == 1 || day == 7){
				qtdDiasUteisSoma++;
			}
			if(day==7)day = 0;
		}
		data.setDate(dataInicial.getDate() + (qtdDias+qtdDiasUteisSoma));
		return data;
	}
	
	public static Date somarAno(Date data,int qtdAno){
		Calendar cal = Calendar.getInstance();  
        
        cal.setTime(data);
        cal.add(Calendar.YEAR, qtdAno);
        
		return cal.getTime();
	}
	
	public static Date subtrairAno(Date data,int qtdAno){
		Calendar cal = Calendar.getInstance();  
        
        cal.setTime(data);
        cal.add(Calendar.YEAR, qtdAno * -1);
        
		return cal.getTime();
	}
	
	public static int getAno(Date data){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		return Integer.parseInt(sdf.format(data));
	}
	
	/** DATA ATUAL **/
	public static Date getDataAtual() {
		return new Date();
	}

	/** DATA ATUAL **/
	public static String getDataAtualPorExtenso() {
		return getDataPorExtenso(getDataAtual());
	}
	
	/** DIA ATUAL **/
	public static Integer getDiaAtual() {
		Calendar calendar = Calendar.getInstance();
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		return dia;
	}
	
	/** DIA POR DATA **/
	public static Integer getDiaPorData(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dia = calendar.get(Calendar.DAY_OF_MONTH);
		return dia;
	}
	
	/** MES POR DATA **/
	public static Integer getMesPorData(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dia = calendar.get(Calendar.MONTH);
		return dia + 1;
	}
	
	/** ANO POR DATA **/
	public static Integer getAnoPorData(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dia = calendar.get(Calendar.YEAR);
		return dia;
	}

	/** MES ATUAL **/
	public static Integer getMesAtual() {
		Calendar calendar = Calendar.getInstance();
		int mes = calendar.get(Calendar.MONTH);
		mes++;
		return mes;
	}
	
	/** ANO ATUAL **/
	public static Integer getAnoAtual() {
		Calendar calendar = Calendar.getInstance();
		int ano = calendar.get(Calendar.YEAR);
		return ano;
	}
	
	/** DATA POR EXTENSO **/
	public static String getDataPorExtenso(Date dt) {
	
		int d = dt.getDate();
	    int m = dt.getMonth()+1;
	    int a = dt.getYear()+1900;
	    
	    String hora = dateToString(dt, "HH:mm");
	    
	    Calendar data = new GregorianCalendar(a, m-1, d);
	    int ds = data.get(Calendar.DAY_OF_WEEK);
	 
	    return(d + " de " + getMesNome(m, false) + " de " +
	      a + " (" + getDiaSemanaNome(ds, 0) + ")  �s "+ hora);
	}
	
	/** DIA DA SEMANA - NOME **/
	private static String getDiaSemanaNome(int i, int tipo) {
	    String diasem[] = {"Domingo", "Segunda-feira", "Ter�a-feira",
	      "Quarta-feira", "Quinta-feira", "Sexta-feira", "S�bado"};
	    if (tipo == 0)
	       return(diasem[i-1]); // extenso
	    else return(diasem[i-1].substring(0, 3));
	}
	  
	/** MES - NOME **/
	public static String getMesNome(int i, boolean abreviado) {
		    String mes[] = {"Janeiro", "Fevereiro", "Mar�o", "Abril",
		      "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
		      "Novembro", "Dezembro"};
		    if (abreviado)
		       return(mes[i-1].substring(0, 3)); // abreviado
		    else
		      return(mes[i-1].substring(0, 3)); // abreviado
	 }
	
	/** DATE TO STRING **/
	public static String dateToString(Date data, String formato) {
			SimpleDateFormat fmt = new SimpleDateFormat(formato);
			try {
				return fmt.format(data);
			} catch (Exception ex) {
				return "";
			}
	 }
	
	/**
	 * Converte String em Date
	 * @param data - String a ser formatada.
	 * @param formato - Formato em um padr�o v�lido ex.: "dd/MM/yyyy"
	 * @return Date
	 * @throws ParseException
	 */
	public static Date stringToDate (String data, String formato){   
		if (data == null || data.equals(""))  
			return null;  

		Date date = null;  
		try {  
			DateFormat formatter = new SimpleDateFormat(formato);  
			date = formatter.parse(data);
		} catch (ParseException e) {              
			e.printStackTrace();  
		} catch (Exception e) {              
			e.printStackTrace();  
		}  
		return date;  
	}  
	
	/** JUNTAR DATA E HORA E TRANSFORMA EM DATETIME **/
	public static Date getDateTime(Date data, Date hora) {
		
		if (data == null || hora == null) {
			return null;
		}
		
		 /** SETA A DATA **/
		 Date dataFinal = new Date(data.getTime());
		 
		 /** SETA A HORA **/
		 dataFinal.setHours(hora.getHours());
		 return dataFinal;
	}
	
	/** RETORNA DUAS DATAS - INICIO E FIM DA SEMANA **/
	public static List<Date> getDataPeriodoSemana(Date data) {
		 List<Date> listDate = new ArrayList<Date>();
		 Date dataInicial    = new Date(data.getTime());
		 Date dataFinal      = new Date(data.getTime()); 
		 
	
		int dia_da_semana   = data.getDay(); 
		 
		 /** DOMINGO INICIO DA SEMANA **/
		 if (dia_da_semana == 0) {
			 dataInicial = subtrairDias(dataInicial, 6) ;
			
		 } else {
			 while (dia_da_semana != 0) {
				 dataInicial = subtrairDias(dataInicial, 1) ;
				 dia_da_semana = dataInicial.getDay(); 
			 }
		 }
		 
		 /** DATA FINAL DA SEMANA **/
		 dataFinal = somarDias(dataInicial, 6); 
		 
		 listDate.add(dataInicial);
		 listDate.add(dataFinal);
		 
		 return listDate;
	}
	
	/** RETORNA DUAS DATAS - INICIO E FIM DO MES **/
	public static List<Date> getDataPeriodoMes(Date data) {
		 List<Date> listDate = new ArrayList<Date>();
		 Date dataInicial    = new Date(data.getTime());
		 Date dataFinal      = new Date(data.getTime()); 
		 
		 dataInicial         = criarData(1,  getMesPorData(data), getAnoPorData(data));
		 dataFinal           = criarData(31, getMesPorData(data), getAnoPorData(data));
		 
		 listDate.add(dataInicial);
		 listDate.add(dataFinal);
		 
		 return listDate;
	}
	
	/** RETORNA DUAS DATAS - DOS ULTIMOS 30 DIAS **/
	public static List<Date> getDataPeriodoUltimos30Dias(Date data) {
		 List<Date> listDate = new ArrayList<Date>();
		 Date dataInicial    = new Date(data.getTime());
		 Date dataFinal      = new Date(data.getTime()); 
		 
		 dataFinal           = getDataAtual(); 
		 dataInicial         = subtrairDias(dataFinal, 30);
		 
		 listDate.add(dataInicial);
		 listDate.add(dataFinal);
		 
		 return listDate;
	}
	
	/** RETORNA DUAS DATAS - DO MES PASSADO **/
	public static List<Date> getDataPeriodoMesPassado(Date data) {
		 List<Date> listDate = new ArrayList<Date>();
		 Date dataInicial    = new Date(data.getTime());
		 Date dataFinal      = new Date(data.getTime()); 
		 
		 dataInicial         = criarData(1,  getMesPorData(data) - 1, getAnoPorData(data));
		 dataFinal           = criarData(31, getMesPorData(data) - 1, getAnoPorData(data));
		 
		 listDate.add(dataInicial);
		 listDate.add(dataFinal);
		 
		 return listDate;
	}
	
	/** RETORNA DATA FORMATA NO FORMATO - 01 Ago 2013 **/
	public static String getDataStringStyleCombo(Date data) {
		
		String dia = SystemUtil.completarComEsquerdo("0", 2, getDiaPorData(data).toString());
		String mes = getMesNome(getMesPorData(data), true);
		
		String dateInicialStr = dia + " " + mes + " " + getAnoPorData(data);
		return dateInicialStr;
	}
	
	/** DATA ATUAL MAIS UMA HORA **/
	public static Date dataMaisUmaHora(Date data) {
		
		 Date dataFinal = new Date(data.getTime());
		 dataFinal.setHours(dataFinal.getHours() + 1);
		 return dataFinal;
	} 
	
	/** DATA ATUAL MAIS UM MES **/
	public static Date dataAtualMaisUmMes() {
		 Date dataFinal = subtrairDias(getDataAtual(), -31);
		 return dataFinal;
	} 
	
	/** DATA ATUAL MAIS UM MES **/
	public static Date dataMaisUmMes(Date data) {
		 Date datafinal = new Date(data.getTime());
		 datafinal.setMonth(data.getMonth() + 1);
		 return datafinal;
	} 
	
	/** DATA ATUAL MAIS QUANTIDADE DE MESES **/
	public static Date dataMaisQtdMeses(Date data, Integer qtdMeses) {
		 Date datafinal = new Date(data.getTime());
		 datafinal.setMonth(data.getMonth() + qtdMeses);
		 return datafinal;
	} 
	
	/** SUBTRAIR DIAS DE UMA DATA **/
	public static Date dataMaisQtdDias(Date data, Integer dias) {
		   
		 Calendar c = Calendar.getInstance();
		 c.setTime(data);
		 c.add(Calendar.DAY_OF_MONTH, dias);
		      
	      return c.getTime();  
	}
	
	/** SUBTRAIR DIAS DE UMA DATA **/
	public static Date subtrairDias(Date data, Integer dias) {
		   
		   dias = dias * (-1);
		  
		   Calendar c = Calendar.getInstance();
		   c.setTime(data);
		   c.add(Calendar.DAY_OF_MONTH, dias);
		      
	      return c.getTime();  
	}
	

	/** SUBTRAIR DIAS DE UMA DATA **/
	public static Date somarDias(Date data, Integer dias) {
		   
		   Calendar c = Calendar.getInstance();
		   c.setTime(data);
		   c.add(Calendar.DAY_OF_MONTH, dias);
		      
	      return c.getTime();  

	}
	
	/** SUBTRAIR DIAS DE UMA DATA **/
	public static Date getProximoDiaUtil(Date data) {
		 Date datafinal = new Date(data.getTime());
		 
		 int dia_da_semana = datafinal.getDay(); 
		 
		 while (dia_da_semana==0 | dia_da_semana==6 ) {
			 datafinal = somarDias(datafinal, 1);
			 dia_da_semana = datafinal.getDay(); 
		 }
		 return datafinal;

	}
	
	/** PRIMEIRO DIA DO MES **/
	public static Date getPrimeiroDiaMes(Date data) {
		 Date dateFinal = criarData(1, getMesPorData(data), getAnoPorData(data));
		 return dateFinal;
	}
	
	/** ULTIMO DIA DO MES **/
	public static Date getUltimoDiaMes(Date data) {
		 Date dateFinal = criarData(31, getMesPorData(data), getAnoPorData(data));
		 return dateFinal;
	}
	
	/** SUBTRAIR DUAS DATAS **/
	public static long subtrairDatas(Date dataInicio, Date dataFinal) {
		   if (dataInicio == null || dataFinal == null) {
			   return 0;
		   }

	       // Calcula a diferen�a entre hoje e da data de inicio
	       long diferenca = dataFinal.getTime() -
	                        dataInicio.getTime() ;

	       // Quantidade de milissegundos em um dia
	       int tempoDia = 1000 * 60 * 60 * 24;
	       long diasDiferenca = diferenca / tempoDia;
	          
	      return diasDiferenca;  

	}
	
	
	/** CRIAR DATA POR PARAMENTO **/
	public static Date criarData(Integer dia, Integer mes, Integer ano) {
		Calendar calendar = Calendar.getInstance();	
		
		/** CRIANDO DATA **/
		calendar.set(ano,mes-1,1); 
		
		/** CAPTURANDO ULTIMO DIA DO MES **/
		if (dia == 31) {
			dia = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
		}
		
		/** FINALIZANDO DATA **/
		calendar.set(ano,mes-1,dia); 
		Date retorno = calendar.getTime();
		return retorno;  
	}
	
	/** FORMATAR DATA INICIAL **/
	public static Date formatarDataInicial(Date date) {
		Calendar calendar = Calendar.getInstance();	
		Date retorno;
		
		/** CRIANDO DATA **/
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);  
		calendar.set(Calendar.MINUTE, 0);  
		calendar.set(Calendar.SECOND, 0);  
		calendar.set(Calendar.MILLISECOND, 0);  
		retorno = calendar.getTime();  
		
		
		return retorno;  
	}
	
	/** FORMATAR DATA INICIAL **/
	public static Date formatarDataFinal(Date date) {
		Calendar calendar = Calendar.getInstance();	
		Date retorno;
		
		/** CRIANDO DATA **/
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 23);  
		calendar.set(Calendar.MINUTE, 59);  
		calendar.set(Calendar.SECOND, 59);  
		calendar.set(Calendar.MILLISECOND, 99);
		retorno = calendar.getTime();  
		
		return retorno;  
	}
	
	/**
	   * Calcula o n�mero de dias entre duas datas.
	   */
	public static Boolean comparaDatas(Date start, Date end) {

		if (start.compareTo(end) < 0) {
			return false;
		} else if (start.compareTo(end) >= 0) {
			return true;
		}
		return false;
	}
	

	/**
	 * Converte uma data no formato ISO8601 para Date. 
	 * @param date ISO8601
	 * @return Date
	 */
	public static Date converterISO8601(String date) {
		return DatatypeConverter.parseDateTime(date.substring(0, 23)).getTime();
	}
	
	/**
	 * Converte um Objeto Date em uma String que representa a data no formato ISO8601 (Scanntech)
	 * @param date
	 * @return String ISO8601
	 */
	public static String converterDateToISO8601(Date date){
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(date);
		String iso =  javax.xml.bind.DatatypeConverter.printDateTime(c);
		String data = iso.substring(0, 19);
		String gmt = iso.substring(19, 25);
		gmt = gmt.replace(":", "");
		return data + ".000"+ gmt;
	}
}
