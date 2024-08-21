package pokejava;

public class Usuario {

    String nome;
    Party party = new Party();
    pc pcUsuario = new pc();

    public Usuario(String nome){
        this.nome = nome;
    }

    public void transferirParaPc(Pokemon pokemon){
        this.pcUsuario.getPC().add(pokemon);
    }



    public void InterfacePC(){
        for(Pokemon pokemon: pcUsuario.getPC()){
            System.out.println(pokemon);
        }
    }

    public Party getParty(){
        return this.party;
    }

    public pc getPcUsuario(){
        return this.pcUsuario;
    }

}
