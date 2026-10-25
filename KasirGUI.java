import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KasirGUI extends JFrame implements ActionListener, KeyListener {
    private JTextField namaField;
    private JTextField jumlahField;
    private JComboBox<String> menuBox;
    private JButton hitungButton;
    private JButton resetButton;
    private JLabel hasilLabel;
    private JLabel infoLabel;

    public KasirGUI() {
        setTitle("Kasir Kantin Mahasiswa");
        setSize(450, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2, 10, 10));
        JLabel namaLabel = new JLabel("Nama Pembeli:");
        namaField = new JTextField();
        JLabel menuLabel = new JLabel("Pilih Menu:");
        String[] menu = {"Nasi Goreng","Mie Goreng","Es Teh"};

        menuBox = new JComboBox<String>(menu);

        JLabel jumlahLabel = new JLabel("Jumlah:");
        jumlahField = new JTextField();

        hitungButton = new JButton("Hitung Total");
        resetButton = new JButton("Reset");

        hasilLabel = new JLabel("Total: Rp0");
        infoLabel = new JLabel("Masukkan jumlah");

        panel.add(namaLabel);
        panel.add(namaField);

        panel.add(menuLabel);
        panel.add(menuBox);

        panel.add(jumlahLabel);
        panel.add(jumlahField);

        panel.add(hitungButton);
        panel.add(resetButton);

        panel.add(hasilLabel);
        panel.add(infoLabel);
        add(panel);

        hitungButton.addActionListener(this);
        resetButton.addActionListener(this);
        jumlahField.addKeyListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hitungButton) {
            try {
                String nama = namaField.getText();
                int jumlah = Integer.parseInt(jumlahField.getText());
                if (nama.trim().isEmpty() || jumlah <= 0) {
                    JOptionPane.showMessageDialog(this,
                            "Masukkan nama dan jumlah yang benar!");
                    return;
                }
                int harga = 0;
                if (menuBox.getSelectedIndex() == 0) {
                    harga = 15000;
                } else if (menuBox.getSelectedIndex() == 1) {
                    harga = 12000;
                } else {
                    harga = 5000;
                }

                int total = harga * jumlah;
                hasilLabel.setText("Total: Rp" + total);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,"Jumlah harus berupa angka!");
            }
        } else if (e.getSource() == resetButton) {
            namaField.setText("");
            jumlahField.setText("");
            menuBox.setSelectedIndex(0);
            hasilLabel.setText("Total: Rp0");
            infoLabel.setText("Masukkan jumlah");
        }
    }

    public void keyReleased(KeyEvent e) {
        if (jumlahField.getText().isEmpty()) {
            infoLabel.setText("Masukkan jumlah");
        } else {
            infoLabel.setText("Jumlah sedang diisi");
        }
    }

    public void keyPressed(KeyEvent e) {
    }
    public void keyTyped(KeyEvent e) {
    }
}