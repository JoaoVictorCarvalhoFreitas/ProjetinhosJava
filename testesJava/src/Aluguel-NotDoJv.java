import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;


public class Aluguel {
    String status = "em andamento";
    Usuario usuario;
    Bike bike;
    String codAluguel = gerarCodAleatorios();
    Instant dataInicial = obterData();
    Instant dataFinal;

    public Aluguel(Usuario usuario,Bike bike){
        this.usuario = usuario;
        this.bike = bike;


    }
    public String gerarCodAleatorios(){
        return UUID.randomUUID().toString();
    }
    public String getCodAluguel(){
        return codAluguel;
    }

    public Instant obterData(){
        return Instant.now();
    }

    public Usuario getUsuario(){
        return usuario;
    }
    public Bike getBike(){
        return bike;
    }

    public void devolver(){
        this.dataFinal = obterData();
        this.status = "devolvido";

        calculaDiferencaData();

    }
    public String getStatus(){
        return status;
    }
    public void calculaDiferencaData(){
        Duration diferenca;
        long segundosDiferenca;

        diferenca = Duration.between(this.dataInicial,this.dataFinal);
        segundosDiferenca = diferenca.getSeconds();
        this.usuario.saldo -= segundosDiferenca * this.bike.preco;

        System.out.println("você alugou por " + segundosDiferenca + " segundos");
        System.out.println("o preço do aluguel foi de " + this.bike.preco*segundosDiferenca + " segundos");
        if (this.usuario.getSaldo()< 0){
            System.out.println("você deve adicionar " + this.usuario.getSaldo() +"reais de saldo para nao ficar negativo.");
        }
        else System.out.println("Novo saldo de " + this.usuario.getSaldo() +"reais.");
    }
}

