package br.com.fiap.dao;
import br.com.fiap.Conexao.Conexao;
import br.com.fiap.model.Resposta;

import java.sql.*;
import java.util.ArrayList;
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

public class RespostaDao {

    private Conexao conexao = new Conexao();

    // CREATE
    public void salvar(Resposta r) throws Exception {

        Connection conn = conexao.getConnection();

        String sql = """
            INSERT INTO respostas (
                nome, email,
                usaIaTrabalho, frequenciaUso, confiancaIa, automatizouTarefas,
                identificaIa, fezCursos, nivelGenAI, impactoProfissao,
                porcentagemAutomacao, conheceRiscos, futuroScore
            ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )
        """;

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, r.getNome());
        ps.setString(2, r.getEmail());
        ps.setString(3, r.getUsaIaTrabalho());
        ps.setString(4, r.getFrequenciaUso());
        ps.setString(5, r.getConfiancaIa());
        ps.setString(6, r.getAutomatizouTarefas());
        ps.setString(7, r.getIdentificaIa());
        ps.setString(8, r.getFezCursos());
        ps.setString(9, r.getNivelGenAI());
        ps.setString(10, r.getImpactoProfissao());
        ps.setString(11, r.getPorcentagemAutomacao());
        ps.setString(12, r.getConheceRiscos());
        ps.setDouble(13, r.getFuturoScore());

        ps.execute();
        conn.close();
    }

    // LISTAR (READ)
    public List<Resposta> listar() throws Exception {

        Connection conn = conexao.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM respostas ORDER BY id DESC");
        ResultSet rs = ps.executeQuery();

        List<Resposta> lista = new ArrayList<>();

        while (rs.next()) {
            Resposta r = new Resposta();
            r.setId(rs.getInt("id"));
            r.setNome(rs.getString("nome"));
            r.setEmail(rs.getString("email"));
            r.setUsaIaTrabalho(rs.getString("usaIaTrabalho"));
            r.setFrequenciaUso(rs.getString("frequenciaUso"));
            r.setConfiancaIa(rs.getString("confiancaIa"));
            r.setAutomatizouTarefas(rs.getString("automatizouTarefas"));
            r.setIdentificaIa(rs.getString("identificaIa"));
            r.setFezCursos(rs.getString("fezCursos"));
            r.setNivelGenAI(rs.getString("nivelGenAI"));
            r.setImpactoProfissao(rs.getString("impactoProfissao"));
            r.setPorcentagemAutomacao(rs.getString("porcentagemAutomacao"));
            r.setConheceRiscos(rs.getString("conheceRiscos"));
            r.setFuturoScore(rs.getDouble("futuroScore"));
            lista.add(r);
        }

        conn.close();
        return lista;
    }

    // BUSCAR POR ID (opcional, mas boa prática)
    public Resposta buscarPorId(int id) throws Exception {

        Connection conn = conexao.getConnection();
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM respostas WHERE id = ?");
        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();
        if (!rs.next()) {
            return null;
        }

        Resposta r = new Resposta();
        r.setId(rs.getInt("id"));
        r.setNome(rs.getString("nome"));
        r.setEmail(rs.getString("email"));
        r.setUsaIaTrabalho(rs.getString("usaIaTrabalho"));
        r.setFrequenciaUso(rs.getString("frequenciaUso"));
        r.setConfiancaIa(rs.getString("confiancaIa"));
        r.setAutomatizouTarefas(rs.getString("automatizouTarefas"));
        r.setIdentificaIa(rs.getString("identificaIa"));
        r.setFezCursos(rs.getString("fezCursos"));
        r.setNivelGenAI(rs.getString("nivelGenAI"));
        r.setImpactoProfissao(rs.getString("impactoProfissao"));
        r.setPorcentagemAutomacao(rs.getString("porcentagemAutomacao"));
        r.setConheceRiscos(rs.getString("conheceRiscos"));
        r.setFuturoScore(rs.getDouble("futuroScore"));

        conn.close();
        return r;
    }

    // UPDATE
    public boolean atualizar(Resposta r) throws Exception {

        Connection conn = conexao.getConnection();

        String sql = """
            UPDATE respostas SET
                nome = ?, email = ?, usaIaTrabalho = ?, frequenciaUso = ?,
                confiancaIa = ?, automatizouTarefas = ?, identificaIa = ?, fezCursos = ?,
                nivelGenAI = ?, impactoProfissao = ?, porcentagemAutomacao = ?,
                conheceRiscos = ?, futuroScore = ?
            WHERE id = ?
        """;

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, r.getNome());
        ps.setString(2, r.getEmail());
        ps.setString(3, r.getUsaIaTrabalho());
        ps.setString(4, r.getFrequenciaUso());
        ps.setString(5, r.getConfiancaIa());
        ps.setString(6, r.getAutomatizouTarefas());
        ps.setString(7, r.getIdentificaIa());
        ps.setString(8, r.getFezCursos());
        ps.setString(9, r.getNivelGenAI());
        ps.setString(10, r.getImpactoProfissao());
        ps.setString(11, r.getPorcentagemAutomacao());
        ps.setString(12, r.getConheceRiscos());
        ps.setDouble(13, r.getFuturoScore());
        ps.setInt(14, r.getId());

        int linhas = ps.executeUpdate();
        conn.close();

        return linhas > 0; // true = atualizado
    }

    // DELETE
    public void deletar(int id) throws Exception {
        Connection conn = conexao.getConnection();
        PreparedStatement ps = conn.prepareStatement("DELETE FROM respostas WHERE id = ?");
        ps.setInt(1, id);
        ps.execute();
        conn.close();
    }
}
