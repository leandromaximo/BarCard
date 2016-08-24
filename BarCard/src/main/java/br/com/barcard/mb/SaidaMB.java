package br.com.barcard.mb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.barcard.entity.Pessoa;
import br.com.barcard.entity.Produto;
import br.com.barcard.entity.Saida;
import br.com.barcard.service.PessoaService;
import br.com.barcard.service.ProdutoService;
import br.com.barcard.service.SaidaService;

@Named
@ConversationScoped
public class SaidaMB extends GenericMB {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	SaidaService saidaService;
	
	@Inject
	ProdutoService produtoService;
	
	@Inject
	PessoaService pessoaService;
	
	Collection<Saida> lstSaida = new ArrayList<Saida>();
	Saida saida = new Saida();
	Collection<Produto> lstProduto = new ArrayList<Produto>();
	BigDecimal inicial = BigDecimal.ONE;
	String cdCartao = new String();
	
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
	
	public void endConversation(){
		if(!conversation.isTransient()){
			conversation.end();
		}
	}
	
	public String salvar(){
		if(saida.getProduto()!=null && saida.getProduto().getId()!=null){
			if(cdCartao!=null && !cdCartao.equals("")){
				Pessoa pessoa = pessoaService.buscarPorCodigoCartao(cdCartao);
				if(pessoa!=null && pessoa.getId()!=null){
					saida.setPessoa(pessoa);
					saida.setDtSaida(new Date());
					saida.setVlVenda(saida.getProduto().getVlVenda());
					saidaService.salvar(saida);
					endConversation();
					return goTo("cadastrarVenda");
				}else{
					cdCartao = new String();
					addMessageErro("Cartão não cadastrado.");
					return goTo("cadastrarVenda");
				}
			}else{
				addMessageErro("Passe o Cartão.");
				return goTo("cadastrarVenda");
			}
		}else{
			addMessageErro("Selecione um produto.");
			return goTo("cadastrarVenda");
		}
	}
	
	public String excluir(){
		saidaService.excluir(saida);
		endConversation();
		return goTo("pesquisarVenda");
	}
	
	public List<BigDecimal> listQnt(){
		List<BigDecimal> listQnt = new ArrayList<BigDecimal>();
		for (int i = 2; i < 50; i++) {
			listQnt.add(new BigDecimal(i));
		}
		return listQnt;
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

	public BigDecimal getInicial() {
		return inicial;
	}

	public void setInicial(BigDecimal inicial) {
		this.inicial = inicial;
	}

	public String getCdCartao() {
		return cdCartao;
	}

	public void setCdCartao(String cdCartao) {
		this.cdCartao = cdCartao;
	}
	
}
