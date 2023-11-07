package ducle.fieldFinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import ducle.fieldFinder.login.LoginActivity;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Intent intent = getIntent();
        String username = (String) intent.getExtras().get("username");
        String password = (String) intent.getExtras().get("password");
        String text = "Hello " + username + " (" + password + ")";
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