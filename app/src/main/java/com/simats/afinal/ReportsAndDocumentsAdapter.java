package com.simats.afinal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReportsAndDocumentsAdapter extends RecyclerView.Adapter<ReportsAndDocumentsAdapter.ViewHolder> {

    private final Context context;
    private final List<Report> reportList;

    public ReportsAndDocumentsAdapter(Context context, List<Report> reportList) {
        this.context = context;
        this.reportList = reportList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_report, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Report report = reportList.get(position);

        holder.reportTitle.setText(report.getTitle());
        holder.reportDetails.setText(report.getDetails());

        // Share functionality
        holder.shareIcon.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Medical Report: " + report.getTitle());
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Shared Medical Report Details:\nTitle: " + report.getTitle() + "\nDate: " + report.getDetails());
            context.startActivity(Intent.createChooser(shareIntent, "Share Report via"));
        });

        // Download functionality
        holder.downloadIcon.setOnClickListener(v -> {
            Toast.makeText(context, "Downloading " + report.getTitle() + "...", Toast.LENGTH_LONG).show();
            // In a real app, you would handle file downloading logic here
        });
    }

    @Override
    public int getItemCount() {
        return reportList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView reportTitle, reportDetails;
        ImageView shareIcon, downloadIcon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            reportTitle = itemView.findViewById(R.id.report_title);
            reportDetails = itemView.findViewById(R.id.report_details);
            shareIcon = itemView.findViewById(R.id.share_icon);
            downloadIcon = itemView.findViewById(R.id.download_icon);
        }
    }
}
