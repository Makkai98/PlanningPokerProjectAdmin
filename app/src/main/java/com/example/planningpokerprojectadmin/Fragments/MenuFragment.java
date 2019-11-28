package com.example.planningpokerprojectadmin.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.planningpokerprojectadmin.R;

public class MenuFragment extends Fragment {

    public MenuFragment() {
    }


    public void Oncreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        final View view = inflater.inflate(
                R.layout.fragment_menu, container, false);


        Button button_addGroup = view.findViewById(R.id.button_addgroup);
        Button button_viewAnswers = view.findViewById(R.id.button_viewanswers);

        button_addGroup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddGroupFragment AFragment = new AddGroupFragment ();
                Fragmentchange(AFragment);
            }
        });


        button_viewAnswers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAnswersFragment VFragment = new ViewAnswersFragment ();
                Fragmentchange(VFragment);
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

