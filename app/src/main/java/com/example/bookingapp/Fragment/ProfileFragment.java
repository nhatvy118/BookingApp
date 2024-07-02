package com.example.bookingapp.Fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bookingapp.R;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {


    private TextView ProfileInfo;
    private TextView profileName;
    private SharedPreferences pref;

    public ProfileFragment() {
        // Required empty public constructor
    }

    private static final String ARG_FIRST_NAME = "argFirstName";
    private static final String ARG_IMAGE_URI = "argImageUri";
    private  String name;
    private String uri;
    private ShapeableImageView profileImage;

    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String Name, String imageUri) {
        ProfileFragment fragment = new ProfileFragment();
        Bundle args = new Bundle();
        args.putString(ARG_FIRST_NAME, Name);
        args.putString(ARG_IMAGE_URI, imageUri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_FIRST_NAME);
            uri = getArguments().getString(ARG_IMAGE_URI);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ProfileInfo = view.findViewById(R.id.personal_information);

        profileName = view.findViewById(R.id.profile_name);
        profileName.setText(name);
        profileImage = view.findViewById(R.id.profile_image);
        if (!Objects.equals(uri, "Default")) {
            profileImage.setImageURI(Uri.parse(uri));
        }

        ProfileInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pref = getActivity().getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
                String firstName = pref.getString("FirstName", "");
                String lastName = pref.getString("LastName", "");
                String phone = pref.getString("PhoneNumber", "");
                String email = pref.getString("Email", "");
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, com.example.bookingapp.Fragment.ProfileInfo.newInstance(firstName,lastName,phone,email,uri));
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        return view;
    }
}