package br.com.barcard.converter;

import javax.enterprise.inject.spi.CDI;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.hibernate.service.spi.ServiceException;

import br.com.barcard.dao.ProdutoDAO;
import br.com.barcard.entity.Produto;
import br.com.barcard.util.SystemUtil;

@FacesConverter(value = "produtoConverter")
public class ProdutoConverter implements Converter {
	
 
    public Object getAsObject(FacesContext context, UIComponent component, String value)  {  
    	 Produto retorno = null;
    	 if (value != null && value.trim().equals("")) {  
             return retorno;  
         } else {  
             try {
            	ProdutoDAO produtoDAO = CDI.current().select(ProdutoDAO.class).get();
				retorno = (Produto) produtoDAO.find(Produto.class ,new Long(value));
			} catch (ServiceException e) {
				System.out.println(e.getMessage());
			}
         }  
         return retorno;  
    }  
  
    public String getAsString(FacesContext context, UIComponent component, Object value) {  
	   String retorno = ""; 
    	try {
	    	if (value == null || value.equals("")) {  
	            return retorno;  
	        } else {
	        	
	        	if (value instanceof Produto) {
	        		Produto e = (Produto) value; 
	        		
	        		if (SystemUtil.possuiDados(e.getId())) {
		        		retorno = ((Produto) value).getId().toString();
		        	}
	        	}
	        } 
        } catch (Exception e) {
        	System.out.println(e.getMessage());
		}
    	return retorno;
    }
}
