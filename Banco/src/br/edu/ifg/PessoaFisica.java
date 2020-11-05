package br.edu.ifg;

public class PessoaFisica extends Pessoa implements Autenticacao {

    private String Cpf;
    private String Nome;

    public PessoaFisica(){//método construtor original
    }
    public PessoaFisica(int id, String Cpf, String Nome ){
        this.setId(id);
        this.Nome = Nome;
        this.Cpf = Cpf;
    }
    public void setNome(String nome) {
        this.Nome = nome;
    }
    public String getNome() {
        return Nome;
    }
    public void setCpf(String cpf) {
        Cpf = cpf;
    }

    public String getCpf() {
        return Cpf;
    }

    @Override
    public boolean autenticar(String cpf, String senha) {
        return false;
    }
}
