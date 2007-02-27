package com.worthsoln.patientview;

public class Panel {

    private int panel;
    private boolean currentPanel;

    public Panel() {
    }

    public Panel(int panel) {
        this.panel = panel;
    }

    public int getPanel() {
        return panel;
    }

    public void setPanel(int panel) {
        this.panel = panel;
    }

    public boolean isCurrentPanel() {
        return currentPanel;
    }

    public void setCurrentPanel(boolean currentPanel) {
        this.currentPanel = currentPanel;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Panel)) {
            return false;
        }
        final Panel panel1 = (Panel) o;
        if (panel != panel1.panel) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return panel;
    }

    public String toString() {
        return panel + "";
    }
}
