package com.softexpert.ujs.davidhood;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.softexpert.ujs.davidhood.models.AdvertiseModel;

public class TermsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);
        String title = (String) getIntent().getSerializableExtra("SEL_TITLE");
        String terms = (String) getIntent().getSerializableExtra("SEL_TERMS");

        TextView txt_title = (TextView)findViewById(R.id.txt_title);
        TextView txt_terms = (TextView)findViewById(R.id.txt_terms);
        txt_title.setText(title);
        txt_terms.setText(terms);
        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
