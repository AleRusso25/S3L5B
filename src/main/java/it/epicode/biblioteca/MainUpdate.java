package it.epicode.biblioteca;




import it.epicode.dao.ElementoCatalogoDAO;
import it.epicode.dao.PrestitoDAO;
import it.epicode.entity.ElementoCatalogo;
import it.epicode.entity.Libro;
import it.epicode.entity.Prestito;
import it.epicode.entity.Rivista;

import java.util.List;

public class MainUpdate {

    public static void main(String[] args) {

        ElementoCatalogoDAO catalogoDAO = new ElementoCatalogoDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();


        ElementoCatalogo elemento = catalogoDAO.findByIsbn("123456789");
        if (elemento != null) {
            System.out.println("Elemento trovato: " + elemento.getTitolo());
        } else {
            System.out.println("Elemento non trovato!");
        }


        List<Prestito> prestitiScaduti = prestitoDAO.findPrestitiScaduti();
        System.out.println("Prestiti scaduti: " + prestitiScaduti.size());


        Rivista nuovaRivista = new Rivista();
        nuovaRivista.setIsbn("123");
        nuovaRivista.setTitolo("Sara");
        nuovaRivista.setAnnoPubblicazione(2022);
        nuovaRivista.setNumeroPagine(41);
        nuovaRivista.setPeriodicita(Rivista.Periodicita.SETTIMANALE);
        catalogoDAO.save(nuovaRivista);
        System.out.println("rivista aggiunta: " + nuovaRivista.getTitolo());

        Libro libro = new Libro();
        libro.setIsbn("145");
        libro.setTitolo("hola");
        libro.setAnnoPubblicazione(2004);
        libro.setNumeroPagine(60);
        libro.setAutore("Ale");
        libro.setGenere("Informatica");
        catalogoDAO.save(libro);

        Rivista nuovaRivista1 = new Rivista();
        nuovaRivista1.setIsbn("433");
        nuovaRivista1.setTitolo("Amore");
        nuovaRivista1.setAnnoPubblicazione(2003);
        nuovaRivista1.setNumeroPagine(6);
        nuovaRivista1.setPeriodicita(Rivista.Periodicita.MENSILE);
        catalogoDAO.save(nuovaRivista1);
        System.out.println("rivista aggiunta: " + nuovaRivista.getTitolo());
}
}