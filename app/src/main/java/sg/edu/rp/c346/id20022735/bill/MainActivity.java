package sg.edu.rp.c346.id20022735.bill;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText et$;
    EditText etNo;
    ToggleButton tbser;
    ToggleButton tbgst;
    EditText etDC;
    RadioGroup rgPay;
    Button btnS;
    Button btnR;
    TextView tvbill;
    TextView tvsplit;

    String a = et$.getText().toString();
    double amt = Double.parseDouble(a);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et$ = findViewById(R.id.amt);
        etNo = findViewById(R.id.no);
        tbser = findViewById(R.id.tbsvs);
        tbgst = findViewById(R.id.tbGST);
        etDC = findViewById(R.id.dis);
        rgPay = findViewById(R.id.radGrpPayment);
        btnS = findViewById(R.id.butS);
        btnR = findViewById(R.id.butR);
        tvbill = findViewById(R.id.total);
        tvsplit = findViewById(R.id.split);





        tbser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (tbser.isChecked() == true) {
                    amt = amt * 1.1;
                }

        }});

        tbgst.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (tbgst.isChecked() == true) {
                        amt = amt * 1.07;
                    }
            }});

        String b = etDC.getText().toString();
        double dis = Double.parseDouble(b);
            if (!(b.isEmpty())){
                amt = amt * (dis /100);
            }
        }
        String c = etNo.getText().toString();
        int ppl = Integer.parseInt(c);
         if (c > 0){
             amt = amt * (dis /100);
    }


    }