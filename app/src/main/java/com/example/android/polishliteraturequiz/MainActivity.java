package com.example.android.polishliteraturequiz;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nameField;
    RadioGroup centuriesGroup;
    RadioButton thirteenthCentury;
    EditText nobelPrizes;
    CheckBox lem;
    CheckBox reymont;
    CheckBox milosz;
    CheckBox bauman;
    CheckBox szymborska;
    CheckBox herbert;
    CheckBox sienkiewicz;
    CheckBox walesa;
    RadioGroup fantasyGroup;
    RadioButton witcher;
    RadioGroup poetsGroup;
    RadioButton brzechwa;
    EditText mickiewicz;
    RadioGroup comicGroup;
    RadioButton thorgal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.name_view);
        thirteenthCentury = findViewById(R.id.thirteenth_century);
        nobelPrizes = findViewById(R.id.number_of_prizes);
        lem = findViewById(R.id.lem_checkbox);
        reymont = findViewById(R.id.reymont_checkbox);
        milosz = findViewById(R.id.milosz_checkbox);
        szymborska = findViewById(R.id.szymborska_checkbox);
        sienkiewicz = findViewById(R.id.sienkiewicz_checkbox);
        witcher = findViewById(R.id.witcher_radiobutton);
        brzechwa = findViewById(R.id.brzechwa_radiobutton);
        mickiewicz = findViewById(R.id.adam_mickiewicz_edittext);
        thorgal = findViewById(R.id.thorgal_radiobutton);

        // prevent from opening keyboard on creation
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

        /**
         * This method shows an appropriate text in a toast.
         */
    public void createMessage(View view) {
        int score = calculateScore();
        String name = nameField.getText().toString();

        if (score == 10) {
            displayToastMessage(getString(R.string.score_10, name, score));
        } else if (score >= 8) {
            displayToastMessage(getString(R.string.score_9_8, name, score));
        } else if (score >= 6) {
            displayToastMessage(getString(R.string.score_7_6, score, name));
        } else if (score >= 4) {
            displayToastMessage(getString(R.string.score_5_4, score, name));
        } else if (score >= 1) {
            displayToastMessage(getString(R.string.score_3_2_1, score, name));
        } else if (score == 0) {
            displayToastMessage(getString(R.string.score_0, score, name));
        }
    }

    private int calculateScore() {
        // Check the answer to the question 1.
        int points = 0;
        thirteenthCentury = findViewById(R.id.thirteenth_century);
        if (thirteenthCentury.isChecked()) {
            points += 1;
        }

        // Check the answer to the question 2.
        nobelPrizes = findViewById(R.id.number_of_prizes);
        String numberOfNobels = nobelPrizes.getText().toString();
        if (numberOfNobels.equals("4")) {
            points += 1;
        }

        // Check the correct answers to the question 3.
        reymont = findViewById(R.id.reymont_checkbox);
        milosz = findViewById(R.id.milosz_checkbox);
        szymborska = findViewById(R.id.szymborska_checkbox);
        sienkiewicz = findViewById(R.id.sienkiewicz_checkbox);

        if (reymont.isChecked()) {
            points += 1;
        }
        if (milosz.isChecked()) {
            points += 1;
        }
        if (szymborska.isChecked()) {
            points += 1;
        }
        if (sienkiewicz.isChecked()) {
            points += 1;
        }

        // Check the answer to the question 4.
        witcher = findViewById(R.id.witcher_radiobutton);
        if (witcher.isChecked()) {
            points += 1;
        }
        // Check the answer to the question 5.
        brzechwa = findViewById(R.id.brzechwa_radiobutton);
        if (brzechwa.isChecked()) {
            points += 1;
        }
        // Check the answer to the question 6.
        mickiewicz = findViewById(R.id.adam_mickiewicz_edittext);
        String adamMickiewicz = mickiewicz.getText().toString();
        if (adamMickiewicz.equalsIgnoreCase("adam mickiewicz") || adamMickiewicz.equalsIgnoreCase("adam mickiewicz ")) {
            points += 1;
        }

        // Check the answer to the question 7.
        thorgal = findViewById(R.id.thorgal_radiobutton);
        if (thorgal.isChecked()) {
            points += 1;
        }
        return points;
    }

    /**
     * This method creates a message.
     */
    private void displayToastMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
    public void resetQuiz(View v) {
        nameField.getText().clear();
        nobelPrizes.getText().clear();
        mickiewicz.getText().clear();
        centuriesGroup = findViewById(R.id.century_group);
        centuriesGroup.clearCheck();
        fantasyGroup = findViewById(R.id.fantasy_group);
        fantasyGroup.clearCheck();
        poetsGroup = findViewById(R.id.poets_group);
        poetsGroup.clearCheck();
        comicGroup = findViewById(R.id.comic_group);
        comicGroup.clearCheck();
        lem = findViewById(R.id.lem_checkbox);
        reymont = findViewById(R.id.reymont_checkbox);
        milosz = findViewById(R.id.milosz_checkbox);
        bauman = findViewById(R.id.bauman_checkbox);
        szymborska = findViewById(R.id.szymborska_checkbox);
        herbert = findViewById(R.id.herbert_checkbox);
        sienkiewicz = findViewById(R.id.sienkiewicz_checkbox);
        walesa = findViewById(R.id.walesa_checkbox);
        lem.setChecked(false);
        reymont.setChecked(false);
        milosz.setChecked(false);
        bauman.setChecked(false);
        szymborska.setChecked(false);
        herbert.setChecked(false);
        sienkiewicz.setChecked(false);
        walesa.setChecked(false);
    }
}
