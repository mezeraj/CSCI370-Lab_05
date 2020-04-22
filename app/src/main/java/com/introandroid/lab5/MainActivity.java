package com.introandroid.lab5;

import androidx.appcompat.app.AppCompatActivity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView valueTxt;
    private EditText editName;
    private Button saveBtn;

    private SharedPreferences myPreference;
    private SharedPreferences.Editor myEditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valueTxt = findViewById(R.id.valueTxt);
        editName = findViewById(R.id.editName);
        saveBtn = findViewById(R.id.changeButton);

        myPreference = PreferenceManager.getDefaultSharedPreferences(this);
        myEditor = myPreference.edit();

        myEditor.putString("key", editName.getText().toString());
        myEditor.commit();
        myPreference.getString("key", "");
        checkSharedPreferences();
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueTxt.setText(editName.getText());
                myEditor.putString(getString(R.string.nameLabel), valueTxt.getText().toString());
                myEditor.commit();
            }
        });
    }

    private void checkSharedPreferences(){
        String savedName = myPreference.getString(getString(R.string.defaultName), "");
        valueTxt.setText(savedName);
    }

}