import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class ColetaDadosdoCliente {
    public static void main(String[] args) {
        Scanner scannerDadosPessoais = new Scanner(System.in);

        // Coleta dos dados do cliente
        System.out.print("Nome do Cliente: ");
        String nome = scannerDadosPessoais.nextLine();

        System.out.println("E-mail do cliente: ");
        String email = scannerDadosPessoais.nextLine();

        System.out.println("Data de Nascimento: ");
        String dataNascimento = "";

        try {
            MaskFormatter mask = new MaskFormatter("####-##-##"); // Formato de data dd/mm/aaaa
            mask.setPlaceholderCharacter('_');

            JFormattedTextField campoData = new JFormattedTextField(mask);
            JOptionPane.showMessageDialog(null, campoData, "Data de nascimento do cliente:", JOptionPane.QUESTION_MESSAGE);

            dataNascimento = campoData.getText(); // Atribui o valor
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dataNascimento);

        System.out.println("CPF do cliente: ");
        String cpf = "";
        try {
            MaskFormatter maskCPF = new MaskFormatter("###.###.###-##"); // Formatar CPF
            maskCPF.setPlaceholderCharacter('_');

            JFormattedTextField campoCPF = new JFormattedTextField(maskCPF);
            JOptionPane.showMessageDialog(null, campoCPF, "CPF do cliente:", JOptionPane.QUESTION_MESSAGE);
            cpf = campoCPF.getText();

        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(cpf);

        System.out.println("Bairro cliente: ");
        String bairro = scannerDadosPessoais.nextLine();

        System.out.println("Profissao do cliente: ");
        String profissao = scannerDadosPessoais.nextLine();

        System.out.println("Onde o cliente nos conheceu: ");
        String ondeConheceu = scannerDadosPessoais.nextLine();

        System.out.println("Cor preferida do cliente: ");
        String corPreferida = scannerDadosPessoais.nextLine();

        // Conectar ao banco de dados e inserir os dados
        String url = "jdbc:mysql://localhost:3306/"; // URL do banco
        String usuario = "root";  // Nome de usuário MySQL
        String senha = "senha12345678_";        // Senha do MySQL

        // Query SQL para inserção dos dados
        String query = "INSERT INTO cliente (nome, email, dataNascimento, cpf, bairro, profissao, ondeConheceu, corPreferida) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(query)) {

            // Definir os valores dos parâmetros
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, dataNascimento);
            stmt.setString(4, cpf);
            stmt.setString(5, bairro);
            stmt.setString(6, profissao);
            stmt.setString(7, ondeConheceu);
            stmt.setString(8, corPreferida);

            // Executar a query
            stmt.executeUpdate();
            System.out.println("Dados inseridos no banco com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Fechar o scannerDadosPessoais
        scannerDadosPessoais.close();
    }
}