package com.hfad.facebookfeedlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rv = findViewById(R.id.recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));
        postAdapter = new PostAdapter();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(),
                DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this, R.drawable.divider));
        rv.addItemDecoration(dividerItemDecoration);

        rv.setAdapter(postAdapter);

        List<Post> posts = new ArrayList<>();

        Post post1 = new Post();
        post1.setImageViewUser(R.drawable.elon);
        post1.setImageViewPost(R.drawable.cybertruck);
        post1.setTextViewUserName("Ellon Muskq");
        post1.setTextViewTime("2 min");
        post1.setTextViewContent("Cybertruck is built with an exterior shell made for ultimate durability and passenger protection. Starting with a nearly impenetrable exoskeleton, every component is designed for superior strength and endurance, from Ultra-Hard 30X Cold-Rolled stainless-steel structural skin to Tesla armor glass.");
        post1.setTextViewTitle("https://www.tesla.com/cybertruck".toUpperCase());
        post1.setTextViewSubTitle("The Tesla Cybertruck is an all-electric battery-powered light commercial vehicle in development by Tesla, Inc. Three models have been announced, with range estimates of 250–500 miles (400–800 km) and an estimated 0–60 mph time of 2.9–6.5 seconds, depending on the model.");
        posts.add(post1);

        Post post2 = new Post();
        post2.setImageViewUser(R.drawable.viuva);
        post2.setImageViewPost(R.drawable.viuvanegra);
        post2.setTextViewUserName("Black Widow");
        post2.setTextViewTime("4 min");
        post2.setTextViewContent("Black Widow is an upcoming American superhero film based on the Marvel Comics character of the same name. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, it is intended to be the twenty-fourth film in the Marvel Cinematic Universe (MCU).");
        posts.add(post2);

        Post post3 = new Post();
        post3.setImageViewUser(R.drawable.xaiomi_icon);
        post3.setImageViewPost(R.drawable.xaiomi);
        post3.setTextViewUserName("Xaiomi");
        post3.setTextViewTime("6 min");
        post3.setTextViewContent("We may wonder what the phone will look like in the future as we are surrounded by more extensive information. Perhaps in the future, the entire mobile phone will look like a display. The display of Mi MIX Alpha extends from front to back. When the screen lights up, it's like the universe: no end and no boundaries, but a stunningly futuristic feeling.");
        post3.setTextViewTitle("https://www.mi.com/global/mi-mix-alpha".toUpperCase());
        post3.setTextViewSubTitle("Mi MIX Alpha is a futuristic phone that shows the many avenues for Xiaomi to explore during the 5G era Not all possibilities can be explored. We want to enable more possibilities for the future instead.");
        posts.add(post3);

        Post post4 = new Post();
        post4.setImageViewUser(R.drawable.thor_icon);
        post4.setImageViewPost(R.drawable.thor_gordo);
        post4.setTextViewUserName("Thor");
        post4.setTextViewTime("8 min");
        post4.setTextViewContent("The success story that is the Marvel Cinematic Universe is, in no small part, the success story of Christopher Markus and Stephen McFeely. The screenwriting duo has penned 6 of the 22 installments in the ultrafranchise, including the 3 films that required the most juggling of ensembles: Captain America: Civil War, Avengers: Infinity War, and this year’s Avengers: Endgame.");
        posts.add(post4);

        postAdapter.setPosts(posts);
        postAdapter.notifyDataSetChanged();
    }

    private static class PostViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageViewUser;
        private final TextView textViewTime;
        private final TextView textViewUserName;
        private final TextView textViewContent;
        private final ImageView imageViewPost;
        private final TextView textViewTitle;
        private final TextView textViewSubTitle;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewUser = itemView.findViewById(R.id.image_view_user);
            textViewTime = itemView.findViewById(R.id.text_view_time);
            textViewUserName = itemView.findViewById(R.id.text_view_username);
            textViewContent = itemView.findViewById(R.id.text_view_content);
            imageViewPost = itemView.findViewById(R.id.image_view_post);
            textViewTitle = itemView.findViewById(R.id.text_view_post_title);
            textViewSubTitle = itemView.findViewById(R.id.text_view_post_subtitle);
        }

        void bind(Post post){
            imageViewUser.setImageResource(post.getImageViewUser());
            textViewTime.setText(post.getTextViewTime());
            textViewUserName.setText(post.getTextViewUserName());
            textViewContent.setText(post.getTextViewContent());
            imageViewPost.setImageResource(post.getImageViewPost());
            textViewTitle.setText(post.getTextViewTitle());
            textViewSubTitle.setText(post.getTextViewSubTitle());

            if (post.getTextViewTitle() == null) {
                itemView.findViewById(R.id.post_container).setVisibility(View.GONE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post, "1:1");
                constraintSet.applyTo((ConstraintLayout) itemView);
            } else {
                itemView.findViewById(R.id.post_container).setVisibility(View.VISIBLE);
                ConstraintSet constraintSet = new ConstraintSet();
                constraintSet.clone((ConstraintLayout) itemView);
                constraintSet.setDimensionRatio(R.id.image_view_post, "16:9");
                constraintSet.applyTo((ConstraintLayout) itemView);
            }
        }
    }

    private class PostAdapter extends RecyclerView.Adapter<PostViewHolder>{

        private List<Post> posts = new ArrayList<>();

        @NonNull
        @Override
        public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.feed_item, parent, false);
            return new PostViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
            Post post = posts.get(position);
            holder.bind(post);
        }

        @Override
        public int getItemCount() {
            return posts.size();
        }

        public void setPosts(List<Post> posts){
            this.posts = posts;
        }
    }

    private class Post {

        private int imageViewUser;
        private String textViewTime;
        private String textViewUserName;
        private String textViewContent;
        private int imageViewPost;
        private String textViewTitle;
        private String textViewSubTitle;

        public int getImageViewUser() {
            return imageViewUser;
        }

        public void setImageViewUser(int imageViewUser) {
            this.imageViewUser = imageViewUser;
        }

        public String getTextViewTime() {
            return textViewTime;
        }

        public void setTextViewTime(String textViewTime) {
            this.textViewTime = textViewTime;
        }

        public String getTextViewUserName() {
            return textViewUserName;
        }

        public void setTextViewUserName(String textViewUserName) {
            this.textViewUserName = textViewUserName;
        }

        public String getTextViewContent() {
            return textViewContent;
        }

        public void setTextViewContent(String textViewContent) {
            this.textViewContent = textViewContent;
        }

        public int getImageViewPost() {
            return imageViewPost;
        }

        public void setImageViewPost(int imageViewPost) {
            this.imageViewPost = imageViewPost;
        }

        public String getTextViewTitle() {
            return textViewTitle;
        }

        public void setTextViewTitle(String textViewTitle) {
            this.textViewTitle = textViewTitle;
        }

        public String getTextViewSubTitle() {
            return textViewSubTitle;
        }

        public void setTextViewSubTitle(String textViewSubTitle) {
            this.textViewSubTitle = textViewSubTitle;
        }
    }
}
