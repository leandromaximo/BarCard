package br.com.barcard.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import br.com.barcard.entity.Entrada;
import br.com.barcard.entity.Produto;
import br.com.barcard.service.EntradaService;

@Named
@ConversationScoped
public class EntradaMB implements Serializable {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	EntradaService entradaService;
	
	Collection<Entrada> lstEntrada = new ArrayList<Entrada>();
	Entrada entrada = new Entrada();
	Produto produto = new Produto();
	Collection<Produto> lstProduto = new ArrayList<Produto>();
	
	@PostConstruct
	public void init(){
		lstEntrada  = entradaService.outraRegraDeNegocioEspecificaBuscar(null);
		lstProduto  = entradaService.buscarProduto(null);
	}
	
	public void initConversation(){
		if (!FacesContext.getCurrentInstance().isPostback() 
			&& conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public String endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
		return "home?faces-redirect=true";
	}
	
	public String salvar(){
		if(produto!=null && produto.getId()!=null){
			entrada.setProduto(produto);
			entradaService.salvar(entrada);
			return "pesquisarEntrada?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Selecione um produto."));
			return null;
		}
	}
	
	public Conversation getConversation() {
		return conversation;
	}

	public Collection<Entrada> getLstEntrada() {
		return lstEntrada;
	}

	public void setLstEntrada(Collection<Entrada> lstEntrada) {
		this.lstEntrada = lstEntrada;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Collection<Produto> getLstProduto() {
		return lstProduto;
	}

	public void setLstProduto(Collection<Produto> lstProduto) {
		this.lstProduto = lstProduto;
	}
	
}
