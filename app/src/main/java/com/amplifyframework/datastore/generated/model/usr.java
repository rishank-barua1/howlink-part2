package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;
import com.amplifyframework.core.model.annotations.HasMany;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the usr type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "usrs")
public final class usr implements Model {
  public static final QueryField ID = field("usr", "id");
  public static final QueryField USER_NAME = field("usr", "user_name");
  public static final QueryField DATE = field("usr", "date");
  public static final QueryField EMAIL_ID = field("usr", "email_id");
  public static final QueryField PHONE_NUM = field("usr", "phone_num");
  public static final QueryField PASSSWORD = field("usr", "passsword");
  public static final QueryField NUM_POST = field("usr", "num_post");
  public static final QueryField FOLLOWER = field("usr", "follower");
  public static final QueryField FOLLOWING = field("usr", "following");
  public static final QueryField PROFILE_PIC = field("usr", "profile_pic");
  public static final QueryField COVER_PIC = field("usr", "cover_pic");
  public static final QueryField BIO = field("usr", "bio");
  public static final QueryField NUM_CHANNEL = field("usr", "num_channel");
  public static final QueryField NUM_DEALS = field("usr", "num_deals");
  public static final QueryField PINCODE = field("usr", "pincode");
  public static final QueryField TEHSIL = field("usr", "tehsil");
  public static final QueryField DISTRICT = field("usr", "District");
  public static final QueryField STATE = field("usr", "State");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String user_name;
  private final @ModelField(targetType="AWSTimestamp") Temporal.Timestamp date;
  private final @ModelField(targetType="String", isRequired = true) String email_id;
  private final @ModelField(targetType="AWSPhone", isRequired = true) String phone_num;
  private final @ModelField(targetType="String", isRequired = true) String passsword;
  private final @ModelField(targetType="Int", isRequired = true) Integer num_post;
  private final @ModelField(targetType="Int", isRequired = true) Integer follower;
  private final @ModelField(targetType="Int", isRequired = true) Integer following;
  private final @ModelField(targetType="AWSURL", isRequired = true) String profile_pic;
  private final @ModelField(targetType="AWSURL", isRequired = true) String cover_pic;
  private final @ModelField(targetType="String", isRequired = true) String bio;
  private final @ModelField(targetType="Int", isRequired = true) Integer num_channel;
  private final @ModelField(targetType="Int", isRequired = true) Integer num_deals;
  private final @ModelField(targetType="String", isRequired = true) String pincode;
  private final @ModelField(targetType="String", isRequired = true) String tehsil;
  private final @ModelField(targetType="String", isRequired = true) String District;
  private final @ModelField(targetType="String", isRequired = true) String State;
  private final @ModelField(targetType="post") @HasMany(associatedWith = "post", type = post.class) List<post> posts = null;
  public String getId() {
      return id;
  }
  
  public String getUserName() {
      return user_name;
  }
  
  public Temporal.Timestamp getDate() {
      return date;
  }
  
  public String getEmailId() {
      return email_id;
  }
  
  public String getPhoneNum() {
      return phone_num;
  }
  
  public String getPasssword() {
      return passsword;
  }
  
  public Integer getNumPost() {
      return num_post;
  }
  
  public Integer getFollower() {
      return follower;
  }
  
  public Integer getFollowing() {
      return following;
  }
  
  public String getProfilePic() {
      return profile_pic;
  }
  
  public String getCoverPic() {
      return cover_pic;
  }
  
  public String getBio() {
      return bio;
  }
  
  public Integer getNumChannel() {
      return num_channel;
  }
  
  public Integer getNumDeals() {
      return num_deals;
  }
  
  public String getPincode() {
      return pincode;
  }
  
  public String getTehsil() {
      return tehsil;
  }
  
  public String getDistrict() {
      return District;
  }
  
  public String getState() {
      return State;
  }
  
  public List<post> getPosts() {
      return posts;
  }
  
  private usr(String id, String user_name, Temporal.Timestamp date, String email_id, String phone_num, String passsword, Integer num_post, Integer follower, Integer following, String profile_pic, String cover_pic, String bio, Integer num_channel, Integer num_deals, String pincode, String tehsil, String District, String State) {
    this.id = id;
    this.user_name = user_name;
    this.date = date;
    this.email_id = email_id;
    this.phone_num = phone_num;
    this.passsword = passsword;
    this.num_post = num_post;
    this.follower = follower;
    this.following = following;
    this.profile_pic = profile_pic;
    this.cover_pic = cover_pic;
    this.bio = bio;
    this.num_channel = num_channel;
    this.num_deals = num_deals;
    this.pincode = pincode;
    this.tehsil = tehsil;
    this.District = District;
    this.State = State;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      usr usr = (usr) obj;
      return ObjectsCompat.equals(getId(), usr.getId()) &&
              ObjectsCompat.equals(getUserName(), usr.getUserName()) &&
              ObjectsCompat.equals(getDate(), usr.getDate()) &&
              ObjectsCompat.equals(getEmailId(), usr.getEmailId()) &&
              ObjectsCompat.equals(getPhoneNum(), usr.getPhoneNum()) &&
              ObjectsCompat.equals(getPasssword(), usr.getPasssword()) &&
              ObjectsCompat.equals(getNumPost(), usr.getNumPost()) &&
              ObjectsCompat.equals(getFollower(), usr.getFollower()) &&
              ObjectsCompat.equals(getFollowing(), usr.getFollowing()) &&
              ObjectsCompat.equals(getProfilePic(), usr.getProfilePic()) &&
              ObjectsCompat.equals(getCoverPic(), usr.getCoverPic()) &&
              ObjectsCompat.equals(getBio(), usr.getBio()) &&
              ObjectsCompat.equals(getNumChannel(), usr.getNumChannel()) &&
              ObjectsCompat.equals(getNumDeals(), usr.getNumDeals()) &&
              ObjectsCompat.equals(getPincode(), usr.getPincode()) &&
              ObjectsCompat.equals(getTehsil(), usr.getTehsil()) &&
              ObjectsCompat.equals(getDistrict(), usr.getDistrict()) &&
              ObjectsCompat.equals(getState(), usr.getState());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUserName())
      .append(getDate())
      .append(getEmailId())
      .append(getPhoneNum())
      .append(getPasssword())
      .append(getNumPost())
      .append(getFollower())
      .append(getFollowing())
      .append(getProfilePic())
      .append(getCoverPic())
      .append(getBio())
      .append(getNumChannel())
      .append(getNumDeals())
      .append(getPincode())
      .append(getTehsil())
      .append(getDistrict())
      .append(getState())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("usr {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("user_name=" + String.valueOf(getUserName()) + ", ")
      .append("date=" + String.valueOf(getDate()) + ", ")
      .append("email_id=" + String.valueOf(getEmailId()) + ", ")
      .append("phone_num=" + String.valueOf(getPhoneNum()) + ", ")
      .append("passsword=" + String.valueOf(getPasssword()) + ", ")
      .append("num_post=" + String.valueOf(getNumPost()) + ", ")
      .append("follower=" + String.valueOf(getFollower()) + ", ")
      .append("following=" + String.valueOf(getFollowing()) + ", ")
      .append("profile_pic=" + String.valueOf(getProfilePic()) + ", ")
      .append("cover_pic=" + String.valueOf(getCoverPic()) + ", ")
      .append("bio=" + String.valueOf(getBio()) + ", ")
      .append("num_channel=" + String.valueOf(getNumChannel()) + ", ")
      .append("num_deals=" + String.valueOf(getNumDeals()) + ", ")
      .append("pincode=" + String.valueOf(getPincode()) + ", ")
      .append("tehsil=" + String.valueOf(getTehsil()) + ", ")
      .append("District=" + String.valueOf(getDistrict()) + ", ")
      .append("State=" + String.valueOf(getState()))
      .append("}")
      .toString();
  }
  
  public static UserNameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static usr justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new usr(
      id,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      user_name,
      date,
      email_id,
      phone_num,
      passsword,
      num_post,
      follower,
      following,
      profile_pic,
      cover_pic,
      bio,
      num_channel,
      num_deals,
      pincode,
      tehsil,
      District,
      State);
  }
  public interface UserNameStep {
    EmailIdStep userName(String userName);
  }
  

  public interface EmailIdStep {
    PhoneNumStep emailId(String emailId);
  }
  

  public interface PhoneNumStep {
    PassswordStep phoneNum(String phoneNum);
  }
  

  public interface PassswordStep {
    NumPostStep passsword(String passsword);
  }
  

  public interface NumPostStep {
    FollowerStep numPost(Integer numPost);
  }
  

  public interface FollowerStep {
    FollowingStep follower(Integer follower);
  }
  

  public interface FollowingStep {
    ProfilePicStep following(Integer following);
  }
  

  public interface ProfilePicStep {
    CoverPicStep profilePic(String profilePic);
  }
  

  public interface CoverPicStep {
    BioStep coverPic(String coverPic);
  }
  

  public interface BioStep {
    NumChannelStep bio(String bio);
  }
  

  public interface NumChannelStep {
    NumDealsStep numChannel(Integer numChannel);
  }
  

  public interface NumDealsStep {
    PincodeStep numDeals(Integer numDeals);
  }
  

  public interface PincodeStep {
    TehsilStep pincode(String pincode);
  }
  

  public interface TehsilStep {
    DistrictStep tehsil(String tehsil);
  }
  

  public interface DistrictStep {
    StateStep district(String district);
  }
  

  public interface StateStep {
    BuildStep state(String state);
  }
  

  public interface BuildStep {
    usr build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep date(Temporal.Timestamp date);
  }
  

  public static class Builder implements UserNameStep, EmailIdStep, PhoneNumStep, PassswordStep, NumPostStep, FollowerStep, FollowingStep, ProfilePicStep, CoverPicStep, BioStep, NumChannelStep, NumDealsStep, PincodeStep, TehsilStep, DistrictStep, StateStep, BuildStep {
    private String id;
    private String user_name;
    private String email_id;
    private String phone_num;
    private String passsword;
    private Integer num_post;
    private Integer follower;
    private Integer following;
    private String profile_pic;
    private String cover_pic;
    private String bio;
    private Integer num_channel;
    private Integer num_deals;
    private String pincode;
    private String tehsil;
    private String District;
    private String State;
    private Temporal.Timestamp date;
    @Override
     public usr build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new usr(
          id,
          user_name,
          date,
          email_id,
          phone_num,
          passsword,
          num_post,
          follower,
          following,
          profile_pic,
          cover_pic,
          bio,
          num_channel,
          num_deals,
          pincode,
          tehsil,
          District,
          State);
    }
    
    @Override
     public EmailIdStep userName(String userName) {
        Objects.requireNonNull(userName);
        this.user_name = userName;
        return this;
    }
    
    @Override
     public PhoneNumStep emailId(String emailId) {
        Objects.requireNonNull(emailId);
        this.email_id = emailId;
        return this;
    }
    
    @Override
     public PassswordStep phoneNum(String phoneNum) {
        Objects.requireNonNull(phoneNum);
        this.phone_num = phoneNum;
        return this;
    }
    
    @Override
     public NumPostStep passsword(String passsword) {
        Objects.requireNonNull(passsword);
        this.passsword = passsword;
        return this;
    }
    
    @Override
     public FollowerStep numPost(Integer numPost) {
        Objects.requireNonNull(numPost);
        this.num_post = numPost;
        return this;
    }
    
    @Override
     public FollowingStep follower(Integer follower) {
        Objects.requireNonNull(follower);
        this.follower = follower;
        return this;
    }
    
    @Override
     public ProfilePicStep following(Integer following) {
        Objects.requireNonNull(following);
        this.following = following;
        return this;
    }
    
    @Override
     public CoverPicStep profilePic(String profilePic) {
        Objects.requireNonNull(profilePic);
        this.profile_pic = profilePic;
        return this;
    }
    
    @Override
     public BioStep coverPic(String coverPic) {
        Objects.requireNonNull(coverPic);
        this.cover_pic = coverPic;
        return this;
    }
    
    @Override
     public NumChannelStep bio(String bio) {
        Objects.requireNonNull(bio);
        this.bio = bio;
        return this;
    }
    
    @Override
     public NumDealsStep numChannel(Integer numChannel) {
        Objects.requireNonNull(numChannel);
        this.num_channel = numChannel;
        return this;
    }
    
    @Override
     public PincodeStep numDeals(Integer numDeals) {
        Objects.requireNonNull(numDeals);
        this.num_deals = numDeals;
        return this;
    }
    
    @Override
     public TehsilStep pincode(String pincode) {
        Objects.requireNonNull(pincode);
        this.pincode = pincode;
        return this;
    }
    
    @Override
     public DistrictStep tehsil(String tehsil) {
        Objects.requireNonNull(tehsil);
        this.tehsil = tehsil;
        return this;
    }
    
    @Override
     public StateStep district(String district) {
        Objects.requireNonNull(district);
        this.District = district;
        return this;
    }
    
    @Override
     public BuildStep state(String state) {
        Objects.requireNonNull(state);
        this.State = state;
        return this;
    }
    
    @Override
     public BuildStep date(Temporal.Timestamp date) {
        this.date = date;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String userName, Temporal.Timestamp date, String emailId, String phoneNum, String passsword, Integer numPost, Integer follower, Integer following, String profilePic, String coverPic, String bio, Integer numChannel, Integer numDeals, String pincode, String tehsil, String district, String state) {
      super.id(id);
      super.userName(userName)
        .emailId(emailId)
        .phoneNum(phoneNum)
        .passsword(passsword)
        .numPost(numPost)
        .follower(follower)
        .following(following)
        .profilePic(profilePic)
        .coverPic(coverPic)
        .bio(bio)
        .numChannel(numChannel)
        .numDeals(numDeals)
        .pincode(pincode)
        .tehsil(tehsil)
        .district(district)
        .state(state)
        .date(date);
    }
    
    @Override
     public CopyOfBuilder userName(String userName) {
      return (CopyOfBuilder) super.userName(userName);
    }
    
    @Override
     public CopyOfBuilder emailId(String emailId) {
      return (CopyOfBuilder) super.emailId(emailId);
    }
    
    @Override
     public CopyOfBuilder phoneNum(String phoneNum) {
      return (CopyOfBuilder) super.phoneNum(phoneNum);
    }
    
    @Override
     public CopyOfBuilder passsword(String passsword) {
      return (CopyOfBuilder) super.passsword(passsword);
    }
    
    @Override
     public CopyOfBuilder numPost(Integer numPost) {
      return (CopyOfBuilder) super.numPost(numPost);
    }
    
    @Override
     public CopyOfBuilder follower(Integer follower) {
      return (CopyOfBuilder) super.follower(follower);
    }
    
    @Override
     public CopyOfBuilder following(Integer following) {
      return (CopyOfBuilder) super.following(following);
    }
    
    @Override
     public CopyOfBuilder profilePic(String profilePic) {
      return (CopyOfBuilder) super.profilePic(profilePic);
    }
    
    @Override
     public CopyOfBuilder coverPic(String coverPic) {
      return (CopyOfBuilder) super.coverPic(coverPic);
    }
    
    @Override
     public CopyOfBuilder bio(String bio) {
      return (CopyOfBuilder) super.bio(bio);
    }
    
    @Override
     public CopyOfBuilder numChannel(Integer numChannel) {
      return (CopyOfBuilder) super.numChannel(numChannel);
    }
    
    @Override
     public CopyOfBuilder numDeals(Integer numDeals) {
      return (CopyOfBuilder) super.numDeals(numDeals);
    }
    
    @Override
     public CopyOfBuilder pincode(String pincode) {
      return (CopyOfBuilder) super.pincode(pincode);
    }
    
    @Override
     public CopyOfBuilder tehsil(String tehsil) {
      return (CopyOfBuilder) super.tehsil(tehsil);
    }
    
    @Override
     public CopyOfBuilder district(String district) {
      return (CopyOfBuilder) super.district(district);
    }
    
    @Override
     public CopyOfBuilder state(String state) {
      return (CopyOfBuilder) super.state(state);
    }
    
    @Override
     public CopyOfBuilder date(Temporal.Timestamp date) {
      return (CopyOfBuilder) super.date(date);
    }
  }
  
}
