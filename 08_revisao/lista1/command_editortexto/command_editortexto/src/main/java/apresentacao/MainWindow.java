
package apresentacao;
import javax.swing.*;

import negocio.Colar;
import negocio.Copiar;
import negocio.Editor;

import java.awt.*;

public class MainWindow extends JFrame {

  private CustomTextArea1 textArea1;
  private CustomButton1 button2;
  private CustomButton2 button3;
  private Editor editor;


  public MainWindow() {
    setTitle("MainWindow");
    setSize(1024, 768);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(null);

    this.editor = new Editor();

    textArea1 = new CustomTextArea1();
    textArea1.setBounds(5, 200, 220, 96);
    this.add(textArea1);

    button2 = new CustomButton1();
    button2.setBounds(18, 304, 120, 36);
    button2.addActionListener(e -> colar());
    this.add(button2);

    button3 = new CustomButton2();
    button3.setBounds(16, 351, 120, 36);
    button3.addActionListener(e -> copiar());
    this.add(button3);

    setLocationRelativeTo(null);
  }

  private void colar() {
      editor.setTexto(this.textArea1.getText());
      editor.ativarFuncao(new Colar("ola!", editor));
      this.textArea1.setText(this.editor.getTexto());
    
  }

  private void copiar() {
      editor.setTexto(this.textArea1.getText());
      editor.ativarFuncao(new Copiar(editor));
      JOptionPane.showMessageDialog(this, "Copiando:" + editor.getTexto());

  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
      MainWindow frame = new MainWindow();
      frame.setVisible(true);
    });
  }
}
