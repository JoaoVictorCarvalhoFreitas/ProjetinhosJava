package pokejava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AtaquesLista {

    public static List<Ataque> criarAtaquesDeArquivo(String caminhoArquivo) {
        List<Ataque> ataques = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Pular o cabeçalho

            br.readLine();
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(";");

                if (partes.length == 5) {
                    String nome = partes[0];
                    int poder = Integer.parseInt(partes[1]);
                    String tipo = partes[2];
                    double ChanceAcerto = Double.parseDouble(partes[3]);
                    double critico = Double.parseDouble(partes[4]);

                    Ataque ataque = new Ataque(nome, poder, tipo, ChanceAcerto, critico);
                    ataques.add(ataque);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ataques;
    }
}