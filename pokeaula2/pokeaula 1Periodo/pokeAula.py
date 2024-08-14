from ast import Match
import random

class Batalha:


    def ataque_efetivo(tipo_atacante, tipo_defensor):
        if tipo_atacante == "Fire" and tipo_defensor in ["Grass", "Bug", "Ice"]:
            return True
        elif tipo_atacante == "Water" and tipo_defensor in ["Fire", "Ground", "Rock"]:
            return True
        elif tipo_atacante == "Electric" and tipo_defensor in ["Water", "Flying"]:
            return True
        elif tipo_atacante == "Grass" and tipo_defensor in ["Water", "Ground", "Rock"]:
            return True
        elif tipo_atacante == "Ice" and tipo_defensor in ["Grass", "Ground", "Flying", "Dragon"]:
            return True
        elif tipo_atacante == "Fighting" and tipo_defensor in ["Normal", "Ice", "Rock", "Dark", "Steel"]:
            return True
        elif tipo_atacante == "Poison" and tipo_defensor in ["Grass", "Fairy"]:
            return True
        elif tipo_atacante == "Ground" and tipo_defensor in ["Fire", "Electric", "Poison", "Rock", "Steel"]:
            return True
        elif tipo_atacante == "Flying" and tipo_defensor in ["Grass", "Fighting", "Bug"]:
            return True
        elif tipo_atacante == "Psychic" and tipo_defensor in ["Fighting", "Poison"]:
            return True
        elif tipo_atacante == "Bug" and tipo_defensor in ["Grass", "Psychic", "Dark"]:
            return True
        elif tipo_atacante == "Rock" and tipo_defensor in ["Fire", "Ice", "Flying", "Bug"]:
            return True
        elif tipo_atacante == "Ghost" and tipo_defensor in ["Psychic", "Ghost"]:
            return True
        elif tipo_atacante == "Dragon" and tipo_defensor in ["Dragon"]:
            return True
        elif tipo_atacante == "Dark" and tipo_defensor in ["Psychic", "Ghost"]:
            return True
        elif tipo_atacante == "Steel" and tipo_defensor in ["Ice", "Rock", "Fairy"]:
            return True
        elif tipo_atacante == "Fairy" and tipo_defensor in ["Fighting", "Dragon", "Dark"]:
            return True
        else:
            return False


    def fugir():
      fugir = random.randint(1,100)
      return fugir < 35

    def atacar(self,pokemon_ativo,pokemonRival):
      for i, ataque in enumerate(pokemon_ativo.ataques):
        print(f"{i+1}-{ataque.nome}")

      escolha_ataque = int(input("escolha o ataque!"))
      ataque_escolhido = pokemon_ativo.ataques[escolha_ataque-1]
      dano_ataque_escolhido = pokemon_ativo.ataques[escolha_ataque-1].dano

      if ataque_escolhido.tipo == pokemonRival.tipo:
        dano_ataque_escolhido -= dano_ataque_escolhido*0.5
      elif self.ataque_efetivo(ataque_escolhido.tipo, pokemonRival.tipo):
        dano_ataque_escolhido -= dano_ataque_escolhido*2

      pokemonRival.hp -= dano_ataque_escolhido

    def esta_vivo(self,pokemon):
      print(pokemon.nome)
      print(pokemon.hp)
      return pokemon.hp > 0

    def party_esta_viva(self,party):
      for pokemon in party.lista_pokemons:
        print(pokemon.nome)
        if self.esta_vivo(pokemon):
          return True
      return False

    def interface_batalha(self,partyPlayer,partyNpc):

      pokemon_player_ativo = partyPlayer.lista_pokemons[0]
      pokemonNpc_ativo = partyNpc.lista_pokemons[0]

      while self.party_esta_viva(partyPlayer) and self.party_esta_viva(partyNpc):
          print("[1] - atacar")
          print("[2] - trocar pokemon")
          print("[3] - mochila")
          print("[4] - fugir")
          acao_atual = input("escolha a proxima ação: ")

          match acao_atual:
            case "1":
              print("atacar")
              self.atacar(pokemon_player_ativo,pokemonNpc_ativo)
            case "2":
              break
            case "3":
              print("mochila")
            case "4":
              if self.fugir():
                print("você conseguiu fugir")
                break
              print("você não conseguiu fugir")
            case _:
              print("opção invalida")



class Ataque:
    def __init__(self, nome, dano, tipo, chance_de_acerto, velocidade_de_ataque):
        self.nome = nome
        self.dano = dano
        self.tipo = tipo
        self.chance_de_acerto = chance_de_acerto
        self.velocidade_de_ataque = velocidade_de_ataque

class Pokemon:
    def __init__(self, nome, hp, tipo, nivel, ataques):
        self.nome = nome
        self.hp = hp
        self.tipo = tipo
        self.nivel = nivel
        self.ataques = ataques


class Party:
    def __init__(self,lista_pokemons = []):
        self.lista_pokemons = lista_pokemons    

    def escolher_pokemon(self,randomico = False):
      if randomico:
        self.lista_pokemons.append(random.sample(pokemons,6))
      else:
          for i in range(1):
              for j,pokemon in enumerate(pokemons):
                print(f"{j+1}- {pokemon.nome} ")
              while True:
                escolha = input("digite sua escolha ")
                try:
                  escolha = int(escolha)

                except ValueError:
                  print("opção invalida.")
                  pass
                  continue
                pokemon_escolhido = pokemons[escolha-1]
                print(f"O pokemon escolhido foi {pokemon_escolhido.nome}")
                break


              self.lista_pokemons.append(pokemon_escolhido)
          print("sua party atual é: ")
          for poke in self.lista_pokemons:
            print(poke.nome)


def criar_ataques():
    ataques = []
    ataques.append(Ataque("Chama", 50, "Fogo", 0.9, 0.7))
    ataques.append(Ataque("Jato de Água", 40, "Água", 0.85, 0.75))
    ataques.append(Ataque("Choque do Trovão", 45, "Elétrico", 0.8, 0.8))
    ataques.append(Ataque("Investida", 35, "Normal", 0.95, 0.85))
    ataques.append(Ataque("Folha Navalha", 55, "Grama", 0.75, 0.65))
    ataques.append(Ataque("Investida Venenosa", 40, "Venenoso", 0.85, 0.8))
    ataques.append(Ataque("Ataque Areia", 30, "Solo", 0.9, 0.9))
    ataques.append(Ataque("Investida de Pedra", 50, "Pedra", 0.8, 0.7))
    ataques.append(Ataque("Furacão", 60, "Voador", 0.7, 0.6))
    ataques.append(Ataque("Pancada", 55, "Lutador", 0.75, 0.7))
    return ataques

def criar_pokemons():
    pokemons = []
    pokemons.append(Pokemon("Charmander", 100, "Fogo", 5, criar_ataques()[:3]))
    pokemons.append(Pokemon("Squirtle", 120, "Água", 5, criar_ataques()[3:6]))
    pokemons.append(Pokemon("Pikachu", 110, "Elétrico", 5, criar_ataques()[6:9]))
    pokemons.append(Pokemon("Bulbasaur", 105, "Grama", 5, criar_ataques()[9:]))
    pokemons.append(Pokemon("Ekans", 95, "Venenoso", 5, criar_ataques()[:3]))
    pokemons.append(Pokemon("Sandshrew", 115, "Solo", 5, criar_ataques()[3:6]))
    pokemons.append(Pokemon("Geodude", 125, "Pedra", 5, criar_ataques()[6:9]))
    pokemons.append(Pokemon("Pidgey", 90, "Voador", 5, criar_ataques()[9:]))
    pokemons.append(Pokemon("Machop", 100, "Lutador", 5, criar_ataques()[:3]))
    pokemons.append(Pokemon("Rattata", 95, "Normal", 5, criar_ataques()[3:6]))
    return pokemons


pokemons = criar_pokemons()
player = Party()
rival = Party()


player.escolher_pokemon()
rival.escolher_pokemon(True)
batalha_atual = Batalha()
batalha_atual.interface_batalha(player,rival)





