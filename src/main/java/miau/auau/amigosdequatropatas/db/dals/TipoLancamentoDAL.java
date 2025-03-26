package miau.auau.amigosdequatropatas.db.dals;

import miau.auau.amigosdequatropatas.entidades.TipoLancamento;
import miau.auau.amigosdequatropatas.util.IDAL;
import miau.auau.amigosdequatropatas.util.SingletonDB;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class TipoLancamentoDAL implements IDAL<TipoLancamento> {

    @Override
    public boolean gravar(TipoLancamento entidade) {
        String sql = """
                INSERT INTO tipo_lancamento (tpl_descricao)
                VALUES ('#1')
                """;
        sql = sql.replace("#1", entidade.getDescricao());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(TipoLancamento entidade) {
        String sql = """
                UPDATE tipo_lancamento
                SET tpl_descricao = '#1'
                WHERE tlp_id = #2
                """;
        sql = sql.replace("#1", entidade.getDescricao())
                .replace("#2", "" + entidade.getCod());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(TipoLancamento entidade) {
        String sql = "DELETE FROM tipo_lancamento WHERE tlp_id = " + entidade.getCod();
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public TipoLancamento get(int id) {
        TipoLancamento tipoLancamento = null;
        String sql = "SELECT * FROM tipo_lancamento WHERE tlp_id = " + id;
        ResultSet resultSet = SingletonDB.getConexao().consultar(sql);
        try {
            if (resultSet.next()) {
                tipoLancamento = new TipoLancamento(
                        id,
                        resultSet.getString("tpl_descricao")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoLancamento;
    }

    @Override
    public List<TipoLancamento> get(String filtro) {
        List<TipoLancamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_lancamento";
        if (!filtro.isEmpty() && !filtro.equals(" ")) {
            filtro = "'" + filtro + "'";
            sql += " WHERE tpl_descricao = " + filtro;
        }
        sql += " ORDER BY tpl_descricao";
        System.out.println("SQL gerado: " + sql);
        ResultSet resultSet = SingletonDB.getConexao().consultar(sql);
        try {
            while (resultSet.next()) {
                lista.add(new TipoLancamento(
                        resultSet.getInt("tlp_id"),
                        resultSet.getString("tpl_descricao")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}
