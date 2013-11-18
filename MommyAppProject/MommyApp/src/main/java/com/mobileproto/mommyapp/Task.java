package com.mobileproto.mommyapp;

/**
 * Created by Chloe Local on 11/13/13.
 */
public class Task {

    String text;
    Boolean isPublic;
    Boolean done;

    public Task(String text, Boolean isPublic, Boolean completed){
        this.isPublic = isPublic;
        this.text = text;
        this.done = completed;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Boolean getStatus() {
        return done;
    }

    public void setStatus(Boolean status) {
        this.done = status;
    }


}
