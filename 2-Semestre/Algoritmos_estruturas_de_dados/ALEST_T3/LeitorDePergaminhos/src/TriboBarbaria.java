
public class TriboBarbaria {    // Classe TriboBarbaria


    // Cada guerreiro vai ter os seguintes atributos:
    private String nomePai;// Nome do pai
    private String nome;// Nome do guerreiro
    private int terras;// terras do guerreiro
    private int gen; // Geração

    
    public TriboBarbaria(String nomePai, String nome, int terras, int gen) { // Método construtor Tribo Barbaria
        this.nomePai = nomePai;
        this.nome = nome;
        this.terras = terras;
        this.gen = gen;
    }


    // Setters

    public void SetNomePai(String novo) {           // Pai
        this.nomePai = novo;
    }

    public void SetNome(String novo) {              // Nome          
        this.nome = novo;
    }

    public void SetTerras(int novo) {               // Terras
        this.terras = novo;
    }
    
    public void SetGen(int novo){
        this.gen = novo;                            // Geração
    }

    // Getters

    public String GetNomePai() {        // Pai
        return this.nomePai;
    }

    public String GetNome() {           // Nome
        return this.nome;
    }

    public int GetTerras() {            // Terras
        return this.terras;
    }

    public int GetGen(){
        return this.gen;                // Geração
    }


    @Override
    // Metodo ToString
    public String toString() {
        return "Guerreiro [Nome Pai=" + this.nomePai + ", Nome=" + this.nome + ", Terras="
                + this.terras+ ", Número geração=" + this.gen + "]";
    }

    //Teste
    //public static void main(String args[]) {
    //    TriboBarbaria T = new TriboBarbaria("Zeus", "Ares", 100000,0);
    //    System.out.print(T.toString());
    //}
}