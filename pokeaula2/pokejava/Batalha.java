package pokejava;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    Scanner input = new Scanner(System.in);
    private Party party;
    private Party partyRival;
    Usuario usuario;


    public Batalha(Usuario usuario,Party PartyRival){
        this.usuario = usuario;
        this.partyRival = PartyRival;
        this.party = this.usuario.getParty();
    }

    public void interfaceBatalha(){

        int contador = 0;
        while (party.partyEstaViva() && partyRival.partyEstaViva()) {
        Pokemon pokemonAtivo = this.party.getParty().getFirst();
        Pokemon pokemonAtivoRival = this.partyRival.getParty().getFirst();

            System.out.println("pokemon ativo: " + pokemonAtivo.getNome() + ", hp: " + pokemonAtivo.getHp());
            System.out.println();
            System.out.println("pokemon ativo do Rival: " + pokemonAtivoRival.getNome() + ", hp: " + pokemonAtivoRival.getHp());

            if (contador > 0) ataqueInimigo(pokemonAtivo, pokemonAtivoRival);
            contador = 1;
            verificahp(this.party);

            System.out.println();
            System.out.println();
            System.out.println("[1] --- atacar");
            System.out.println("[2] --- trocar pokemon");
            System.out.println("[3] pc");
            System.out.println("[4] --- fugir ");
            System.out.println("sua escolha: ");

            int escolha;
            try {
                escolha = input.nextInt();
                input.nextLine();
            } catch (Exception e) {
                System.out.println("opção invalida tente de novo");
                input.nextLine();
                continue;
            }
            switch (escolha) {
                case 1: {
                    atacar(pokemonAtivo, pokemonAtivoRival);
                    verificahp(this.partyRival);
                    continue;
                }
                case 2: {
                    party.trocarPokemon();
                    continue;
                }
                case 3: {
                    while(true){
                        System.out.println("[1] --- colocar pokemon do pc na party");
                        System.out.println("[2] --- colocar pokemon no pc");
                        System.out.println("[0] sair");
                        System.out.println("sua escolha: ");
                        int escolhaPC = input.nextInt();
                        input.nextLine();
                        switch (escolhaPC) {
                            case 1: {
                                System.out.println("Pokemons no Pc :");
                                System.out.println();
                                System.out.println("PC: ");
                                int cont = 1;
                                for (Pokemon poke : usuario.pcUsuario.getPC()) {
                                    System.out.println(cont + " --- pokemon: " + poke.getNome() + "--- hp: " + poke.getHp());
                                    cont++;
                                }

                                System.out.println("escolha qual pokemon do Pc você quer colocar na party");

                                int pokeTroca = input.nextInt();
                                input.nextLine();
//                                adiciona o pokemon no pc e retira da party
                                party.adPokemonParty(usuario.pcUsuario.getPC().get(pokeTroca - 1));
                                usuario.pcUsuario.removerPokemon(pokeTroca);

                                System.out.println("PC: ");
                                cont = 1;
                                for (Pokemon poke : usuario.pcUsuario.getPC()) {
                                    System.out.println(cont + " --- pokemon: " + poke.getNome() + "--- hp: " + poke.getHp());
                                    cont++;
                                }
                                continue;
                            }
                            case 2: {
                                int cont = 1;
                                System.out.println("party: ");
                                System.out.println();
                                for (Pokemon poke : party.getParty()) {
                                    System.out.println(cont + " --- " + poke.getNome());
                                    System.out.println("hp ---" + poke.getHp());
                                    cont++;
                                }
                                System.out.println("Escolha o pokemon da sua party que você quer colocar no pc");
                                int pokeTroca = input.nextInt();
                                input.nextLine();
                                this.usuario.pcUsuario.adicionaPoke(party.getParty().get(pokeTroca - 1));
                                party.removerPokemon(pokeTroca);

                                cont = 1;
                                System.out.println("Party: ");
                                for (Pokemon poke : party.getParty()) {
                                    System.out.println(cont + " --- " + poke.getNome());
                                    System.out.println("hp ---" + poke.getHp());
                                    cont++;
                                }
                                continue;
                            }
                            default: {
                                System.out.println("opcao invalida tente novamente");
                                continue;
                            }
                            case 0: {
                                System.out.println("saindo ");
                                break;
                            }
                        }
                        break;
                    }

                }
                case 4: {
                    if (Batalha.fugir()) {
                        System.out.println("voce conseguiu fugir");
                        break;
                    } else {
                        System.out.println("voce nao consguiu fugir");
                        continue;
                    }
                }
                default: {
                    System.out.println("opção invalida tente novamente");
                    continue;
                }
            }
        }
    }

    public static boolean fugir(){
        int chance;
        chance = (int)(Math.random()*100);
        return chance > 35;
    }

    public boolean ataqueEfetivo(String tipoAtacante, String tipoDefensor) {
        if (tipoAtacante.equals("Fire") && Arrays.asList("Grass", "Bug", "Ice").contains(tipoDefensor)) {
            return true;
        }else if (tipoAtacante.equals("Water") && Arrays.asList("Fire", "Ground", "Rock").contains(tipoDefensor)) {
            return true;
        }else if (tipoAtacante.equals("Electric") && Arrays.asList("Water", "Flying").contains(tipoDefensor)) {
            return true;
        }else if (tipoAtacante.equals("Grass") && Arrays.asList("Water", "Ground", "Rock").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Ice") && Arrays.asList("Grass", "Ground", "Flying", "Dragon").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Fighting") && Arrays.asList("Normal", "Ice", "Rock", "Dark", "Steel").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Poison") && Arrays.asList("Grass", "Fairy").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Ground") && Arrays.asList("Fire", "Electric", "Poison", "Rock", "Steel").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Flying") && Arrays.asList("Grass", "Fighting", "Bug").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Psychic") && Arrays.asList("Fighting", "Poison").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Bug") && Arrays.asList("Grass", "Psychic", "Dark").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Rock") && Arrays.asList("Fire", "Ice", "Flying", "Bug").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Ghost") && Arrays.asList("Psychic", "Ghost").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Dragon") && Arrays.asList("Dragon").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Dark") && Arrays.asList("Psychic", "Ghost").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Steel") && Arrays.asList("Ice", "Rock", "Fairy").contains(tipoDefensor)) {
            return true;
        } else if (tipoAtacante.equals("Fairy") && Arrays.asList("Fighting", "Dragon", "Dark").contains(tipoDefensor)) {
            return true;
        } else {
            return false;
        }
    };

    public void atacar(Pokemon pokemonAtivo,Pokemon pokemonAtivoRival){
        Scanner input = new Scanner(System.in);

        while(true) {
            for (int i = 0; i < pokemonAtivo.getAtaques().size(); i++) {
                Ataque ataque = pokemonAtivo.getAtaques().get(i);
                System.out.println((i + 1) + "-" + ataque.getNome());
            }
            System.out.print("Escolha o ataque: ");
            int escolhaAtaque;
            try {
                escolhaAtaque = input.nextInt();
                input.nextLine();

            } catch (Exception e) {
                System.out.println("opção invalida tente novamente");
                input.nextLine();
                continue;
            }
            try{
                Ataque ataqueEscolhido = pokemonAtivo.getAtaques().get(escolhaAtaque - 1);

                int danoAtaqueEscolhido = ataqueEscolhido.getDano();

                if (probAtaque(ataqueEscolhido)){
                        {
                            if (ataqueEscolhido.getTipo().equals(pokemonAtivoRival.getTipo())) {
                                danoAtaqueEscolhido = (int) (danoAtaqueEscolhido * 0.5);
                            } else if (ataqueEfetivo(ataqueEscolhido.getTipo(), pokemonAtivoRival.getTipo())) {
                                danoAtaqueEscolhido = danoAtaqueEscolhido * 2;
                            }

                            pokemonAtivoRival.diminuirHP(danoAtaqueEscolhido);
                            System.out.println(pokemonAtivo.getNome() + " usou " + ataqueEscolhido);
                            System.out.println();
                            System.out.println(pokemonAtivoRival.getNome() + " agora tem " + pokemonAtivoRival.getHp() + " HP.");
                            System.out.println();
                        }
                }
                else{
                    System.out.println("o pokemon adversario desviou esta ataque");
                    break;
                }
            }
            catch (Exception e){
            System.out.println("Opcao invalida tente novamente");
            continue;
            }
            break;
        }
    }

    public  void ataqueInimigo(Pokemon pokemonAtivo, Pokemon pokemonAtivoRival){
        Random rand = new Random();
        int ataqueAleatorio = rand.nextInt(pokemonAtivoRival.getAtaques().size());
        Ataque ataqueInimigo = pokemonAtivoRival.getAtaques().get(ataqueAleatorio);
        int danoAtaqueInimigo = ataqueInimigo.getDano();

        if (probAtaque(ataqueInimigo)){

        if (ataqueInimigo.getTipo().equals(pokemonAtivoRival.getTipo())) {
             danoAtaqueInimigo = (int) (danoAtaqueInimigo * 0.5);
        } else if (ataqueEfetivo(ataqueInimigo.getTipo(), pokemonAtivoRival.getTipo())) {
            danoAtaqueInimigo = danoAtaqueInimigo * 2;
        }

        System.out.println(pokemonAtivoRival.getNome() + " usou " + ataqueInimigo.getNome() + " e causou " + danoAtaqueInimigo + " de dano");
        System.out.println(pokemonAtivo.getNome() + " tem " + pokemonAtivo.getHp() + " hp restante");
        pokemonAtivo.diminuirHP(danoAtaqueInimigo);
        }else {
            System.out.println("o seu pokemon desviou esta ataque");

        }
    }

    public void verificahp(Party party){
        if (party.getParty().getFirst().getHp() <= 0){
              for(int i = 0;i < party.getParty().size();i++){
                  if (party.getParty().get(i).getHp() > 0){
                      System.out.println(party.getParty().getFirst().getNome() + " faleceu. " + party.getParty().get(i).getNome() + " Apareceu");
                      party.TrocaPokemon(0,1);
                      break;
                  }
              }
        }
    }

    public boolean probAtaque(Ataque ataque){
        Random rand = new Random();
        double chancetentativa = (double) rand.nextInt(0, 100) /100;
        return chancetentativa < ataque.getChanceAcerto() ;
    }
}

