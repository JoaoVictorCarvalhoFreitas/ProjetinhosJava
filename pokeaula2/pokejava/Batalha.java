package pokejava;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Batalha {
    Scanner input = new Scanner(System.in);
    Party party;
    Party partyRival;

    public Batalha(Party party, Party partyRival){
        this.party = party;
        this.partyRival = partyRival;
    }

    public void interfaceBatalha(){

        int contador = 0;

        while (party.partyEstaViva() && partyRival.partyEstaViva()) {
        Pokemon pokemonAtivo = this.party.party.getFirst();
        Pokemon pokemonAtivoRival = this.partyRival.party.getFirst();

            System.out.println("pokemon ativo: " + pokemonAtivo.nome + ", hp: " + pokemonAtivo.hp);
            System.out.println();
            System.out.println("pokemon ativo do Rival: " + pokemonAtivoRival.nome + ", hp: " + pokemonAtivoRival.hp);

            if (contador > 0) ataqueInimigo(pokemonAtivo, pokemonAtivoRival);
            contador = 1;
            verificahp(this.party);

            System.out.println();
            System.out.println();
            System.out.println("[1] --- atacar");
            System.out.println("[2] --- trocar pokemon");
            System.out.println("[3] mochila");
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
                    System.out.println("nao implementado ...ainda");
                    continue;
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
            for (int i = 0; i < pokemonAtivo.ataques.size(); i++) {
                Ataque ataque = pokemonAtivo.ataques.get(i);
                System.out.println((i + 1) + "-" + ataque.nome);
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
                Ataque ataqueEscolhido = pokemonAtivo.ataques.get(escolhaAtaque - 1);

                int danoAtaqueEscolhido = ataqueEscolhido.dano;

                if (probAtaque(ataqueEscolhido)){
                        {
                            if (ataqueEscolhido.tipo.equals(pokemonAtivoRival.tipo)) {
                                danoAtaqueEscolhido = (int) (danoAtaqueEscolhido * 0.5);
                            } else if (ataqueEfetivo(ataqueEscolhido.tipo, pokemonAtivoRival.tipo)) {
                                danoAtaqueEscolhido = danoAtaqueEscolhido * 2;
                            }

                            pokemonAtivoRival.hp -= danoAtaqueEscolhido;
                            System.out.println(pokemonAtivo.nome + " usou " + ataqueEscolhido);
                            System.out.println();
                            System.out.println(pokemonAtivoRival.nome + " agora tem " + pokemonAtivoRival.hp + " HP.");
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
        int ataqueAleatorio = rand.nextInt(pokemonAtivoRival.ataques.size());
        Ataque ataqueInimigo = pokemonAtivoRival.ataques.get(ataqueAleatorio);
        int danoAtaqueInimigo = ataqueInimigo.dano;

        if (probAtaque(ataqueInimigo)){

        if (ataqueInimigo.tipo.equals(pokemonAtivoRival.tipo)) {
             danoAtaqueInimigo = (int) (danoAtaqueInimigo * 0.5);
        } else if (ataqueEfetivo(ataqueInimigo.tipo, pokemonAtivoRival.tipo)) {
            danoAtaqueInimigo = danoAtaqueInimigo * 2;
        }

        System.out.println(pokemonAtivoRival.nome + " usou " + ataqueInimigo.nome + " e causou " + danoAtaqueInimigo + " de dano");
        System.out.println(pokemonAtivo.nome + " tem " + pokemonAtivo.hp + " hp restante");
        pokemonAtivo.hp -= danoAtaqueInimigo;
        }else {
            System.out.println("o seu pokemon desviou esta ataque");

        }
    }

    public void verificahp(Party party){
        if (party.party.getFirst().hp <= 0){
              for(int i = 0;i < party.party.size();i++){
                  if (party.party.get(i).hp > 0){
                      System.out.println(party.party.getFirst().nome + " faleceu. " + party.party.get(i).nome + " Apareceu");
                      Pokemon novoPoke;
                      novoPoke = party.party.get(i);
                      Pokemon primeiroPoke = party.party.getFirst();
                      party.party.set(0, novoPoke);
                      party.party.set(i,primeiroPoke);
                      break;
                  }
              }
        }
    }

    public boolean probAtaque(Ataque ataque){
        Random rand = new Random();
        double chancetentativa = (double) rand.nextInt(0, 100) /100;
        return chancetentativa < ataque.chanceAcerto;
    }
}

