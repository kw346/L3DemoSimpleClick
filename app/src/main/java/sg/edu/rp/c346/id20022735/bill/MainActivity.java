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

    String i = et$.getText().toString();
    double indi = Double.parseDouble(a);

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



        tvsplit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et$.getText().toString().trim().length() != 0 && etNo.getText().toString().trim().length() != 0){
                    double ori = Double.parseDouble(et$.getText().toString());
                    double newtot = 0.0;
                    if (!tbser.isChecked() && !tbgst.isChecked()){
                        newtot = ori;
                    } else if (!tbser.isChecked() && tbgst.isChecked()){
                        newtot = ori * 1.07;
                    }else if(tbser.isChecked() && !tbgst.isChecked()){
                        newtot = ori* 1.1;
                    }
                    else {
                        newtot = ori * 1.17;
                    }
                if (etDC.getText().toString().trim().length() != 0){
                    newtot *= Double.parseDouble(etDC.getText().toString()) /100;
                }

                String m = " in cash";
                if (rgPay.getCheckedRadioButtonId() == R.id.radButP){
                    m = " via Paynow to 91234578";
                }

                tvbill.setText("Total Bill:$" + String.format(".%2f",newtot));

                int noppl = Integer.parseInt(etNo.getText().toString());
                if (noppl != 1){
                    tvsplit.setText("Each Pays: $" + String.format("%.2f",newtot / noppl) + m);
                }
                else{
                    tvsplit.setText("Each Pays: $" + newtot + m);
                }




                }

            }
        });
        btnR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et$.setText("");
                etNo.setText("");
                tbser.setChecked(false);
                tbgst.setChecked(false);
                etDC.setText("");
                rgPay.check(R.id.radButC);
            }
        });


    }}