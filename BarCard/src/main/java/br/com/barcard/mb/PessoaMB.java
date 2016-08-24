package br.com.barcard.mb;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.barcard.entity.Cartao;
import br.com.barcard.entity.Pessoa;
import br.com.barcard.service.CartaoService;
import br.com.barcard.service.PessoaService;

@Named
@ConversationScoped
public class PessoaMB extends GenericMB {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	PessoaService pessoaService;
	
	@Inject 
	CartaoService cartaoService;
	
	Collection<Pessoa> listPessoa = new ArrayList<Pessoa>();
	Pessoa pessoa = new Pessoa();
	Cartao cartao = new Cartao();
	String nomeFilter = new String();
	
	@PostConstruct
	public void init(){
		listPessoa  = pessoaService.outraRegraDeNegocioEspecificaBuscar(null);
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
		if(pessoa.getTelefone()!=null && !pessoa.getTelefone().equals("") &&
				pessoa.getPessoaFisica().getNome()!=null && !pessoa.getPessoaFisica().getNome().equals("") &&
				pessoa.getPessoaFisica().getCpf()!=null && !pessoa.getPessoaFisica().getCpf().equals("") ){
			if(pessoa!=null && pessoa.getId()==null){
				pessoa.setCartao(null);
				pessoaService.salvar(pessoa);
			}else{
				pessoa.setCartao(null);
				pessoaService.alterar(pessoa);
			}
			endConversation();
			addMessageInfo("Cadastrado com Sucesso!");
			return goTo("pesquisarPessoa");
		}else{
			addMessageErro("Preencha todos os campos obrigatorios!");
			return goTo("cadastrarPessoa");
		}
	}
	
	public String excluir(){
		pessoaService.excluir(pessoa);
		endConversation();
		return goTo("pesquisarPessoa");
	}
	
	public String salvarCartao(){
		if(cartaoService.buscarPorCodigo(cartao.getCdCartao())==null){
			if(pessoa.getCartao()!=null && pessoa.getCartao().getId()!=null){
				Cartao cartaoExcluir = pessoa.getCartao();
				cartaoService.excluir(cartaoExcluir);
			}
			pessoa.setCartao(cartao);
			pessoaService.alterar(pessoa);
			endConversation();
			addMessageInfo("Cadastrado com Sucesso!");
		}else{
			addMessageErro("Cartão Associado a outra pessoa.");
		}
		cartao = new Cartao();
		return goTo("pesquisarPessoa");
	}
	
	public String buscarPorNome(){
		listPessoa = pessoaService.buscarPorNome(nomeFilter);
		return goTo("pesquisarPessoa");
	}
	
	public Conversation getConversation() {
		return conversation;
	}

	public Collection<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public void setListPessoa(Collection<Pessoa> listPessoa) {
		this.listPessoa = listPessoa;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Cartao getCartao() {
		return cartao;
	}

	public void setCartao(Cartao cartao) {
		this.cartao = cartao;
	}

	public String getNomeFilter() {
		return nomeFilter;
	}

	public void setNomeFilter(String nomeFilter) {
		this.nomeFilter = nomeFilter;
	}
	
}
