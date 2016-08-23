package br.com.barcard.mb;

import java.util.ArrayList;
import java.util.Collection;

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
public class PessoaMB extends GenericMB {

	private static final long serialVersionUID = 4771270804699990999L;
	
	@Inject
    private Conversation conversation;
	
	@Inject 
	PessoaService pessoaService;
	
	Collection<Pessoa> listPessoa = new ArrayList<Pessoa>();
	Pessoa pessoa = new Pessoa();
	
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
		if(pessoa!=null && pessoa.getId()==null){
			pessoaService.salvar(pessoa);
		}else{
			pessoaService.alterar(pessoa);
		}
		endConversation();
		return goTo("pesquisarPessoa");
	}
	
	public String excluir(){
		pessoaService.excluir(pessoa);
		endConversation();
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
	
}
