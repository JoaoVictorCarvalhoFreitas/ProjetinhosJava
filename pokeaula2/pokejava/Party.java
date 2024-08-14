package pokejava;
import java.util.*;




import static pokejava.Pokemon.criarPokemons;

public class Party {
    ArrayList<Pokemon> party = new ArrayList<>();

    public void adPokemonParty(Pokemon pokemon) {
        if(party.size() < 6) {
            party.add(pokemon);
        }else{
            System.out.println("party esta cheia");
        }
    }
    public void removerPokemon(String nome) {
        for (int i = 0; i < party.size(); i++) {
            if (party.get(i).nome.equals(nome)) {
                party.remove(i);
            }
        }
    }

    public boolean estaViva(Pokemon pokemon) {
        System.out.println(pokemon.nome);
        System.out.println(pokemon.hp);
        return pokemon.hp > 0;
    }

    public boolean partyEstaViva() {
        if(!this.party.isEmpty()){
            for (int i = 0; i < this.party.size(); i++) {
                if ((this.party.get(i).hp > 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void escolherPokemon(boolean randomico) {
        Random rand = new Random();
        int tamanhoParty = 5;
        if (randomico) {
            for (int i = 0; i < tamanhoParty; i++) {
                int numRandom = rand.nextInt();
                this.adPokemonParty(Pokemon.criarPokemons().get(numRandom));
            }

        }

    }

    public void trocarPokemon(){
        Scanner input = new Scanner(System.in);
        for(int i = 0;i < this.party.size();i++){
            System.out.println(i+1 +" --- " + this.party.get(i).nome);
        }
        int indice = input.nextInt()-1;
        input.nextLine();
        System.out.println("sua escolha: ");

        System.out.println("voce trocou " + this.party.getFirst().nome + " por " + this.party.get(indice).nome);
        ;
        Collections.swap(this.party, 0, indice);
    }

    public void trocarPokemon(int indice){
        Collections.swap(this.party, 0, indice);
    }

    public void escolherPokemon(boolean randomico, int tamanhoParty) {
        Random rand = new Random();
        if (randomico) {
            for (int i = 0; i < tamanhoParty; i++) {
                int numRandom = rand.nextInt(10);
                this.adPokemonParty(Pokemon.criarPokemons().get(numRandom));
            }
        }
    }

    public void escolherPokemon() {
        int tamanhoParty = 6;
        Scanner input = new Scanner(System.in);

        List<Pokemon> pokemons = criarPokemons();
        for (int i = 0; i < pokemons.size(); i++) {
            System.out.println(i + 1 + " --- " + pokemons.get(i).nome  );
        }

        for (int i = 0; i < tamanhoParty; i++) {

            System.out.println("Escolha o pokemon " + i);
            System.out.println("Digite 0 para sair.");
            int escolha = input.nextInt() -1;
            input.nextLine();
            if (escolha == -1) {
                break;
            }

            this.adPokemonParty(pokemons.get(escolha));

            System.out.println("pokemon " + pokemons.get(escolha).nome + " adicionado a party " );
            System.out.println();
            System.out.println(this.party.size() +" pokemons escolhidos de 6");
            System.out.println("Pokemons escolhidos: ");
            for (Pokemon pokemon2 : this.party) {
                System.out.println(pokemon2.nome);
            }
        }
    }
}