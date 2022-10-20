package pt.trainings.maven.templating;

import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;

class MyWindowAdapter1 extends WindowAdapter {
    public void windowClosing(WindowEvent e) { System.exit(0); }
}

class MyFrame1 extends Frame {

    Label wynik;
    
    public int kwadrat(int n)
    {
    	return n*n;
    }

    MyFrame1(int n) {
        addWindowListener(new MyWindowAdapter1());
        setLayout(new GridLayout(n, 1));
        setBounds(100,100,3*n*n+5*n+50,40*n+75);
        setFont(new Font(Font.SERIF,Font.BOLD,20));
        for(int i=1;i<=n;i++)
        {
            wynik = new Label();
            wynik.setAlignment(Label.CENTER);
            String str = "";
            wynik.setText(str+kwadrat(i));
            wynik.setForeground(Color.WHITE);
            wynik.setBackground(Color.BLUE);
            add(wynik);
        }
    }
}


public class Kwadraty {
    public static void main(String[] args) {
    	
        boolean isDone = false;
        Scanner scan = new Scanner(System.in);
        String s;
        int n;

        do {
            System.out.println("Program wypisujacy kwadraty liczb od 1 do n");
            System.out.println("Podaj n: ");
            s = scan.nextLine();
            try { n = Integer.parseInt(s);
	            if(n<1){
	                System.out.println("Bledne dane");
	            }
	            else {
	            	isDone = true;
	                MyFrame1 frame = new MyFrame1(n);
	                frame.setVisible(true);
	            }
            }
            catch (NumberFormatException ex) {
                System.out.println("Bledne dane");
            }

        }while (!isDone);
    }
}