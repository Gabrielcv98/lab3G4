package pe.edu.pucp.tel306;




import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import pe.edu.pucp.tel306.ViewModels.TempoViewModel;

public class MainActivity extends AppCompatActivity {
    private static final int STARTING_TIME = 1500;

    private boolean mTimerRunning;
    private int mTimeLeft = STARTING_TIME;
    private TextView temporizador;
    private ImageView iniciarTempo;
    private ImageView reiniciarTempo;
    private ImageView pausarTempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      temporizador = findViewById(R.id.temporizador);
        iniciarTempo  =findViewById(R.id.play);
        pausarTempo = findViewById(R.id.pausa);
        reiniciarTempo = findViewById(R.id.reiniciar);




        iniciarTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciarTempo.setVisibility(View.INVISIBLE);
                pausarTempo.setVisibility(View.VISIBLE);
                ViewModelProvider viewModelProvider = new ViewModelProvider(MainActivity.this);
                final TempoViewModel tempoViewModel = viewModelProvider.get(TempoViewModel.class);
                tempoViewModel.iniciarTemporizador();

                tempoViewModel.getTempo().observe(MainActivity.this, new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        if (integer == 0) {
                            tempoViewModel.getTempo().setValue(STARTING_TIME);
                            tempoViewModel.iniciarDescanso();
                            // if variable del reloj termina, se muestra este mensaje
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setTitle("Mensaje");
                            builder.setMessage("Tiempo para un descanso");
                            builder.setPositiveButton("Ok", null);

                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }
                        int minutos = integer / 60 ;
                        int segundos = integer % 60;

                        String tiempoRestante = String.format(Locale.getDefault(),"%02d:%02d",minutos,segundos);

                        temporizador.setText(tiempoRestante);

                    }
                });

            }
        });
        pausarTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewModelProvider viewModelProvider = new ViewModelProvider(MainActivity.this);
                final TempoViewModel tempoViewModel = viewModelProvider.get(TempoViewModel.class);
                tempoViewModel.detenerTemporizador();
               pausarTempo.setVisibility(View.INVISIBLE);
               iniciarTempo.setVisibility(View.VISIBLE);

            }
        });


        reiniciarTempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });






        //iniciarTempo.setOnClickListener(new View.OnClickListener(){



        //mensaje cuando termina el tiempo de descanso
        AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
        builder2.setTitle("Mensaje");
        builder2.setMessage("Here we go again");
        builder2.setPositiveButton("Ok", null);
        AlertDialog dialog2 = builder2.create();
        dialog2.show();


        AlertDialog.Builder builder3 = new AlertDialog.Builder(this);
        builder3.setTitle("Mensaje");
        builder3.setMessage("Kate Winslet guarda su Oscar en el cuarto de baño " +
                "para que sus invitados puedan sostenerlo e improvisar sus propios" +
                " discursos de agradecimiento sin sentirse observados.");
        builder3.setPositiveButton("Ok", null);
        AlertDialog dialog3 = builder3.create();
        dialog3.show();

    }
    private void updateCountDownText(){


    }

}