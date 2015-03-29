package ohtu.data_access;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import ohtu.domain.User;

public class FileUserDAO implements UserDao {

    Scanner lukija;
    File file;

    public FileUserDAO(File file) {
        lukija = null;
        this.file = file;
        try {
            lukija = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Tiedoston lukeminen epäonnistui. Virhe: " + e.getMessage());
            return; // poistutaan metodista
        }
    }

    @Override
    public List<User> listAll() {
        if (lukija == null) {
            return null;
        }
        List lista = new ArrayList<User>();
        while (lukija.hasNextLine()) {
            lista.add(new User(lukija.next(), lukija.next()));
        }
        return lista;
    }

    @Override
    public User findByName(String name) {
        if (lukija == null) {
            return null;
        }
        while (lukija.hasNextLine()) {
            String nimi = lukija.next();
            if(nimi.equals(name)){
                return new User(nimi, lukija.next());
            }
        }
        return null;
    }

    @Override
    public void add(User user) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaminen ei onnistunut :(");
            return;
        }
        try {
            fw.write(user.getUsername() + " " + user.getPassword() + "\n");
        } catch (IOException ex) {
            System.out.println("Tiedostoon kirjoittaminen ei onnistunut :(");
        }
    }

}
