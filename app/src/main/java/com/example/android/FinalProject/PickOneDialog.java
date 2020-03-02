package com.example.android.FinalProject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class PickOneDialog extends AppCompatDialogFragment {
    private EditText amountPeople;
    private PickOneDialogListener listener;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View view = inflater.inflate(R.layout.dialog_num, null);
        builder.setView(view).setTitle("How many people do you want to pick from?").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int peopleAmount = Integer.parseInt(amountPeople.getText().toString());
                listener.applyTexts(peopleAmount);

                Intent intent = new Intent(getContext(), PickOne.class);
                startActivity(intent);


            }
        });
        amountPeople = view.findViewById(R.id.PeopleAmount);
        return  builder.create();
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            listener = (PickOneDialogListener) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement PickOneDialogListener");
        }

    }

    public interface PickOneDialogListener{
        void applyTexts(int peopleAmount);
    }
}
