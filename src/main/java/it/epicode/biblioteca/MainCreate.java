package it.epicode.biblioteca;



import it.epicode.dao.ElementoCatalogoDAO;
import it.epicode.dao.PrestitoDAO;
import it.epicode.dao.UtenteDAO;
import it.epicode.entity.Libro;
import it.epicode.entity.Prestito;
import it.epicode.entity.Rivista;
import it.epicode.entity.Utente;

import java.time.LocalDate;

public class MainCreate {

    public static void main(String[] args) {

        ElementoCatalogoDAO catalogoDAO = new ElementoCatalogoDAO();
        UtenteDAO utenteDAO = new UtenteDAO();
        PrestitoDAO prestitoDAO = new PrestitoDAO();


        Libro libro = new Libro();
        libro.setIsbn("555");
        libro.setTitolo("ciao");
        libro.setAnnoPubblicazione(2022);
        libro.setNumeroPagine(5);
        libro.setAutore("Alessandra");
        libro.setGenere("Informatica");
        catalogoDAO.save(libro);


        Rivista rivista = new Rivista();
        rivista.setIsbn("551");
        rivista.setTitolo("luca");
        rivista.setAnnoPubblicazione(2000);
        rivista.setNumeroPagine(10);rivista.setPeriodicita(Rivista.Periodicita.MENSILE);
        catalogoDAO.save(rivista);


        Utente utente = new Utente();
        utente.setNome("sara");
        utente.setCognome("verdi");
        utente.setDataNascita(LocalDate.of(2005, 2, 3));
        utente.setNumeroTessera("U555");
        utenteDAO.save(utente);


        Prestito prestito = new Prestito();
        prestito.setUtente(utente);
        prestito.setElementoPrestato(libro);
        prestito.setDataInizioPrestito(LocalDate.now());
        prestito.setDataRestituzionePrevista(LocalDate.now().plusDays(30));
        prestitoDAO.save(prestito);

        System.out.println("Database creato!");




}
}