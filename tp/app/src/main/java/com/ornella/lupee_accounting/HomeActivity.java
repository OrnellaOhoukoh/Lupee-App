package com.ornella.lupee_accounting;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.ornella.lupee_accounting.adapter.ItemsAdapter;
import com.ornella.lupee_accounting.entities.Item;
import com.ornella.lupee_accounting.manager.ItemManager;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Button addTransaction, removeTransaction;
    private TextView balance;
    private LinearLayout llTransaction;
    private Context ctx;
    private Spinner mySpinner;
    private ItemsAdapter itemAdapter;
    Boolean colorSet = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_home);
        addTransaction = findViewById(R.id.newTran);
        removeTransaction = findViewById(R.id.rmvTran);
        llTransaction = findViewById(R.id.llTran);
        addTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder transaction = new AlertDialog.Builder(ctx);
                transaction.setView(R.layout.transaction_layout);
                //mySpinner = view.findViewById(R.id.itemSpinner);
               // ArrayList<Item>items = ItemManager.getAll(ctx);
                //itemAdapter = new ItemsAdapter(ctx, R.layout.item_layout, items);
                //mySpinner.setAdapter(itemAdapter);
                transaction.setPositiveButton("Enregistrer", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        AlertDialog dialog = (AlertDialog) dialogInterface;
                        LinearLayout llView = new LinearLayout(ctx);
                        llView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        llView.setOrientation(LinearLayout.HORIZONTAL);
                        TextView detailsTransaction = new TextView(ctx);
                        TextView montantTransaction = new TextView(ctx);
                        EditText mtt = dialog.findViewById(R.id.montant);
                        String value = mtt.getText().toString();
                        detailsTransaction.setText("From Spinner" + "  ");
                        montantTransaction.setText("         " + value);
                        llView.addView(detailsTransaction);
                        llView.addView(montantTransaction);
                        llTransaction.addView(llView);
                        if(colorSet){
                            llView.setBackgroundColor(Color.CYAN);
                            colorSet = false;
                        }else{
                            llView.setBackgroundColor(Color.WHITE);
                            colorSet = true;
                        }

                        balance = findViewById(R.id.amtBalance);
                        Float balanceValue = Float.parseFloat(value);
                        balance.setText(balanceValue + "$");

                    }
                });
                transaction.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                transaction.show();

            }
        });

        removeTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index =llTransaction.getChildCount() - 1;
                llTransaction.removeViewAt(index);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
            String text = "";
            switch(item.getItemId()){
                case R.id.facture:
                    text = "Allons créer votre facture!";
                    break;
                case R.id.logout:
                    text="Retour";
                    startActivity(new Intent(this, MainActivity.class));
                    break;
            }
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        return true;
    }
}