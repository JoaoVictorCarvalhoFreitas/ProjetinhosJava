package pokejava;
import java.util.ArrayList;
import java.util.List;

public class Ataque {
    String nome;
    int  dano;
    String tipo;
    double chanceAcerto;
    double velocidade_de_ataque;

    public Ataque(String nome,int dano,String tipo, double chanceAcerto, double velocidade_de_ataque){
        this.nome = nome;
        this.dano = dano;
        this.tipo = tipo;
        this.chanceAcerto = chanceAcerto;
        this.velocidade_de_ataque = velocidade_de_ataque;
    }

    @Override

    public String toString(){
        return "ataque "+ nome + ", tipo: "+ tipo + ", dano: "+  dano + ", chance de acerto: " + chanceAcerto+ ", velocidade: "+ velocidade_de_ataque;
    }

    public static List<Ataque> criarAtaques() {
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(new Ataque("Chama", 50, "Fogo", 0.9, 0.7));
        ataques.add(new Ataque("Jato de Água", 40, "Água", 0.85, 0.75));
        ataques.add(new Ataque("Choque do Trovão", 45, "Elétrico", 0.8, 0.8));
        ataques.add(new Ataque("Investida", 35, "Normal", 0.95, 0.85));
        ataques.add(new Ataque("Folha Navalha", 55, "Grama", 0.75, 0.65));
        ataques.add(new Ataque("Investida Venenosa", 40, "Venenoso", 0.85, 0.8));
        ataques.add(new Ataque("Ataque Areia", 30, "Solo", 0.9, 0.9));
        ataques.add(new Ataque("Investida de Pedra", 50, "Pedra", 0.8, 0.7));
        ataques.add(new Ataque("Furacão", 60, "Voador", 0.7, 0.6));
        ataques.add(new Ataque("Pancada", 55, "Lutador", 0.75, 0.7));
        return ataques;
    }
}
