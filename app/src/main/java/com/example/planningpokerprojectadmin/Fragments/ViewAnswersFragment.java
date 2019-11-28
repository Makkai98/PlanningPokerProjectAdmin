package com.example.planningpokerprojectadmin.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.planningpokerprojectadmin.Model.Group;
import com.example.planningpokerprojectadmin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ViewAnswersFragment extends Fragment {
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    public ViewAnswersFragment() {
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
                R.layout.fragment_viewanswers, container, false);

        Button checkanswers = view.findViewById(R.id.button_viewanswers1);
        checkanswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                EditText groupid = view.findViewById(R.id.et_groupid1);
                String groupId = groupid.getText().toString();


                Group g = dataSnapshot.child(groupId).getValue(Group.class);
                if (g==null)
                {
                    Toast.makeText(getContext(), "This Group doesn't exist!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    final Bundle bundle = new Bundle();

                    bundle.putString("groupid", groupId);

                    QuestionListFragment Qfragment = new QuestionListFragment();
                    Qfragment.setArguments(bundle);
                    Fragmentchange(Qfragment);
                }

            }
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
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

