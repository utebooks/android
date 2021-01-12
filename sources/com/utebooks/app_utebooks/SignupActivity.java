package com.utebooks.app_utebooks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
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

public class SignupActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private Button btnResetPassword;
    private Button btnSignIn;
    private Button btnSignUp;
    /* access modifiers changed from: private */
    public EditText inputEmail;
    /* access modifiers changed from: private */
    public EditText inputPassword;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_signup);
        this.auth = FirebaseAuth.getInstance();
        this.btnSignIn = (Button) findViewById(C0719R.C0721id.sign_in_button);
        this.btnSignUp = (Button) findViewById(C0719R.C0721id.sign_up_button);
        this.inputEmail = (EditText) findViewById(C0719R.C0721id.email);
        this.inputPassword = (EditText) findViewById(C0719R.C0721id.password);
        this.progressBar = (ProgressBar) findViewById(C0719R.C0721id.progressBar);
        this.btnResetPassword = (Button) findViewById(C0719R.C0721id.btn_reset_password);
        this.btnResetPassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SignupActivity.this.startActivity(new Intent(SignupActivity.this, ResetPasswordActivity.class));
            }
        });
        this.btnSignIn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SignupActivity.this.finish();
            }
        });
        this.btnSignUp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = SignupActivity.this.inputEmail.getText().toString().trim();
                String password = SignupActivity.this.inputPassword.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(SignupActivity.this.getApplicationContext(), "أدخل عنوان البريد الالكتروني!", 0).show();
                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(SignupActivity.this.getApplicationContext(), "أدخل كلمة المرور!", 0).show();
                } else if (password.length() < 6) {
                    Toast.makeText(SignupActivity.this.getApplicationContext(), "كلمة المرور قصيرة جدا، أدخل 6 أحرف على الأقل!", 0).show();
                } else {
                    SignupActivity.this.progressBar.setVisibility(0);
                    SignupActivity.this.auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener((Activity) SignupActivity.this, new OnCompleteListener<AuthResult>() {
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(SignupActivity.this, "تم التسجيل بنجاح" + task.isSuccessful(), 0).show();
                            SignupActivity.this.progressBar.setVisibility(8);
                            if (!task.isSuccessful()) {
                                Toast.makeText(SignupActivity.this, "فشل عملية التسجيل، يرجى المحاولة مرة أخرى" + task.getException(), 0).show();
                                return;
                            }
                            SignupActivity.this.startActivity(new Intent(SignupActivity.this, Menu.class));
                            SignupActivity.this.finish();
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.progressBar.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
