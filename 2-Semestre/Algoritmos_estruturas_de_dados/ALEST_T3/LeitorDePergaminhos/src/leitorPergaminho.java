
import java.io.BufferedReader; //  Importação da classe BufferedReader para salvar as linhas em Strings
import java.io.FileReader; //  Importação da classe FileReader para ler os arquivos
import java.io.File; //  Importação da classe File para armazenar o caminho do arquivo
import java.io.IOException; //  Importação das Exceptions para a realização do tratamento de exceções

public class leitorPergaminho { // Classe leitor Pergaminho

    File file = null; // file = armazena o caminho para o arquivo do pergaminho
    FileReader fr = null; // fr = irá ler o arquivo do pergaminho
    BufferedReader br = null; // br = irá salvar as linhas do arquivo em strings que terão seus dados salvos

    FileReader fr0 = null; // fr0 = essa instância de file reader irá ler o mesmo arquivo do pergaminho
    BufferedReader br0 = null; // br0 = essa instância de buffered reader irá salvar apenas a primeira linha

    String[] info; // Informações de uma linha
    int terrasInicial; // Quantidade de terras inicial
    int terrasFilho; // Número de terras que um filho terá
    String nomePai; // Nome do pai do guerreiro
    String nomeFilho; // Nome do guerreiro filho

    public TriboBarbaria[] lerPergaminho() throws IOException {
        TriboBarbaria TB[] = new TriboBarbaria[100]; // Criação arranjo de TriboBarbaria


        //PROF COLOCAR CAMINHO AQUI!!!
        //PROF COLOCAR CAMINHO AQUI!!!
        //PROF COLOCAR CAMINHO AQUI!!!
        //PROF COLOCAR CAMINHO AQUI!!!
        file = new File("COLOCAR CAMINHO AQUI!!!!"); // Caminho para o arquivo texto do pergaminho


        
        fr0 = new FileReader(file); // fr0 recebe file (path para o arquivo do pergaminho)
        br0 = new BufferedReader(fr0); // br0 recebe file reader

        String linha = br0.readLine();// Lê a primeira linha e salva seu valor
        terrasInicial = Integer.valueOf(linha);// transforma o valor da primeira linha para int
        String linha2 = br0.readLine();// Lê e salva o valor da segunda linha
        info = linha2.split(" ");// divide a segunda linha nos espaços
        TriboBarbaria GuerreiroInit = new TriboBarbaria("", info[0], terrasInicial, 1);// Cria um objeto GuerreiroInit com o valor do paizão, paizão faz parte da primeira geração
        TB[0] = GuerreiroInit;// salva o paizão no array de guerreiros
        br0.close(); // br0 foi fechado
        fr0.close(); // fr0 foi fechado

        // Será criado um novo FileReader e BufferedReader
        // Para começar a leitura do arquivo desde o início

        fr = new FileReader(file); // fr recebe file (path para o arquivo do pergaminho)
        br = new BufferedReader(fr); // br recebe file reader
        String linhaNova = br.readLine(); // Pula a primeira linha
        int i = 1; // Pula para a próxima posição
        try {
            while (linhaNova != null) { // Verificar se linha nova não é nula
                linhaNova = br.readLine(); // Leitura da próxima linha e armazenamento da sua informação
                info = linhaNova.split(" "); // A linha será divididade entre os espaços e será adicionada ao arranjo info
                nomePai = info[0]; // a primeira posição (0) será o pai
                nomeFilho = info[1];// a segunda posição (1) será o filho
                terrasFilho = Integer.valueOf(info[2]);// a terceira posição (3) será a quantidade de terras que o filho conquistou em sua vida
                TriboBarbaria Guerreiro = new TriboBarbaria(nomePai, nomeFilho, terrasFilho,0); // Novo guerreiro filho será adicionado
                TB[i] = Guerreiro;// enche a tribo barbara de guerreiro
                i++; // Passar para próxima linha
            }
        } catch (Exception e) {

            System.out.println("FIM DA LEITURA"); // Quando a leitura chegar em (null), essa mensagem aparecerá
        }

        return TB; // Retorno do arranjo de Tribo Barbária
    }

}
