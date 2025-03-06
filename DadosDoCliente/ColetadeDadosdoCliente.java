package DadosDoCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class ColetadeDadosdoCliente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Coleta dos dados do cliente
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.println("E-mail do cliente: ");
        String email = scanner.nextLine();

        System.out.println("Data de Nascimento: ");
        String datanascimento = ""; 

        try {
            MaskFormatter mask = new MaskFormatter("####-##-##"); // Formato de data dd/mm/aaaa
            mask.setPlaceholderCharacter('_');

            JFormattedTextField campoData = new JFormattedTextField(mask);
            JOptionPane.showMessageDialog(null, campoData, "Data de nascimento do cliente:", JOptionPane.QUESTION_MESSAGE);
            
            datanascimento = campoData.getText(); // Atribui o valor
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(datanascimento);
  
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
        String bairro = scanner.nextLine();

        System.out.println("Profissao do cliente: ");
        String profissao = scanner.nextLine();

        System.out.println("Onde o cliente nos conheceu: ");
        String ondeconheceu = scanner.nextLine();

        System.out.println("Cor preferida do cliente: ");
        String corpreferida = scanner.nextLine();

        System.out.println("Descrição da tattoo: ");
        String descricao = scanner.nextLine();

        System.out.println("Data de procedimento: ");
        String dataprocedimento = ""; 

        try {
            MaskFormatter mask = new MaskFormatter("####-##-##");
            mask.setPlaceholderCharacter('_');

            JFormattedTextField campoData = new JFormattedTextField(mask);
            JOptionPane.showMessageDialog(null, campoData, "Data do procedimento: ", JOptionPane.QUESTION_MESSAGE);
            
            dataprocedimento = campoData.getText(); 
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dataprocedimento);
        
        // Conectar ao banco de dados e inserir os dados
        String url = ""; // URL do banco
        String usuario = "";  // Nome de usuário MySQL
        String senha = "";        // Senha do MySQL

        // Query SQL para inserção dos dados
        String query = "INSERT INTO cliente (nome, email, datanascimento, cpf, bairro, profissao, ondeconheceu, corpreferida, descricao, dataprocedimento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(url, usuario, senha);
             PreparedStatement stmt = conn.prepareStatement(query)) {
            
            // Definir os valores dos parâmetros
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, datanascimento);
            stmt.setString(4, cpf);
            stmt.setString(5, bairro);
            stmt.setString(6, profissao);
            stmt.setString(7, ondeconheceu);
            stmt.setString(8, corpreferida);
            stmt.setString(9, descricao);
            stmt.setString(10, dataprocedimento);

            // Executar a query
            stmt.executeUpdate();
            System.out.println("Dados inseridos no banco com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Fechar o scanner
        scanner.close();
    }
}
