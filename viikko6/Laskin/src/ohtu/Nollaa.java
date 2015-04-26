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
class Nollaa implements Komento {
    Sovelluslogiikka sovellus;
    JTextField tuloskentta;
    JTextField syotekentta;
    private int vanhatulos;
    
    public Nollaa(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        vanhatulos = sovellus.tulos();
        sovellus.nollaa();
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
