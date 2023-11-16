package ducle.fieldFinder.activities.browse;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import ducle.fieldFinder.AppRepository;
import ducle.fieldFinder.R;

public class FieldBrowseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_field_browse, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ListView fieldListView = (ListView) view.findViewById(R.id.browseFieldListView);

        Bundle bundle = this.getArguments();
        String centreId = bundle.getString("centreId");

        ArrayAdapter arrayAdapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, AppRepository.Instance().findCentre(centreId).getFieldManager().getList());
        fieldListView.setAdapter(arrayAdapter);

        fieldListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView adapterView, View view, int i, long id) {
                
            }
        });
    }

    private void popStack(){
        getParentFragmentManager().popBackStack();
    }
}