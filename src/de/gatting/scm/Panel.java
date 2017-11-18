package de.gatting.scm;

import com.intellij.openapi.project.Project;
import git4idea.GitLocalBranch;
import git4idea.branch.GitBranchUtil;

import javax.swing.*;
import java.util.Arrays;


public class Panel {
    private JPanel mainPanel;
    private JTextField ticket;
    private JTextField shortDescription;
    private JTextArea longDescription;

    Panel(Project project) {
        GitLocalBranch currentBranch = GitBranchUtil.getCurrentRepository(project).getCurrentBranch();
        if (currentBranch != null) {
            // Branch name  matches Ticket Name
            String branch = currentBranch.getName().trim();
            // If e.g feature branch feature/ZCORE-1234
            if (branch.contains("-")) {
                String[] parts = branch.split("-");
                ticket.setText(parts[0] + "-" + parts[1]);
                shortDescription.setText(String.join(" ", Arrays.copyOfRange(parts, 2, parts.length)).trim());
            } else {
                ticket.setText(currentBranch.getName());
            }
        }
    }

    JPanel getMainPanel() {
        return mainPanel;
    }

    public String getTicket() {
        return this.ticket.getText();
    }

    public String getShortDescription() {
        return shortDescription.getText().trim();
    }

}