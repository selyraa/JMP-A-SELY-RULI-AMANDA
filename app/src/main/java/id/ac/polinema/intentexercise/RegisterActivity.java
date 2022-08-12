package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email, password, confirmPassword, homepage, about;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        username = (EditText) findViewById(R.id.text_fullname);
        email = (EditText) findViewById(R.id.text_email);
        password = (EditText) findViewById(R.id.text_password);
        confirmPassword = (EditText) findViewById(R.id.text_confirm_password);
        homepage = (EditText) findViewById(R.id.text_homepage);
        about = (EditText) findViewById(R.id.text_about);
        buttonRegister = findViewById(R.id.button_ok);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usernameKey = username.getText().toString();
                String emailKey = email.getText().toString();
                String passwordKey = password.getText().toString();
                String confirmKey = confirmPassword.getText().toString();
                String homepageKey = homepage.getText().toString();
                String aboutKey = about.getText().toString();

                if (passwordKey.equals(confirmKey)) {
                    if (!usernameKey.isEmpty() && !emailKey.isEmpty() && !confirmKey.isEmpty()
                            && !homepageKey.isEmpty() && !aboutKey.isEmpty()) {
                        Intent move = new Intent(RegisterActivity.this, ProfileActivity.class);
                        move.putExtra("Name", usernameKey);
                        move.putExtra("Email", emailKey);
                        //move.putExtra("Password", passwordKey);
                        //move.putExtra("Confirm Password", confirmKey);
                        move.putExtra("Homepage", homepageKey);
                        move.putExtra("About", aboutKey);
                        startActivity(move);
                        Toast.makeText(RegisterActivity.this, "REGISTER SUCCESS",
                                Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "REGISTER FAILED",
                                Toast.LENGTH_SHORT).show();
                    }
                } else {
                    AlertDialog.Builder build = new AlertDialog.Builder(RegisterActivity.this);
                    build.setMessage("Password Salah!").setNegativeButton("Retry", null)
                            .create().show();
                }
            }
        });
    }
}
