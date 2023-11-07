package ducle.fieldFinder;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // login
        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        EditText username = (EditText) findViewById(R.id.usernameLogin);
        EditText password = (EditText) findViewById(R.id.passwordLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("username", username.getText().toString());
                intent.putExtra("password", password.getText().toString());
                startActivityForResult(intent, 100);
            }
        });

        // register
        Button buttonRegister = (Button) findViewById(R.id.buttonLoginRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 100){
            if(resultCode == RESULT_OK){
                String text = (String) data.getExtras().get("response");
                Toast.makeText(LoginActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        }
    }
}