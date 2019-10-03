import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private Container cp;
    private String str[] = {"9", "8", "7", "+", "6", "5", "4", "-", "3", "2", "1", "*", "0", ".", "=", "/"};
    private JButton jbtns[] = new JButton[16];
    private JLabel jlb = new JLabel("0");
    private JPanel jpl = new JPanel(new GridLayout(4, 4, 3, 3));
    private double v1 = 0.0;
    private double v2 = 0.0;
    private int opentyp = 0;
    private boolean isDotclick = false;
    private boolean isopclik = false;

    public MainFrame() {
        init();
    }

    private void init() {
        cp = this.getContentPane();
        this.setLayout(new BorderLayout(2, 2));
        this.setBounds(100, 150, 500, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        cp.add(jlb, BorderLayout.NORTH);
        cp.add(jpl, BorderLayout.CENTER);
        jlb.setHorizontalAlignment(JLabel.RIGHT);
        jlb.setFont(new Font(null,Font.PLAIN,60));

        for (int i = 0; i < 16; i++) {
            jbtns[i] = new JButton(str[i]);
            jpl.add(jbtns[i]);
            jbtns[i].setFont(new Font(null, Font.PLAIN, 24));
            jbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton jbt = (JButton) e.getSource();
                    int vx = jbt.getText().charAt(0) - '0';
                    if (vx >= 0 && vx <= 9) {
                        double v1 = Double.parseDouble(jlb.getText());
                        if (isopclik) {
                            jlb.setText(" ");
                            isopclik = false;
                        }
                        if (v1 == 0.0f) {
                            if (isopclik) {
                                jlb.setText(jlb.getText() + jbt.getText());
                            } else {
                                jlb.setText(jbt.getText());
                            }
                        } else {
                            jlb.setText(jlb.getText()+jbt.getText());
                        }
                    }else {
                            switch (jbt.getText()) {
                                case "+":
                                    isopclik = true;
                                    opentyp = 1;
                                    v1 = Float.parseFloat(jlb.getText());
                                    isDotclick=false;
                                    break;
                                case "-":
                                    isopclik = true;
                                    opentyp = 2;
                                    v1 = Float.parseFloat(jlb.getText());
                                    isDotclick=false;
                                    break;
                                case "*":
                                    isopclik = true;
                                    opentyp = 1;
                                    v1 = Float.parseFloat(jlb.getText());
                                    isDotclick=false;
                                    break;
                                case "/":
                                    isopclik = true;
                                    opentyp = 1;
                                    v1 = Float.parseFloat(jlb.getText());
                                    isDotclick=false;
                                    break;
                                case "=":
                                    Double v2 = Double.parseDouble(jlb.getText());
                                    switch (opentyp) {
                                        case 1:
                                            jlb.setText(Double.toString(v1 + v2));
                                            break;
                                        case 2:
                                            jlb.setText(Double.toString(v1 - v2));
                                            break;
                                        case 3:
                                            jlb.setText(Double.toString(v1 * v2));
                                            break;
                                        case 4:
                                            jlb.setText(Double.toString(v1 / v2));
                                            break;
                                    }
                            }

                        }
                    }
            });
        }
    }
}
