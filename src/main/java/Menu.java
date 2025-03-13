import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ColetaDadosdoCliente dadosPessoaisDAO = new ColetaDadosdoCliente();
        ColetaDadosFinanceiros dadosFinanceirosDAO = new ColetaDadosFinanceiros();

        try (Connection conexao = Conexao.conectar()) {
            while (true) {
                System.out.println("\n===== MENU =====");
                System.out.println("1 - Cadastrar dados pessoais.");
                System.out.println("2 - Cadastrar dados financeiros.");
                System.out.println("3 - Sair.");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        dadosPessoaisDAO.cadastrarDadosPessoais(conexao);
                        break;
                    case 2:
                        System.out.print("Digite o ID do usuário: ");
                        int usuarioId = scanner.nextInt();
                        dadosFinanceirosDAO.cadastrarDadosFinanceiros(conexao, usuarioId);
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        return;
                    default:
                        System.out.println("Opção inválida!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
