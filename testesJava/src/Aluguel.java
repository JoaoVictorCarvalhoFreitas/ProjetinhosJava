import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;


public class Aluguel {
    String status = "em andamento";
    Usuario usuario;
    Bike bike;
    String codAluguel = gerarCodAleatorios();
    Instant dataInicial = Instant.now();
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


    public Instant getData(){
        return Instant.now();
    }


    public Usuario getUsuario(){
        return usuario;
    }


    public Bike getBike(){
        return bike;
    }


    public void devolver(){

        this.dataFinal = getData();
        this.status = "devolvido";
        calculaDiferencaData();
        System.out.println("A bike foi devolvido com sucesso!");
        System.out.println("Novo credito de: " + this.usuario.getSaldo() );
    }


    public String getStatus(){
        return status;
    }


    private void calculaDiferencaData(){
        Duration diferenca;
        long segundosDiferenca;

        diferenca = Duration.between(this.dataInicial, this.dataFinal);
        segundosDiferenca = diferenca.getSeconds();
        System.out.println("voce alugou por segundos: " + segundosDiferenca);
        this.usuario.saldo -= segundosDiferenca * this.bike.preco;
        if (this.usuario.getSaldo()< 0){
            System.out.println("você tem um saldo negativo de " + this.usuario.getSaldo() +"reais.");
        }
    }
}

