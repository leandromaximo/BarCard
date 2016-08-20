package br.com.barcard.mb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.barcard.entity.Pessoa;
import br.com.barcard.service.PessoaService;

@Named
@ConversationScoped
public class ConversationBean implements Serializable {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	PessoaService pessoaService;
	
	
	private int counter;
	
	@PostConstruct
	public void init(){
		counter = 0;
	}
	
	@SuppressWarnings("unused")
	public void teste(){
		for (Pessoa p : pessoaService.regraDeNegocioBuscar(null)) {
//			System.out.println(p.getNome());
		}
		
	}
	
	
	
	public void initConversation(){
		if (!FacesContext.getCurrentInstance().isPostback() 
			&& conversation.isTransient()) {
			
			conversation.begin();
		}
	}
	
	public void increment(){
		counter++;
	}
	
	public String handleFirstStepSubmit(){
		return "step2?faces-redirect=true";
	}
	
	public String endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
		return "step1?faces-redirect=true";
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public Conversation getConversation() {
		return conversation;
	}
	
}
