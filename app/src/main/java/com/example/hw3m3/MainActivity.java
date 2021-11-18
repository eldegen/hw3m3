package com.example.hw3m3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edEmail, edHeading, edMessage;
    private Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edEmail = findViewById(R.id.ed_email);
        edHeading = findViewById(R.id.ed_heading);
        edMessage = findViewById(R.id.ed_message);

        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_EMAIL, new String[] {edEmail.getText().toString()});
                intent.putExtra(Intent.EXTRA_SUBJECT, edHeading.getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, edMessage.getText().toString());

                startActivity(intent);
            }
        });
    }

    public void onNextClick(View view) {
        Toast.makeText(this, "pizza", Toast.LENGTH_SHORT).show();
    }
}