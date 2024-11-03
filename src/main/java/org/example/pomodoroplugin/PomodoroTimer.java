package org.example.pomodoroplugin;
import java.util.Timer;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.JBColor;


import javax.swing.*;


public class PomodoroTimer implements ToolWindowFactory {
    private static final int WORK_INTERVAL = 25 * 60 * 1000;
    private static final int BREAK_INTERVAL = 5 * 60 * 1000;
    private static final int LONG_BREAK_INTERVAL = 15 * 60 * 1000;
    private Timer timer;
    private int workIntervalCounter;

    @Override
    public void createToolWindowContent(Project project, ToolWindow toolWindow) {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Pomodoro Timer");
        label.setForeground(JBColor.RED);
        panel.add(label);
    }

    private void startPomodoro(JLabel label) {

    }

}
