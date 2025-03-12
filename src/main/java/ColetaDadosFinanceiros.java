import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ColetaDadosFinanceiros {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do cliente: ");
        int clienteId = Integer.parseInt(scanner.nextLine()); // Associar ao cliente correto

        System.out.print("Data de procedimento (YYYY-MM-DD): ");
        String dataProcedimento = scanner.nextLine();

        System.out.print("Descrição da tatuagem: ");
        String descricaoTatuagem = scanner.nextLine();

        System.out.print("Valor total da tatuagem: ");
        double valor = Double.parseDouble(scanner.nextLine());

        System.out.print("Método de pagamento: ");
        String metodoPagamento = scanner.nextLine();

        System.out.print("Número de parcelas: ");
        int parcelas = Integer.parseInt(scanner.nextLine());

        System.out.print("Valor dividido: ");
        String valorDividido = scanner.nextLine();

        // Conectar ao banco de dados e inserir os dados
        String url = "jdbc:mysql://localhost:3306/management-ink?useSSL=false&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String senha = "senha12345678_";

        // Query SQL corrigida para a tabela `financeiro`
        String query = "INSERT INTO financeiro (cliente_id, dataProcedimento, descricaoTatuagem, valor, metodoPagamento, parcelas, valorDivido) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Definir os valores dos parâmetros
            stmt.setInt(1, clienteId);
            stmt.setString(2, dataProcedimento);
            stmt.setString(3, descricaoTatuagem);
            stmt.setDouble(4, valor);
            stmt.setString(5, metodoPagamento);
            stmt.setInt(6, parcelas);
            stmt.setString(7, valorDividido);

            // Executar a query
            stmt.executeUpdate();
            System.out.println("Dados financeiros inseridos no banco com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
