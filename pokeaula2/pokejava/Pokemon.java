package pokejava;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static pokejava.Ataque.criarAtaques;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Pokemon {
    String nome;
    int hp;
    String tipo;
    int nivel;
    List<Ataque> ataques;


    public Pokemon(String nome, int hp, String tipo, int nivel,List<Ataque> ataques){
        this.nome = nome;
        this.hp = hp;
        this.tipo = tipo;
        this.nivel = nivel;
        this.ataques = ataques;
    }


    public static List<Pokemon> criarPokemons() {
        List<Ataque> ataques = criarAtaques();
        List<Pokemon> pokemons = new ArrayList<>();

        pokemons.add(new Pokemon("Charmander", 100, "Fogo", 5, ataques.subList(0, 3)));
        pokemons.add(new Pokemon("Squirtle", 120, "Água", 5, ataques.subList(3, 6)));
        pokemons.add(new Pokemon("Pikachu", 110, "Elétrico", 5, ataques.subList(6, 9)));
        pokemons.add(new Pokemon("Bulbasaur", 105, "Grama", 5, ataques.subList(9, ataques.size())));
        pokemons.add(new Pokemon("Ekans", 95, "Venenoso", 5, ataques.subList(0, 3)));
        pokemons.add(new Pokemon("Sandshrew", 115, "Solo", 5, ataques.subList(3, 6)));
        pokemons.add(new Pokemon("Geodude", 125, "Pedra", 5, ataques.subList(6, 9)));
        pokemons.add(new Pokemon("Pidgey", 90, "Voador", 5, ataques.subList(7, ataques.size())));
        pokemons.add(new Pokemon("Machop", 100, "Lutador", 5, ataques.subList(0, 3)));
        pokemons.add(new Pokemon("Rattata", 95, "Normal", 5, ataques.subList(3, 6)));
        pokemons.add(new Pokemon("Sandshrew", 30, "Solo", 5, ataques.subList(1, 4)));
        pokemons.add(new Pokemon("Sandshrew", 30, "Solo", 5, ataques.subList(1, 4)));
        pokemons.add(new Pokemon("Sandshrew", 30, "Solo", 5, ataques.subList(1, 4)));

        return pokemons;
    }
}



class LeitorTXT {



    public static void main(String[] args) {
    List<Ataque> ataques2 = criarAtaques();
    List<Pokemon> pokemons2 = new ArrayList<>();
        try {
            FileReader arquivo = new FileReader("pokemons.txt");
            BufferedReader lerLinha = new BufferedReader(arquivo);
            String str;
            while ((str = lerLinha.readLine()) != null) {
                String nome = lerLinha.readLine();
                int hp = Integer.parseInt(lerLinha.readLine());
                String tipo = lerLinha.readLine();
                int nivel = Integer.parseInt(lerLinha.readLine());

                Pokemon pokemon = new Pokemon(nome, hp, tipo, nivel,ataques2.subList(1, 4));
                System.out.println(pokemon.nome);
                pokemons2.add(pokemon);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}