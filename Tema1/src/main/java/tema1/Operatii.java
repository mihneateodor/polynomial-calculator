package tema1;

import java.lang.*;

public class Operatii {

    public Operatii() {
    }

    public Polinom adunare(Polinom polinom1, Polinom polinom2) {
        Polinom rezultat = new Polinom();
        for (Monom mon1 : polinom1.getPolinom()) {
            for (Monom mon2 : polinom2.getPolinom()) {
                Integer exp1 = mon1.getExponent();
                Integer exp2 = mon2.getExponent();
                if (exp1.equals(exp2) && !(exp1.equals(-1)) && !(exp2.equals(-1)) && mon1.getParcurs() == false && mon2.getParcurs() == false) {
                    Monom monRezultat = new Monom();
                    mon1.setParcurs(true);
                    mon2.setParcurs(true);
                    monRezultat.setExponent(exp1);
                    monRezultat.setCoeficient(mon1.getCoeficient() + mon2.getCoeficient());
                    rezultat.addMonom(monRezultat);
                }
            }
        }
        for (Monom mon1 : polinom1.getPolinom()) {
            if (mon1.getParcurs() == false)
                rezultat.addMonom(mon1);
        }
        for (Monom mon2 : polinom2.getPolinom()) {
            if (mon2.getParcurs() == false)
                rezultat.addMonom(mon2);
        }
        return rezultat;
    }

    public Polinom scadere(Polinom polinom1, Polinom polinom2) {
        Polinom rezultat = new Polinom();
        for( Monom mon : polinom1.getPolinom())
        {
                mon.setParcurs(false);
        }
        for (Monom mon1 : polinom1.getPolinom()) {
            for (Monom mon2 : polinom2.getPolinom()) {
                Integer exp1 = mon1.getExponent();
                Integer exp2 = mon2.getExponent();
                if (exp1.equals(exp2) && !(exp1.equals(-1)) && !(exp2.equals(-1)) && mon1.getParcurs() == false && mon2.getParcurs() == false) {
                    Monom monRezultat = new Monom();
                    mon1.setParcurs(true);
                    mon2.setParcurs(true);
                    monRezultat.setExponent(exp1);
                    monRezultat.setCoeficient(mon1.getCoeficient() - mon2.getCoeficient());
                    rezultat.addMonom(monRezultat);
                }
            }
        }
        for (Monom mon1 : polinom1.getPolinom()) {
            if (mon1.getParcurs() == false)
                rezultat.addMonom(mon1);
        }
        for (Monom mon2 : polinom2.getPolinom()) {
            if (mon2.getParcurs() == false) {
                mon2.setCoeficient(-mon2.getCoeficient());
                rezultat.addMonom(mon2);
            }
        }
        return rezultat;
    }

    public Polinom inmultire(Polinom polinom1, Polinom polinom2) {
        Polinom rezultat = new Polinom();
        for (Monom mon1 : polinom1.getPolinom()) {
            for (Monom mon2 : polinom2.getPolinom()) {
                Monom monRezultat = new Monom();
                monRezultat.setCoeficient(mon1.getCoeficient() * mon2.getCoeficient());
                monRezultat.setExponent(mon1.getExponent() + mon2.getExponent());
                rezultat.addMonom(monRezultat);
            }
        }
        return rezultat;
    }

    public Polinom derivare(Polinom polinom) {
        Polinom rezultat = new Polinom();
        for (Monom mon1 : polinom.getPolinom()) {
            Monom monRezultat = new Monom();
            monRezultat.setCoeficient(mon1.getCoeficient() * mon1.getExponent());
            monRezultat.setExponent(mon1.getExponent() - 1);
            rezultat.addMonom(monRezultat);
        }
        return rezultat;
    }

    public Polinom integrare(Polinom polinom) {
        Polinom rezultat = new Polinom();
        for (Monom mon1 : polinom.getPolinom()) {
            Monom monRezultat = new Monom();
            try {
                monRezultat.setExponent(mon1.getExponent() + 1);
                monRezultat.setCoeficient(mon1.getCoeficient() / (mon1.getExponent() + 1));
                rezultat.addMonom(monRezultat);
            } catch (ArithmeticException e) {
                monRezultat.setCoeficient(0);
                monRezultat.setExponent(0);
            }
        }
        return rezultat;
    }

    public Polinom impartire(Polinom polinom1, Polinom polinom2) {
        Polinom rezultat = new Polinom();

        if (polinom1.getPolinom().get(0).getExponent() < polinom2.getPolinom().get(0).getExponent()) {
            Monom monom0 = new Monom(0, 0, false);
            rezultat.addMonom(monom0);
            return rezultat;
        }
        Polinom polinomAux = new Polinom();

        while (polinom1.getPolinom().get(0).getExponent() >= polinom2.getPolinom().get(0).getExponent()) {
            Monom monomRezultat = new Monom();
            monomRezultat.setExponent(polinom1.getPolinom().get(0).getExponent() - polinom2.getPolinom().get(0).getExponent());
            try {
                monomRezultat.setCoeficient(polinom1.getPolinom().get(0).getCoeficient() / polinom2.getPolinom().get(0).getCoeficient());
            } catch (ArithmeticException e) {
                monomRezultat.setCoeficient(0);
                monomRezultat.setExponent(0);
            }
            rezultat.addMonom(monomRezultat);
            polinomAux.addMonom(monomRezultat);
            polinom1 = this.scadere(polinom1, this.inmultire(polinomAux, polinom2));
            polinomAux.removeMonom(polinomAux.getPolinom().get(0));
            polinom1.removeMonom(polinom1.getPolinom().get(0));
            polinom1.toString();
        }
        return rezultat;
    }

    public Polinom rest(Polinom polinom1, Polinom polinom2){
        Polinom rezultat;
        Polinom aux;
        aux=this.impartire(polinom1,polinom2);
        aux=this.inmultire(polinom2,aux);
        aux.toString();
        rezultat=this.scadere(polinom1,aux);
        return rezultat;
    }
}
