package pe.edu.pucp.tel306;




import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.pucp.tel306.ViewModels.TempoViewModel;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final TextView temporizador = findViewById(R.id.temporizador);
        ImageView iniciarTempo=findViewById(R.id.play);


        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        final TempoViewModel tempoViewModel = viewModelProvider.get(TempoViewModel.class);

        iniciarTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempoViewModel.iniciarTemporizador(temporizador);
            }
        });






        //iniciarTempo.setOnClickListener(new View.OnClickListener(){


        // if variable del reloj termina, se muestra este mensaje
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Mensaje");
        builder.setMessage("Tiempo para un descanso");
        builder.setPositiveButton("Ok", null);

        AlertDialog dialog = builder.create();
        dialog.show();

        //mensaje cuando termina el tiempo de descanso
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Mensaje");
        builder2.setMessage("Here we go again");
        builder2.setPositiveButton("Ok", null);
        AlertDialog dialog2 = builder.create();
        dialog2.show();


        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        builder3.setTitle("Mensaje");
        builder3.setMessage("Kate Winslet guarda su Oscar en el cuarto de baño " +
                "para que sus invitados puedan sostenerlo e improvisar sus propios" +
                " discursos de agradecimiento sin sentirse observados.");
        builder3.setPositiveButton("Ok", null);
        AlertDialog dialog3 = builder.create();
        dialog3.show();

    }


}