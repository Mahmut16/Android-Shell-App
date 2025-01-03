package com.example.androidshellapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button executeButton;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        executeButton = findViewById(R.id.executeButton);
        outputTextView = findViewById(R.id.outputTextView);

        executeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeShellScript();
            }
        });
    }

    private void executeShellScript() {
        try {
            ShellExecutor shellExecutor = new ShellExecutor();
            String output = shellExecutor.runShellCommand("/data/data/com.example.androidshellapp/files/script.sh");
            outputTextView.setText(output);
        } catch (IOException e) {
            outputTextView.setText("Error executing script: " + e.getMessage());
        }
    }
}
