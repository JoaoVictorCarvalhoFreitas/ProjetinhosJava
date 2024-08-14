import java.util.UUID;

public class Bike {
    int tamanhoAro;
    String cor;
    String tipoBike;
    String id = gerarIdUnicos();
    double preco;

    public Bike(int tamanhoAro, String cor, String tipoBike, double preco){
        this.tamanhoAro=tamanhoAro;
        this.cor=cor;
        this.tipoBike=tipoBike;
        this.preco = preco;

    }

    private String gerarIdUnicos(){
        return UUID.randomUUID().toString();
    }
    public String getId(){
        return id;
    }

    public double getPreco(){
        return preco;
    }











}





