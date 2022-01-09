package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 *Die Klasse SongListGui visualisiert die Benutzeroberfläche (GUI)
 * und verwaltet den Array.
 */
public class SongListGui {
    private int nextSong = 0;

    public static void main(String[] args){
        new SongListGui().doGui();
    }
    
    final Song[] songs = new Song[100];

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    final JTextField txtTrackNo = new JTextField("");
    final JTextField txtSongTitle = new JTextField("");
    final JTextField txtReleaseDate = new JTextField("");

    /**
     * Erstellt das GUI mit den Knöpfen, Textfelder und Labels
     */
    private void doGui(){
        /*Erzeuge das JFrame frame*/
        JFrame frame = new JFrame();

        /*Erzeuge den JButton button*/
        JLabel lblTrackNo = new JLabel("Track Nummer");
        JLabel lblSongTitle = new JLabel("Song Titel");
        JLabel lblReleaseDate = new JLabel("Release Datum");

        JButton btnAddSong = new JButton("Song hinzufügen");
        btnAddSong.addActionListener(new btnAddSongReader());

        JButton btnRemoveSong = new JButton("Song entfernen");
        btnRemoveSong.addActionListener(new clearSong());

        JButton btnWriteToConsole = new JButton("Auf der Konsole ausgeben");
        btnWriteToConsole.addActionListener(new btnShowSongs());

        /*Erzeuge panelA und panelB*/
        JPanel panelA = new JPanel();
        JPanel panelB = new JPanel();

        /*Wird benötigt, ansonsten lässt sich das Fenster nie mehr schliessen!*/
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*Neues BoxLayout erzeugen (für panelB). Y-Axis ~ übereinander. Layout setzen für panelB.*/
        panelB.setLayout(new BoxLayout(panelB, BoxLayout.Y_AXIS));

        /*panelB enthält die buttons*/
        panelB.add(lblTrackNo);
        panelB.add(txtTrackNo);
        panelB.add(lblSongTitle);
        panelB.add(txtSongTitle);
        panelB.add(lblReleaseDate);
        panelB.add(txtReleaseDate);
        panelB.add(btnAddSong);
        panelB.add(btnRemoveSong);
        panelB.add(btnWriteToConsole);

        /*panelA enthält panelB*/
        panelA.add(panelB);

        /*panelA kommt in die Mitte des Frames mit BorderLayout*/
        frame.getContentPane().add(BorderLayout.CENTER, panelA);
        
        /*Grösse setzen*/
        frame.setSize(250, 260);


        /*Wird benötigt, ansonsten ist das Fenster nicht sichtbar!*/
        frame.setResizable(false);
        frame.setVisible(true);

        /*
        songs[0] = new Song(1, "Test Song 1", LocalDate.now());
        songs[1] = new Song(2, "Test Song 2", LocalDate.now());
        songs[2] = new Song(3, "Test Song 3", LocalDate.now());
        nextSong = 3;
        */
    }

    /**
     *Fügt einen Song auf Knopfdruck hinzu
     */
    class btnAddSongReader implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Song song = new Song(Integer.parseInt(txtTrackNo.getText()), txtSongTitle.getText(), LocalDate.parse(txtReleaseDate.getText(), DATE_TIME_FORMATTER));
                songs[nextSong] = song;
                nextSong++;
                System.out.println(" ");
                System.out.println("Der Song '" + song.getSongTitle() + "' wurde erfolgreich hinzugefügt.");
                txtTrackNo.setText("");
                txtSongTitle.setText("");
                txtReleaseDate.setText("");
            } catch (DateTimeParseException | NumberFormatException ex){
                System.out.println(" ");
                System.out.println("Geben Sie ein gültiges 'Datum' 'dd.MM.yyyy' und eine 'Track Nummer' von '1-100' ein!");
            }

        }
    }

    /**
     *Gibt auf Knopfdruck alle hinzugefügten Songs auf der Konsole aus
     */
    class btnShowSongs implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {

            for (int i = 0; i < nextSong; i++) {
                if (songs[i] !=null){
                    System.out.println(" ");
                    System.out.println("Index ist: " + i);
                    System.out.println("Track Nummer: " + songs[i].getTrackNO());
                    System.out.println("Song Titel: " + songs[i].getSongTitle());
                    System.out.println("Release Datum: " + songs[i].getReleaseDate());
                }
            }
        }
    }

    /**
     *Löscht auf Knopfdruck den gewünschten Song
     */
    class clearSong implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int deleteTrackIdx = -1;
            for(int i = 0; i < nextSong; i++){
                if(songs[i].getTrackNO() == Integer.parseInt(txtTrackNo.getText())){
                    deleteTrackIdx = i;
                    break;
                }
            }
            if(deleteTrackIdx == -1){
                System.out.println(" ");
                System.out.println("TrackNo. " + txtTrackNo.getText() + " existiert nicht!");
            }
            else{
                songs[deleteTrackIdx] = songs[nextSong - 1];
                songs[nextSong - 1] = null;
                nextSong--;
                System.out.println(" ");
                System.out.println("Der Song auf der Track Nummer '" + txtTrackNo.getText() + "' wurde erfolgreich entfernt!");
                txtTrackNo.setText("");
            }
        }
    }
}
