package com.example.planningpokerprojectadmin.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.planningpokerprojectadmin.Model.Group;
import com.example.planningpokerprojectadmin.Model.Question;
import com.example.planningpokerprojectadmin.Model.User;
import com.example.planningpokerprojectadmin.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddGroupFragment extends Fragment {

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    static String status1 ;
    static String status2 ;
    static String status3 ;
    static String status4 ;
    static String status5 ;
    static boolean groupStatus;

    public AddGroupFragment() {
    }


    public void Oncreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        final View view = inflater.inflate(
                R.layout.fragment_addgroup, container, false);

        Button addgroup = view.findViewById(R.id.button_creategroup);

        addgroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        EditText groupId = view.findViewById(R.id.et_groupid);
        String groupid = groupId.getText().toString();
        EditText question1 = view.findViewById(R.id.question1);
        EditText question2 = view.findViewById(R.id.question2);
        EditText question3 = view.findViewById(R.id.question3);
        EditText question4 = view.findViewById(R.id.question4);
        EditText question5 = view.findViewById(R.id.question5);

        String q1 = question1.getText().toString();
        String q2 = question2.getText().toString();
        String q3 = question3.getText().toString();
        String q4 = question4.getText().toString();
        String q5 = question5.getText().toString();



        Switch s1 = (Switch) view.findViewById(R.id.switch1);
                if (s1.isChecked())
                {
                    status1 = "active";

                }
                else
                {
                    status1 = "inactive";
                }

        Switch s2 = (Switch) view.findViewById(R.id.switch2);
                if (s2.isChecked())
                {
                    status2 = "active";

                }
                else
                {
                    status2 = "inactive";
                }

        Switch s3 = (Switch) view.findViewById(R.id.switch3);
                if (s3.isChecked())
                {
                    status3 = "active";

                }
                else
                {
                    status3 = "inactive";
                }

        Switch s4 = (Switch) view.findViewById(R.id.switch4);
                if (s4.isChecked())
                {
                    status4 = "active";

                }
                else
                {
                    status4 = "inactive";
                }

        Switch s5 = (Switch) view.findViewById(R.id.switch5);
        if (s5.isChecked())
        {
            status5 = "active";

        }
        else
        {
            status5 = "inactive";
        }

        Switch gr = (Switch) view.findViewById(R.id.switchgroup);
                if (gr.isChecked())
                {
                    groupStatus = true;

                }
                else
                {
                    groupStatus = false;
                }


        ArrayList <User> users = new ArrayList<>();

        Question Question1 = new Question(0,q1, status1, users );
        Question Question2 = new Question(1,q2, status2, users );
        Question Question3 = new Question(2,q3, status3, users );
        Question Question4 = new Question(3,q4, status4, users );
        Question Question5 = new Question(4,q5, status5, users );



        ArrayList <Question> questions = new ArrayList<>();
        questions.add(Question1);
        questions.add(Question2);
        questions.add(Question3);
        questions.add(Question4);
        questions.add(Question5);

        Group g = new Group(groupid,groupStatus, questions);
        databaseReference.child(g.getId()).setValue(g);

                Toast.makeText(getContext(), "Group added successfully!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;



    }

    public void Fragmentchange (Fragment fragment)
    {

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container, fragment);
        fr.addToBackStack(null);
        fr.commit();
    }
}

