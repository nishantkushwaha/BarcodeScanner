package com.wockito.codescanner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        mTextView = (TextView) findViewById(R.id.result_tv);

        Intent intent = getIntent();
        String resString = intent.getStringExtra(getResources().getString(R.string.qr_result));
        mTextView.setText(resString);
    }
}
