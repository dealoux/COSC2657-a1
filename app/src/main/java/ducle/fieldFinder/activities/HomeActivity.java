package ducle.fieldFinder.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ducle.fieldFinder.R;
import ducle.fieldFinder.activities.login.LoginActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String username = (String) intent.getExtras().get("username");
        String password = (String) intent.getExtras().get("password");
        String response = (String) intent.getExtras().get("response");

        String text = response + ": " + username + " (" + password + ")";
        Toast.makeText(HomeActivity.this, text, Toast.LENGTH_LONG).show();

        Button button = (Button) findViewById(R.id.buttonLogout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(HomeActivity.this, LoginActivity.class);
                intent1.putExtra("response", "Logged out");
                setResult(RESULT_OK, intent1);
                finish();
            }
        });
    }
}