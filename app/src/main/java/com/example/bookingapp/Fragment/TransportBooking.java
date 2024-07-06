package com.example.bookingapp.Fragment;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.bookingapp.Data;
import com.example.bookingapp.Flights;
import com.example.bookingapp.HomePage;
import com.example.bookingapp.R;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TransportBooking#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TransportBooking extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TransportBooking() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TransportBooking.
     */
    // TODO: Rename and change types and number of parameters
    public static TransportBooking newInstance(String param1, String param2) {
        TransportBooking fragment = new TransportBooking();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    private TextInputEditText departureInput;
    private TextInputEditText returnInput;
    private ArrayAdapter<String> placesAdapter;
    private AutoCompleteTextView fromInput;
    private AutoCompleteTextView toInput;
    private String previousFragment;
    private Button searchButton;
    private String selectedAirportFrom;
    private String selectedAirportTo;
    private EditText passengerCountEditText;
    private EditText childrenCountEditText;
    private EditText petCountEditText;
    private EditText luggageCountEditText;
    private String[] places = {"Ho Chi Minh (SGN)", "Da Nang (DNA)", "Hue (HUI)", "Ha Noi (HAN)", "Da Lat (DLI)", "Can Tho (CTH)"};

    private int isAirplaneSelected = -1;
    private ImageButton backBtn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transport_booking, container, false);
        departureInput = view.findViewById(R.id.departureInput);
        returnInput = view.findViewById(R.id.returnInput);
        fromInput = view.findViewById(R.id.fromText);
        toInput = view.findViewById(R.id.toText);
        ImageButton switchButton = view.findViewById(R.id.switchButton);
        passengerCountEditText = view.findViewById(R.id.passengerCountEditText);
        childrenCountEditText = view.findViewById(R.id.childrenCountEditText);
        petCountEditText = view.findViewById(R.id.petCountEditText);
        luggageCountEditText = view.findViewById(R.id.luggageCountEditText);
        Button buttonEconomy = view.findViewById(R.id.button_economy);
        Button buttonBusiness = view.findViewById(R.id.button_business);
        ImageButton buttonAirplane = view.findViewById(R.id.button_airplane);
        ImageButton buttonBoat = view.findViewById(R.id.button_boat);
        ImageButton buttonTrain = view.findViewById(R.id.button_train);
        ImageButton buttonBus = view.findViewById(R.id.button_bus);
        searchButton = view.findViewById(R.id.searchButton);
        backBtn = view.findViewById(R.id.back_button);

        buttonAirplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAirplaneSelected = 1;
            }
        });
        buttonBoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAirplaneSelected = 0;
            }
        });
        buttonBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAirplaneSelected = 0;
            }
        });
        buttonTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isAirplaneSelected = 0;
            }
        });






       // Set adapter for AutoCompleteTextViews
        ArrayAdapter<String> adapter = new ArrayAdapter<>(requireContext(),
                android.R.layout.simple_dropdown_item_1line, places);

        fromInput.setAdapter(adapter);
        toInput.setAdapter(adapter);
        fromInput.setThreshold(0);
        toInput.setThreshold(0);

        fromInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    fromInput.showDropDown();
                } else {
                    String inputText = fromInput.getText().toString();
                    selectedAirportFrom = findAirportByString(inputText);
                    if (selectedAirportFrom == null) {
                        // Reset to the first item if no match found
                        fromInput.setText(places[0]);
                    }
                }
            }
        });

        toInput.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (hasFocus) {
                    toInput.showDropDown();
                } else {
                    String inputText = toInput.getText().toString();
                    selectedAirportTo = findAirportByString(inputText);
                    if (selectedAirportTo == null) {
                        // Reset to the first item if no match found
                        toInput.setText(places[0]);
                    }
                }
            }
        });
        // Set OnClickListener on switchButton
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Swap selected items in Spinners
                String fromText = fromInput.getText().toString();
                String toText = toInput.getText().toString();
                fromInput.setText(toText);
                toInput.setText(fromText);
                selectedAirportFrom = fromInput.getText().toString();
                selectedAirportTo = toInput.getText().toString();
            }
        });



        departureInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(departureInput);
            }
        });


        returnInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker(returnInput);
            }
        });

        setupEditText(passengerCountEditText, R.drawable.person_icon, R.string.passenger_hint);
        setupEditText(childrenCountEditText, R.drawable.child_icon, R.string.children_hint);
        setupEditText(petCountEditText, R.drawable.pet_icon, R.string.pet_hint);
        setupEditText(luggageCountEditText, R.drawable.luggage_icon, R.string.luggage_hint);

        buttonEconomy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                buttonEconomy.setSelected(true);
                buttonBusiness.setSelected(false);
            }
        });

        buttonBusiness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                buttonEconomy.setSelected(false);
                buttonBusiness.setSelected(true);
            }
        });



        buttonAirplane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                buttonAirplane.setSelected(true);
                buttonBoat.setSelected(false);
                buttonTrain.setSelected(false);
                buttonBus.setSelected(false);
            }
        });

        buttonBoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                buttonAirplane.setSelected(false);
                buttonBoat.setSelected(true);
                buttonTrain.setSelected(false);
                buttonBus.setSelected(false);
            }
        });

        buttonTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                buttonAirplane.setSelected(false);
                buttonBoat.setSelected(false);
                buttonTrain.setSelected(true);
                buttonBus.setSelected(false);
            }
        });

        buttonBus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                buttonAirplane.setSelected(false);
                buttonBoat.setSelected(false);
                buttonTrain.setSelected(false);
                buttonBus.setSelected(true);
            }
        });


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearForcus();
                String departureDate = String.valueOf(departureInput.getText());
                String returnDate = String.valueOf(returnInput.getText());
                String passengerCount = passengerCountEditText.getText().toString();
                String childrenCount = childrenCountEditText.getText().toString();
                String petCount = petCountEditText.getText().toString();
                String luggageCount = luggageCountEditText.getText().toString();
                String classType = buttonEconomy.isSelected() ? "Economy" : "Business";
                String flightType = buttonAirplane.isSelected() ? "Airplane" : buttonBoat.isSelected() ? "Boat" : buttonTrain.isSelected() ? "Train" : "Bus";


                if (selectedAirportFrom == null || selectedAirportTo == null) {
                    Toast.makeText(getContext(), "Please select an airport", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (departureInput.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please select a departure date", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (returnInput.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please select a return date", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passengerCountEditText.getText().toString().isEmpty()) {
                    Toast.makeText(getContext(), "Please enter passenger count", Toast.LENGTH_SHORT).show();
                    return;
                }
                Data data = new Data();

                data.setSelectedAirportFrom(selectedAirportFrom);
                data.setSelectedAirportTo(selectedAirportTo);
                data.setDepartureDate(departureDate);
                data.setReturnDate(returnDate);
                data.setNumberOfPassengers(passengerCount);
                data.setNumberOfChildren(childrenCount);
                data.setTransportType(flightType);
                data.setClassType(classType);


                Intent intent = new Intent(getContext(), Flights.class);
                intent.putExtra("Information", data);
                startActivity(intent);
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getArguments() != null) {
                    previousFragment = getArguments().getString("previous_fragment");
                }
                if ("HomePageFragment".equals(previousFragment)) {
                    // Perform specific actions for HomePageFragment
                    ((HomePage) requireActivity()).navigateToHome();
                    getActivity().onBackPressed();


                } else {
                    getActivity().onBackPressed();
                }
            }
        });
        return view;
    }




    private void setupEditText(EditText editText, int drawableResId, int hintResId) {
        editText.setHint(hintResId);
        editText.setCompoundDrawablesWithIntrinsicBounds(drawableResId, 0, 0, 0);
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    // Text color
                    editText.setTextColor(getResources().getColor(R.color.edittext_focused_color));
                    // Underline color
                    editText.getBackground().mutate().setColorFilter(getResources().getColor(R.color.edittext_focused_color), PorterDuff.Mode.SRC_ATOP);
                } else {
                    // Text color
                    editText.setTextColor(getResources().getColor(R.color.edittext_default_color));
                    // Underline color
                    editText.getBackground().mutate().setColorFilter(getResources().getColor(R.color.edittext_default_color), PorterDuff.Mode.SRC_ATOP);
                }

            }
        });
    }

    private void showDatePicker(final TextInputEditText editText) {
        final Calendar currentDate = Calendar.getInstance();
        final Calendar date = Calendar.getInstance();
        if (getContext() != null) {
            new DatePickerDialog(getContext(), (view, year, monthOfYear, dayOfMonth) -> {
                date.set(year, monthOfYear, dayOfMonth);
                String selectedDateStr = DateFormat.format("MMM dd, yyyy", date).toString();

                // Set the selected date in the EditText
                editText.setText(selectedDateStr);


                // Validate the date immediately after setting
                if (editText == returnInput || editText == departureInput ) {
                    String departureDateStr = departureInput.getText().toString();
                    if (!isValidDates(departureDateStr, selectedDateStr)) {
                        // Show a dialog with an error message
                        showDialog("Error", "Invalid date");
                        // Clear the text in returnInput
                        editText.setText("");
                    } else {
                        returnInput.setError(null);
                    }
                }
            }, currentDate.get(Calendar.YEAR), currentDate.get(Calendar.MONTH), currentDate.get(Calendar.DATE)).show();
        }
    }

    private boolean isValidDates(String departureDateStr, String returnDateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());

        try {
            Date departureDate = sdf.parse(departureDateStr);
            Date returnDate = sdf.parse(returnDateStr);

            Calendar currentCalendar = Calendar.getInstance();
            currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
            currentCalendar.set(Calendar.MINUTE, 0);
            currentCalendar.set(Calendar.SECOND, 0);
            currentCalendar.set(Calendar.MILLISECOND, 0);

            // Check if return date is after departure date and both are not in the past
            return !departureDate.after(returnDate) && !departureDate.before(currentCalendar.getTime())
                    && !returnDate.before(currentCalendar.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return false; // Handle parsing error if necessary
        }

    }
    private void showDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", (dialog, which) -> {
                    // Positive button click handled here
                })
                .show();
    }
    private String findAirportByString(String input) {
        for (String airport : places) {
            if (airport.equalsIgnoreCase(input)) {
                return airport;
            }
        }
        return null; // Return null if no match found
    }
    private void clearForcus(){
        fromInput.clearFocus();
        toInput.clearFocus();
        departureInput.clearFocus();
        returnInput.clearFocus();
        passengerCountEditText.clearFocus();
        childrenCountEditText.clearFocus();
        petCountEditText.clearFocus();
        luggageCountEditText.clearFocus();
    }

}
