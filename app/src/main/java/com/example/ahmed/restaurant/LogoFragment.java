package com.example.ahmed.restaurant;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class LogoFragment extends Fragment implements View.OnClickListener {

    private Button login;
    private Button signUp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_logo, container, false);
        login = (Button) view.findViewById(R.id.logo_login);
        signUp = (Button) view.findViewById(R.id.logo_sign_up);
        login.setOnClickListener(this);
        signUp.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        Intent intent=null;
        switch (v.getId()) {
            case R.id.logo_login:

                intent = new Intent(getActivity(),LoginActivity.class);
                break;
            case R.id.logo_sign_up:
                intent=new Intent(getActivity(),SignUpActivity.class);
                break;
        }
        startActivity(intent);
    }
}
