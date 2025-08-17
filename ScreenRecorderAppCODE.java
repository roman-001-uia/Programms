import com.teamdev.jxcapture.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenRecorderApp extends JFrame {
    private ScreenCapture capture;
    private boolean recording = false;
    
    public ScreenRecorderApp() {
        initUI();
    }

    private void initUI() {
        setTitle("Screen Recorder");
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new FlowLayout());
        
        JButton startButton = new JButton("Начать запись");
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRecording();
            }
        });
        
        panel.add(startButton);
        add(panel);
    }

    private void startRecording() {
        if (!recording) {
            recording = true;
            capture = new ScreenCapture();
            
            try {
                // Настройка параметров записи
                capture.setOutputFile("output.mp4");
                capture.setFrameRate(30);
                capture.setQuality(80);
                
                // Начало записи
                capture.start();
                
                // Таймер для остановки записи
                new Thread(() -> {
                    try {
                        Thread.sleep(60000); // Запись длится 1 минуту
                        stopRecording();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void stopRecording() {
        if (recording) {
            recording = false;
            try {
                capture.stop();
                capture.release();
                System.out.println("Запись сохранена");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ScreenRecorderApp().setVisible(true);
        });
    }
}

