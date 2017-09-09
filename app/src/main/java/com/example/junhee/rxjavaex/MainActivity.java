package com.example.junhee.rxjavaex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText input;
    private EditText output;
    private Button button;
    private Integer data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    public void startObservable(int dan) {
        input.setText(dan + "");
        Observable.range(1, 9)
                .map(row -> dan + "*" + row + " = " + (row * dan))
                .map(row -> row + "\n")
                .subscribe(output::append);
    }

    private void initView() {
        output = (EditText) findViewById(R.id.output);
        input = (EditText) findViewById(R.id.input);
        button = (Button) findViewById(R.id.button);

        input.setHint("숫자를 입력해주시오.");
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                output.setText("");
                startObservable(Integer.parseInt(input.getText().toString()));
                break;
        }
    }
}
