//the background image of the app has been extracted from the internet
package com.example.lenovo.primenochecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    int num;// variable to store the random no generated which will be checked for primality
    int savenum=0;//variable to store state of the num variable
    int value=0;//variable that will check if onResume() is called first time when our app is launched or after screen rotation
    int savevalue=0;//variable to store state of the value variable
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Random rand=new Random();
        if(value==0) { //i.e, if value is zero i.e, if onResume is called when our app is launched and not after screen rotation
            value = 1;//then set value=1 so that when wev rotate screen code inside if block doesn't run
            num = rand.nextInt(1000) + 1;//generate a random no between 1 and 1000
        }
        String qstn = num +" "+ "is a prime no";
        TextView question = (TextView) findViewById(R.id.textView);
        question.setText(qstn);//display the question
    }

    public void checkprime1(View view) {//this function will be called when user clicks on CORRECT Button.
        int n = num;
        int k;
        for (k = 2; k < n; k++) {
            if (n % k == 0) {
                Toast t = Toast.makeText(getApplicationContext(), "FALSE", Toast.LENGTH_SHORT);
                //if no is not prime then a toast with message FALSE will be displayed
                t.show();
                break;
            }
        }
        if (k == n) {
            Toast t = Toast.makeText(getApplicationContext(), "TRUE", Toast.LENGTH_SHORT);
            //if the no is prime then a toast with message TRUE will be displayed
            t.show();
        }
    }


    public void nextquestion(View view) {//this function will be called everytime the user presses the NEXT button.
                                         //this method wil display the next question
        Random rand = new Random();
        num = rand.nextInt(1000) + 1;
        String qstn = num + " " +"is a prime no";
        TextView question = (TextView) findViewById(R.id.textView);
        question.setText(qstn);
    }

    public void checkprime2(View view) {//this function will be called when user clicks on INCORRECT Button
        int n=num;
        int k;
        for(k=2;k<n;k++)
        {
            if(n%k==0)
            {
                Toast t=Toast.makeText(getApplicationContext(),"TRUE",Toast.LENGTH_SHORT);
                //if no is not prime then a toast with message TRUE will be displayed
                t.show();
                break;
            }
        }
        if(k==n)
        {
            Toast t=Toast.makeText(getApplicationContext(),"FALSE",Toast.LENGTH_SHORT);
            //if the no is prime then a toast with message FALSE will be displayed
            t.show();
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {//function to save the activity state
        savedInstanceState.putInt("savenum",num);
        savedInstanceState.putInt("savevalue",value);
        super.onSaveInstanceState(savedInstanceState);
    }

   @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {//function to restore the activity state
       super.onRestoreInstanceState(savedInstanceState);
       num = savedInstanceState.getInt("savenum");
       value = savedInstanceState.getInt("savevalue");
    }
}



