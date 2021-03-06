/**
 * @author Marcel Buschmann
 * version 1.0
 */

import java.io.*;
import java.util.DuplicateFormatFlagsException;


/**
 * Klasse BenutzerVerwaltungAdmin, mit der Admins erzeugt werden können, welche dann {@link Benutzer} verwalten können
 */
public class BenutzerVerwaltungAdmin implements BenutzerVerwaltung  {

    /**
     * Array in dem mehrere Benutzer gespeichert werden können.
     */
    //hier rausnehmen klappt nicht! Ist aber auch gar nicht nötig!
    Benutzer datenhaltung[] = new Benutzer[5];
    String AdminUsername;
    String passwort;
    String dateiName = "";

    //privat machen!
    public Benutzer[] deserialisieren()throws IOException,ClassNotFoundException {
        FileInputStream fis = new FileInputStream(this.dateiName);
        ObjectInputStream ois = new ObjectInputStream(fis);

        Benutzer[] datenarray = (Benutzer[]) ois.readObject(); //unsere File mit der Datenhaltung einlesen

        fis.close();
        ois.close();
        return datenarray;
    }
    //privat machen!
    private void serialisieren()throws IOException{
        FileOutputStream fos = new FileOutputStream(this.dateiName);
        ObjectOutputStream os = new ObjectOutputStream(fos);

        os.writeObject(datenhaltung); //Dateien mit neuem benutzer abspeichern

        os.close();
        fos.close();
    }

    //Admin soll mehrere Datenhaltungen erzeugen können!
    public void dbInit() throws IOException {
        Benutzer[] datenhaltung = new Benutzer[5]; //Hierdurch kann Admin mehrere Datenbanken erzeugen
        serialisieren();
    }


    /**
     * Trägt einen Benutzer in die Datenhaltung eines Admins ein.
     * @see Benutzer
     * @param benutzer Der einzutragende Benutzer
     * @throws DuplicateObjectException Gibt Fehler zurück, wenn der Benutzer bereits vorhanden ist.
     * @throws IndexOutOfBoundsException Gibt einen Fehler zurück, wenn die Datenhaltung voll ist.
     */
    @Override
    public void benutzerEintragen(Benutzer benutzer) throws DuplicateObjectException, IndexOutOfBoundsException,IOException,ClassNotFoundException{

        //Daten lesen
        datenhaltung = this.deserialisieren();

            for (int i = 0; i < datenhaltung.length; i++) {
                if (datenhaltung[i] == null) {
                    datenhaltung[i] = benutzer;

                    //Daten speichern
                    serialisieren();
                    break;
                }
                else if(this.benutzerVorhanden(benutzer)){
                    throw new DuplicateObjectException(benutzer.getUserId()+ " bereits vorhanden");
                }
                else if(datenhaltung[0]!=null&&datenhaltung[1]!=null&&datenhaltung[2]!=null&&datenhaltung[3]!=null&&datenhaltung[4]!=null){
                    throw new IndexOutOfBoundsException("Datenhaltung ist voll");
                }

            }
    }

    /**
     * Methode zum Löschen eines Benutzer aus der Datenhaltung.
     * @param benutzer Zu löschender Benutzer.
     * @throws DuplicateObjectException Gibt einen Fehler zurück, wenn der zu löschende Benutzer nicht existiert.
     */
    public void benutzerLoeschen (Benutzer benutzer) throws DuplicateObjectException,IOException,ClassNotFoundException{

        //Daten öffnen und lesen
        deserialisieren();

            if(benutzerVorhanden(benutzer)==false){
            throw new DuplicateObjectException(benutzer.getUserId() + " existiert nicht");
            }
            else{
            for(int i=0;i<datenhaltung.length;i++) {
                if (this.datenhaltung[i] != null && this.datenhaltung[i].equals(benutzer)) {
                    this.datenhaltung[i] = null;

                    //Daten speichern
                    serialisieren();

                    break;
                }
            }
        }
    }


    /**
     * Prüft, ob ein {@link Benutzer} bereits vorhanden ist in der Datenhaltung des Admins
     * @param benutzer Der auf Vorhandenheit zu prüfende Benutzer.
     * @return Gibt zurück, ob der Benutzer bereits vorhanden ist oder nicht.
     */
    @Override
    public boolean benutzerVorhanden(Benutzer benutzer)throws IOException,ClassNotFoundException {
        //deserialisieren
        datenhaltung = this.deserialisieren();

        boolean vorhanden = true;
        for (int i = 0; i < datenhaltung.length; i++) {
            if(datenhaltung[i]==null){
                return false;
            }
            else if (datenhaltung[i].equals(benutzer)) {
                vorhanden = true;
                break;
            } else {
                vorhanden = false;

            }

        } return vorhanden;
    }

    /**
     * Selbst definierte Exception, die in {@link #benutzerEintragen(Benutzer)} verwendet wird.
     */
    public class DuplicateObjectException extends DuplicateFormatFlagsException{
        DuplicateObjectException (String ausgabe){
            super(ausgabe);
        }

    }

    /**
     * Default Konstruktor
     */
    //Konstruktor
    BenutzerVerwaltungAdmin(String DateiName) {this.dateiName = DateiName;};

    /**
     * toString Methode mittels der alle {@link Benutzer} einer Datenhaltung als String ausgegeben werden können.
     * @param array Das auzugebende Array welches die Benutzer enthält.
     * @return Gibt alle Benutzer aus.
     */
    //toString
    String toString(Benutzer array[]) {
        String datenhaltungErgebnis = "";
        for (int i = 0; i < datenhaltung.length; i++) {
            if (datenhaltung[i] != null) {
              datenhaltungErgebnis += datenhaltung[i].toString();
            }
        }
        return datenhaltungErgebnis;
    }
}