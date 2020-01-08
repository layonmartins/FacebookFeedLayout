package com.hfad.facebookfeedlayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
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
        rv.setAdapter(postAdapter);


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

        public void setPosts(List<Post> post){
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
