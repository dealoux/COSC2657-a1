package ducle.fieldFinder.activities.utils;
import androidx.fragment.app.FragmentManager;

public class ActivityUtils {
    public static void datePickerDialog(FragmentManager fragmentManager){
        DatePickerFragment datePicker = new DatePickerFragment();
        datePicker.show(fragmentManager, "date picker");
    }
}
