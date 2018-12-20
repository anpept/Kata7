package watch;

import java.time.LocalTime;
import javax.swing.JFrame;

public class Main extends JFrame{
    
    public static void main (String[] args){
        new Main().execute();
    }
    
    public Main(){
        LocalTime sysHour = LocalTime.now();
        Watch watch = new Watch(sysHour.getSecond(), sysHour.getMinute(), sysHour.getHour());
        WatchDisplay display = new WatchDisplay();
        new WatchPresenter(watch, display);
        this.setTitle("Reloj Analógico");
        this.setSize(400,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(display);
    }
    
    public void execute(){
        this.setVisible(true);
    }
    
}
