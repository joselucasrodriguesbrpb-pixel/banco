import java.util.ArrayList;
import java.util.List;

public class BancoList {
    private String nome;
    private String cnpj;
    private ArrayList<Conta> contas;

    public BancoList(String nome, String cnpj, ArrayList<Conta> contas) {
        this.nome = nome;
        this.cnpj = cnpj;
        this.contas = contas;
    }

    public String toString() {
        return "Banco " + this.nome + " de CNPJ " + this.cnpj + " e que tem " + this.contas.size() + " contas";
    }

    public void transferir(String numContaO, String numAgO, String numContaD, String numAgenciaD, double valor) {
        sacarDeConta(numContaO, numAgO, valor);
        depositarEmConta(numContaD, numAgenciaD, valor);
    }

    public void abrirConta(String cpfTitular, String numConta, String numAgencia, double saldoInicial) {
        Conta conta = new Conta(cpfTitular, numConta, numAgencia, saldoInicial);
        contas.add(conta);
    }

    public ArrayList<Conta> pesquisarContasComSaldoNegativo(ArrayList<Conta> contas) {
        ArrayList<Conta> saldoNegativo = new ArrayList<>();
        for (int i = 0; i < contas.size(); i++) {
            if (contas.get(i).getSaldo()< 0) {
                saldoNegativo.add(contas.get(i));
            }
        }
        return saldoNegativo;
    }

    public double consultarSaldoDeConta(String numConta, String numAgencia) {
        double saldo = 0;
        for (Conta c : this.contas) {
            if (c.getNumeroConta().equals(numConta) && c.getNumeroAgencia().equals(numAgencia)) {
                saldo = c.getSaldo();
            }
        }
        return saldo;
    }

    public double sacarDeConta(String numConta, String numAgencia, double valor) {
        for (int i = 0; i < contas.size(); i++) {
            Conta contaAtual = contas.get(i);
            if (numConta.equals(contaAtual.getNumeroConta()) && numAgencia.equals(contaAtual.getNumeroAgencia())) {
                if (contaAtual.getSaldo() >= valor) {
                    contaAtual.setSaldo(contaAtual.getSaldo() - valor);
                    return contaAtual.getSaldo();
                }
            }
        }
        return 0.0;
    }

    public double depositarEmConta(String numConta, String numAgencia, double valor) {
        for (int i = 0; i < contas.size(); i++) {
            Conta contaAtual = contas.get(i);
            if (numConta.equals(contaAtual.getNumeroConta()) && numAgencia.equals(contaAtual.getNumeroAgencia())) {
                contaAtual.setSaldo(contaAtual.getSaldo() + valor);
                return contaAtual.getSaldo();
            }
        }
        return 0.0;
    }

    public ArrayList<Conta> pesquisarContasDoCliente(String cpf) {
        ArrayList<Conta> contasEncontradas = new ArrayList<>();
        for (int i = 0; i < contas.size(); i++) {
            if (cpf.equalsIgnoreCase(contas.get(i).getCpfTitular())) {
                contasEncontradas.add(contas.get(i));
            }
        }
        return contasEncontradas;
    }
}