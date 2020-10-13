package pe.edu.pucp.tel306.ViewModels;


import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TempoViewModel extends ViewModel {


    private MutableLiveData<Integer> tempo = new MutableLiveData<>(1500);
    private Thread thread = null;


    public void iniciarTemporizador(){

        if (getThread() == null) {

            setThread(new Thread(new Runnable() {
                @Override
                public void run() {

                    int tempoLocal = getTempo().getValue();

                    for (; tempoLocal >= 0; tempoLocal--) {
                        Log.d("tempoApp", String.valueOf(tempoLocal));

                        getTempo().postValue(tempoLocal);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    setThread(null);
                    if(tempoLocal == 0) {
                        getTempo().postValue(tempoLocal);
                    }
                }
            }));

            getThread().start();
        }





    }

    public void detenerTemporizador(){
        if(thread != null){
            thread.interrupt();
        }
    }

    public MutableLiveData<Integer> getTempo() {
        return tempo;
    }

    public void setTempo(MutableLiveData<Integer> tempo) {
        this.tempo = tempo;
    }

    public Thread getThread() {
        return thread;
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}
