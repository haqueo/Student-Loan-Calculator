package com.example.omar.studentloans2;
import android.text.Editable;
import android.text.TextWatcher;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText passwordEditText;
    private TextView textView;


    private EditText salaryfigure;
    private EditText loanfigure;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Font path
        String fontPath = "fonts/RobotoSlab-Regular.ttf";
        TextView textView1 = (TextView) findViewById(R.id.salary);
        TextView textView2 = (TextView) findViewById(R.id.loan);
        TextView textView3 = (TextView) findViewById(R.id.newIntro);
        TextView textView4 = (TextView) findViewById(R.id.toolbarTitle);
        TextView textView5 = (TextView) findViewById(R.id.salaryIntro);
        TextView textView6 =(TextView) findViewById(R.id.loanIntro);
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        textView1.setTypeface(tf);
        textView2.setTypeface(tf);
        textView3.setTypeface(tf);
        textView4.setTypeface(tf);
        textView5.setTypeface(tf);
        textView6.setTypeface(tf);



       Toolbar toolbar =(Toolbar) findViewById(R.id.toolbar) ;
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");



        salaryfigure = (EditText) findViewById(R.id.salary);
        loanfigure = (EditText) findViewById(R.id.loan);
        btnSubmit = (Button) findViewById(R.id.button);
        btnSubmit.setOnClickListener(this);





        /* Initializing views */
//        passwordEditText = (EditText) findViewById(R.id.password);
//        textView = (TextView) findViewById(R.id.passwordHint);
//        textView.setVisibility(View.GONE);

        /* Set Text Watcher listener */
//        passwordEditText.addTextChangedListener(passwordWatcher);
//        salaryfigure.addTextChangedListener(passwordWatcher);

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("fname", salaryfigure.getText().toString());
        intent.putExtra("loan", loanfigure.getText().toString());
        startActivity(intent);
    }



//    private final TextWatcher passwordWatcher = new TextWatcher() {
//        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//        }
//
//        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            textView.setVisibility(View.VISIBLE);
//        }
//
//        public void afterTextChanged(Editable s) {
//            if (s.length() == 0) {
//                textView.setVisibility(View.GONE);
//                passwordEditText.append("wassup");
//                salaryfigure.append("2");
//
//            } else{
//                textView.setText("You have entered : " + passwordEditText.getText());
//            }
//        }
//    };




}
