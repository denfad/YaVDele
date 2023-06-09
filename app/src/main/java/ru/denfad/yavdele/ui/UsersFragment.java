package ru.denfad.yavdele.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.google.android.flexbox.JustifyContent;

import java.util.List;
import java.util.Random;

import ru.denfad.yavdele.Model.Team;
import ru.denfad.yavdele.Model.User;
import ru.denfad.yavdele.R;
import ru.denfad.yavdele.Service;
import ru.denfad.yavdele.activity.TeamProfileActivity;
import ru.denfad.yavdele.activity.UserProfileActivity;

public class UsersFragment extends Fragment {
    private List<User> users;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        users = Service.getInstance().getUsers();
        return inflater.inflate(R.layout.fragment_users, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RecyclerView list = view.findViewById(R.id.list_users);
        list.setLayoutManager(new LinearLayoutManager(getContext()));
        list.setAdapter(new UsersAdapter());
    }

    class UsersAdapter extends RecyclerView.Adapter<UserBigHolder> {
        private View selectedCard = null;

        @NonNull
        @Override
        public UserBigHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.item_big_user, parent, false);

            // Return a new holder instance
            UserBigHolder viewHolder = new UserBigHolder(contactView);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull UserBigHolder holder, int position) {
            User user = users.get(position);
            holder.name.setText(user.getName());
            holder.place.setText(user.getPlace()+ "📍");
            FlexboxLayoutManager layoutManager = new FlexboxLayoutManager(getContext());
            layoutManager.setFlexDirection(FlexDirection.ROW);
            layoutManager.setJustifyContent(JustifyContent.FLEX_START);

            holder.box.setLayoutManager(layoutManager);
            holder.box.setAdapter(new TagAdapter(user.getTags()));

            holder.about.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getContext(), UserProfileActivity.class);
                    startActivity(intent);
                }
            });

            int r = new Random().nextInt(4)+1;
            Resources resources = getContext().getResources();
            final int resourceId = resources.getIdentifier("photo"+r, "drawable",
                    getContext().getPackageName());
            holder.image.setImageResource(resourceId);

            holder.view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(selectedCard ==  holder.view) {
                        holder.view.findViewById(R.id.expanded_information).setVisibility(View.GONE);
                        TransitionManager.beginDelayedTransition((CardView) holder.view, new AutoTransition());
                        selectedCard = null;
                    }
                    else if(selectedCard != null) {
                        selectedCard.findViewById(R.id.expanded_information).setVisibility(View.GONE);
                        TransitionManager.beginDelayedTransition((CardView)selectedCard, new AutoTransition());
                        selectedCard =  holder.view;
                        holder.view.findViewById(R.id.expanded_information).setVisibility(View.VISIBLE);
                        TransitionManager.beginDelayedTransition((CardView) holder.view, new AutoTransition());
                    } else {
                        selectedCard =  holder.view;
                        holder.view.findViewById(R.id.expanded_information).setVisibility(View.VISIBLE);
                        TransitionManager.beginDelayedTransition((CardView) holder.view, new AutoTransition());
                    }
                }
            });
        }

        @Override
        public int getItemCount() {
            return users.size();
        }
    }
}

