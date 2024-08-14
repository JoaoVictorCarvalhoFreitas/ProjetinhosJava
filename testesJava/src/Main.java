import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {





        // variaveis de usuario
        boolean fecharPrograma = true;
        String nome;
        int idade;
        String senha;
        String cpf;
        int escolha;
        String email;
        Usuario user;

        //1 objeto Usuario ja cadastrado
        Usuario joao = new Usuario("joao", "1234", "1234", 1234, "joao");

        //variaveis de bike
        int tamanhoAro;
        String cor;
        String tipoBike;
        double preco;

        //1 objeto Bike ja cadastrado
        Bike bik = new Bike(29,"azul","montanha",40);

        Aluguel aluguel1 = new Aluguel(joao,bik);

        // arrays onde sao armazenados os usuarios e os alugueis
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
        ArrayList<Aluguel> alugueis = new ArrayList<>();
        usuarios.add(joao);


        while (fecharPrograma) {

            System.out.println("1 --- logar");
            System.out.println("2 --- cadastrar");
            System.out.println("0 --- fechar o programa");
            System.out.println("Sua escolha:");
            Scanner input = new Scanner(System.in);
            escolha = input.nextInt();
            input.nextLine();

            switch (escolha) {
                case 1: {

                    System.out.println("Digite seu email: ");
                    email = input.nextLine();

                    System.out.println("Digite sua senha: ");
                    senha = input.nextLine();

                    if (usuarios.isEmpty()) {
                        System.out.println("Nenhum usuario cadastrado");
                        break;
                    }

                    for (Usuario usuario : usuarios) {

                        if (usuario.getEmail().equals(email)) {
                            usuario.logar(senha);
                        } else {
                            System.out.println("Email ou senha incorretos");
                            continue;
                        }

                        while (usuario.logado) {

                            System.out.println("Usuario: " + usuario.nome);
                            System.out.println("saldo = " + usuario.saldo);
                            System.out.println("1 --- conferir saldo");
                            System.out.println("2 --- adicionar saldo");
                            System.out.println("3 --- alugar uma bike");
                            System.out.println("4 --- devolver uma bike");
                            System.out.println("0 --- sair");
                            System.out.println("Sua escolha:");
                            int escolhaLogado = input.nextInt();
                            input.nextLine();

                            switch (escolhaLogado) {
                                case 1: {
                                    System.out.println(usuario.getSaldo());
                                    continue;
                                }
                                case 2: {
                                    System.out.println("Digite o valor a ser adicionado");
                                    double valor = input.nextDouble();
                                    usuario.adicionaSaldo(valor);
                                    System.out.println("novo saldo " + usuario.getSaldo());
                                    continue;
                                }
                                case 3:{
                                    if (usuario.saldo > bik.preco){
                                        Aluguel aluguel = new Aluguel(usuario,bik);
                                        alugueis.add(aluguel);
                                        System.out.println("bike" + bik + "alugada com sucesso. Novo saldo " + usuario.getSaldo());
                                        System.out.println("O codigo do seu aluguel é: " + aluguel.getCodAluguel());
                                    }else{
                                        System.out.println("Saldo insuficiente. Você precisa de pelo menos " +
                                                bik.getPreco() + " reais de saldo para alugar.");
                                    }
                                    continue;
                                }
                                case 4:{
                                    System.out.println("digite o codigo do seu aluguel");
                                    String codAluguel = input.nextLine();
                                    for (Aluguel alug : alugueis){
                                        if (alug.getCodAluguel().equals(codAluguel)){
                                            alug.devolver();
                                        }

                                    }
                                    continue;
                                }
                                case 0: {
                                    usuario.deslogar();
                                    break;
                                }
                                default: {
                                    System.out.println("opção inválida");
                                    break;
                                }

                            }
                            break;
                        }
                        break;
                    }
                    break;
                }
                case 2: {
                    System.out.println("Digite seu nome: ");
                    nome = input.nextLine();
                    System.out.println("Digite seu email: ");
                    email = input.nextLine();
                    System.out.println("Digite sua idade: ");
                    idade = input.nextInt();
                    input.nextLine();
                    System.out.println("Digite seu senha: ");
                    senha = input.nextLine();
                    System.out.println("Digite seu cpf: ");
                    cpf = input.nextLine();

                    user = new Usuario(nome, senha, cpf, idade, email);
                    usuarios.add(user);

                    System.out.println("usuario " + user.nome + " cadastrado com sucesso!");
                    System.out.println(usuarios);
                    continue;
                }
                case 0: {
                    System.out.println("você fechou o programa");
                    fecharPrograma = false;
                    break;

                }
                default: {
                    System.out.println("opção invalida");
                }
            }
        }
    }
}


