import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ColetaDadosdoCliente {

    public void cadastrarDadosPessoais(Connection conexao) {
        Scanner scanner = new Scanner(System.in);

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

        String query = "INSERT INTO cliente (nome, email, dataNascimento, cpf, bairro, profissao, ondeConheceu, corPreferida) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, dataNascimento);
            stmt.setString(3, dataNascimento);
            stmt.setString(4, cpf);
            stmt.setString(5, bairro);
            stmt.setString(6, profissao);
            stmt.setString(7, ondeConheceu);
            stmt.setString(8, corPreferida);

            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int clienteId = generatedKeys.getInt(1);
                System.out.println("Cliente cadastrado com sucesso! ID do cliente: " + clienteId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
