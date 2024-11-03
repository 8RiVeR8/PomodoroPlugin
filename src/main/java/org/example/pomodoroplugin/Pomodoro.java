package org.example.pomodoroplugin;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class Pomodoro extends AnAction {
    @Override
    public void actionPerformed(@NotNull AnActionEvent e) {
        JOptionPane.showMessageDialog(null, "Pomodoro Timer started!");
        var pomodoroTimer = new PomodoroTimer();

    }
}
