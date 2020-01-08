package com.hfad.facebookfeedlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        posts.add(post1);

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
