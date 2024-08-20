package pokejava;
import java.util.Scanner;


public class Pokejava {

    public static void main(String[] args) {

        boolean jogoAtivo = true;

        Scanner input = new Scanner(System.in);


        Usuario player1 = new Usuario("Joao");
        Usuario player2 = new Usuario("Maria");
        player1.party.escolherPokemon(true,6);
        player2.party.escolherPokemon(true, 4);

        while (jogoAtivo){
        Batalha player1Batalha = new Batalha(player1.party,player2.party);
        player1Batalha.interfaceBatalha();
        }
    }
}