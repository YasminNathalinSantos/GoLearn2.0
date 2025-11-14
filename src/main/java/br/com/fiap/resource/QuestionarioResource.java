package br.com.fiap.resource;

import br.com.fiap.bo.FuturoScoreBo;
import br.com.fiap.dao.RespostaDao;
import br.com.fiap.model.Resposta;
import br.com.fiap.model.ResultadoFuturoScore;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

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

@Path("/questionario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QuestionarioResource {

    private RespostaDao dao = new RespostaDao();
    private FuturoScoreBo bo = new FuturoScoreBo();


    @POST
    public Response responder(Resposta r) {
        try {
            double score = bo.calcular(r);
            r.setFuturoScore(score);

            dao.salvar(r);

            ResultadoFuturoScore resultado = gerarResultado(score);

            return Response.status(Response.Status.CREATED).entity(resultado).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao salvar resposta.")
                    .build();
        }
    }


    @GET
    public Response listar() {
        try {
            List<Resposta> respostas = dao.listar();
            return Response.ok(respostas).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao listar respostas.")
                    .build();
        }
    }


    @GET
    @Path("/{id}")
    public Response buscarPorId(@PathParam("id") int id) {
        try {
            Resposta resposta = dao.buscarPorId(id);

            if (resposta == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Resposta não encontrada.")
                        .build();
            }

            return Response.ok(resposta).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao buscar resposta.")
                    .build();
        }
    }


    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Resposta r) {
        try {

            Resposta existente = dao.buscarPorId(id);

            if (existente == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Resposta não encontrada.")
                        .build();
            }


            r.setId(id);


            double novoScore = bo.calcular(r);
            r.setFuturoScore(novoScore);

            boolean atualizado = dao.atualizar(r);

            if (!atualizado) {
                return Response.status(Response.Status.NOT_MODIFIED)
                        .entity("Não foi possível atualizar.")
                        .build();
            }

            ResultadoFuturoScore resultado = gerarResultado(novoScore);

            return Response.ok(resultado).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao atualizar resposta.")
                    .build();
        }
    }


    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        try {
            Resposta r = dao.buscarPorId(id);

            if (r == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Resposta não encontrada.")
                        .build();
            }

            dao.deletar(id);

            return Response.status(Response.Status.NO_CONTENT).build();

        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Erro ao excluir resposta.")
                    .build();
        }
    }


    private ResultadoFuturoScore gerarResultado(double score) {

        String nivel;

        if (score < 25)       nivel = "Iniciante";
        else if (score < 50)  nivel = "Intermediário";
        else if (score < 75)  nivel = "Avançado";
        else                  nivel = "Especialista";

        String recomendacao = switch (nivel) {
            case "Iniciante" -> "Você precisa começar a explorar IA.";
            case "Intermediário" -> "Bom caminho! Continue praticando.";
            case "Avançado" -> "Ótimo! Já possui domínio sólido.";
            default -> "Excelente! Você tem perfil de liderança em IA.";
        };

        return new ResultadoFuturoScore(score, nivel, recomendacao);
    }
}
