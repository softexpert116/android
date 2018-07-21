package com.softexpert.ujs.davidhood;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.softexpert.ujs.davidhood.widget.AlertUtil;

import org.json.JSONObject;

public class Signup2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        final EditText edit_address = findViewById(R.id.edit_address);
        final EditText edit_postal_code = findViewById(R.id.edit_postal_code);
        final EditText edit_iban = findViewById(R.id.edit_iban);

        ImageButton btn_back = (ImageButton)findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ImageButton btn_next = (ImageButton)findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = edit_address.getText().toString().trim();
                String postal_code = edit_postal_code.getText().toString().trim();
                String iban = edit_iban.getText().toString().trim();

                if (address.length()*postal_code.length()*iban.length() == 0) {
                    AlertUtil.showAlert(Signup2Activity.this, getString(R.string.fill_message));
                    return;
                }
                JSONObject jsonObject = App.readPreference_JsonObject(App.SIGNUP_INFO);
                try {
                    jsonObject.put("address", address);
                    jsonObject.put("postal_code", postal_code);
                    jsonObject.put("iban", "CH"+iban);
                }catch (Exception e) {
                    e.printStackTrace();
                }
                App.setPreference_JsonObject(App.SIGNUP_INFO, jsonObject);
                Intent intent = new Intent(getBaseContext(), Signup3Activity.class);
                startActivity(intent);
            }
        });

    }
}
