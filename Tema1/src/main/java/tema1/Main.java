package tema1;

public class Main {
    public static void main(String[] args){
        Operatii operatii=new Operatii();
        View view=new View(operatii);
        view.setVisible(true);
        Controller controller=new Controller(operatii,view);
    }
}
//x^3-2x^2+6x-5
//x^2-1