package br.edu.ifg;
public class Main {
    public static void main(String[] args) {
        System.out.println("########################################");
        System.out.println("# Criação de objetos PessoaFisica      #");
        System.out.println("########################################");
        PessoaFisica p1 = new PessoaFisica(1, "111.111.111-11", "Fulano de Tal");
        System.out.println("###################################################");
        System.out.println("# Criacao de objetos Conta com dono Pessoa Fisica #");
        System.out.println("###################################################");
        Conta c1 = new Conta(p1, 0, 100, 111, "minhasenha"); //Deposito inicial de R$ 0,00 e limite de R$ 100,00
        String cpf = c1.lerCpf();
        String senha = c1.lerSenha();
        if (c1.autenticar(cpf, senha)) {
            c1.imprimirSaldo();
            c1.depositar(2); //deposito de R$ 2,00
            c1.imprimirSaldo();
            c1.sacar(3); // saque de R$ 3,00
            c1.imprimirSaldo();
        }
    }
}
