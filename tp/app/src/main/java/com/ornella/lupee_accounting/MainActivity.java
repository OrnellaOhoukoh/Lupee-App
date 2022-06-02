package com.ornella.lupee_accounting;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ornella.lupee_accounting.entities.User;
import com.ornella.lupee_accounting.manager.UserManager;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private LinearLayout llMain;
    private EditText connectLogin, connectPwd;
    private Button demarrer;
    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ctx = this;
        setContentView(R.layout.activity_main);

        demarrer = findViewById(R.id.btnStart);
        llMain = findViewById(R.id.llmain);

        demarrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LinearLayout llEntry = new LinearLayout(ctx);
                llEntry.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                llEntry.setOrientation(LinearLayout.VERTICAL);

                Button singUp = new Button(ctx);
                Button login = new Button(ctx);
                singUp.setText("Creer un Compte");
                login.setText("Se Connecter");
                llEntry.addView(singUp);
                llEntry.addView(login);
                llMain.addView(llEntry);

                singUp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                    }
                });

                login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
                        builder.setTitle("Saisir vos données de connexion");
                        builder.setView(R.layout.connexion_dialog_layout);
                        builder.setPositiveButton("Soumettre", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //If LOGIN IN DATABASE OPEN HOME PAGE
                                //AlertDialog dialog = (AlertDialog) dialogInterface;
                                //connectLogin = dialog.findViewById(R.id.edt1);
                                //connectPwd = dialog.findViewById(R.id.pwd);
                               // ArrayList<User>users = UserManager.getAll(ctx);
                                //for (User u : users){

                                   // if(connectLogin.getText().toString().equals(u.getLogin()) && connectPwd.getText().toString().equals(u.getPassword())){
                                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                        startActivity(intent);
                                    //}else{
                                    //    finish();
                                    //}
                                //}


                                //IF NOT TOAST MAUVAIS LOGIN SET ALERT DIALOGUE LAST TEXTVIEW VISIBLE AND ASK IF USER WANT TO SIGNUP
                                //IF USER WANT TO SIGN UP START LOGIN ACTIVITY
                            }
                        });

                        builder.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        });
                        builder.show();




                    }
                });

            }
        });


    }
}