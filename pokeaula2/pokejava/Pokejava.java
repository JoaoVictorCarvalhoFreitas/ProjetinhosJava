package pokejava;
import java.util.Scanner;


public class Pokejava {

    public static void main(String[] args) {
        boolean jogoAtivo = true;
        Scanner input = new Scanner(System.in);
        Party player1 = new Party();
        Party player2 = new Party();
        player1.escolherPokemon(true,6);
        player2.escolherPokemon(true, 4);

        while (jogoAtivo){
        Batalha player1Batalha = new Batalha(player1,player2);
        player1Batalha.interfaceBatalha();
        }
    }
}