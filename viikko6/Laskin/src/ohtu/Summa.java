/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author joopeti
 */
public class Summa implements Komento{
    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    private int vanhatulos;

    public Summa(Sovelluslogiikka logiikka, JTextField tuloskentta, JTextField syötekenttä) {
        this.sovellus = logiikka;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syötekenttä;
    }
    
    @Override
    public void suorita() {
        vanhatulos = sovellus.tulos();
        int arvo = 0;
        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }
        sovellus.plus(arvo);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        sovellus.setTulos(vanhatulos);
        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }
    
}
