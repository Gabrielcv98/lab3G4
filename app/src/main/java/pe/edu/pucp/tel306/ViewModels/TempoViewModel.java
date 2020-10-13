package pe.edu.pucp.tel306.ViewModels;


import android.util.Log;
import android.widget.TextView;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TempoViewModel extends ViewModel {


    private MutableLiveData<Integer> tempo = new MutableLiveData<>(1500);

    private MutableLiveData<Integer> descanso = new MutableLiveData<>(300);
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
    public void iniciarDescanso() {

        if (getThread() == null) {

            setThread(new Thread(new Runnable() {
                @Override
                public void run() {

                    int descansoLocal = getTempo().getValue();

                    for (; descansoLocal >= 0; descansoLocal--) {
                        Log.d("descansoApp", String.valueOf(descansoLocal));

                        getDescanso().postValue(descansoLocal);

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            break;
                        }
                    }
                    setThread(null);
                    if (descansoLocal == 0) {
                        getDescanso().postValue(descansoLocal);
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

    public MutableLiveData<Integer> getDescanso() {
        return descanso;
    }

    public void setDescanso(MutableLiveData<Integer> descanso) {
        this.descanso = descanso;
    }
}
