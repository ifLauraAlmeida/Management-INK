import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

    public class ColetaDadosFinanceiros {
        public static class DadosFinanceiros {
            public static void main(String[] args) {

                Scanner scannerFinanceiro = new Scanner(System.in);

                System.out.println("Data de procedimento: ");
                String dataProcedimento ="";

                try {
                    MaskFormatter mask = new MaskFormatter("####-##-##");
                    mask.setPlaceholderCharacter('_');

                    JFormattedTextField campoData = new JFormattedTextField(mask);
                    JOptionPane.showMessageDialog(null, campoData, "Data do procedimento: ", JOptionPane.QUESTION_MESSAGE);

                    dataProcedimento = campoData.getText();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                System.out.println(dataProcedimento);

                System.out.print("Descrição da tatuagem: ");
                String descricaoTatuagem = scannerFinanceiro.nextLine();

                System.out.println("Valor total da tatuagem: ");
                String valor = scannerFinanceiro.nextLine();

                System.out.println("Método de pagamento: ");
                String metodoPagamento = scannerFinanceiro.nextLine();

                System.out.println("Número de parcelas: ");
                String parcelas = scannerFinanceiro.nextLine();

                System.out.println("Valor divido: ");
                String valorDividido = scannerFinanceiro.nextLine();

                // Conectar ao banco de dados e inserir os dados
                String url = "jdbc:mysql://localhost:3306/"; // URL do banco
                String usuario = "root";  // Nome de usuário MySQL
                String senha = "senha12345678_";        // Senha do MySQL

                // Query SQL para inserção dos d--ados
                String query = "INSERT INTO cliente (dataProcedimento, descricaoTatuagem, valor, metodoPagamento, parcelas, valorDivido) VALUES (?, ?, ?, ?, ?, ?)";

                try (Connection conn = DriverManager.getConnection(url, usuario, senha);
                     PreparedStatement stmt = conn.prepareStatement(query)) {

                    // Definir os valores dos parâmetros
                    stmt.setString(1, dataProcedimento);
                    stmt.setString(2, descricaoTatuagem);
                    stmt.setString(3, valor);
                    stmt.setString(4, metodoPagamento);
                    stmt.setString(5, parcelas);
                    stmt.setString(6, valorDividido);

                    // Executar a query
                    stmt.executeUpdate();
                    System.out.println("Dados inseridos no banco com sucesso!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                // Fechar o scannerDadosPessoais
                scannerFinanceiro.close();
            }
        }
    }

