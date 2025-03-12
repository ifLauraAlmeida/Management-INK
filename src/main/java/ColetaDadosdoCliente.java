import java.sql.*;
import java.util.Scanner;

public class ColetaDadosdoCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Coleta dos dados do cliente
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.print("E-mail do cliente: ");
        String email = scanner.nextLine();

        System.out.print("Data de Nascimento (YYYY-MM-DD): ");
        String dataNascimento = scanner.nextLine();

        System.out.print("CPF do cliente: ");
        String cpf = scanner.nextLine();

        System.out.print("Bairro do cliente: ");
        String bairro = scanner.nextLine();

        System.out.print("Profissão do cliente: ");
        String profissao = scanner.nextLine();

        System.out.print("Onde o cliente nos conheceu: ");
        String ondeConheceu = scanner.nextLine();

        System.out.print("Cor preferida do cliente: ");
        String corPreferida = scanner.nextLine();

        // Conectar ao banco de dados e inserir os dados
        String url = "jdbc:mysql://localhost:3306/management-ink?useSSL=false&allowPublicKeyRetrieval=true";
        String usuario = "root";
        String senha = "senha12345678_";

        // Query para inserção
        String query = "INSERT INTO cliente (nome, email, dataNascimento, cpf, bairro, profissao, ondeConheceu, corPreferida) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            // `Statement.RETURN_GENERATED_KEYS` permite capturar o ID gerado

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, dataNascimento);
            stmt.setString(4, cpf);
            stmt.setString(5, bairro);
            stmt.setString(6, profissao);
            stmt.setString(7, ondeConheceu);
            stmt.setString(8, corPreferida);

            stmt.executeUpdate();

            // Recupera o ID gerado
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int clienteId = generatedKeys.getInt(1);
                System.out.println("Cliente cadastrado com sucesso! ID do cliente: " + clienteId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
