package br.com.barcard.util;

import java.math.BigDecimal;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

public class StringUtil {

	public static void main(String[] args) {
		System.out.println(getNomeUnicoCurtoArquivo("D:\\asdf\\qwer\\dfgh\\arquivo.jpg"));
	}
	
	public static String getNomeUnicoArquivoIndex(String nome,Integer index){
		String nomeUnico = getNomeUnicoArquivo(nome);
		int i = nomeUnico.lastIndexOf(".");
		return nomeUnico.substring(0,i)+index+nomeUnico.substring(i);
	}
	
	public static String getNomeUnicoCurtoArquivo(String nome){
		String nomeUnico = "";
		
		String nomeSplit[] = getNomeArquivo(nome).split("\\.");
		String dataSplit[] = new Date().toString().split(" ");
		
		
		for (int i = 0; i < nomeSplit.length-1; i++) {
			nomeUnico += nomeSplit[i];
		}
		
		return nomeUnico.substring(0,6)+dataSplit[2]+dataSplit[1]+dataSplit[5]
						+dataSplit[3].replace(":", "")+"."+getExtensao(nome);
	}
	
	public static String getNomeUnicoArquivo(String nome){
		String nomeUnico = "";
		
		String nomeSplit[] = getNomeArquivo(nome).split("\\.");
		String dataSplit[] = new Date().toString().split(" ");
		
		
		for (int i = 0; i < nomeSplit.length-1; i++) {
			nomeUnico += nomeSplit[i];
		}
		
		return nomeUnico+"_"+dataSplit[2]+dataSplit[1]+dataSplit[5]
						+dataSplit[3].replace(":", "")+"."+getExtensao(nome);
	}
	
	public static String getNomeArquivo(String nome){
		String nomeSplit[] = nome.split("\\\\");
		return nomeSplit[nomeSplit.length-1];
	}
	
	public static String getExtensao(String nome){
		String nomeSplit[] = nome.split("\\.");
		return nomeSplit[nomeSplit.length-1];
	}
	
	public static String removeAcentos(String str) {
		 
	  str = Normalizer.normalize(str, Normalizer.Form.NFD);
	  str = str.replaceAll("[^\\p{ASCII}]", "");
	  return str;
	 
	}
	
	public static String maskMoeda(BigDecimal moeda){
		return NumberFormat.getCurrencyInstance(new Locale("pt","BR")).format(moeda);
    }
	
	public static String maskCpf(String cpf){
		return cpf.substring(0, 3)+"."+cpf.substring(3, 6)+"."+cpf.substring(6, 9)+"-"+cpf.substring(9);
    }
	
	public static String maskCnpj(String cnpj){
		return cnpj.substring(0, 2)+"."+cnpj.substring(2, 5)+"."+cnpj.substring(5, 8)+"/"+cnpj.substring(8, 12)+"-"+cnpj.substring(12);
    }
	
	public static String maskTelefone(String telefone){
		return "("+telefone.substring(0, 2)+")"+telefone.substring(2, 6)+"-"+telefone.substring(6, 10);
    }
	
}
