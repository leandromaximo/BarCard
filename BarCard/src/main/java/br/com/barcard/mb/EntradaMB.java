package br.com.barcard.mb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

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
public class EntradaMB extends GenericMB {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	EntradaService entradaService;
	
	@Inject 
	ProdutoService produtoService;
	
	private Collection<Entrada> lstEntrada = new ArrayList<Entrada>();
	private Entrada entrada = new Entrada();
	private Collection<Produto> lstProduto = new ArrayList<Produto>();
	private String nomeProd = new String();
	String nomeFilter = new String();
	
	@PostConstruct
	public void init(){
		try {
			lstEntrada  = entradaService.findAll();
			lstProduto  = produtoService.outraRegraDeNegocioEspecificaBuscar(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		if(entrada.getProduto()!=null && entrada.getProduto().getId()!=null &&
				entrada.getQuantidade()!=null && entrada.getQuantidade().compareTo(BigDecimal.ZERO)>0 &&
				entrada.getVlCusto()!=null && entrada.getVlCusto().compareTo(BigDecimal.ZERO)>0){
			TimeZone tz = TimeZone.getTimeZone("America/Sao_Paulo");
			TimeZone.setDefault(tz);
			entrada.setDtEntrada(new Date());
			if(entrada!=null && entrada.getId()==null){
				entradaService.salvar(entrada);
			}else{
				entradaService.alterar(entrada);
			}
			endConversation();
			addMessageInfo("Cadastrado com Sucesso!");
			return goTo("pesquisarEntrada");
		}else{
			addMessageErro("Preencha todos os campos obrigatorios!");
			return goTo("cadatrarEntrada");
		}
	}
	
	public String excluir(){
		entradaService.excluir(entrada);
		endConversation();
		return goTo("pesquisarEntrada");
	}
	
	public String buscarPorNome(){
		lstEntrada = entradaService.buscarPorNome(nomeFilter);
		return goTo("pesquisarEntrada");
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

	public Collection<Produto> getLstProduto() {
		return lstProduto;
	}

	public void setLstProduto(Collection<Produto> lstProduto) {
		this.lstProduto = lstProduto;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getNomeFilter() {
		return nomeFilter;
	}

	public void setNomeFilter(String nomeFilter) {
		this.nomeFilter = nomeFilter;
	}
	
}
