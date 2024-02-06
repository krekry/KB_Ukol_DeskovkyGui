import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class BoardGameGUI extends JFrame{
    private List<BoardGame> seznamHer;
    private int aktualniIndex;
    private JCheckBox koupenoCheckBox;
    private JRadioButton BTN1, BTN2, BTN3;
    private JButton predchoziButton;
    private JButton dalsiButton;
    private JLabel nazevLabel;

    public BoardGameGUI(List<BoardGame> seznamHer) {
        this.seznamHer = seznamHer;
        this.aktualniIndex = 0;

        setTitle("Deskové Hry");
        setSize(600, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InicializovatUI();
        dalsiHra();
    }

    private void InicializovatUI()  {
        JPanel hlavniPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;

        nazevLabel = new JLabel();
        gbc.gridx = 1;
        hlavniPanel.add(nazevLabel, gbc);
        gbc.gridy++;

        koupenoCheckBox = new JCheckBox("Koupeno");
        gbc.gridx = 0;
        hlavniPanel.add(koupenoCheckBox, gbc);
        gbc.gridy++;

        ButtonGroup oblibenostSkupina = new ButtonGroup();
        BTN1 = new JRadioButton("1");
        BTN2 = new JRadioButton("2");
        BTN3 = new JRadioButton("3");

        oblibenostSkupina.add(BTN1);
        oblibenostSkupina.add(BTN2);
        oblibenostSkupina.add(BTN3);

        gbc.gridx = 0;
        hlavniPanel.add(new JLabel("Oblíbenost:"), gbc);
        gbc.gridx = 1;
        hlavniPanel.add(BTN1, gbc);
        gbc.gridx = 2;
        hlavniPanel.add(BTN2, gbc);
        gbc.gridx = 3;
        hlavniPanel.add(BTN3, gbc);
        gbc.gridy ++;

        predchoziButton = new JButton("Předchozí");
        dalsiButton = new JButton("Další");

        predchoziButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktualniIndex =(aktualniIndex - 1 + seznamHer.size()) % seznamHer.size();
                dalsiHra();
            }
        });

        dalsiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aktualniIndex = (aktualniIndex + 1) % seznamHer.size();
                dalsiHra();
            }
        });

        gbc.gridx = 1;
        hlavniPanel.add(predchoziButton, gbc);
        gbc.gridx = 2;
        hlavniPanel.add(dalsiButton, gbc);

        add(hlavniPanel);
    }

    private void dalsiHra() {
        if(!seznamHer.isEmpty()) {
            BoardGame aktualniHra = seznamHer.get(aktualniIndex);

            nazevLabel.setText(aktualniHra.getJmeno());
            koupenoCheckBox.setSelected(aktualniHra.isKoupeno());

            int oblibenost = aktualniHra.getPopularita();
            switch (oblibenost) {
                case 1:
                    BTN1.setSelected(true);
                    break;
                case 2:
                    BTN2.setSelected(true);
                    break;
                case 3:
                    BTN3.setSelected(true);
                    break;
            }
        }
    }
}
