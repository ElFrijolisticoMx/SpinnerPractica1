import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.spinner.R;

public class MainActivity extends AppCompatActivity {

    private Spinner fruitsSpinner;
    private TextView selectedFruitText;

    private String[] fruits = {"Manzana", "Plátano", "Naranja", "Piña", "Fresa"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fruitsSpinner = findViewById(R.id.fruits_spinner);
        selectedFruitText = findViewById(R.id.selected_fruit_text);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fruits);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fruitsSpinner.setAdapter(adapter);

        fruitsSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String selectedFruit = fruits[position];
                Toast.makeText(MainActivity.this, "Has seleccionado: " + selectedFruit, Toast.LENGTH_SHORT).show();
                selectedFruitText.setText("Fruta seleccionada: " + selectedFruit);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // No se seleccionó ninguna fruta
            }
        });
    }
}
