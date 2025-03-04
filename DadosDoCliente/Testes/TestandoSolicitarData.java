package DadosDoCliente.Testes;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

public class TestandoSolicitarData {
    public static void main(String[] args) {
        try {
            MaskFormatter mask = new MaskFormatter("##/##/####"); // Formato dd/MM/yyyy
            mask.setPlaceholderCharacter('_');

            JFormattedTextField campoData = new JFormattedTextField(mask);
            JOptionPane.showMessageDialog(null, campoData, "Digite a Data", JOptionPane.QUESTION_MESSAGE);
            
            String data = campoData.getText();
            System.out.println("Data digitada: " + data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}

    
