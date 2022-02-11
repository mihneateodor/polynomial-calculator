package tema1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class View extends JFrame {
    private Operatii operatii;
    private JPanel continut = new JPanel();
    private JLabel etPolUnu = new JLabel("Primul polinom:");
    private JLabel etPolDoi = new JLabel("Al doilea polinom:");
    private JTextField polUnuText = new JTextField();
    private JTextField polDoiText = new JTextField();
    private JButton reset = new JButton("Reset");
    private JButton adunare = new JButton("Adunare");
    private JButton scadere = new JButton("Scadere");
    private JButton inmultire = new JButton("Inmultire");
    private JButton impartire = new JButton("Impartire");
    private JButton derivare = new JButton("Derivare");
    private JButton integrare = new JButton("Integrare");
    private JLabel etRezultat = new JLabel("Rezultat:");
    private JTextField textRezultat = new JTextField();
    private JLabel etRest = new JLabel("Rest:");
    private JTextField textRest = new JTextField();
    private JButton info = new JButton("Info");
    private JButton trimitePolinom = new JButton(" ^ Trimite ca \"Primul polinom\"");

    public View(Operatii operatii) {
        this.operatii=operatii;
        this.setBounds(100, 100, 463, 538);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        continut.setLayout(null);
        this.setTitle("Calculator de polinoame");

        etPolUnu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        etPolUnu.setBounds(10, 10, 151, 25);
        continut.add(etPolUnu);

        etPolDoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
        etPolDoi.setBounds(10, 86, 151, 29);
        continut.add(etPolDoi);

        polUnuText.setBounds(10, 45, 405, 31);
        continut.add(polUnuText);

        polDoiText.setBounds(10, 125, 405, 31);
        continut.add(polDoiText);

        reset.setFont(new Font("Tahoma", Font.BOLD, 16));
        reset.setBounds(281, 166, 134, 31);
        continut.add(reset);

        adunare.setFont(new Font("Tahoma", Font.BOLD, 16));
        adunare.setBounds(10, 210, 190, 31);
        continut.add(adunare);

        scadere.setFont(new Font("Tahoma", Font.BOLD, 16));
        scadere.setBounds(210, 210, 190, 31);
        continut.add(scadere);

        inmultire.setFont(new Font("Tahoma", Font.BOLD, 16));
        inmultire.setBounds(10, 251, 190, 31);
        continut.add(inmultire);

        impartire.setFont(new Font("Tahoma", Font.BOLD, 16));
        impartire.setBounds(210, 251, 190, 31);
        continut.add(impartire);

        derivare.setFont(new Font("Tahoma", Font.BOLD, 16));
        derivare.setBounds(10, 292, 190, 31);
        continut.add(derivare);

        integrare.setFont(new Font("Tahoma", Font.BOLD, 16));
        integrare.setBounds(210, 292, 190, 31);
        continut.add(integrare);

        etRezultat.setFont(new Font("Tahoma", Font.PLAIN, 14));
        etRezultat.setBounds(10, 333, 92, 27);
        continut.add(etRezultat);

        textRezultat.setBounds(10, 370, 405, 31);
        textRezultat.setEditable(false);
        continut.add(textRezultat);

        etRest.setFont(new Font("Tahoma", Font.PLAIN, 14));
        etRest.setBounds(10, 417, 92, 27);
        continut.add(etRest);

        textRest.setEditable(false);
        textRest.setBounds(10, 454, 405, 31);
        continut.add(textRest);

        info.setFont(new Font("Tahoma", Font.BOLD, 14));
        info.setBounds(315, 14, 85, 21);
        continut.add(info);

        trimitePolinom.setFont(new Font("Tahoma", Font.BOLD, 14));
        trimitePolinom.setBounds(112, 411, 289, 31);
        continut.add(trimitePolinom);

        this.setContentPane(continut);
    }

    void showError(String err) {
        JOptionPane.showMessageDialog(this, err);
    }

    String getPolinomUnu() {
        return polUnuText.getText();
    }

    String getPolinomDoi() {
        return polDoiText.getText();
    }

    String getRezultat(){
        return textRezultat.getText();
    }

    void setPolinomUnu(String polinom){
        polUnuText.setText(polinom);
    }

    void resetPolinom1() {
        polUnuText.setText("");
    }

    void resetPolinom2() {
        polDoiText.setText("");
    }

    void resetRezultat() {
        textRezultat.setText("");
    }

    void resetRest(){
        textRest.setText("");
    }

    void setRezultat(Polinom polinom){
        textRezultat.setText(polinom.toString());
    }

    void setRest(Polinom polinom){
        textRest.setText(polinom.toString());
    }

    void resetActionListener(ActionListener a){
        reset.addActionListener(a);
    }
    void adunareActionListener(ActionListener a){
        adunare.addActionListener(a);
    }
    void scadereActionListener(ActionListener a){
        scadere.addActionListener(a);
    }
    void infoActionListener(ActionListener a){
        info.addActionListener(a);
    }
    void inmultireActionListener(ActionListener a){
        inmultire.addActionListener(a);
    }
    void derivareActionListener(ActionListener a){
        derivare.addActionListener(a);
    }
    void trimitePolinomActionListener(ActionListener a){
        trimitePolinom.addActionListener(a);
    }
    void integrarePolinomActionListener(ActionListener a){
        integrare.addActionListener(a);
    }
    void impartirePolinomActionListener(ActionListener a){
        impartire.addActionListener(a);
    }
}
