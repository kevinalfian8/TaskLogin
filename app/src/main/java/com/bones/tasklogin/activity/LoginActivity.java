package com.bones.tasklogin.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bones.tasklogin.R;
import com.bones.tasklogin.model.User;
import com.bones.tasklogin.model.UserResponse;
import com.bones.tasklogin.rest.ApiClient;
import com.bones.tasklogin.rest.ApiInterface;
import com.bones.tasklogin.session.SessionManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText email,password;
    SessionManager session;
    Button login,create;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText) findViewById(R.id.txtemail);
        password = (EditText) findViewById(R.id.txtpassword);

        session = new SessionManager(getApplicationContext());


        login = (Button) findViewById(R.id.btnLogin);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check()){

                    ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                    final String txtemail = email.getText().toString();
                    final String txtpassword = password.getText().toString();
                    Call<UserResponse> call = apiService.login();
                    call.enqueue(new Callback<UserResponse>() {
                        @Override
                        public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                            int success = 0;

                            for (int i = 0; i < response.body().getUsers().size(); i++) {
                                String _email = response.body().getUsers().get(i).getEmail();
                                String _password = response.body().getUsers().get(i).getPassword();

                                if (_email.equals(txtemail) && _password.equals(txtpassword)) {
                                    success = 1;
                                }

                            }

                            if (success == 1) {
                                session.createLoginSession(txtemail);

                                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_SHORT).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<UserResponse> call, Throwable t) {
                            Log.d("error", t.toString());
                        }
                    });
                }
            }
        });


    }

    public boolean check(){
        boolean check;
        if(TextUtils.isEmpty(email.getText().toString())){
            Toast.makeText(this, "email is empty", Toast.LENGTH_SHORT).show();
            check = false;
        } else if (TextUtils.isEmpty(password.getText().toString())){
            Toast.makeText(this, "password is empty", Toast.LENGTH_SHORT).show();
            check = false;
        } else {
            check = true;
        }

        return check;

    }



}
