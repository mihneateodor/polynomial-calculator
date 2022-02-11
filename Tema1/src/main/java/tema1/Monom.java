package tema1;

public class Monom implements Comparable<Monom>{
    private int coeficient;
    private int exponent;
    private boolean parcurs=false;

    public Monom(int coeficient, int exponent, boolean parcurs) {
        this.coeficient = coeficient;
        this.exponent = exponent;
        this.parcurs = parcurs;
    }

    public Monom() {
    }

    public void setParcurs(boolean parcurs){
        this.parcurs=parcurs;
    }

    public boolean getParcurs(){
        return this.parcurs;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public int getCoeficient() {
        return this.coeficient;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getExponent() {
        return this.exponent;
    }

    public String toString() {
        Integer coef = this.coeficient;
        Integer exp = this.exponent;
        String monom = "";
        if (coef.equals(0))
            return monom;
        else if (coef != 0) {
            if (coef<0)
            {
                if(coef.equals(-1) && exp.equals(0))
                {
                    monom=monom+coef;
                }
                else if(coef.equals(-1) && exp.equals(1))
                {
                    monom=monom+"-x";
                }
                else if(coef.equals(-1))
                {
                    monom=monom+"-x^"+exp;
                }
                else
                    if(exp.equals(1))
                        monom=monom+coef+"x";
                    else
                        if(exp.equals(0))
                            monom=monom+coef;
                        else
                            monom=monom+coef+"x^"+exp;

            }
            else
            {
                if(coef.equals(1) && exp.equals(0))
                {
                    monom=monom+"+"+coef;
                }
                else if(coef.equals(1) && exp.equals(1))
                {
                    monom=monom+"+x";
                }
                else if(coef.equals(1))
                {
                    monom=monom+"+x^"+exp;
                }
                else
                    if(exp.equals(1))
                        monom=monom+"+"+coef+"x";
                    else if (exp.equals(0))
                        monom=monom+"+"+coef;
                    else
                        monom=monom+"+"+coef+"x^"+exp;
            }
        }
        return monom;
    }

    @Override
    public int compareTo(Monom o) {
        if ( this.exponent > o.exponent)    return -1;
        else if ( this.exponent == o.exponent) return 0;
        else return 1;
    }
}
