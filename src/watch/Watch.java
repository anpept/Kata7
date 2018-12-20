package watch;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

public class Watch {
    private static final double SecondStep = 2*Math.PI / 60;
    private static final double MinuteStep = SecondStep/60;
    private static final double HourStep = MinuteStep/24;
    private double seconds;
    private double minutes;
    private double hours;
    private final Timer timer;
    private final List<Observer> observers = new ArrayList<>();
    
    public Watch(int seconds, int minutes, int hours){
        this.seconds = (Math.PI/2) + seconds * SecondStep;
        this.minutes = (Math.PI/2) + minutes * SecondStep;
        this.hours = (Math.PI/2) + (hours % 12) * (Math.PI/6);
        timer = new Timer();
        timer.schedule(timerTask(), 0, 1000);
    }

    public double getSeconds() {
        return seconds;
    }

    public double getMinutes() {
        return minutes;
    }

    public double getHours() {
        return hours;
    }

    private TimerTask timerTask() {
        return new TimerTask() {
            @Override
            public void run() {
                step();
                updateObserver();
            }
        };
    }
    
    private void updateObserver() {
        for (Observer observer : observers){
            observer.update(null, null);
        }
    }
    
    private void step() {
        seconds = normalizar(seconds + SecondStep);
        minutes = normalizar(minutes + MinuteStep);
        hours = normalizar(hours + HourStep);
    }   

    private double normalizar(double d) {
        return (d % (Math.PI*2));
    }

    void add(Observer o) {
        observers.add(o);
    }
    
}
