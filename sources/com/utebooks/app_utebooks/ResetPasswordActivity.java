package com.utebooks.app_utebooks;

import android.content.Context;
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
import com.google.firebase.auth.FirebaseAuth;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class ResetPasswordActivity extends AppCompatActivity {
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private Button btnBack;
    private Button btnReset;
    /* access modifiers changed from: private */
    public EditText inputEmail;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_reset_password);
        this.inputEmail = (EditText) findViewById(C0719R.C0721id.email);
        this.btnReset = (Button) findViewById(C0719R.C0721id.btn_reset_password);
        this.btnBack = (Button) findViewById(C0719R.C0721id.btn_back);
        this.progressBar = (ProgressBar) findViewById(C0719R.C0721id.progressBar);
        this.auth = FirebaseAuth.getInstance();
        this.btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ResetPasswordActivity.this.finish();
            }
        });
        this.btnReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String email = ResetPasswordActivity.this.inputEmail.getText().toString().trim();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(ResetPasswordActivity.this.getApplication(), "أدخل بريدك الإلكتروني المسجل", 0).show();
                    return;
                }
                ResetPasswordActivity.this.progressBar.setVisibility(0);
                ResetPasswordActivity.this.auth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPasswordActivity.this, "لقد أرسلنا إليك تعليمات لإعادة تعيين كلمة المرور!", 0).show();
                        } else {
                            Toast.makeText(ResetPasswordActivity.this, "فشل إرسال رسالة إعادة تعيين البريد الإلكتروني!", 0).show();
                        }
                        ResetPasswordActivity.this.progressBar.setVisibility(8);
                    }
                });
            }
        });
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
