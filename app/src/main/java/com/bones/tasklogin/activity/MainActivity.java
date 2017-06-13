package com.bones.tasklogin.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bones.tasklogin.R;
import com.bones.tasklogin.session.SessionManager;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    SessionManager session;
    Button logout;
    TextView welcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        session = new SessionManager(getApplicationContext());

        session.checkLogin();

        welcome = (TextView) findViewById(R.id.txtWelcome);

        HashMap<String,String> user = session.getUserDetails();

        String email = user.get(SessionManager.KEY_EMAIL);

        welcome.setText("Welcome\n"+email);

        logout = (Button) findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.logoutUser();
            }
        });
    }
}
