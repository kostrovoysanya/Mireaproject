package ru.mirea.kudriashov.mireaproject.ui.settings;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import androidx.fragment.app.Fragment;


import ru.mirea.kudriashov.mireaproject.R;

import static android.content.Context.MODE_PRIVATE;

public class Settings extends Fragment {
    private RadioButton radioButtonDark;
    private RadioButton radioButtonLight;
    private RadioButton radioButtonNight;
    private SharedPreferences preferences;
    private final String SAVED_COLOR = "saved_color";
    private String color;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_settings, container, false);

        radioButtonDark = root.findViewById(R.id.button_dark_theme);
        radioButtonLight = root.findViewById(R.id.button_light_theme);
        radioButtonNight = root.findViewById(R.id.button_gray_theme);
        preferences = getActivity().getPreferences(MODE_PRIVATE);

        radioButtonDark.setOnClickListener(radioButtonListener);
        radioButtonLight.setOnClickListener(radioButtonListener);
        radioButtonNight.setOnClickListener(radioButtonListener);

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        color = preferences.getString(SAVED_COLOR, "Empty");
        if (color != null) {

            switch (color) {
                case "dark":
                    getView().setBackgroundColor(getResources().getColor(R.color.dark));
                    break;
                case "light":
                    getView().setBackgroundColor(getResources().getColor(R.color.design_default_color_background));
                    break;
                case "gray":
                    getView().setBackgroundColor(getResources().getColor(R.color.light_gray));
                    break;
            }
        }
    }

    View.OnClickListener radioButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton clickedButton = (RadioButton) v;
            switch (clickedButton.getId()) {
                case R.id.button_dark_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.dark));
                    color = "dark";
                    break;
                case R.id.button_light_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.design_default_color_background));
                    color = "light";
                    break;
                case R.id.button_gray_theme:
                    getView().setBackgroundColor(getResources().getColor(R.color.light_gray));
                    color = "gray";
                    break;
            }
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(SAVED_COLOR, color);
            editor.apply();
        }
    };

}