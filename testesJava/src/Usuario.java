public class Usuario {
        String email;
        String nome;
        String senha;
        double saldo;
        String cpf;
        int idade;
        boolean logado = false;



    public Usuario(String nome, String senha, String cpf, int idade, String email){
        this.nome = nome;
        this.senha = senha;
        this.cpf = cpf;
        this.saldo = 0 ;
        this.idade = idade;
        this.email = email;
    }

    void adicionaSaldo(double saldo){
        if (this.logado) {
            this.saldo += saldo;
        }
    }

    String getEmail(){
            return this.email;
    }

    double getSaldo(){
        if (this.logado) {
        return this.saldo;
        }
        return 0;
    }

    void logar(String senha){
        if (senha.equals(this.senha)){
            System.out.println("Senha correta!");
            this.logado = true;
        }
        else {
            System.out.println("Senha incorreta!");

        }
    }

    void deslogar(){
        this.logado = false;
    }
}
