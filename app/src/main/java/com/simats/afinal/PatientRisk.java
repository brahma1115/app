package com.simats.afinal;

import java.util.List;

public class PatientRisk {
    private final int riskScore;
    private final String patientName;
    private final String patientIcu;
    private final List<String> riskFactors;
    private final int graphIcon;
    private final String riskLevel;

    public PatientRisk(int riskScore, String patientName, String patientIcu, List<String> riskFactors, int graphIcon, String riskLevel) {
        this.riskScore = riskScore;
        this.patientName = patientName;
        this.patientIcu = patientIcu;
        this.riskFactors = riskFactors;
        this.graphIcon = graphIcon;
        this.riskLevel = riskLevel;
    }

    public int getRiskScore() {
        return riskScore;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getPatientIcu() {
        return patientIcu;
    }

    public List<String> getRiskFactors() {
        return riskFactors;
    }

    public int getGraphIcon() {
        return graphIcon;
    }

    public String getRiskLevel() {
        return riskLevel;
    }
}
