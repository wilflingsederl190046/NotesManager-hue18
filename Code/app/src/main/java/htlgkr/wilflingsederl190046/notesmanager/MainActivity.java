package htlgkr.wilflingsederl190046.notesmanager;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.getSimpleName();

    private List<Note> notes = new ArrayList<>();
    private ListView mListView;
    private NotesAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configActionBar();

        mListView = findViewById(R.id.mainList);
        notes.add(new Note(new Date(System.currentTimeMillis()), "Hello, this is an example text."));
        mAdapter = new NotesAdapter(this, R.layout.my_list_view_item_layout, notes);
        mListView.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId() ;
        Log.d(TAG, "onOptionsItemSelected: " + id );
        switch (id) {
            case R.id.menu_new:
                openNewNoteDialog();
                break;
            case R.id.menu_save:
                if(saveNotes()) {
                    Toast.makeText(this, "Notes successfully saved.", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(this, "ERROR: Couldn't save the notes", Toast.LENGTH_LONG).show();
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean loadNotes() {
        return false;
    }

    private boolean saveNotes() {
        String filename = "testfile.txt";
        String input = "test content";
        try {
            FileOutputStream fos = openFileOutput(filename, MODE_PRIVATE | MODE_APPEND);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(fos));
            out.println(input);
            out.flush();
            out.close();
        } catch (FileNotFoundException exp) {
            Log.d(TAG, Arrays.toString(exp.getStackTrace()));
        }

        return false;
    }

    private void openNewNoteDialog() {

    }

    private void configActionBar() {
        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setSubtitle ("Version 1.0");
        actionBar.setTitle ("NotesManager");
    }
}