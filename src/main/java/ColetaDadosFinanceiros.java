import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ColetaDadosFinanceiros {

    public void cadastrarDadosFinanceiros(Connection conexao, int clienteId) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Data de procedimento (YYYY-MM-DD): ");
        String dataProcedimento = scanner.nextLine();

        System.out.print("Descrição da tatuagem: ");
        String descricaoTatuagem = scanner.nextLine();

        System.out.print("Valor total da tatuagem: ");
        double valor = Double.parseDouble(scanner.nextLine());

        System.out.println("Selecione o método de pagamento:");
        System.out.println("1 - Débito");
        System.out.println("2 - Crédito");
        String metodoPagamento = scanner.nextLine();

        String metodoPagamentoTexto = "";
        double valorDividido = 0;

        if (metodoPagamento.equals("1")) {
            metodoPagamentoTexto = "Débito";
            valorDividido = valor / 2;
        } else if (metodoPagamento.equals("2")) {
            System.out.println("1 - Com Juros");
            System.out.println("2 - Sem Juros");
            String creditoJuros = scanner.nextLine();

            if (creditoJuros.equals("1")) {
                metodoPagamentoTexto = "Crédito com juros";
                valorDividido = valor / 2;
            } else if (creditoJuros.equals("2")) {
                metodoPagamentoTexto = "Crédito sem juros";
                valorDividido = valor * 0.85; // Redução de 15%
            } else {
                System.out.println("Opção inválida.");
                return;
            }
        } else {
            System.out.println("Opção inválida.");
            return;
        }

        String query = "INSERT INTO financeiro (cliente_id, dataProcedimento, descricaoTatuagem, valor, metodoPagamento, valorDividido) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(query)) {
            stmt.setInt(1, clienteId);
            stmt.setString(2, dataProcedimento);
            stmt.setString(3, descricaoTatuagem);
            stmt.setDouble(4, valor);
            stmt.setString(5, metodoPagamentoTexto);
            stmt.setDouble(6, valorDividido);

            stmt.executeUpdate();
            System.out.println("Dados financeiros inseridos no banco com sucesso!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
