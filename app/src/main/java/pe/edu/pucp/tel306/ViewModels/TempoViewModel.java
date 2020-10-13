package pe.edu.pucp.tel306.ViewModels;


import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TempoViewModel extends ViewModel {


    private MutableLiveData<Integer> contador = new MutableLiveData<>();
    private Thread thread = null;


    public void iniciarTemporizador(final TextView temporizador){
        if(thread == null){

            new CountDownTimer(2500, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    temporizador.setText("" + millisUntilFinished / 1000);

                }

                @Override
                public void onFinish() {

                }
            }.start();



        }


    }
}
