package com.example.candidateevaluationsystemandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Home extends AppCompatActivity {
   // private static final String PHONE_NUMBER = "^(?:(?:\\+|0{0,2})91(\\s*[\\ -]\\s*)?|[0]?)?[789]\\d{9}|(\\d[ -]?){10}\\d$";
   private static final String PHONE_NUMBER = "^[6-9][0-9]{9}";
    private Pattern pattern;
    private Matcher matcher;
    Button login,apply;
    private FirebaseUser user;
    EditText phoneno;
    BottomSheetDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        login = (Button) findViewById(R.id.login);
        apply = (Button) findViewById(R.id.apply);
        apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user = FirebaseAuth.getInstance().getCurrentUser();
                if(user != null){
                    Intent intent = new Intent(Home.this,Details.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                }
                else {
                    dialog = new BottomSheetDialog(Home.this, R.style.BottomSheetDialogTheme);
                    dialog.setContentView(R.layout.bottomsheet);
                    dialog.setCanceledOnTouchOutside(false);
                    phoneno = (EditText) dialog.findViewById(R.id.phoneno);
                    dialog.show();
                    Button next = dialog.findViewById(R.id.submit);
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            pattern = Pattern.compile(PHONE_NUMBER);
                            matcher = pattern.matcher(phoneno.getText().toString());
                            String phonenumber = "+91" + phoneno.getText().toString().trim();
                            if (matcher.find()) {
                                Intent intent = new Intent(getApplicationContext(), Verification.class);
                                intent.putExtra("Number", phonenumber);
                                startActivity(intent);
                            } else {
                                Toast.makeText(getApplicationContext(), "Enter Valid Phone Number", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });

    }
}
