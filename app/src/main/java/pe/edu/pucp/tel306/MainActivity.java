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
    TextView temporizador = findViewById(R.id.temporizador);
    ImageView iniciarTempo=findViewById(R.id.play);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        final TempoViewModel tempoViewModel = viewModelProvider.get(TempoViewModel.class);






        //iniciarTempo.setOnClickListener(new View.OnClickListener(){






    }
    public void iniciarTemporizadorMain (View view) {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        TempoViewModel tempoViewModel = viewModelProvider.get(TempoViewModel.class);
        tempoViewModel.iniciarTemporizador(temporizador);

    }

}