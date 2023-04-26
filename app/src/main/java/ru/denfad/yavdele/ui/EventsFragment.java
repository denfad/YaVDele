package ru.denfad.yavdele.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.pdf.PdfRenderer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.ArrayList;
import java.util.List;

import ru.denfad.yavdele.Model.Event;
import ru.denfad.yavdele.R;
import ru.denfad.yavdele.Service;
import ru.denfad.yavdele.activity.EventActivity;
import ru.denfad.yavdele.activity.SplashActivity;

public class EventsFragment extends Fragment {
    private List<Event> events = new ArrayList<>();
    private boolean bLockScroll = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        events = Service.getInstance().getEvents();
        return inflater.inflate(R.layout.fragment_news, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView list = view.findViewById(R.id.list_events);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new EventsAdapter());
        PagerSnapHelper p = new PagerSnapHelper();
        LinearSnapHelper l = new LinearSnapHelper();
        p.attachToRecyclerView(list);

//        ImageButton lockScroll = view.findViewById(R.id.lock_scroll);
//        lockScroll.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                if(bLockScroll) {
//                    lockScroll.setImageResource(R.drawable.unlock);
//                    bLockScroll = false;
//                    p.attachToRecyclerView(null);
//                    l.attachToRecyclerView(list);
//                } else {
//                    lockScroll.setImageResource(R.drawable.lock);
//                    bLockScroll = true;
//                    l.attachToRecyclerView(null);
//                    p.attachToRecyclerView(list);
//                }
//            }
//        });

    }

    class EventsAdapter extends RecyclerView.Adapter<EventViewHolder> {

        @NonNull
        @Override
        public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.item_event, parent, false);

            // Return a new holder instance
            EventViewHolder viewHolder = new EventViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
            Event e = events.get(position);
            holder.name.setText(e.getName());
            holder.date.setText(e.getDate());
            holder.place.setText(e.getPlace() + "📍");
            holder.online.setText(e.getOnline());

            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
            layoutManager.setFlexDirection(FlexDirection.ROW);
            layoutManager.setJustifyContent(JustifyContent.FLEX_START);
            holder.box.setLayoutManager(layoutManager);
            holder.box.setAdapter(new TagAdapter(e.getTags()));

            holder.about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent mainIntent = new Intent(getContext(), EventActivity.class);
                    startActivity(mainIntent);
                }
            });



        }

        @Override
        public int getItemCount() {
            return events.size();
        }
    }


}
