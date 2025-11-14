package br.com.fiap.model;
/*
PERGUNTAS DO QUESTIONÁRIO FUTURO SCORE - QUE ESTA NO FRONT
1) usaIaTrabalho – Sim/Não
2) frequenciaUso – Sempre/Frequentemente/Às vezes
3) confiancaIa – Alta/Média/Baixa
4) automatizouTarefas – Sim/Não
5) identificaIa – Sim/Mais ou menos/Não
6) fezCursos – Sim/Não
7) nivelGenAI – Alto/Médio/Baixo
8) impactoProfissao – Com certeza/Talvez/Não sei
9) porcentagemAutomacao – 75-100% / 50-75% / 25-50% / 0-25%
10) conheceRiscos – Sim / Mais ou menos / Não


OBS: AS RESPOSTAS TEM QUE SER IDENTICAS POR QUE NO FRONTEND SÃO BOTOES PARA MELHOR INTERÇÃO COM O USUARIO
*/
public class Resposta {
    private int id;
    private String nome;
    private String email;

    private String usaIaTrabalho;
    private String frequenciaUso;
    private String confiancaIa;
    private String automatizouTarefas;
    private String identificaIa;
    private String fezCursos;
    private String nivelGenAI;
    private String impactoProfissao;
    private String porcentagemAutomacao;
    private String conheceRiscos;

    private double futuroScore;

    public Resposta() {}

    public String getAutomatizouTarefas() {
        return automatizouTarefas;
    }

    public void setAutomatizouTarefas(String automatizouTarefas) {
        this.automatizouTarefas = automatizouTarefas;
    }

    public String getConfiancaIa() {
        return confiancaIa;
    }

    public void setConfiancaIa(String confiancaIa) {
        this.confiancaIa = confiancaIa;
    }

    public String getConheceRiscos() {
        return conheceRiscos;
    }

    public void setConheceRiscos(String conheceRiscos) {
        this.conheceRiscos = conheceRiscos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFezCursos() {
        return fezCursos;
    }

    public void setFezCursos(String fezCursos) {
        this.fezCursos = fezCursos;
    }

    public String getFrequenciaUso() {
        return frequenciaUso;
    }

    public void setFrequenciaUso(String frequenciaUso) {
        this.frequenciaUso = frequenciaUso;
    }

    public double getFuturoScore() {
        return futuroScore;
    }

    public void setFuturoScore(double futuroScore) {
        this.futuroScore = futuroScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdentificaIa() {
        return identificaIa;
    }

    public void setIdentificaIa(String identificaIa) {
        this.identificaIa = identificaIa;
    }

    public String getImpactoProfissao() {
        return impactoProfissao;
    }

    public void setImpactoProfissao(String impactoProfissao) {
        this.impactoProfissao = impactoProfissao;
    }

    public String getNivelGenAI() {
        return nivelGenAI;
    }

    public void setNivelGenAI(String nivelGenAI) {
        this.nivelGenAI = nivelGenAI;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPorcentagemAutomacao() {
        return porcentagemAutomacao;
    }

    public void setPorcentagemAutomacao(String porcentagemAutomacao) {
        this.porcentagemAutomacao = porcentagemAutomacao;
    }

    public String getUsaIaTrabalho() {
        return usaIaTrabalho;
    }

    public void setUsaIaTrabalho(String usaIaTrabalho) {
        this.usaIaTrabalho = usaIaTrabalho;
    }
}
