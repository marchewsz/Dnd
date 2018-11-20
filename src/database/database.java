/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;


import dnd.Models.Atut;
import dnd.Models.Gracz;
import dnd.Models.Przedmiot;
import java.sql.*;
import java.util.*;
/**
 *
 * @author march
 */
public class database {
    
    public static final String DRIVER = "org.sqlite.JDBC";
    public static final String DB_URL = "jdbc:sqlite:dane.db";

    private Connection conn;
    private Statement stat;
    
    public database(){
         try {
            Class.forName(database.DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println("Brak sterownika JDBC");
            e.printStackTrace();
        }

        try {
            conn = DriverManager.getConnection(DB_URL);
            stat = conn.createStatement();
        } catch (SQLException e) {
            System.err.println("Problem z otwarciem polaczenia");
            e.printStackTrace();
        }

        createTables();
    }

    /**
     * Tworzenie tabel w bazie danych jeżeli nie istnieją
     * @return 
     * -true jeśli tabele zostaną utworzone pomyślnie <br/>
     * -false w przypadku błędu
     */
    public boolean createTables()  {
        String createGracze =
                "CREATE TABLE IF NOT EXISTS gracze ("
                + "id_gracza INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "imie varchar(255), "
                + "rasa varchar(255), "
                + "klasa varchar(255),"
                + "sciezkaArchetypu varchar(255),"
                + "rozmiar varchar(255),"
                + "wiek int,"
                + "plec varchar(255),"
                + "wzrost double,"
                + "waga double,"
                + "charakter varchar(255),"
                + "bostwo varchar(255),"
                + "poziom int,"
                + "epickiePrzeznaczenie varchar(255),"
                + "druzyna varchar(255),"
                + "pktAkcji double,"
                + "sila int,"
                + "kondycja int,"
                + "zrecznosc int,"
                + "inteligencja int,"
                + "rozsadek int,"
                + "charyzma int"
                + ")";
        String createPrzedmioty = "CREATE TABLE IF NOT EXISTS przedmioty ("
                + "id_przedmiotu INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nazwa varchar(255), "
                + "klasaPancerza int,"
                + "usprawnienie int,"
                + "rozne varchar(255)"
                + ")";
        String createEkwipunek = "CREATE TABLE IF NOT EXISTS ekwipunek ("
                + "id_ekwipunku INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "id_gracza int, "
                + "id_przedmiotu int)";
        String createAtuty = "CREATE TABLE IF NOT EXISTS atuty ("
                + "id_atutu INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "nazwa varchar(255), "
                + "opis varchar(255)"
                + ")";
       
        try {
            stat.execute(createGracze);
            stat.execute(createPrzedmioty);
            stat.execute(createEkwipunek);
            stat.execute(createAtuty);
        } catch (SQLException e) {
            System.err.println("Blad przy tworzeniu tabeli");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * Dodaje do tabeli gracze dane gracza
     * @param gracz
     * Obiekt klasy Gracz
     * @return 
     * -true jeśli dodanie zakończone pomyślnie <br/>
     * -false w przypadku błędu
     */
    public boolean insertGracz(Gracz gracz){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into gracze values (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            prepStmt.setString(1, gracz.getImie());
            prepStmt.setString(2, gracz.getRasa());
            prepStmt.setString(3, gracz.getKlasa());
            prepStmt.setString(4, gracz.getSciezkaArchetypu());
            prepStmt.setString(5, gracz.getRozmiar());
            prepStmt.setInt(6, gracz.getWiek());
            prepStmt.setString(7, gracz.getPlec());
            prepStmt.setDouble(8, gracz.getWzrost());
            prepStmt.setDouble(9, gracz.getWaga());
            prepStmt.setString(10, gracz.getCharakter());
            prepStmt.setString(11, gracz.getBostwo());
            prepStmt.setInt(12, gracz.getPoziom());
            prepStmt.setString(13, gracz.getEpickiePrzeznaczenie());
            prepStmt.setString(14, gracz.getDruzyna());
            prepStmt.setDouble(15, gracz.getPktAkcji());
            prepStmt.setInt(16, gracz.getSila());
            prepStmt.setInt(17, gracz.getKondycja());
            prepStmt.setInt(18, gracz.getZrecznosc());
            prepStmt.setInt(19, gracz.getInteligencja());
            prepStmt.setInt(20, gracz.getRozsadek());
            prepStmt.setInt(21, gracz.getCharyzma());
            
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu gracza");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * Dodaje przedmiot do tabeli przedmioty 
     * @param przedmiot
     * Obiekt klasy Przedmiot
     * @return 
     * -true jeśli dodanie zakończone pomyślnie <br/>
     * -false w przypadku błędu
     */
    public boolean insertPrzedmiot(Przedmiot przedmiot){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into przedmioty values (NULL, ?, ?, ?, ?);");
            prepStmt.setString(1, przedmiot.getNazwa());
            prepStmt.setInt(2, przedmiot.getKlasaPancerza());
            prepStmt.setInt(3, przedmiot.getUsprawnienie());
            prepStmt.setString(4, przedmiot.getRozne());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu przedmiotu");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * Dodawanie atutu do tabeli atuty
     * @param atut
     * Obiekt klasy Atut
     * @return 
     * -true jeśli dodanie zakończone pomyślnie <br/>
     * -false w przypadku błędu
     */
    public boolean insertAtut(Atut atut){
        
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into atuty values (NULL, ?, ?);");
            prepStmt.setString(1, atut.getNazwa());
            prepStmt.setString(2, atut.getOpis());
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu atutu");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    /**
     * Nie używać, do rozbudowy w przypadku wielu graczy
     * @param idGracz
     * @param idPrzedmiot
     * @return 
     * -true jeśli dodanie zakończone pomyślnie <br/>
     * -false w przypadku błędu
     */
   public boolean insertEkwipunek(int idGracz, int idPrzedmiot){
       try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "insert into ekwipunek values (NULL, ?, ?);");
            prepStmt.setInt(1, idGracz);
            prepStmt.setInt(2, idPrzedmiot);
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu ekwipunku");
            e.printStackTrace();
            return false;
        }
        return true;
   }
   
//       int id_gracza;
//     String imie;
//     String rasa;
//     String klasa;
//     String sciezkaArchetypu;
//     String rozmiar;
//     int wiek;
//     String plec;
//     double wzrost;
//     double waga;
//     String charakter;
//     String bostwo;
//     int poziom;
//     String epickiePrzeznaczenie;
//     String druzyna;
//     double pktAkcji;
   
   /**
    * Funkcja aktualizująca dane gracza o id 1
    * @param gracz
    * @return 
    */
   public boolean updateGracz(Gracz gracz){
       int id = 1;
       try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "UPDATE gracze SET imie = ? ,"
                            + "rasa = ? , "
                            + "klasa = ? , "
                            + "sciezkaArchetypu = ? , "
                            + "rozmiar = ? , "
                            + "wiek = ? , "
                            + "plec = ? , "
                            + "wzrost = ? , "
                            + "waga = ? , "
                            + "charakter = ?, "
                            + "bostwo = ? , "
                            + "poziom = ? , "
                            + "epickiePrzeznaczenie = ? , "
                            + "druzyna = ? , "
                            + "pktAkcji = ? , "
                            + "sila = ? , "
                            + "kondycja = ? , "
                            + "zrecznosc = ? , "
                            + "inteligencja = ? , "
                            + "rozsadek = ? , "
                            + "charyzma = ? "
                            + "WHERE id_gracza = 1;");
            prepStmt.setString(1, gracz.getImie());
            prepStmt.setString(2, gracz.getRasa());
            prepStmt.setString(3, gracz.getKlasa());
            prepStmt.setString(4, gracz.getSciezkaArchetypu());
            prepStmt.setString(5, gracz.getRozmiar());
            prepStmt.setInt(6, gracz.getWiek());
            prepStmt.setString(7, gracz.getPlec());
            prepStmt.setDouble(8, gracz.getWzrost());
            prepStmt.setDouble(9, gracz.getWaga());
            prepStmt.setString(10, gracz.getCharakter());
            prepStmt.setString(11, gracz.getBostwo());
            prepStmt.setInt(12, gracz.getPoziom());
            prepStmt.setString(13, gracz.getEpickiePrzeznaczenie());
            prepStmt.setString(14, gracz.getDruzyna());
            prepStmt.setDouble(15, gracz.getPktAkcji());
            prepStmt.setInt(16, gracz.getSila());
            prepStmt.setInt(17, gracz.getKondycja());
            prepStmt.setInt(18, gracz.getZrecznosc());
            prepStmt.setInt(19, gracz.getInteligencja());
            prepStmt.setInt(20, gracz.getRozsadek());
            prepStmt.setInt(21, gracz.getCharyzma());
            
            prepStmt.execute();
        } catch (SQLException e) {
            System.err.println("Blad przy wstawianiu gracza");
            e.printStackTrace();
            return false;
        }
        return true;
       
   }
   /**
    * Funkcja wyciągająca z bazy gracza o konkretnym id
    * @param id
    * Numer id konkretnego gracza z bazy
    * @return 
    * Obiekt klasy Gracz
    */
   public Gracz selectGracz(int id){
       Gracz gracz = new Gracz();
       
       try{
           ResultSet result = stat.executeQuery("SELECT * FROM gracze WHERE id_gracza = "+id+"");
           gracz.setId(result.getInt("id_gracza"));
           gracz.setImie(result.getString("imie"));
           gracz.setRasa(result.getString("rasa"));
           gracz.setKlasa(result.getString("klasa"));
           gracz.setSciezkaArchetypu(result.getString("sciezkaArchetypu"));
           gracz.setRozmiar(result.getString("charakter"));
           gracz.setRozmiar(result.getString("rozmiar"));
           gracz.setWiek(result.getInt("wiek"));
           gracz.setPlec(result.getString("plec"));
           gracz.setWzrost(result.getDouble("wzrost"));
           gracz.setWaga(result.getDouble("waga"));
           gracz.setBostwo(result.getString("bostwo"));
           gracz.setPoziom(result.getInt("poziom"));
           gracz.setEpickiePrzeznaczenie(result.getString("epickiePrzeznaczenie"));
           gracz.setDruzyna(result.getString("druzyna"));
           gracz.setPktAkcji(result.getDouble("pktAkcji"));
           gracz.setSila(result.getInt("sila"));
           gracz.setKondycja(result.getInt("kondycja"));
           gracz.setZrecznosc(result.getInt("zrecznosc"));
           gracz.setInteligencja(result.getInt("inteligencja"));
           gracz.setRozsadek(result.getInt("rozsadek"));
           gracz.setCharyzma(result.getInt("charyzma"));
           return gracz;
       }catch(Exception e){
           e.getMessage();
           return null;
       }
   }
   
   /**
    * Funkcja zwracająca liste wszystkich graczy w bazie
    * @return 
    * Obiekt klasy List, zawierający listę wszystkich graczy (id,imie,klasa,rasa) w bazie
    */
    public List<Gracz> selectGracze() {
        List<Gracz> gracze = new LinkedList<Gracz>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM gracze");
            int id;
            String imie, rasa, klasa;
            
            while(result.next()) {
                id = result.getInt("id_gracza");
                imie = result.getString("imie");
                klasa = result.getString("klasa");
                rasa = result.getString("rasa");
                gracze.add(new Gracz(id,imie,rasa,klasa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return gracze;
    }
    /**
    * Funkcja zwracająca liste wszystkich atutów w bazie
    * @return 
    * Obiekt klasy List, zawierający listę wszystkich atutów w bazie
    */
    public List<Atut> selectAtuty(){
        List<Atut> atuty = new LinkedList<Atut>();
        try {
            ResultSet result = stat.executeQuery("SELECT * FROM atuty");
            int id;
            String imie, rasa, klasa;
            
            while(result.next()) {
                id = result.getInt("id_atutu");
                imie = result.getString("nazwa");
                klasa = result.getString("opis");
                atuty.add(new Atut(id, imie, klasa));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return atuty;
    }
    
    /**
     * Funkcja kasująca zawartość tabeli
     * @param nazwa
     * Nazwa tabeli w bazie
     * @return 
     * -True jeśli wszystko ok
     */
    public boolean truncate(String nazwa){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "delete from "+nazwa);
            prepStmt.execute();
            prepStmt = conn.prepareStatement("vacuum");
            prepStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Blad przy czyszczeniu tabeli "+nazwa);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    /**
     * 
     * Funkcja czyszcząca tabele gracze
     * @return 
     */
    @Deprecated
    public boolean truncateGracze(){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "delete from gracze");
            prepStmt.execute();
            prepStmt = conn.prepareStatement("vacuum");
            prepStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Blad przy czyszczeniu tabeli gracze");
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public boolean deleteDb(String nazwa){
        try {
            PreparedStatement prepStmt = conn.prepareStatement(
                    "drop table "+nazwa);
            prepStmt.execute();
            
        } catch (SQLException e) {
            System.err.println("Blad przy kasowaniu tabeli "+nazwa);
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.err.println("Problem z zamknieciem polaczenia");
            e.printStackTrace();
        }
    }
    
}
