package htlgkr.wilflingsederl190046.notesmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends BaseAdapter {
    private List<Note> notes = new ArrayList<>();
    private int layoutId;
    private LayoutInflater inflater;

    public NotesAdapter(Context ctx, int layoutId, List<Note> notes) {
        this.notes = notes;
        this.layoutId = layoutId;
        this.inflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return notes.size();
    }

    @Override
    public Object getItem(int i) {
        return notes.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Note note = notes.get(i);
        View listItem = (view == null) ? inflater.inflate(this.layoutId, null) : view;
        ((TextView) listItem.findViewById(R.id.tvDateTime)).setText(note.getDateTimeAsFormattedString());
        ((TextView) listItem.findViewById(R.id.tvNote)).setText(note.getText());
        return listItem;
    }
}
