package ru.mirea.kudriashov.mireaproject.ui.audioplayer;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ru.mirea.kudriashov.mireaproject.R;

public class AudioPlayerFragment extends Fragment {
    Button buttonPlay;
    Button buttonStop;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_audio_player, container, false);

        buttonPlay = root.findViewById(R.id.button_play);
        buttonStop = root.findViewById(R.id.button_stop);
        View.OnClickListener playClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().startService(new Intent(getContext(), AudioPlayerService.class));
            }
        };
        buttonPlay.setOnClickListener(playClickListener);


        View.OnClickListener stopClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().stopService(new Intent(getContext(), AudioPlayerService.class));
            }
        };

        buttonStop.setOnClickListener(stopClickListener);
        return  root;
    }
}