package com.nguyendinhdoan.alertdialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.Objects;

public class AlertDialogFragment extends DialogFragment {

    public static final String TITLE_KEY = "TITLE_KEY";

    public static AlertDialogFragment newInstance(String dialogTitle) {
        AlertDialogFragment alertDialogFragment = new AlertDialogFragment();
        Bundle args = new Bundle();
        args.putString(TITLE_KEY, dialogTitle);
        alertDialogFragment.setArguments(args);
        return alertDialogFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Context context = getActivity();
        AlertDialog.Builder dialog = new AlertDialog.Builder(Objects.requireNonNull(context));

        if (getArguments() != null) {
            // get dialog title form arguments
            String dialogTitle = getArguments().getString(TITLE_KEY);
            dialog.setTitle(dialogTitle);
        } else {
            dialog.setTitle(context.getString(R.string.dialog_title));
        }

        // set the information display on dialog
        dialog.setMessage(context.getString(R.string.dialog_message));
        dialog.setCancelable(false);

        // set the event when user click button on dialog
        dialog.setPositiveButton(context.getString(R.string.dialog_button_ok),
                new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // if success ...
                Toast.makeText(context, "ok button clicked", Toast.LENGTH_SHORT).show();
            }
        });

        dialog.setNegativeButton(context.getString(R.string.dialog_button_cancel),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // close the dialog and back to the parent activity
                        dialog.dismiss();
                    }
                });

        return dialog.create();
    }
}
