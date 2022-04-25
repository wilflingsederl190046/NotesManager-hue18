package htlgkr.wilflingsederl190046.notesmanager;

import android.annotation.SuppressLint;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Note {
    @SuppressLint("SimpleDateFormat")
    private final DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm" , Locale.getDefault());

    private Date date;
    private String text;

    public Note(Date date, String text) {
        formatter.setTimeZone(TimeZone.getTimeZone("Europe/Vienna"));
        this.date = date;
        this.text = text;
    }

    public Date getDateTime() {
        return date;
    }

    public void setDateTime(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDateTimeAsFormattedString() {
        return formatter.format(date);
    }

    @Override
    public String toString() {
        return formatter.format(date) + ";" + text;
    }
}
