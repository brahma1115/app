package com.simats.afinal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PatientHistoryAdapter extends RecyclerView.Adapter<PatientHistoryAdapter.ViewHolder> {

    private final Context context;
    private final List<PatientHistoryItem> historyItemList;

    public PatientHistoryAdapter(Context context, List<PatientHistoryItem> historyItemList) {
        this.context = context;
        this.historyItemList = historyItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_patient_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PatientHistoryItem item = historyItemList.get(position);

        holder.timestamp.setText(item.getTimestamp());
        holder.eventTitle.setText(item.getEventTitle());
        holder.eventDescription.setText(item.getEventDescription());
        holder.eventIcon.setImageResource(item.getEventIcon());
        holder.timelineDot.setImageResource(item.getDotDrawable());

        // First item ki top line hide cheyyali
        if (position == 0) {
            holder.timelineLineTop.setVisibility(View.INVISIBLE);
        } else {
            holder.timelineLineTop.setVisibility(View.VISIBLE);
        }

        // Last item ki bottom line hide cheyyali
        if (position == historyItemList.size() - 1) {
            holder.timelineLineBottom.setVisibility(View.INVISIBLE);
        } else {
            holder.timelineLineBottom.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return historyItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView timestamp, eventTitle, eventDescription;
        ImageView eventIcon, timelineDot;
        View timelineLineTop, timelineLineBottom;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            timestamp = itemView.findViewById(R.id.timestamp);
            eventTitle = itemView.findViewById(R.id.event_title);
            eventDescription = itemView.findViewById(R.id.event_description);
            eventIcon = itemView.findViewById(R.id.event_icon);
            timelineDot = itemView.findViewById(R.id.timeline_dot);
            timelineLineTop = itemView.findViewById(R.id.timeline_line_top);
            timelineLineBottom = itemView.findViewById(R.id.timeline_line_bottom);
        }
    }
}
