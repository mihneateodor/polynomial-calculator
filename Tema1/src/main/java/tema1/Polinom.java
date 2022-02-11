
package tema1;

import java.util.Collections;
import java.util.regex.*;
import java.util.List;
import java.util.ArrayList;

public class Polinom {
    private List<Monom> polinom;

    public Polinom() {
        this.polinom = new ArrayList<Monom>();
    }

    public void addMonom(Monom monom) {
        this.polinom.add(monom);
    }

    public void removeMonom( Monom monom ){
        this.polinom.remove(monom);
    }

    public List<Monom> getPolinom() {
        return polinom;
    }

    public void verificarePattern(String input) {
        Pattern p = Pattern.compile("([-+]?)(\\d*\\.?\\d*)?([xX](\\^-?\\d*\\.?\\d*)?)?");
        Matcher m = p.matcher(input);
        while (m.find()) {
            Monom monom = new Monom();
            try{
                monom.setCoeficient(Integer.parseInt(m.group(1)+m.group(2)));
            }
            catch(NumberFormatException ex){
                if(m.group(2).equals("") && m.group(3)!=null) {
                    monom.setCoeficient(1);
                }
                if(m.group(1).startsWith("-") && m.group(2).equals(""))
                    monom.setCoeficient(-1);
                if(m.group(1).startsWith("+") && m.group(2).equals(""))
                    monom.setCoeficient(1);
            }
            try{
                monom.setExponent(Integer.parseInt(m.group(4).substring(1)));
            }
            catch(NumberFormatException ex){}
            catch(NullPointerException ex){
                Integer coef= monom.getCoeficient();
                if(!(coef.equals(0)) && m.group(3) !=null)
                    monom.setExponent(1);
                else if(m.group(4) == null )
                    monom.setExponent(0);
            }
            if(m.group(1).equals("") && m.group(2).equals("") && m.group(3)==null && m.group(4)==null){
                monom.setExponent(-1);
            }
            this.addMonom(monom);
        }
    }

    public String toString() {
        Collections.sort(this.polinom);
        String polinomString = new String("");
        for (Monom var : this.polinom) {
            polinomString = polinomString + var.toString();
        }
        if(polinomString.startsWith("+"))
            polinomString=polinomString.substring(1);
        if(polinomString.isEmpty())
            return "0";
        else
            return polinomString;
    }
}
