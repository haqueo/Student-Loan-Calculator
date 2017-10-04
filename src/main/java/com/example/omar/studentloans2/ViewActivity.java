package com.example.omar.studentloans2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.omar.studentloans2.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ViewActivity extends Activity {

    TextView tvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view);

        tvView = (TextView) findViewById(R.id.tvView);

        Intent intent = getIntent();

        String fName = intent.getStringExtra("fname");
        String loan = intent.getStringExtra("loan");

       double estimatedSalary = Double.parseDouble(fName);
        double loanOutstanding = Double.parseDouble(loan);


        double years = studentFinance(loanOutstanding,estimatedSalary)[0];
        double totalPaid = studentFinance(loanOutstanding,estimatedSalary)[1];
        int realYears = (int) years;

        String fontPath = "fonts/RobotoSlab-Regular.ttf";
        TextView textView7 = (TextView) findViewById(R.id.tvView);
        TextView textView8 = (TextView) findViewById(R.id.toolbarTitle);
        Typeface tf = Typeface.createFromAsset(getAssets(),fontPath);
        textView7.setTypeface(tf);
        textView8.setTypeface(tf);





        String result2 = "You will pay £" + totalPaid + ", over the course of " + realYears + " years.";
        String result = years + " years and " + totalPaid + " paid";

        tvView.setText(result2);


    }




    public static double[] studentFinance(double loanOutstanding, double estimatedSalary) {


        double[] result = new double[2];
        final double INTERESTONLOAN = 1.036;
        final double AMOUNTPAYABLERATE = 0.09;
        final double YEARLYCAP = 21000;
        int years = 0;
        double totalPaidSoFar = 0.0;

        while (loanOutstanding > 0){

            // how much you pay
            double surplus = estimatedSalary-YEARLYCAP; // 50k-21k = 29k
            double amountPaid = surplus*AMOUNTPAYABLERATE; // per year you pay 29k * 0.09
            totalPaidSoFar = totalPaidSoFar + amountPaid; // Sum up what you've paid so far
            loanOutstanding = loanOutstanding - amountPaid; // subtract from loanOutstanding
            estimatedSalary = estimatedSalary + 2000.0;

            // interest on your loan.
            loanOutstanding = loanOutstanding*INTERESTONLOAN;

            estimatedSalary = estimatedSalary + 2000.0;
            years++; // move on to next year





                            /* PRINTS */
            System.out.println("The year is " + years);
            System.out.println("loanOutstanding is " + loanOutstanding);
        }


        result[0] = years;
        result[1] = totalPaidSoFar;

        return result;
    }



    public void goBack(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}