package pe.edu.pucp.tel306;




import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.pucp.tel306.ViewModels.TempoViewModel;

public class MainActivity extends AppCompatActivity {
    TextView temporizador;
    ImageView iniciarTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        temporizador = findViewById(R.id.temporizador);
        iniciarTempo = findViewById(R.id.play);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        final TempoViewModel tempoViewModel = viewModelProvider.get(TempoViewModel.class);

        iniciarTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempoViewModel.iniciarTemporizador(temporizador);
            }
        });






        //iniciarTempo.setOnClickListener(new View.OnClickListener(){






    }


}