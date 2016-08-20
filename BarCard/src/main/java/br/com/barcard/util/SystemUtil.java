package br.com.barcard.util;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Locale;

public class SystemUtil {

	public static String substituirChar(String valor,Integer numero,Integer posicao){
		return valor.substring(0,--posicao)+numero+valor.substring(++posicao);
	}
	
	public static BigDecimal getPercentual(Integer valor,Integer total){
		if(valor != null && total != null){
			BigDecimal valorBig = new BigDecimal(valor);
			BigDecimal totalBig = new BigDecimal(total);
		
			if(!totalBig.equals(BigDecimal.ZERO)){
				return valorBig.divide(totalBig,2,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
			}
		}
		return null;
	}
	
	public static BigDecimal getPercentual(BigDecimal valor,BigDecimal total){
		if(valor != null && total != null){
			if(!total.equals(BigDecimal.ZERO)){
				return valor.divide(total,2,RoundingMode.HALF_UP).multiply(new BigDecimal(100));
			}
		}
		return null;
	}
	
	public static boolean isMaiorOuIgual(BigDecimal valor1,BigDecimal valor2){
		if(valor1 != null && valor2 != null){
			if(valor1.compareTo(valor2) >= 0){
				return true;
			}
		}
		return false;
	}
	
	public static boolean isMenorOuIgual(BigDecimal valor1,BigDecimal valor2){
		if(valor1 != null && valor2 != null){	
			if(valor1.compareTo(valor2) <= 0){
				return true;
			}
		}
		return false;
	}
	
	/** GERADOR DE MD5 **/	
	public static String getMD5(String value) throws Exception {
		String retorno = "";

		try {
			if (value == null) {
				return retorno;
			}
			MessageDigest m = MessageDigest.getInstance("MD5");
			m.update(value.getBytes(),0,value.length());

			retorno = ""+ new BigInteger(1,m.digest()).toString(16);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		return retorno;
	}

	public static boolean isNumerico (String s) {  
	    try {  
	        Long.parseLong (s);   
	        return true;  
	    } catch (NumberFormatException ex) {  
	        return false;  
	    }  
	}
	
	/** POSSUI DADOS - STRING **/
	public static Boolean possuiDados(String dados) {
		Boolean retorno = false;
		if ( dados != null ) {
			if ( !dados.trim().equals("") ){
				retorno = true;
			}
		}
		return retorno;
	}

	/** POSSUI DADOS - OUTROS NIVEIS STRING **/
	public static Boolean possuiDadosGrupo(String dados) {
		Boolean retorno = false;
		if ( dados != null ) {
			if ( !dados.trim().equals("") &&
					!dados.trim().equals("00")	 ){
				retorno = true;
			}
		}
		return retorno;
	}


	/** POSSUI DADOS - INTEGER **/
	public static Boolean possuiDados(Integer dados) {
		Boolean retorno = false;
		if ( dados != null ) {
			if ( dados > 0 ){
				retorno = true;
			}
		}
		return retorno;
	}

	/** POSSUI DADOS - INTEGER **/
	public static Boolean possuiDados(BigDecimal dados) {
		Boolean retorno = false;
		if ( dados != null ) {
			if ( dados.doubleValue() > 0 ){
				retorno = true;
			}
		}
		return retorno;
	}

	public static Boolean possuiDados(Object obj) {
		return obj == null ? false : true;
	}

	/** COMPLETA COM LADO ESQUERDO **/
	public static String completarComEsquerda(String caracter, Integer qtdeCaracteres, String base){
		if(base == null || "".equals(base))
			return null;

		if(qtdeCaracteres <= base.length())
			return base;

		StringBuffer bf = new StringBuffer();
		for(int i = 1; i <= qtdeCaracteres - base.length(); i++){
			bf.append(caracter);
		}
		return bf.append(base).toString();
	}

	/** COMPLETA COM LADO DIREITO **/
	public static String completarComDireita(String caracter, Integer qtdeCaracteres, String base){
		if(base == null || "".equals(base))
			return "";

		if(qtdeCaracteres <= base.length())
			return base;

		Integer acrescentar = qtdeCaracteres - base.length();

		for(int i = 1; i <= acrescentar; i++){
			base = base + caracter + "";
		}

		return base;
	}

	/** REMOVE CARACTER DIREITA **/
	public static String removeCaracterDireita(Character caracter, String base){
		int indexCorte = 0; 
		int posicao = base.length() - 1;

		for(int i = 0; i <= base.length(); i++){

			if ( base.charAt(posicao) != caracter ) {
				indexCorte = posicao;
				break;
			}
			posicao--;
		}
		base = base.substring(0, indexCorte + 1);
		return base;
	}

	/** GERAR DIGITO VERIFICADOR **/
	public static String gerarDigitoVerificador(String value) {
		if (value == null) return ""; 
		int[] aux = new int[value.length()];
		int variavel = 2;
		int total = 0;
		for (int i = aux.length - 1; i >= 0; i--) {
			aux[i] = Integer.parseInt("" + value.charAt(i));
			aux[i] = aux[i] * variavel;
			variavel++;
			if (variavel > 9)
				variavel = 2;
			total += aux[i];
		}
		if (total == 0 || total == 1)
			total = 0;
		else
			total = 11 - total;

		String digito = "" + total;

		return digito;

	}

	/** COMPLETA COM LADO ESQUERDO **/
	public static String completarComEsquerdo(String caracter, Integer qtdeCaracteres, String base){
		if(base == null)
			return "";

		if(qtdeCaracteres <= base.length())
			return base;

		StringBuffer bf = new StringBuffer();
		for(int i = 1; i <= qtdeCaracteres - base.length(); i++){
			bf.append(caracter);
		}
		return bf.append(base).toString();
	}

	public static String incluirSimbolo(String caracter, Integer posicao, String base){
		if(base == null)
			return "";
		//verifica se e uma posicao valida
		if(posicao > base.length()){
			return base;
		}else{
			String prefixo = base.substring(0,base.length() - posicao);
			String sufixo = base.substring(base.length()-posicao,base.length());
			
			return  prefixo+caracter+sufixo ;
		}
	}
	
	public static String formatarMatricula(String matricula){
		String matriculaLenght7 = SystemUtil.completarComEsquerdo("0", 7, matricula); 
		return incluirSimbolo("-", 1, matriculaLenght7);
	}
	
	public static String formatarAutorizacao(String Autorizacao){
		String AutorizacaoLenght7 = SystemUtil.completarComEsquerdo("0", 7, Autorizacao); 
		return incluirSimbolo("-", 1, AutorizacaoLenght7);
	}
	
	/**
	 * @author :Paulo Sérgio
	 * @since :04/12/2013 
	 * @see :Calculo do Modulo 10 para geracao do digito verificador
	 */

	// Módulo 10
	// Conforme o esquema abaixo, cada dígito do número, começando da direita para a esquerda 
	// (menos significativo para o mais significativo) é multiplicado, na ordem, por 2, depois 1, depois 2, depois 1 e 
	// assim sucessivamente.
	// Em vez de ser feito o somatório das multiplicações, será feito o somatório dos dígitos das multiplicações 
	// (se uma multiplicação der 12, por exemplo, será somado 1 + 2 = 3).
	// O somatório será dividido por 10 e se o resto (módulo 10) for diferente de zero, o dígito será 10 menos este valor.
	// Número exemplo: 123456
	//  +---+---+---+---+---+---
	//  | 1 | 2 | 3 | 4 | 5 | 6 |
	//  +---+---+---+---+---+---+
	//	|   |   |   |   |   |   | 
	//   x1  x2  x1  x2  x1  x2  
	//	|   |   |   |   |   |   |  
	//   =1  =4  =3  =8  =5  =1+3  
	//	+---+---+---+---+---+-> = (24 / 10) = 2, resto 4 => DV = (10 - 4) = 6 <-- Este é o DV

	public static Integer calculoBase10(String value){  

		//variáveis de instancia
		int soma = 0;
		int resto = 0;
		int dv = 0;
		String[] numeros = new String[value.length()+1];
		int multiplicador = 2;
		String aux;
		String aux2;
		String aux3;

		for (int i = value.length(); i > 0; i--) {  	    	
			//Multiplica da direita pra esquerda, alternando os algarismos 2 e 1
			if(multiplicador % 2 == 0){
				// pega cada numero isoladamente  
				numeros[i] = String.valueOf(Integer.valueOf(value.substring(i-1,i))*3);
				multiplicador = 1;
			}else{
				numeros[i] = String.valueOf(Integer.valueOf(value.substring(i-1,i))*1);
				multiplicador = 2;
			}
		}  

		// Realiza a soma dos campos de acordo com a regra
		for(int i = (numeros.length-1); i > 0; i--){
			aux = String.valueOf(Integer.valueOf(numeros[i]));

			if(aux.length()>1){
				aux2 = aux.substring(0,aux.length()-1);	    		
				aux3 = aux.substring(aux.length()-1,aux.length());
				numeros[i] = String.valueOf(Integer.valueOf(aux2) + Integer.valueOf(aux3));	    		
			}
			else{
				numeros[i] = aux;    		
			}
		}

		//Realiza a soma de todos os elementos do array e calcula o digito verificador
		//na base 10 de acordo com a regra.	    
		for(int i = numeros.length; i > 0 ; i--){
			if(numeros[i-1] != null){
				soma += Integer.valueOf(numeros[i-1]);
			}
		}
		resto = soma%10;
		dv = 10 - resto;

		//retorna o digito verificador
		return dv;
	}

	/**
	 * @author :Paulo Sergio
	 * @since :16/12/2013  
	 * @see :Calculo do Modulo 11 para geracao do digito verificador.
	 */
	// Módulo 11
	// Conforme o esquema abaixo, para calcular o primeiro dígito verificador, cada dígito do número, 
	// começando da direita para a esquerda (do dígito menos significativo para o dígito mais significativo) 
	// é multiplicado, na ordem, por 2, depois 3, depois 4 e assim sucessivamente, até o primeiro dígito do número. 
	// O somatório dessas multiplicações dividido por 11. O resto desta divisão (módulo 11) é subtraido da base (11), 
	// o resultado é o dígito verificador. Para calcular o próximo dígito, considera-se o dígito anterior como parte 
	// do número e efetua-se o mesmo processo. No exemplo, foi considerado o número 261533:
	//  +---+---+---+---+---+---+   +---+
	//  | 2 | 6 | 1 | 5 | 3 | 3 | - | 9 |
	//  +---+---+---+---+---+---+   +---+
	//	|   |   |   |   |   |
	//   x7  x6  x5  x4  x3  x2
	//  |   |   |   |   |   |
	//   =14 =36  =5 =20  =9  =6 soma = 90
	// 	+---+---+---+---+---+-> = (90 / 11) = 8,1818 , resto 2 => DV = (11 - 2) = 9

	public static Integer calculoBase11(String num){  
	    /** 
	     *    Calculo do Modulo 11 para geracao do digito verificador 
	     *    de boletos bancarios conforme documentos obtidos 
	     *    da Febraban - www.febraban.org.br 
	     * 
	     *   Entrada: 
	     *     num: string numérica para a qual se deseja calcular o digito verificador; 
	     * 
	     *   Saída: 
	     *     Retorna o Digito verificador. 
	     */  
	    int base = 9;  
	  
	    int soma = 0;  
	    int fator = 2;  
	    String[] numeros,parcial;  
	    numeros = new String[num.length()+1];  
	    parcial = new String[num.length()+1];  
	  
	    /* Separacao dos numeros */  
	    for (int i = num.length(); i > 0; i--) {  
	        // pega cada numero isoladamente  
	        numeros[i] = num.substring(i-1,i);  
	        // Efetua multiplicacao do numero pelo falor  
	        parcial[i] = String.valueOf(Integer.parseInt(numeros[i]) * fator);  
	        // Soma dos digitos  
	        soma += Integer.parseInt(parcial[i]);  
	        if (fator == base) {  
	            // restaura fator de multiplicacao para 2  
	            fator = 1;  
	        }  
	        fator++;  
	  
	    }  
	  
	    /* Calculo do modulo 11 */  
        soma *= 10;  
        int digito = soma % 11;  
        if (digito == 10) {  
            digito = 0;  
        }  
        return digito;  
	}

	/** METDODO PARA VALIDACAO DE CODIGOS DE BARRAS EAN13 **/
	public static boolean isValidarCodigoBarrasEAN13(String barCode) {
		int digit;
		int calculated;
		String ean;
		String checkSumEan13 = "131313131313";
		int sum = 0;

		if (barCode.length() == 13) {
			digit = Integer.parseInt("" + barCode.charAt(barCode.length() - 1));
			ean = barCode.substring(0, barCode.length() - 1);

			for (int i = 0; i <= ean.length() - 1; i++) {
				sum += (Integer.parseInt("" + ean.charAt(i)))
						* (Integer.parseInt("" + checkSumEan13.charAt(i)));
			}
			calculated = 10 - (sum % 10);

			if (calculated >= 10) {
				calculated = 0;
			}
			return (digit == calculated);
		} else {
			return false;
		}
	}

	/** METDODO PARA VALIDACAO DE CODIGOS DE BARRAS EAN8 **/
	public static boolean isValidarCodigoBarrasEAN8(String barCode) {
		int digit;
		int calculated;
		String ean;
		String checkSumEan8 = "3131313";
		int sum = 0;

		if (barCode.length() == 8) {
			digit = Integer.parseInt("" + barCode.charAt(barCode.length() - 1));
			ean = barCode.substring(0, barCode.length() - 1);

			for (int i = 0; i <= ean.length() - 1; i++) {
				sum += (Integer.parseInt("" + ean.charAt(i)))
						* (Integer.parseInt("" + checkSumEan8.charAt(i)));
			}

			calculated = 10 - (sum % 10);

			if (calculated == 10) {
				calculated = 0;
			}
			return (digit == calculated);
		} else {
			return false;
		}
	}

	/**METDODO PARA VALIDACAO DE CODIGOS DE BARRAS EAN8 OU EAN13**/ 
	public static boolean isValidarCodigoBarrasEAN(String barCode) {
		//EAN deve ser numerico
		if(SystemUtil.isNumerico(barCode)){
			if (barCode.length() == 8 ) {
				return isValidarCodigoBarrasEAN8(barCode);
			}
			else if(barCode.length() == 13){
				return isValidarCodigoBarrasEAN13(barCode);
			}
		}
		return false;
	}

	/**METDODO PARA VALIDACAO DE CODIGOS DE BARRAS DUN14(EAN14)**/ 
	public static boolean isValidarCodigoBarrasDUN14(String barCode) {
		//DUN14 deve ser numerico de 14 digitos
		if(SystemUtil.isNumerico(barCode)){
			if (barCode.length() == 14 ) {
				return true;
			}
		}
		return false;
	}
	
	/**METDODO PARA VALIDACAO DE CODIGOS DE BARRAS UPC**/ 
	public static boolean isValidarCodigoBarrasUPC(String barCode) {
		//UPC deve ser numerico de 12 digitos
		if(SystemUtil.isNumerico(barCode)){
			if (barCode.length() == 12 ) {
				return true;
			}
		}
		return false;
	}
	
	/** RETIRAR NUMEROS DE UMA STRING **/
	public static String retirarNumeros(String value){
		value = value.replaceAll("\\d", "");
		return value;
	}

	/** RETIRAR ASTERISCOS DE UMA STRING **/
	public static String retirarAsteriscos(String value){
		value = value.replace("*", "");
		return value;
	}

	/**
	 * Realiza teste de ping de um IP
	 * @param ip String
	 * @return boolean
	 */
	public static Boolean testeIp(String ip) {
		InetAddress address = null;
		Boolean retorno = false;
		/** Se for informado Ip nulo ou vazio o método retorna falso.
		 * Se não for testado assim o método retorna verdadeiro pois faz o ping no localhost **/
		if (null == ip || ip.isEmpty()) return false;

		try {
			address = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			System.out.println("Cannot lookup host " + ip);
			retorno = false;
		}
		try {
			if (address.isReachable(5000)) {
				long nanos = 0;
				long millis = 0;
				long iterations = 0;
				while (iterations < 1) {
					++iterations;
					try {
						nanos = System.nanoTime();
						address.isReachable(500);
						nanos = System.nanoTime() - nanos;
					} catch (IOException e) {
						retorno = false;
					}
					millis = Math.round(nanos / Math.pow(10, 6));
					System.out.println("Resposta do IP: "
							+ address.getHostAddress() + " com de tempo="
							+ millis + " ms");
					try {
						Thread.sleep(Math.max(0, 1000 - millis));
						retorno = true;
					} catch (InterruptedException e) {
						retorno = false;
						break;
					}
				}
			} else {
				retorno = false;
			}
		} catch (IOException e) {
			retorno = false;
		}
		return retorno;
	}

	/**
	 * Converte todos os caracteres acentuados de uma String nos respectivos caracteres sem acento. 
	 * @param texto String
	 * @return String - texto normalizado.
	 */
	public static String normalizer(String texto) {
		String nfdNormalizedString = Normalizer.normalize(texto, Normalizer.Form.NFD);
		return nfdNormalizedString;
	}

	/**
	 * Redimensiona imagem
	 * @param image {@link BufferedImage}
	 * @param imageType - BufferedImage.TYPE_INT_RGB
	 * @param newWidth int - largura
	 * @param newHeight int - altura
	 * @param ratio boolean - mantém proporção
	 * @return BufferedImage - imagem redimensionada
	 */
	public static BufferedImage scaleImage(BufferedImage image, int imageType,
			int newWidth, int newHeight, boolean ratio) {
		// Certifique-se que a proporção é mantida, para que a imagem não seja
		// distorcida
		if (ratio) {
			double thumbRatio = (double) newWidth / (double) newHeight;
			int imageWidth = image.getWidth(null);
			int imageHeight = image.getHeight(null);
			double aspectRatio = (double) imageWidth / (double) imageHeight;

			if (thumbRatio < aspectRatio) {
				newHeight = (int) (newWidth / aspectRatio);
			} else {
				newWidth = (int) (newHeight * aspectRatio);
			}
		}
		// Desenhará a imagem
		BufferedImage newImage = new BufferedImage(newWidth, newHeight,
				imageType);
		Graphics2D graphics2D = newImage.createGraphics();
		graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
				RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		graphics2D.drawImage(image, 0, 0, newWidth, newHeight, null);

		return newImage;
	}

	/**
	 * Converte String para BigDecimal.
	 * @param str
	 * @return BigDecimal
	 */
	public static BigDecimal stringToBigDecimal(String str){
		Locale locale = new Locale("en","US");
		String b = str.trim();
		DecimalFormat nf = (DecimalFormat)NumberFormat.getInstance(locale);
		nf.setParseBigDecimal(true);

		BigDecimal bd = (BigDecimal)nf.parse(b, new ParsePosition(0));
		return bd;
	}

	public static Integer stringToInteger(String str){
		Integer num = 0;

		try {
			num = new Integer(str);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter string em inteiro: " + e.getMessage());
		}
		return num;

	}

	public static BigInteger stringToBigInteger(String str){
		BigInteger num = new BigInteger("0");

		try {
			num = new BigInteger(str);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter string em inteiro: " + e.getMessage());
		}
		return num;

	}
	
	public static Integer isInteger(String str){
		Integer num = 0;
		try {
			num = new Integer(str);
		} catch (NumberFormatException e) {
			System.out.println("Erro ao converter string em inteiro: " + e.getMessage());
		}
		return num;
	}



	/**
	 * 
	 * @param str
	 * @return
	 */
	public static String tratamentoNull(String str) {
		if (null == str){
			return "";
		} else {
			return str;
		}
	}

	public static BigDecimal tratamentoNull(BigDecimal bd) {
		if (null == bd){
			return new BigDecimal("0.00");
		} else {
			return bd;
		}
	}

	public static Integer tratamentoNull(Integer itr) {
		if (null == itr){
			return 0;
		} else {
			return itr;
		}
	}

	/**
	 * Converte código de barras para ser utilizado pela fonte BarraLumi
	 * no padrão ITF 2 of 5
	 * @param codigoBarras
	 * @return
	 */
	public static String barra25i(String codigoBarras){

		String retorno 			= "";
		String seqInicial		= "FfFf";
		String seqFinalizacao	= "GfFf";
		Integer tamanho 		= codigoBarras.trim().toString().length();
		String lcBarras 		= null;
		String lcEspacos 		= null;
		
		ArrayList<String> laBarras = new ArrayList<String>();

		laBarras.add("00110");
		laBarras.add("10001");
		laBarras.add("01001");
		laBarras.add("11000");
		laBarras.add("00101");
		laBarras.add("10100");
		laBarras.add("01100");
		laBarras.add("00011");
		laBarras.add("10010");
		laBarras.add("01010");
		
		if (tamanho % 2 != 0){
			codigoBarras = "0" + codigoBarras;
		}

		for (int i=0; i < tamanho; i = i + 2){
			
			Integer posicaoB = new Integer(codigoBarras.substring(i, i + 1));
			lcBarras = laBarras.get(posicaoB);

			Integer posicaoE = new Integer(codigoBarras.substring(i + 1 , i + 2));
			lcEspacos = laBarras.get(posicaoE);
			
			for(int u=0; u < 5; u++){
				retorno = retorno + (lcBarras.substring(u, u + 1).equalsIgnoreCase("0") ? "F": "G");
				retorno = retorno + (lcEspacos.substring(u, u + 1).equalsIgnoreCase("0") ? "f": "g");
			}
		}
		retorno = seqInicial + retorno + seqFinalizacao;
		return retorno;

	}
}
