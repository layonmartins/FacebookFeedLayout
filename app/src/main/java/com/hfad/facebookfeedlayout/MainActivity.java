package com.hfad.facebookfeedlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
