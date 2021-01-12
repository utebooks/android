package com.utebooks.app_utebooks;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.p003v7.app.AppCompatActivity;
import android.support.p003v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import p004uk.p005co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class UserProfile extends AppCompatActivity {
    /* access modifiers changed from: private */
    public FirebaseAuth auth;
    private FirebaseAuth.AuthStateListener authListener;
    private Button btnChangeEmail;
    private Button btnChangePassword;
    private Button btnRemoveUser;
    private Button btnSendResetEmail;
    /* access modifiers changed from: private */
    public Button changeEmail;
    /* access modifiers changed from: private */
    public Button changePassword;
    /* access modifiers changed from: private */
    public EditText newEmail;
    /* access modifiers changed from: private */
    public EditText newPassword;
    /* access modifiers changed from: private */
    public EditText oldEmail;
    /* access modifiers changed from: private */
    public EditText password;
    /* access modifiers changed from: private */
    public ProgressBar progressBar;
    /* access modifiers changed from: private */
    public Button remove;
    /* access modifiers changed from: private */
    public Button sendEmail;
    private Button signOut;
    Toolbar toolbar0;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int) C0719R.layout.activity_user_profile);
        if (getWindow().getDecorView().getLayoutDirection() == 0) {
            getWindow().getDecorView().setLayoutDirection(1);
        }
        Toolbar toolbar = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        toolbar.setTitle((CharSequence) getString(C0719R.string.app_name));
        setSupportActionBar(toolbar);
        this.toolbar0 = (Toolbar) findViewById(C0719R.C0721id.toolbar);
        this.toolbar0.setTitle((CharSequence) "خصائص الحساب الشخصي");
        setSupportActionBar(this.toolbar0);
        this.auth = FirebaseAuth.getInstance();
        final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        this.authListener = new FirebaseAuth.AuthStateListener() {
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null) {
                    UserProfile.this.startActivity(new Intent(UserProfile.this, LoginActivity.class));
                    UserProfile.this.finish();
                }
            }
        };
        this.btnChangeEmail = (Button) findViewById(C0719R.C0721id.change_email_button);
        this.btnChangePassword = (Button) findViewById(C0719R.C0721id.change_password_button);
        this.btnSendResetEmail = (Button) findViewById(C0719R.C0721id.sending_pass_reset_button);
        this.btnRemoveUser = (Button) findViewById(C0719R.C0721id.remove_user_button);
        this.changeEmail = (Button) findViewById(C0719R.C0721id.changeEmail);
        this.changePassword = (Button) findViewById(C0719R.C0721id.changePass);
        this.sendEmail = (Button) findViewById(C0719R.C0721id.send);
        this.remove = (Button) findViewById(C0719R.C0721id.remove);
        this.signOut = (Button) findViewById(C0719R.C0721id.sign_out);
        this.oldEmail = (EditText) findViewById(C0719R.C0721id.old_email);
        this.newEmail = (EditText) findViewById(C0719R.C0721id.new_email);
        this.password = (EditText) findViewById(C0719R.C0721id.password);
        this.newPassword = (EditText) findViewById(C0719R.C0721id.newPassword);
        this.oldEmail.setVisibility(8);
        this.newEmail.setVisibility(8);
        this.password.setVisibility(8);
        this.newPassword.setVisibility(8);
        this.changeEmail.setVisibility(8);
        this.changePassword.setVisibility(8);
        this.sendEmail.setVisibility(8);
        this.remove.setVisibility(8);
        this.progressBar = (ProgressBar) findViewById(C0719R.C0721id.progressBar);
        if (this.progressBar != null) {
            this.progressBar.setVisibility(8);
        }
        this.btnChangeEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.oldEmail.setVisibility(8);
                UserProfile.this.newEmail.setVisibility(0);
                UserProfile.this.password.setVisibility(8);
                UserProfile.this.newPassword.setVisibility(8);
                UserProfile.this.changeEmail.setVisibility(0);
                UserProfile.this.changePassword.setVisibility(8);
                UserProfile.this.sendEmail.setVisibility(8);
                UserProfile.this.remove.setVisibility(8);
            }
        });
        this.changeEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.progressBar.setVisibility(0);
                if (user != null && !UserProfile.this.newEmail.getText().toString().trim().equals("")) {
                    user.updateEmail(UserProfile.this.newEmail.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(UserProfile.this, "Email address is updated. Please sign in with new email id!", 1).show();
                                UserProfile.this.signOut();
                                UserProfile.this.progressBar.setVisibility(8);
                                return;
                            }
                            Toast.makeText(UserProfile.this, "Failed to update email!", 1).show();
                            UserProfile.this.progressBar.setVisibility(8);
                        }
                    });
                } else if (UserProfile.this.newEmail.getText().toString().trim().equals("")) {
                    UserProfile.this.newEmail.setError("أدخل البريد الإلكتروني");
                    UserProfile.this.progressBar.setVisibility(8);
                }
            }
        });
        this.btnChangePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.oldEmail.setVisibility(8);
                UserProfile.this.newEmail.setVisibility(8);
                UserProfile.this.password.setVisibility(8);
                UserProfile.this.newPassword.setVisibility(0);
                UserProfile.this.changeEmail.setVisibility(8);
                UserProfile.this.changePassword.setVisibility(0);
                UserProfile.this.sendEmail.setVisibility(8);
                UserProfile.this.remove.setVisibility(8);
            }
        });
        this.changePassword.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.progressBar.setVisibility(0);
                if (user == null || UserProfile.this.newPassword.getText().toString().trim().equals("")) {
                    if (UserProfile.this.newPassword.getText().toString().trim().equals("")) {
                        UserProfile.this.newPassword.setError("أدخل كلمة السر");
                        UserProfile.this.progressBar.setVisibility(8);
                    }
                } else if (UserProfile.this.newPassword.getText().toString().trim().length() < 6) {
                    UserProfile.this.newPassword.setError("Password too short, enter minimum 6 characters");
                    UserProfile.this.progressBar.setVisibility(8);
                } else {
                    user.updatePassword(UserProfile.this.newPassword.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(UserProfile.this, "Password is updated, sign in with new password!", 0).show();
                                UserProfile.this.signOut();
                                UserProfile.this.progressBar.setVisibility(8);
                                return;
                            }
                            Toast.makeText(UserProfile.this, "فشل في تحديث كلمة السر", 0).show();
                            UserProfile.this.progressBar.setVisibility(8);
                        }
                    });
                }
            }
        });
        this.btnSendResetEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.oldEmail.setVisibility(0);
                UserProfile.this.newEmail.setVisibility(8);
                UserProfile.this.password.setVisibility(8);
                UserProfile.this.newPassword.setVisibility(8);
                UserProfile.this.changeEmail.setVisibility(8);
                UserProfile.this.changePassword.setVisibility(8);
                UserProfile.this.sendEmail.setVisibility(0);
                UserProfile.this.remove.setVisibility(8);
            }
        });
        this.sendEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.progressBar.setVisibility(0);
                if (!UserProfile.this.oldEmail.getText().toString().trim().equals("")) {
                    UserProfile.this.auth.sendPasswordResetEmail(UserProfile.this.oldEmail.getText().toString().trim()).addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(UserProfile.this, "Reset password email is sent!", 0).show();
                                UserProfile.this.progressBar.setVisibility(8);
                                return;
                            }
                            Toast.makeText(UserProfile.this, "Failed to send reset email!", 0).show();
                            UserProfile.this.progressBar.setVisibility(8);
                        }
                    });
                    return;
                }
                UserProfile.this.oldEmail.setError("Enter email");
                UserProfile.this.progressBar.setVisibility(8);
            }
        });
        this.btnRemoveUser.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.progressBar.setVisibility(0);
                if (user != null) {
                    user.delete().addOnCompleteListener(new OnCompleteListener<Void>() {
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(UserProfile.this, "Your profile is deleted:( Create a account now!", 0).show();
                                UserProfile.this.startActivity(new Intent(UserProfile.this, SignupActivity.class));
                                UserProfile.this.finish();
                                UserProfile.this.progressBar.setVisibility(8);
                                return;
                            }
                            Toast.makeText(UserProfile.this, "Failed to delete your account!", 0).show();
                            UserProfile.this.progressBar.setVisibility(8);
                        }
                    });
                }
            }
        });
        this.signOut.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                UserProfile.this.signOut();
            }
        });
    }

    public void signOut() {
        this.auth.signOut();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.progressBar.setVisibility(8);
    }

    public void onStart() {
        super.onStart();
        this.auth.addAuthStateListener(this.authListener);
    }

    public void onStop() {
        super.onStop();
        if (this.authListener != null) {
            this.auth.removeAuthStateListener(this.authListener);
        }
    }

    /* access modifiers changed from: protected */
    public void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C0719R.C0722menu.menu_back, menu);
        return true;
    }
}
