package ru.denfad.yavdele.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;

import ru.denfad.yavdele.Model.Team;
import ru.denfad.yavdele.R;
import ru.denfad.yavdele.Service;
import ru.denfad.yavdele.activity.TeamProfileActivity;

public class TeamsFragment  extends Fragment {
    private List<Team> teams;
    private boolean bLockScroll = true;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        teams = Service.getInstance().getTeams();
        return inflater.inflate(R.layout.fragment_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView list = view.findViewById(R.id.list_teams);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new TeamsAdapter());

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

    class TeamsAdapter extends RecyclerView.Adapter<TeamBigViewHolder> {
        @NonNull
        @Override
        public TeamBigViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.item_big_team, parent, false);


            // Return a new holder instance
            TeamBigViewHolder viewHolder = new TeamBigViewHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull TeamBigViewHolder holder, int position) {
            Team team = teams.get(position);
            holder.name.setText(team.getName());
            holder.activity.setText(team.getActivity());
            holder.place.setText(team.getPlace());
            holder.description.setText(team.getDescription());
            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
            layoutManager.setFlexDirection(FlexDirection.ROW);
            layoutManager.setJustifyContent(JustifyContent.FLEX_START);

            holder.box.setLayoutManager(layoutManager);
            holder.box.setAdapter(new TagAdapter(team.getTags()));

            holder.about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), TeamProfileActivity.class);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return teams.size();
        }
    }
}
