package br.com.barcard.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.barcard.entity.Produto;
import br.com.barcard.entity.Saida;
import br.com.barcard.service.ProdutoService;
import br.com.barcard.service.SaidaService;

@Named
@ConversationScoped
public class SaidaMB implements Serializable {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	SaidaService saidaService;
	
	@Inject
	ProdutoService produtoService;
	
	Collection<Saida> lstSaida = new ArrayList<Saida>();
	Saida saida = new Saida();
	Collection<Produto> lstProduto = new ArrayList<Produto>();
	
	@PostConstruct
	public void init(){
		lstSaida  = saidaService.outraRegraDeNegocioEspecificaBuscar(null);
		lstProduto  = produtoService.outraRegraDeNegocioEspecificaBuscar(null);
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
		if(saida.getProduto()!=null && saida.getProduto().getId()!=null){
			saida.setDtSaida(new Date());
			saida.setVlVenda(saida.getProduto().getVlVenda());
			saidaService.salvar(saida);
			return "pesquisarVenda?faces-redirect=true";
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Selecione um produto."));
			return null;
		}
	}
	
	public Conversation getConversation() {
		return conversation;
	}

	public Collection<Saida> getLstSaida() {
		return lstSaida;
	}

	public void setLstSaida(Collection<Saida> lstSaida) {
		this.lstSaida = lstSaida;
	}

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	public Collection<Produto> getLstProduto() {
		return lstProduto;
	}

	public void setLstProduto(Collection<Produto> lstProduto) {
		this.lstProduto = lstProduto;
	}
	
}
