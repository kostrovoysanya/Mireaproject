package ru.mirea.kudriashov.mireaproject.ui.calculator;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import ru.mirea.kudriashov.mireaproject.R;

public class CalculateFragment extends Fragment {
    private TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_calculator, container, false);
        textView = root.findViewById(R.id.text_numbers);

        CalculatorModel calculatorModel = new CalculatorModel();

        View.OnClickListener actionClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorModel.clickedAction(view.getId());
                textView.setText(calculatorModel.getIn());
            }
        };
        View.OnClickListener numberClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculatorModel.clickedNumber(view.getId());
                textView.setText(calculatorModel.getIn());
            }
        };

        root.findViewById(R.id.plus).setOnClickListener(actionClickListener);
        root.findViewById(R.id.minus).setOnClickListener(actionClickListener);
        root.findViewById(R.id.multiply).setOnClickListener(actionClickListener);
        root.findViewById(R.id.divide).setOnClickListener(actionClickListener);
        root.findViewById(R.id.C).setOnClickListener(actionClickListener);
        root.findViewById(R.id.equals).setOnClickListener(actionClickListener);

        root.findViewById(R.id.b0).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b1).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b2).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b3).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b4).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b5).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b6).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b7).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b8).setOnClickListener(numberClickListener);
        root.findViewById(R.id.b9).setOnClickListener(numberClickListener);

        return root;
    }
}