package DadosDoCliente;


import java.io.*;
import java.text.ParseException;
import java.util.Scanner;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class PrimeiroCodigoBasico {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();

        System.out.println("E-mail do cliente: ");
        String email = scanner.nextLine();

        System.out.println("Data de Nascimento: ");
        String datanascimento = ""; // ✅ Declara APENAS uma vez

        try {
            MaskFormatter mask = new MaskFormatter("##/##/####"); // Formato de data dd/mm/aaaa
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

        System.out.println("Profissao dO cliente: ");
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
            MaskFormatter mask = new MaskFormatter("##/##/####");
            mask.setPlaceholderCharacter('_');

            JFormattedTextField campoData = new JFormattedTextField(mask);
            JOptionPane.showMessageDialog(null, campoData, "Data do procedimento: ", JOptionPane.QUESTION_MESSAGE);
            
            dataprocedimento = campoData.getText(); 
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(dataprocedimento);
        
        
        try (FileWriter fw = new FileWriter("dados_usuario.txt", true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            
            bw.write("Nome: " + nome);
            bw.newLine();
            bw.write("E-mail: " + email);
            bw.newLine();
            bw.write("Data Nascimento: " + datanascimento);
            bw.newLine();
            bw.write("CPF: " + cpf);
            bw.newLine();
            bw.write("Bairro: " + bairro);
            bw.newLine();
            bw.write("Profissao: " + profissao);
            bw.newLine();
            bw.write("Onde nos conheceu: " + ondeconheceu);
            bw.newLine();
            bw.write("preferida: " + corpreferida);
            bw.newLine();
            bw.write("Descrição da tattoo: " + descricao);
            bw.newLine();
            bw.write("----------------------");
            
            System.out.println("Dados salvos com sucesso!");
        } catch (IOException e) {
            System.out.println("Erro ao salvar os dados: " + e.getMessage());
        }
        
        scanner.close();
    }
}
