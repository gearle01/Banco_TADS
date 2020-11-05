package br.edu.ifg;
import java.util.Scanner;

public class Conta implements Autenticacao, Transferencia {
    private PessoaFisica dono;
    private double saldo;
    private double limite;
    private int numero;
    private String senha;

    public Conta() {//Método construtor original (oculto)
    }

    public Conta(double saldo) { //Método construtor modificado (polimorfismo)
        this.saldo = saldo;
    }

    public Conta(double saldo, double limite) {//Método construtor modificado (polimorfismo)
        this.saldo = saldo;
        this.limite = limite;
    }

    public Conta(PessoaFisica dono, double saldo, double limite, int numero, String senha) {//Método construtor modificado (polimorfismo)
        this.dono = dono;
        this.saldo = saldo;
        this.limite = limite;
        this.numero = numero;
        this.senha = senha;
    }

    public void setDono(PessoaFisica dono) {

        this.dono = dono;
    }

    public PessoaFisica getDono() {
        return dono;
    }

    public void setSaldo(double saldo) { //saldo acumulado

        this.saldo =  saldo;
    }

    public double getSaldo() {

        return saldo;
    }

    public void setLimite(double limite) {

        this.limite = limite;
    }

    public double getLimite() {

        return limite;
    }

    public int getNumero() {

        return numero;
    }

    public void setNumero(int numero) {

        this.numero = numero;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void depositar(double valor){
        this.saldo = this.getSaldo() + valor;
    }

    public void sacar(double valor){ //TODO ver continha errada
        if (valor > this.getSaldo()+this.getLimite()){
            System.out.println("Saldo insuficiente.");
        }
        else if (valor > this.getSaldo()) {
            this.setSaldo(this.getSaldo()-valor);
            this.setLimite(this.getLimite()-this.getSaldo());
        }
    }

    public void imprimirSaldo(){
        System.out.println("########## BANCO DO TADS ##########");
        System.out.println("Conta: " + this.getNumero());
        System.out.println("Cliente: " + this.getDono().getNome());
        System.out.println("-----------------------------------");
        System.out.println("Saldo...........R$ " + this.getSaldo());
        System.out.println("Limite..........R$ " + this.getLimite());
        System.out.println("###################################\n\n");
    }

    @Override
    public boolean autenticar(String cpf, String senha){
        if ( cpf.equals(( getDono().getCpf() && senha.equals(getSenha())))){
            return true;
        }
        else{
            return false;
        }
    }

    public String lerSenha(){ // tod.o ver erro de leitura resolvido com a dica da ide e adicionando o trim para remover os espaços
        System.out.print("Digite sua senha: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }
    public String lerCpf(){ //TOD.O ver erro de leitura resolvido com a dica da ide e adicionando o trim para remover os espaços
        System.out.print("Digite seu CPF: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim();
    }

    @Override
    public boolean transferir(Conta origem, Conta destino, double valor) {
        try {
            if (this.autenticar()){
            origem.sacar(valor);
            destino.depositar(valor);
            return true;
        }
        } catch (Exception e) {
            System.out.println("Erro de transação. Por favor tente novamente.");
            return false;
        }
        return  false;
    }
}
