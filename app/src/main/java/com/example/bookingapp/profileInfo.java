package com.example.bookingapp;

import static androidx.core.app.ActivityCompat.startActivityForResult;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.Manifest;
import android.widget.Toast;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link profileInfo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class profileInfo extends Fragment {


    private static final String ARG_FIRST_NAME = "FirstName";
    private static final String ARG_LAST_NAME = "LastName";
    private static final String ARG_PHONE = "PhoneNumber";
    private static final String ARG_EMAIL = "Email";
    private static final String ARG_IMAGE = "image";
    private ImageView profileImage;
    private TextInputEditText firstNameEditText, lastNameEditText, phoneEditText, emailEditText;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;
    private ShapeableImageView image;
    private static final int PICK_IMAGE = 1;
    private String uri;


    private String firstName;
    private String lastName;
    private String phone;
    private String email;



    // TODO: Rename and change types of parameters


    public profileInfo() {
        // Required empty public constructor
    }


    public static profileInfo newInstance(String firstName, String lastName, String phone, String email,String uri) {
        profileInfo fragment = new profileInfo();
        Bundle args = new Bundle();
        args.putString(ARG_FIRST_NAME, firstName);
        args.putString(ARG_LAST_NAME, lastName);
        args.putString(ARG_PHONE, phone);
        args.putString(ARG_EMAIL, email);
        args.putString(ARG_IMAGE,uri);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            firstName = getArguments().getString(ARG_FIRST_NAME);
            lastName = getArguments().getString(ARG_LAST_NAME);
            phone = getArguments().getString(ARG_PHONE);
            email = getArguments().getString(ARG_EMAIL);
            uri = getArguments().getString(ARG_IMAGE);
        }
    }


    ActivityResultLauncher<Intent> resultLauncher;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile_info, container, false);
        ImageButton camera = view.findViewById(R.id.camera);
        image = view.findViewById(R.id.profile_image);
        firstNameEditText = view.findViewById(R.id.first_name);
        lastNameEditText = view.findViewById(R.id.last_name);
        phoneEditText = view.findViewById(R.id.phone);
        emailEditText = view.findViewById(R.id.email);
        initAccountInfo();
        ImageButton backBtn = view.findViewById(R.id.back_button);
        Button saveChangesButton = view.findViewById(R.id.save_changes);
        registerResult();
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = requireActivity().getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, profileFragment.newInstance(firstName +" " + lastName,uri));
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });
        camera.setOnClickListener(v -> openGallery());
        saveChangesButton.setOnClickListener(v -> saveProfileInfo());
        return view;
    }

    private void initAccountInfo() {
        firstNameEditText.setText(firstName);
        lastNameEditText.setText(lastName);
        phoneEditText.setText(phone);
        emailEditText.setText(email);
        if (!Objects.equals(uri, "Default")){
            image.setImageURI(Uri.parse(uri));
        }
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        resultLauncher.launch(intent);
    }

    private void registerResult() {
        resultLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == getActivity().RESULT_OK && result.getData() != null) {
                    Uri imageUri = result.getData().getData();
                    if (imageUri != null) {
                        image.setImageURI(imageUri);
                        uri = imageUri.toString();
                    } else {
                        Toast.makeText(getActivity(), "No image", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getActivity(), "No image", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void saveProfileInfo() {
        if (firstName.isEmpty() || lastName.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            Toast.makeText(getActivity(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }
        firstName = firstNameEditText.getText().toString();
        lastName = lastNameEditText.getText().toString();
        phone = phoneEditText.getText().toString();
        email = emailEditText.getText().toString();
        firstNameEditText.setText(firstName);
        lastNameEditText.setText(lastName);
        phoneEditText.setText(phone);
        emailEditText.setText(email);

        pref = getActivity().getSharedPreferences("AccountInfo", Context.MODE_PRIVATE);
        editor = pref.edit();
        editor.putString("FirstName", firstName);
        editor.putString("LastName", lastName);
        editor.putString("PhoneNumber", phone);
        editor.putString("Email", email);
        if (!uri.equals("Default")) {
            editor.putString("Image", uri);
        }
        editor.apply();
        Toast.makeText(getActivity(), "Profile information saved", Toast.LENGTH_SHORT).show();
    }

}





