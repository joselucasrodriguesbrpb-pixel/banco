import java.util.ArrayList;

public class TesteBanco {
    public static void main(String[] args) {
        Conta produtor = new Conta("139.598.604-70", "222-2", "333-3", 200.0);
        ArrayList lista = new ArrayList();
        lista.add(produtor);
        BancoList b = new BancoList("Banco do Brasil", "1113332231-17", lista);
        b.abrirConta("133.898.504-80", "111-1", "222-2", 0.0);

        b.transferir("222-2", "333-3", "111-1", "222-2", 100.0);
        System.out.println(b.consultarSaldoDeConta("111-1", "222-2"));

        System.out.println(b.pesquisarContasComSaldoNegativo(lista));
    }
}
