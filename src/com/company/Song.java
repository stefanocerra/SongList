package com.company;

import java.time.LocalDate;

/**
 * Die Klasse Song repräsentiert einen Song mit trackNo,
 * songTitle und releaseDate.
 */
public class Song {

    private int trackNo;
    private String songTitle;
    private LocalDate releaseDate;

    /**
     * Konstruiert einen Song.
     * @param trackNo Nummerierung des Songs
     * @param songTitle Titel des Songs
     * @param releaseDate Erscheinungsdatum des Songs
     */
    public Song(int trackNo, String songTitle, LocalDate releaseDate) {
        this.trackNo = trackNo;
        this.songTitle = songTitle;
        this.releaseDate = releaseDate;
    }

    /**
     * Getter-Methode
     * @return gibt die Nummer des Songs zurück
     */
    public int getTrackNO() {
        return this.trackNo;
    }

    /**
     * Getter-Methode
     * @return gibt den Titel des Songs zurück
     */
    public String getSongTitle() {
        return this.songTitle;
    }

    /**
     * Getter-Methode
     * @return gibt das Erscheinungsdatum des Songs zurück
     */
    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    /**
     *Setter-Methode
     * @param trackNo Nummerierung des Songs
     */
    public void setTrackNo(int trackNo) {
        this.trackNo = trackNo;
    }

    /**
     *Setter-Methode
     * @param songTitle Titel des Songs
     */
    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    /**
     *Setter-Methode
     * @param releaseDate Erscheinungsdatum des Songs
     */
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }
}