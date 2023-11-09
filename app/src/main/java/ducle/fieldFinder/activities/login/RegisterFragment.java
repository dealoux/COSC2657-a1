package ducle.fieldFinder.activities.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ducle.fieldFinder.R;

public class RegisterFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText fName = (EditText) view.findViewById(R.id.fNameRegister);
        EditText lName = (EditText) view.findViewById(R.id.lNameRegister);
        EditText dob = (EditText) view.findViewById(R.id.dobRegister);
        EditText phone = (EditText) view.findViewById(R.id.phoneRegister);
        EditText email = (EditText) view.findViewById(R.id.emailRegister);
        EditText username = (EditText) view.findViewById(R.id.usernameRegister);
        EditText password = (EditText) view.findViewById(R.id.passwordRegister);
        Button buttonConfirm = (Button) view.findViewById(R.id.buttonRegisterConfirm);
        Button buttonCancel = (Button) view.findViewById(R.id.buttonRegisterCancel);

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Registered User " + username, Toast.LENGTH_SHORT);
                returnLogin();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                returnLogin();
            }
        });
    }

    private void returnLogin(){
//        getParentFragmentManager().beginTransaction().replace(R.id.loginFragmentFl, new LoginFragment()).commit();
        getParentFragmentManager().popBackStack();
    }
}