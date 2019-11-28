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
import com.example.planningpokerprojectadmin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginFragment extends Fragment {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    String adminName = "Admin";
    String adminPassword = "12345";

    public LoginFragment(){};

    public void Oncreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(
                R.layout.fragment_login, container, false);

        firebaseDatabase = firebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();


        final EditText et_password = view.findViewById(R.id.Login_password);
        final EditText et_name = view.findViewById(R.id.Login_name);

        Button login_button = view.findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if (et_name.getText().toString().isEmpty() || (et_password.toString().isEmpty())) {

                    Toast.makeText(getContext(), "Fields cannot be empty!", Toast.LENGTH_SHORT).show();
                } else {

                    final String name = et_name.getText().toString();
                    final String password = et_password.getText().toString();

                    if ((name.equals(adminName))&&(password.equals(adminPassword)))
                    {
                        MenuFragment mFragment = new MenuFragment();
                        Fragmentchange(mFragment);
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Incorrect Login credentials!", Toast.LENGTH_SHORT).show();
                    }


                }
            }
        });

        return  view;
    }



    public void Fragmentchange (Fragment fragment)
    {

        FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.fragment_container, fragment);
        fr.addToBackStack(null);
        fr.commit();
    }
}