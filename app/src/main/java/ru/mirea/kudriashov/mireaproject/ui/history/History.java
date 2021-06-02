package ru.mirea.kudriashov.mireaproject.ui.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import ru.mirea.kudriashov.mireaproject.R;

public class History extends Fragment {
    private RecyclerView stories;
    private ru.mirea.kudriashov.mireaproject.ui.history.AdapterCell adapterCell;
    List<ru.mirea.kudriashov.mireaproject.ui.history.Cell> listStories;

    public History() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);
        ru.mirea.kudriashov.mireaproject.ui.history.AppDatabase db = ru.mirea.kudriashov.mireaproject.ui.history.App.getInstance().getDatabase();
        HistoryDao historyDao = db.storyDao();
        stories = view.findViewById(R.id.recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        stories.setLayoutManager(layoutManager);
        stories.setHasFixedSize(true);
        listStories = historyDao.getAll();
        adapterCell = new ru.mirea.kudriashov.mireaproject.ui.history.AdapterCell(listStories);
        stories.setAdapter(adapterCell);
        return view;
    }
}