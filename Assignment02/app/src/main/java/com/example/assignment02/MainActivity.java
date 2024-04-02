package com.example.assignment02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox checkBox;
    RadioGroup radioGroup;
    RadioButton radioButtonDog, radioButtonCat, radioButtonFrog;
    Button btnOk;
    ImageView imgPet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        text1 = findViewById(R.id.SelectText1);
        checkBox = findViewById(R.id.CheckAgree);

        text2 = findViewById(R.id.SelectText2);
        radioGroup = findViewById(R.id.RadioGroup);
        radioButtonDog = findViewById(R.id.RadioDog);
        radioButtonCat = findViewById(R.id.RadioCat);
        radioButtonFrog = findViewById(R.id.RadioFrog);

        btnOk = findViewById(R.id.BtnOk);
        imgPet = findViewById(R.id.ImgPet);

        checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (checkBox.isChecked()) {
                text2.setVisibility(View.VISIBLE);
                radioGroup.setVisibility(View.VISIBLE);
                btnOk.setVisibility(View.VISIBLE);
                imgPet.setVisibility(View.VISIBLE);
            } else {
                text2.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
                btnOk.setVisibility(View.INVISIBLE);
                imgPet.setVisibility(View.INVISIBLE);
            }
        });

        btnOk.setOnClickListener(v -> {
            int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
            if (checkedRadioButtonId == R.id.RadioDog) {
                imgPet.setImageResource(R.drawable.dog);
            } else if (checkedRadioButtonId == R.id.RadioCat) {
                imgPet.setImageResource(R.drawable.cat);
            } else if (checkedRadioButtonId == R.id.RadioFrog) {
                imgPet.setImageResource(R.drawable.frog);
            } else {
                Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요", Toast.LENGTH_SHORT).show();
            }
        });


    }
}