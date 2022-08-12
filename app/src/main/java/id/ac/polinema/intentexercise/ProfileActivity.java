package id.ac.polinema.intentexercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    TextView hasilUsername, hasilEmail, hasilHomepage, hasilAbout;
    private Button buttonHomepage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        String username = getIntent().getExtras().getString("Name");
        String email = getIntent().getExtras().getString("Email");
        //String password = getIntent().getExtras().getString("Password");
        //String confirm = getIntent().getExtras().getString("Confirm Password");
        String homepage = getIntent().getExtras().getString("Homepage");
        String about = getIntent().getExtras().getString("About");

        hasilUsername = findViewById(R.id.label_fullname);
        hasilEmail = findViewById(R.id.label_email);
        hasilHomepage = findViewById(R.id.label_homepage);
        hasilAbout = findViewById(R.id.label_about);

        hasilUsername.setText(username);
        hasilEmail.setText(email);
        hasilHomepage.setText(homepage);
        hasilAbout.setText(about);

        buttonHomepage = findViewById(R.id.button_homepage);
        buttonHomepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(home);
            }
        });
    }
}
