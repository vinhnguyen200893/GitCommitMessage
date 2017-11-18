package de.gatting.scm;

import com.intellij.ide.plugins.IdeaPluginDescriptor;
import com.intellij.ide.plugins.PluginManager;
import com.intellij.openapi.extensions.PluginId;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.DialogWrapper;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PanelDialog extends DialogWrapper {


    private final Panel panel;

    PanelDialog(@Nullable Project project) {
        super(project);
        panel = new Panel(project);
        IdeaPluginDescriptor pluginDescriptor = PluginManager.getPlugin(PluginId.getId("git-commit-message-plugin-for-dotmark"));

        setTitle("Git Commit Message For Zazu Team");
        setOKButtonText("OK");
        setSize(300, 200);
        init();
    }

    @Nullable
    @Override
    protected JComponent createCenterPanel() {
        return panel.getMainPanel();
    }

    String getCommitMessage(Project project) {
        return (panel.getTicket()).toLowerCase() + " " + panel.getShortDescription();
    }
}