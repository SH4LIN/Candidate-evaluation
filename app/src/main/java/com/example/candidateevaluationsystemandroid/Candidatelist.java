package com.example.candidateevaluationsystemandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Candidatelist extends AppCompatActivity {

    RecyclerView recyclerView;
    recycleradapter myadapter;
    FirebaseFirestore db;
    DocumentReference docRef;
    public String Score,Name,Email,Contact,Address,doc;
    private List<DocumentSnapshot> list;
    TextView tname , temail, taddress, tcontact, tscore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidatelist);
        findViewsById();

        db.collection("Resumes").orderBy("Score",Query.Direction.DESCENDING).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                QuerySnapshot queryDocumentSnapshot = task.getResult();
                list = queryDocumentSnapshot.getDocuments();
                while(!list.isEmpty()){
                    doc = list.get(0).getId();
                    //Toast.makeText(Candidatelist.this, doc, Toast.LENGTH_SHORT).show();
                    //docRef = db.collection("Resumes").document(doc);
                    /*docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                            if(task.isSuccessful()){
                                DocumentSnapshot documentSnapshot = task.getResult();
                                Score = documentSnapshot.getString("Score");
                                Toast.makeText(Candidatelist.this, Score, Toast.LENGTH_SHORT).show();
                                docRef.collection("PersonalDetails").document("1").get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                    @Override
                                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                        if(task.isSuccessful()) {
                                            DocumentSnapshot documentSnapshot = task.getResult();
                                            Name = documentSnapshot.getString("Name");
                                            Email = documentSnapshot.getString("Email");
                                            Address = documentSnapshot.getString("Address");
                                            Contact = documentSnapshot.getString("Mobile");

                                            Toast.makeText(Candidatelist.this, ""+Score+" "+Name+" "+Email+" "+Address+" "+Contact, Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });
                            }
                        }
                    });*/tr add.\
                    list.remove(0);
                }
            }
        });
        recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myadapter = new recycleradapter(this,getMyList());
        recyclerView.setAdapter(myadapter);



    }

    private ArrayList<ModelData> getMyList(){
        ArrayList<ModelData> models = new ArrayList<>();
        //  int len = name.length;

        //for (int i=0;i<len;i++)
        //{
        ModelData m = new ModelData();
        m.setMname(Name);
        m.setMemail(Email);
        m.setMadderess(Address);
        m.setMcontact(Contact);
        m.setMscore(Score);
        models.add(m);
        //}
        return models;
    }
    public void findViewsById(){
        db = FirebaseFirestore.getInstance();

        tname = (TextView) findViewById(R.id.txtnameans);
        temail = (TextView) findViewById(R.id.txtemailans);
        taddress = (TextView) findViewById(R.id.txtaddressans);
        tcontact = (TextView) findViewById(R.id.txtcontactnoans);
        tscore = (TextView) findViewById(R.id.txtscoreans);


    }
}
