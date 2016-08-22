package br.com.barcard.mb;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public abstract class GenericMB implements Serializable{

	public abstract void initConversation();
	
	public abstract void endConversation();

	public void addMessageInfo(String msg){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,msg,null));
	}
	
	public void addMessageErro(String msg){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().getFlash().setKeepMessages(true);
		
		context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,msg,null));
	}
	
}
