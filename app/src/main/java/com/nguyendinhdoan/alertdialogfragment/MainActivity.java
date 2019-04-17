package com.nguyendinhdoan.alertdialogfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String DIALOG_TAG = "DIALOG_TAG";
    private Button showDialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDialogButton = findViewById(R.id.show_dialog_button_text);
        showDialogButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.show_dialog_button_text) {
            showAlertDialog();
        }
    }

    private void showAlertDialog() {
        String dialogTitle = getString(R.string.dialog_title);
        AlertDialogFragment alertDialogFragment = AlertDialogFragment.newInstance(dialogTitle);
        alertDialogFragment.show(getSupportFragmentManager(), DIALOG_TAG);
    }
}
