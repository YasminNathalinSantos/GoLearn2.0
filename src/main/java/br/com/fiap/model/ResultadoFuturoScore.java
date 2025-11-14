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
public class ResultadoFuturoScore {
    private double score;
    private String nivel;
    private String recomendacao;

    public ResultadoFuturoScore(double score, String nivel, String recomendacao) {
        this.score = score;
        this.nivel = nivel;
        this.recomendacao = recomendacao;
    }

    public double getScore() { return score; }
    public String getNivel() { return nivel; }
    public String getRecomendacao() { return recomendacao; }
}
