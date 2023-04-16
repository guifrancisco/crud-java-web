package protozoario.model;

import java.util.ArrayList;

import protozoario.dao.ProtozoarioDao;

public class Protozoario {

    private int idProtozoario;
    private String nome;
    private String filo;
    private String classe;
    private String ordem;

    public Protozoario() {
    }

    public Protozoario(String nome, String filo, String classe, String ordem){
        this.nome = nome;
        this.filo = filo;
        this.classe = classe;
        this.ordem = ordem;
    }

    public Protozoario(int idProtozoario, String nome, String filo, String classe, String ordem){
        this.idProtozoario = idProtozoario;
        this.nome = nome;
        this.filo = filo;
        this.classe = classe;
        this.ordem = ordem;
    }

   public int getIdProtozoario() {
       return idProtozoario;
   }

   public void setIdProtozoario(int idProtozoario) {
       this.idProtozoario = idProtozoario;
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFilo() {
        return filo;
    }

    public void setFilo(String filo) {
        this.filo = filo;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getOrdem() {
        return ordem;
    }

    public void setOrdem(String ordem) {
        this.ordem = ordem;
    }
    
  //Atraves da model � enviado as classes DAO o trabalho de salvar no banco
  	public void salvar() {
  		new ProtozoarioDao().CadastrarProtozoario(this);
  	}
  	
  	
  	public Protozoario buscarProtozoarioPorId(int idProtozoario) {
  		return new ProtozoarioDao().BuscarProtozoarioPorId(idProtozoario);
  	}
  	
  	public ArrayList<Protozoario> BuscarProtozoarioPorNome(String nome) {
  		return new ProtozoarioDao().BuscarProtozoarioPorNome(nome);
  	}
  	
  	public void excluir(int idProtozoario) {
  		new ProtozoarioDao().ExcluirProtozoario(idProtozoario);
  	}
  	
  	public void alterar() {
		new ProtozoarioDao().AlterarProtozoario(this);
	}


}

