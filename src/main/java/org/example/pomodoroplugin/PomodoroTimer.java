package org.example.pomodoroplugin;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PomodoroTimer {
    private static final int WORK_INTERVAL = 25 * 60 * 1000;
    private static final int BREAK_INTERVAL =  5 * 60 * 1000;
    private static final int LONG_BREAK_INTERVAL = 15 * 60 * 1000;
    private static final int SESSIONS_BEFORE_LONG_BREAK = 4;
    private int workIntervalCounter = 0;
    private Timer timer;

    public void startPomodoro() {
        startWorkSession();
    }

    private void showMessage(String message) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(null, message));
    }

    private void startWorkSession() {
        workIntervalCounter++;
        playSound();
        showMessage("It's time for work! Session " + workIntervalCounter + "/" + SESSIONS_BEFORE_LONG_BREAK + " (25 minutes)");
        startTimer(WORK_INTERVAL, this::startBreakSession);
    }

    private void startTimer(int interval, Runnable onComplete) {
        timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
                onComplete.run();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    private void startBreakSession() {
        if (workIntervalCounter % SESSIONS_BEFORE_LONG_BREAK == 0) {
            showMessage("It's time for a Long Break (15 minutes)!");
            playSound();
            startTimer(LONG_BREAK_INTERVAL, this::startWorkSession);
        } else {
            playSound();
            showMessage("It's time for a Short Break (5 minutes)!");
            startTimer(BREAK_INTERVAL, this::startWorkSession);
        }
    }

    private void playSound() {
        Toolkit.getDefaultToolkit().beep();
    }

}
