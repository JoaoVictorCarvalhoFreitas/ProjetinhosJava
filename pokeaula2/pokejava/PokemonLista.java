package pokejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonLista {

    public static List<Pokemon> criarPokemonsDeArquivo(String caminhoArquivo) {
        List<Ataque> ataques = Ataque.criarAtaques(); // Supondo que você já tenha este método
        List<Pokemon> pokemons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Pular o cabeçalho, se houver
            br.readLine();

            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length == 5) {
                    String nome = partes[0];
                    int hp = Integer.parseInt(partes[1]);
                    String tipo = partes[2];
                    int nivel = Integer.parseInt(partes[3]);
                    List<Integer> indicesAtaques = Arrays.stream(partes[4].split(","))
                            .map(Integer::parseInt)
                            .collect(Collectors.toList());

                    List<Ataque> listaAtaques = indicesAtaques.stream()
                            .map(ataques::get)
                            .collect(Collectors.toList());

                    Pokemon pokemon = new Pokemon(nome, hp, tipo, nivel, listaAtaques);
                    pokemons.add(pokemon);
                } else {
                    System.out.println("Linha inválida no arquivo: " + linha);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return pokemons;
    }
}
