package br.com.barcard.mb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.barcard.entity.Cartao;
import br.com.barcard.entity.Pessoa;
import br.com.barcard.entity.Produto;
import br.com.barcard.entity.Saida;
import br.com.barcard.service.CartaoService;
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
	
	@Inject
	CartaoService cartaoService;
	
	
	Collection<Saida> lstSaida = new ArrayList<Saida>();
	Saida saida = new Saida();
	Collection<Produto> lstProduto = new ArrayList<Produto>();
	BigDecimal inicial = BigDecimal.ONE;
	String cdCartao = new String();
	Collection<Saida> lstFechamento = new ArrayList<Saida>();
	Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public void init(){
		try {
			saida.setQntSaida(BigDecimal.ONE);
			lstSaida  = saidaService.findAllByProperty();
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
		if(saida.getProduto()!=null && saida.getProduto().getId()!=null){
			if(cdCartao!=null && !cdCartao.equals("")){
				Pessoa pessoa = pessoaService.buscarPorCodigoCartao(cdCartao);
				if(pessoa!=null && pessoa.getId()!=null){
					if(saida.getQntSaida().compareTo(BigDecimal.ZERO)>0){
						saida.setPessoa(pessoa);
						saida.setDtSaida(new Date());
						saida.setVlVenda(saida.getProduto().getVlVenda());
						saida.setStAtivo(true);
						saidaService.salvar(saida);
						endConversation();
						return goTo("cadastrarVenda");
					}else{
						cdCartao = new String();
						saida.setQntSaida(BigDecimal.ONE);
						addMessageErro("A quantidade tem que ser maior que 0.");
						return goTo("cadastrarVenda");
					}
				}else{
					cdCartao = new String();
					addMessageErro("Cartão não cadastrado.");
					return goTo("cadastrarVenda");
				}
			}else{
				cdCartao = new String();
				addMessageErro("Passe o Cartão.");
				return goTo("cadastrarVenda");
			}
		}else{
			cdCartao = new String();
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
	
	public BigDecimal totalFechamento(){
		BigDecimal total = BigDecimal.ZERO;
		for (Saida saida : lstFechamento) {
			total = total.add(saida.getQntSaida().multiply(saida.getVlVenda()));
		}
		return total;
	}
	
	public String fechaConta(){
		if(lstFechamento.size()>0){
			Pessoa pessoa = ((List<Saida>)lstFechamento).get(0).getPessoa();
			Cartao cartao = pessoa.getCartao();
			pessoa.setCartao(null);
			for (Saida saida : lstFechamento) {
				saida.setStAtivo(false);
				saidaService.alterar(saida);
			}
			pessoaService.alterar(pessoa);
			cartaoService.excluir(cartao);
			lstFechamento = new ArrayList<Saida>();
		}else{
			addMessageErro("Passe o Cartão.");
		}
		return goTo("fechamento");
	}
	
	public String buscarFechamento(){
		if(!cdCartao.equals("")){
			Pessoa pessoa = pessoaService.buscarPorCodigoCartao(cdCartao);
			if(pessoa!=null){
				lstFechamento = new ArrayList<Saida>();
				for (Saida saida : pessoa.getLstSaida()) {
					if(saida.getStAtivo()){
						lstFechamento.add(saida);
					}
				}
			}else{
				addMessageErro("Cartão não cadastrado.");
			}
		}else{
			addMessageErro("Passe o Cartão.");
		}
		cdCartao =  new String();
		return goTo("fechamento");
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

	public Collection<Saida> getLstFechamento() {
		return lstFechamento;
	}

	public void setLstFechamento(Collection<Saida> lstFechamento) {
		this.lstFechamento = lstFechamento;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
