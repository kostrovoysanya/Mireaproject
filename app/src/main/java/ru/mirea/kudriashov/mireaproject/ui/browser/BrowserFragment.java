package ru.mirea.kudriashov.mireaproject.ui.browser;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.mirea.kudriashov.mireaproject.R;

public class BrowserFragment extends Fragment {
    WebView page;
    EditText edit;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_browser, container, false);
        page = root.findViewById(R.id.page);
        page.getSettings().setJavaScriptEnabled(true);
        page.loadUrl("https://www.mirea.ru/");
        edit = root.findViewById(R.id.edit);
        View.OnClickListener goClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page.loadUrl(edit.getText().toString());
            }
        };
        root.findViewById(R.id.srch).setOnClickListener(goClickListener);
        View.OnClickListener homeClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                page.loadUrl("https://www.mirea.ru/");
            }
        };
        root.findViewById(R.id.thome).setOnClickListener(homeClickListener);
        return root;
    }
}