package ducle.fieldFinder.activities.login;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ducle.fieldFinder.AppRepository;
import ducle.fieldFinder.activities.HomeActivity;
import ducle.fieldFinder.R;

public class LoginFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText username = (EditText) view.findViewById(R.id.usernameLogin);
        EditText password = (EditText) view.findViewById(R.id.passwordLogin);
        Button buttonLogin = (Button) view.findViewById(R.id.buttonLogin);
        Button buttonRegister = (Button) view.findViewById(R.id.buttonLoginRegister);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if(result.getResultCode() == RESULT_OK){
                        Intent data = result.getData();
                        Toast.makeText(getActivity(), (String) data.getExtras().get("response"), Toast.LENGTH_SHORT).show();
                    }
                });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), HomeActivity.class);
                intent.putExtra("username", username.getText().toString());
                intent.putExtra("password", password.getText().toString());

                if((AppRepository.Instance().getUserManager().validateLogin(username.getText().toString(), password.getText().toString()))){
                    intent.putExtra("response", "Logged in");
                } else {
                    intent.putExtra("response", "Failed to log in");
                }

                launcher.launch(intent);
            }
        });

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.loginFragmentFl, new RegisterFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}