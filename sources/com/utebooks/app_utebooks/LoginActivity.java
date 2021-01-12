package com.utebooks.app_utebooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class LoginActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private Button btnLogin;
    private Button btnReset;
    private Button btnSignup;
    /* access modifiers changed from: private */
    public EditText inputEmail;
    /* access modifiers changed from: private */
    public EditText inputPassword;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.auth = FirebaseAuth.getInstance();
        if (this.auth.getCurrentUser() != null) {
            startActivity(new Intent(this, Menu.class));
            finish();
        }
        setContentView((int) C0719R.layout.activity_login);
        setSupportActionBar((Toolbar) findViewById(C0719R.C0721id.toolbar));
        this.inputEmail = (EditText) findViewById(C0719R.C0721id.email);
        this.inputPassword = (EditText) findViewById(C0719R.C0721id.password);
        this.progressBar = (ProgressBar) findViewById(C0719R.C0721id.progressBar);
        this.btnSignup = (Button) findViewById(C0719R.C0721id.btn_signup);
        this.btnLogin = (Button) findViewById(C0719R.C0721id.btn_login);
        this.btnReset = (Button) findViewById(C0719R.C0721id.btn_reset_password);
        this.auth = FirebaseAuth.getInstance();
        this.btnSignup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, SignupActivity.class));
            }
        });
        this.btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                LoginActivity.this.startActivity(new Intent(LoginActivity.this, ResetPasswordActivity.class));
            }
        });
        this.btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = LoginActivity.this.inputEmail.getText().toString();
                final String password = LoginActivity.this.inputPassword.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(LoginActivity.this.getApplicationContext(), "أدخل عنوان البريد الالكتروني!", 0).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(LoginActivity.this.getApplicationContext(), "أدخل كلمة المرور!", 0).show();
                } else {
                    LoginActivity.this.progressBar.setVisibility(0);
                    LoginActivity.this.auth.signInWithEmailAndPassword(email, password).addOnCompleteListener((Activity) LoginActivity.this, new OnCompleteListener<AuthResult>() {
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            LoginActivity.this.progressBar.setVisibility(8);
                            if (task.isSuccessful()) {
                                LoginActivity.this.startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                LoginActivity.this.finish();
                            } else if (password.length() < 6) {
                                LoginActivity.this.inputPassword.setError(LoginActivity.this.getString(C0719R.string.minimum_password));
                            } else {
                                Toast.makeText(LoginActivity.this, LoginActivity.this.getString(C0719R.string.auth_failed), 1).show();
                            }
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
