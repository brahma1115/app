package com.simats.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatientRiskAdapter extends RecyclerView.Adapter<PatientRiskAdapter.ViewHolder> {

    private final Context context;
    private final List<PatientRisk> patientRiskList;

    public PatientRiskAdapter(Context context, List<PatientRisk> patientRiskList) {
        this.context = context;
        this.patientRiskList = patientRiskList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_patient_risk, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PatientRisk patientRisk = patientRiskList.get(position);

        holder.riskScore.setText(String.valueOf(patientRisk.getRiskScore()));
        holder.patientName.setText(patientRisk.getPatientName());
        holder.patientIcu.setText(patientRisk.getPatientIcu());
        holder.graphIcon.setImageResource(patientRisk.getGraphIcon());

        if (patientRisk.getRiskLevel().equals("High")) {
            holder.riskScore.setBackgroundResource(R.drawable.risk_score_high_background);
            holder.riskScore.setTextColor(context.getResources().getColor(R.color.high_risk));
        } else if (patientRisk.getRiskLevel().equals("Medium")) {
            holder.riskScore.setBackgroundResource(R.drawable.risk_score_medium_background);
            holder.riskScore.setTextColor(context.getResources().getColor(R.color.medium_risk));
        } else {
            holder.riskScore.setBackgroundResource(R.drawable.risk_score_low_background);
            holder.riskScore.setTextColor(context.getResources().getColor(R.color.low_risk));
        }

        ConstraintLayout layout = (ConstraintLayout) holder.itemView;
        Flow flow = layout.findViewById(R.id.flow);

        int[] tagIds = new int[patientRisk.getRiskFactors().size()];

        for (int i = 0; i < patientRisk.getRiskFactors().size(); i++) {
            TextView tagView = new TextView(context);
            tagView.setId(View.generateViewId());
            tagView.setText(patientRisk.getRiskFactors().get(i));
            tagView.setBackgroundResource(R.drawable.tag_background);
            tagView.setPadding(16, 8, 16, 8);
            layout.addView(tagView);
            tagIds[i] = tagView.getId();
        }

        flow.setReferencedIds(tagIds);
    }

    @Override
    public int getItemCount() {
        return patientRiskList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView riskScore, patientName, patientIcu;
        ImageView graphIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            riskScore = itemView.findViewById(R.id.riskScore);
            patientName = itemView.findViewById(R.id.patientName);
            patientIcu = itemView.findViewById(R.id.patientIcu);
            graphIcon = itemView.findViewById(R.id.graphIcon);
        }
    }
}
