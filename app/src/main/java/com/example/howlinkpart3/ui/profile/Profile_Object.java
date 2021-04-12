package com.example.howlinkpart3.ui.profile;

public class Profile_Object {
    String name,bio,filepath;
    public Profile_Object(String name,String bio,String filepath)
    {
        this.name = name; this.bio = bio;this.filepath=filepath;
    }

    public String getBio() { return bio; }

    public String getFilepath() { return filepath; }

    public String getName() { return name; }

    public void setBio(String bio) { this.bio = bio; }

    public void setFilepath(String filepath) { this.filepath = filepath; }

    public void setName(String name) { this.name = name; }
}
