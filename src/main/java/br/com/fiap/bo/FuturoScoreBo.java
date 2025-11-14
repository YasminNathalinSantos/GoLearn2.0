package br.com.fiap.bo;

import br.com.fiap.model.Resposta;

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

public class FuturoScoreBo {
    public double calcular(Resposta r) {

        double score = 0;

        score += r.getUsaIaTrabalho().equals("Sim") ? 10 : 0;

        switch (r.getFrequenciaUso()) {
            case "Sempre" -> score += 10;
            case "Frequentemente" -> score += 7;
            case "Às vezes" -> score += 4;
        }

        switch (r.getConfiancaIa()) {
            case "Alta" -> score += 10;
            case "Média" -> score += 7;
            case "Baixa" -> score += 3;
        }

        score += r.getAutomatizouTarefas().equals("Sim") ? 10 : 0;

        switch (r.getIdentificaIa()) {
            case "Sim" -> score += 10;
            case "Mais ou menos" -> score += 5;
        }

        score += r.getFezCursos().equals("Sim") ? 10 : 0;

        switch (r.getNivelGenAI()) {
            case "Alto" -> score += 10;
            case "Médio" -> score += 7;
        }

        switch (r.getImpactoProfissao()) {
            case "Com certeza" -> score += 10;
            case "Talvez" -> score += 5;
        }

        switch (r.getPorcentagemAutomacao()) {
            case "75-100%" -> score += 10;
            case "50-75%" -> score += 7;
            case "25-50%" -> score += 4;
        }

        switch (r.getConheceRiscos()) {
            case "Sim" -> score += 10;
            case "Mais ou menos" -> score += 5;
        }

        return score;
    }
}
