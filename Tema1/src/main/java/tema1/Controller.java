package tema1;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {
    private Operatii operatii;
    private View view;

    public Controller(Operatii operatii, View view){
        this.operatii=operatii;
        this.view=view;
        view.resetActionListener(new ResetActionListener());
        view.adunareActionListener(new AdunareActionListener());
        view.scadereActionListener(new ScadereActionListener());
        view.infoActionListener(new InfoActionListener());
        view.inmultireActionListener(new InmultireActionListener());
        view.derivareActionListener(new DerivareActionListener());
        view.trimitePolinomActionListener(new TrimitePolinomActionListener());
        view.integrarePolinomActionListener(new IntegrareActionListener());
        view.impartirePolinomActionListener(new ImpartireActionListener());
    }

    class ResetActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.resetPolinom1();
            view.resetPolinom2();
            view.resetRezultat();
            view.resetRest();
        }
    }
    class AdunareActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom polinom1=new Polinom();
            Polinom polinom2=new Polinom();
            Polinom rezultat;
            try{
                polinom1.verificarePattern(view.getPolinomUnu());
                polinom2.verificarePattern(view.getPolinomDoi());
                rezultat=operatii.adunare(polinom1,polinom2);
                view.setRezultat(rezultat);
                view.resetRest();
            }
            catch(NullPointerException ex){
                view.resetRezultat();
                view.resetRest();
            }
        }
    }
    class ScadereActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom polinom1=new Polinom();
            Polinom polinom2=new Polinom();
            Polinom rezultat;
            try{
                polinom1.verificarePattern(view.getPolinomUnu());
                polinom2.verificarePattern(view.getPolinomDoi());
                rezultat=operatii.scadere(polinom1,polinom2);
                view.setRezultat(rezultat);
                view.resetRest();
            }
            catch(NullPointerException ex){
                view.resetRezultat();
                view.resetRest();
            }
        }
    }
    class InfoActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(view, "Calculator de Polinoame realizat de Circiu Mihnea Teodor");
        }
    }
    class InmultireActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom polinom1=new Polinom();
            Polinom polinom2=new Polinom();
            Polinom rezultat;
            try{
                polinom1.verificarePattern(view.getPolinomUnu());
                polinom2.verificarePattern(view.getPolinomDoi());
                rezultat=operatii.inmultire(polinom1,polinom2);
                view.setRezultat(rezultat);
                view.resetRest();
            }
            catch(NullPointerException ex){
                view.resetRezultat();
                view.resetRest();
            }
        }
    }
    class DerivareActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom polinom=new Polinom();
            Polinom rezultat=new Polinom();
            view.resetPolinom2();
            try{
                polinom.verificarePattern(view.getPolinomUnu());
                rezultat=operatii.derivare(polinom);
                view.setRezultat(rezultat);
                view.resetRest();
            }
            catch(Exception ex){
                view.resetRezultat();
                view.resetRest();
            }
        }
    }
    class TrimitePolinomActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            view.setPolinomUnu(view.getRezultat());
        }
    }
    class IntegrareActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            Polinom polinom=new Polinom();
            Polinom rezultat;
            view.resetPolinom2();
            try{
                polinom.verificarePattern(view.getPolinomUnu());
                rezultat=operatii.integrare(polinom);
                view.setRezultat(rezultat);
                view.resetRest();
            }
            catch(Exception ex){
                view.resetRezultat();
                view.resetRest();
            }
        }
    }
    class ImpartireActionListener implements ActionListener{
        public void actionPerformed (ActionEvent e){
            Polinom polinom1=new Polinom();
            Polinom polinom2=new Polinom();
            Polinom rezultat;
            Polinom rest;
            try{
                polinom1.verificarePattern(view.getPolinomUnu());
                polinom2.verificarePattern(view.getPolinomDoi());
                if(polinom2.getPolinom().get(0).getExponent()==-1){
                    view.showError("Impartire la 0 imposibila!");
                }
                else {
                    rezultat = operatii.impartire(polinom1, polinom2);
                    rest = operatii.rest(polinom1, polinom2);
                    view.setRezultat(rezultat);
                    view.setRest(rest);
                }
            }
            catch( Exception ex){
                view.resetRezultat();
                view.resetRest();
            }
        }
    }
}
