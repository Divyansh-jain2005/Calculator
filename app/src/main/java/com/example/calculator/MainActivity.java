package com.example.calculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.splashscreen.SplashScreen;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {


    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,bdiv,bdot,bmul,badd,bsub,bc,bce,bx,bsign,bequal,bsq;
    TextView output,input;

    Toolbar app;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
SplashScreen.installSplashScreen(this);

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            b1=findViewById(R.id.btn1);
            b2=findViewById(R.id.btn1);
            b3=findViewById(R.id.btn1);
            b4=findViewById(R.id.btn1);
            b5=findViewById(R.id.btn1);
            b6=findViewById(R.id.btn1);
            b7=findViewById(R.id.btn1);
            b8=findViewById(R.id.btn1);
            b9=findViewById(R.id.btn1);
            b0=findViewById(R.id.btn0);
            bdiv=findViewById(R.id.btndiv);
            bdot=findViewById(R.id.btndot);
            bmul=findViewById(R.id.btnmul);
            badd=findViewById(R.id.btnadd);
            bsub=findViewById(R.id.btnsub);
            bsign=findViewById(R.id.btnsign);
            bc=findViewById(R.id.btnc);
            bce=findViewById(R.id.ce);
            bequal=findViewById(R.id.btnequal);
            bsq=findViewById(R.id.btnXsq);
            input=findViewById(R.id.input);
            output=findViewById(R.id.output);



            bequal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String data=input.getText().toString();
                    Context context=Context.enter();
                    context.setOptimizationLevel(-1);
                    Scriptable scriptable=context.initSafeStandardObjects();
                    String result=context.evaluateString(scriptable,data,"JavaScript",1,null).toString();
                    output.setText(result);

                }
            });





            bce.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    input.setText("");
                    output.setText("");
                }
            });

            bc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   String text=input.getText().toString();

                    if(text.length()!=0) {
                        input.setText(text.substring(0,text.length()-1));

                    }

                }
            });
            return insets;
        });
    }
    public  void getValue(View View){

    Button btn =(Button) View;
    input.setText(input.getText().toString()+btn.getText().toString());
    }

    public  void getValue2(View View){

        Button btn =(Button) View;
        if(btn==bmul){
            input.setText(input.getText().toString()+" * ");
        } else if (btn==bdiv) {
            input.setText(input.getText().toString()+" / ");

        } else if (btn==bsq) {
            input.setText(input.getText().toString()+ "*"+ input.getText().toString());

        }

    }
    public  void getValue3(View View){
        Integer cnt=0;
        Button btn =(Button) View;
            input.setText("-"+input.getText().toString());
    }

}