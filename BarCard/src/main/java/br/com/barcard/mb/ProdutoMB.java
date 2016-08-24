package br.com.barcard.mb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.barcard.entity.Entrada;
import br.com.barcard.entity.Produto;
import br.com.barcard.service.EntradaService;
import br.com.barcard.service.ProdutoService;

@Named
@ConversationScoped
public class ProdutoMB  extends GenericMB {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	ProdutoService produtoService;
	
	@Inject 
	EntradaService entradaService;
	
	Collection<Produto> lstProduto = new ArrayList<Produto>();
	Produto produto = new Produto();
	Entrada entrada = new Entrada();
	
	@PostConstruct
	public void init(){
		lstProduto  = produtoService.outraRegraDeNegocioEspecificaBuscar(null);
	}
	
	public void initConversation(){
		if (!FacesContext.getCurrentInstance().isPostback() 
			&& conversation.isTransient()) {
			conversation.begin();
		}
	}
	
	public void endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
	}
	
	public String salvar(){
		if(produto!=null && produto.getId()==null){
			produtoService.salvar(produto);
		}else{
			produtoService.alterar(produto);
		}
		endConversation();
		addMessageInfo("Cadastrado com Sucesso!");
		return goTo("pesquisarProduto");
	}
	
	public String excluir(){
		produtoService.excluir(produto);
		endConversation();
		return "pesquisarProduto?faces-redirect=true";
	}
	
	public String salvarEntrada(){
		if(entrada.getProduto()!=null && entrada.getProduto().getId()!=null){
			entrada.setDtEntrada(new Date());
			entradaService.salvar(entrada);
		}
		endConversation();
		addMessageInfo("Cadastrado com Sucesso!");
		return goTo("pesquisarProduto");
	}

	public Conversation getConversation() {
		return conversation;
	}

	public Collection<Produto> getLstProduto() {
		return lstProduto;
	}

	public void setLstProduto(Collection<Produto> lstProduto) {
		this.lstProduto = lstProduto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}
	
}
