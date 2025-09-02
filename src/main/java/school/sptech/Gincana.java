package school.sptech;

public class Gincana {
    private String nome;
    private Double premio;
    private Integer qtdInscrito = 0;
    private Boolean ativa = true;

    public Gincana(String nome, Double premio){
        this.nome = nome;
        this.premio = premio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPremio() {
        return premio;
    }

    public Integer getQtdInscrito() {
        return qtdInscrito;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void inscrever(Integer qtd){
        if(ativa && qtd != null && qtd > 0){
            this.qtdInscrito += qtd;
        }
    }

    public Integer remover(Integer qtd){
        if(ativa && qtd != null && qtd > 0 && qtd <= qtdInscrito) {
            this.qtdInscrito -= qtd;
            return qtd;
        } else {
            return null;
        }
    }

    public Integer desativar(){
        if(ativa){
            Integer qtdInscritoAnterior = qtdInscrito;
            qtdInscrito = 0;
            ativa = false;
            return qtdInscritoAnterior;
        } else {
            return null;
        }
    }

    public void transferir(Gincana destino, Integer qtdATransferir){
        if(this.ativa && destino != null && destino.getAtiva() && qtdATransferir != null
                && qtdATransferir > 0 && qtdATransferir <= this.qtdInscrito){
            this.qtdInscrito -= qtdATransferir;
            destino.inscrever(qtdATransferir);
        }
    }

    public Boolean reajustarPremio(Double reajuste){
        if(reajuste != null && reajuste > 0) {
            this.premio = this.premio + (this.premio * reajuste);
            return true;
        } else {
            return  false;
        }
    }
}
