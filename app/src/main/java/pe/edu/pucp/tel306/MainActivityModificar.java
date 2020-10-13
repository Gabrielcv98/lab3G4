package pe.edu.pucp.tel306;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class MainActivityModificar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_modificar);
        setTitle("Editar");

        Button buttoncambios = findViewById(R.id.buttonCambios);

        buttoncambios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editTextPomodoro = findViewById(R.id.editTextPomodoro);
                EditText editTextDescanso = findViewById(R.id.editTextDescanso);
                EditText editTextCiclo = findViewById(R.id.editTextCiclos);

                String pomodoro = editTextPomodoro.getText().toString();
                String descanso = editTextDescanso.getText().toString();
                String ciclo = editTextCiclo.getText().toString();

                /*if (pomodoro.isEmpty()){
                    editTextPomodoro.setError("no puede ser vacío");
                }

                if (descanso.isEmpty()){
                    editTextDescanso.setError("no puede ser vacío");
                }

                if (ciclo.isEmpty()){
                    editTextCiclo.setError("no puede ser vacío");
                }*/


                try {

                    Integer pomodoroValor = Integer.valueOf(pomodoro);

                }catch (NumberFormatException e){
                    editTextPomodoro.setError("Debe ingresar un número entero");
                }

                try {

                    Integer descansoValor = Integer.valueOf(descanso);

                }catch (NumberFormatException e){
                    editTextDescanso.setError("Debe ingresar un número entero");
                }

                try {

                    Integer cicloValor = Integer.valueOf(ciclo);

                }catch (NumberFormatException e){
                    editTextCiclo.setError("Debe ingresar un número entero");
                }

                if (!pomodoro.isEmpty() && !descanso.isEmpty() && !ciclo.isEmpty()){

                    Intent intent = new Intent(MainActivityModificar.this, MainActivity.class);
                    intent.putExtra("pomodoroValor", Integer.valueOf(pomodoro));
                    intent.putExtra("descansoValor", Integer.valueOf(descanso));
                    intent.putExtra("cicloValor", Integer.valueOf(ciclo));
                    startActivity(new Intent(MainActivityModificar.this, MainActivity.class));

                }


            }
        });

    }
}