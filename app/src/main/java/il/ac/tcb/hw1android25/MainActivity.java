package il.ac.tcb.hw1android25;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    String inputValue ;
    String outPut;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText inputValue = findViewById(R.id.ConvertOutPut1);

        TextView outPut = findViewById(R.id.txtViewoutput);

        Button CnvBtn = findViewById(R.id.convBtn2);

        Spinner mySpinner = findViewById(R.id.convSpinner1);
        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        ArrayList<String>arrayList= new ArrayList<>();
        arrayList.add("CenyimetersToMeters");
        arrayList.add("MetersToKiloMeters");
        arrayList.add("CelsiusToFarenheit");
        arrayList.add("FarenheitToCelsius");
        arrayList.add("GramsToKiolgrams");
        ArrayAdapter<String>
                adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,arrayList);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        mySpinner.setAdapter(adapter);


        CnvBtn.setOnClickListener(view->{
            String selectedConversion = mySpinner.getSelectedItem().toString();
            String inputStr = inputValue.getText().toString();

            if (inputStr.isEmpty()) {
                Toast.makeText(this, "Insert a Value", Toast.LENGTH_SHORT).show();
                return;
            }

            double input = Double.parseDouble(inputStr);
            double res = 0;

            switch (selectedConversion){
                case "CenyimetersToMeters":
                    res=input/100;
                    break;
                case "MetersToKiloMeters":
                    res=input/1000;
                    break;
                case "CelsiusToFarenheit":
                    res = (input*9/5)+32;
                    break;
                case "FarenheitToCelsius":
                    res = (input-32)*(5/9.0);
                    break;
                case "GramsToKiolgrams":
                        res=input/1000;
                        break;
                default:
                    Toast.makeText(this,"non",Toast.LENGTH_SHORT).show();
                    return;
            }
                outPut.setText("result is "+res);
        });



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}