package com.example.lab2_a;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText firstNameEditText, lastNameEditText, gradesEditText;
    Button gradesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNameEditText = findViewById(R.id.firstNameEditText);
        lastNameEditText = findViewById(R.id.lastNameEditText);
        gradesEditText = findViewById(R.id.gradesEditText);
        gradesButton = findViewById(R.id.gradesButton);

        checkEmptyFields();
        // Przywracanie stanu po obrocie urządzenia
        if (savedInstanceState != null) {
            firstNameEditText.setText(savedInstanceState.getString(getString(R.string.firstname)));
            lastNameEditText.setText(savedInstanceState.getString(getString(R.string.lastname)));
            gradesEditText.setText(savedInstanceState.getString(getString(R.string.grades)));
            gradesButton.setVisibility(savedInstanceState.getInt(getString(R.string.buttonvisibility)));
        }

        gradesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.button_clicked_toast, Toast.LENGTH_SHORT).show();
            }
        });

        firstNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateFields();
                }
            }
        });

        lastNameEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateFields();
                }
            }
        });

        gradesEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validateFields();
                }
            }
        });
    }

    private void validateFields() {
        boolean isFirstNameValid = !TextUtils.isEmpty(firstNameEditText.getText().toString());
        boolean isLastNameValid = !TextUtils.isEmpty(lastNameEditText.getText().toString());
        boolean isGradesValid = false;
        try {
            int grades = Integer.parseInt(gradesEditText.getText().toString());
            isGradesValid = (grades >= 5 && grades <= 15);
        } catch (NumberFormatException e) {
            isGradesValid = false;
        }

        // Walidacja pól
        if (!isFirstNameValid) {
            showToastAndSetError(R.string.first_name_empty_error, firstNameEditText);
        }
        if (!isLastNameValid) {
            showToastAndSetError(R.string.last_name_empty_error, lastNameEditText);
        }
        if (!isGradesValid) {
            showToastAndSetError(R.string.grades_range_error, gradesEditText);
        }

        // Wyświetlenie przycisku tylko jeśli wszystkie pola są poprawne
        if (isFirstNameValid && isLastNameValid && isGradesValid) {
            gradesButton.setVisibility(View.VISIBLE);
        } else {
            gradesButton.setVisibility(View.GONE);
        }
    }

    // Metoda pomocnicza do wyświetlania komunikatów Toast i ustawiania błędów w polach
    private void showToastAndSetError(int messageResId, EditText editText) {
        Toast.makeText(MainActivity.this, messageResId, Toast.LENGTH_SHORT).show();
        editText.setError(getString(messageResId));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(getString(R.string.firstname), firstNameEditText.getText().toString());
        outState.putString(getString(R.string.lastname), lastNameEditText.getText().toString());
        outState.putString(getString(R.string.grades), gradesEditText.getText().toString());
        outState.putInt(getString(R.string.buttonvisibility), gradesButton.getVisibility());
    }
    private void checkEmptyFields() {
        boolean isFirstNameEmpty = TextUtils.isEmpty(firstNameEditText.getText().toString().trim());
        boolean isLastNameEmpty = TextUtils.isEmpty(lastNameEditText.getText().toString().trim());
        boolean isGradesEmpty = TextUtils.isEmpty(gradesEditText.getText().toString().trim());

        if (isFirstNameEmpty || isLastNameEmpty || isGradesEmpty) {
            // Jesli chociaz jedno pole jest puste, to ukrywany button
            gradesButton.setVisibility(View.GONE);

        }
    }
}
