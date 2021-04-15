package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;

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

/** This is an auto generated class representing the comment type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "comments")
@Index(name = "bycomm", fields = {"post_id","comm_id"})
public final class comment implements Model {
  public static final QueryField ID = field("comment", "id");
  public static final QueryField COMM_ID = field("comment", "comm_id");
  public static final QueryField MESSAGE = field("comment", "message");
  public static final QueryField POST = field("comment", "post_id");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="ID", isRequired = true) String comm_id;
  private final @ModelField(targetType="String", isRequired = true) String message;
  private final @ModelField(targetType="post") @BelongsTo(targetName = "post_id", type = post.class) post post;
  public String getId() {
      return id;
  }
  
  public String getCommId() {
      return comm_id;
  }
  
  public String getMessage() {
      return message;
  }
  
  public post getPost() {
      return post;
  }
  
  private comment(String id, String comm_id, String message, post post) {
    this.id = id;
    this.comm_id = comm_id;
    this.message = message;
    this.post = post;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      comment comment = (comment) obj;
      return ObjectsCompat.equals(getId(), comment.getId()) &&
              ObjectsCompat.equals(getCommId(), comment.getCommId()) &&
              ObjectsCompat.equals(getMessage(), comment.getMessage()) &&
              ObjectsCompat.equals(getPost(), comment.getPost());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getCommId())
      .append(getMessage())
      .append(getPost())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("comment {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("comm_id=" + String.valueOf(getCommId()) + ", ")
      .append("message=" + String.valueOf(getMessage()) + ", ")
      .append("post=" + String.valueOf(getPost()))
      .append("}")
      .toString();
  }
  
  public static CommIdStep builder() {
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
  public static comment justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new comment(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      comm_id,
      message,
      post);
  }
  public interface CommIdStep {
    MessageStep commId(String commId);
  }
  

  public interface MessageStep {
    BuildStep message(String message);
  }
  

  public interface BuildStep {
    comment build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep post(post post);
  }
  

  public static class Builder implements CommIdStep, MessageStep, BuildStep {
    private String id;
    private String comm_id;
    private String message;
    private post post;
    @Override
     public comment build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new comment(
          id,
          comm_id,
          message,
          post);
    }
    
    @Override
     public MessageStep commId(String commId) {
        Objects.requireNonNull(commId);
        this.comm_id = commId;
        return this;
    }
    
    @Override
     public BuildStep message(String message) {
        Objects.requireNonNull(message);
        this.message = message;
        return this;
    }
    
    @Override
     public BuildStep post(post post) {
        this.post = post;
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
    private CopyOfBuilder(String id, String commId, String message, post post) {
      super.id(id);
      super.commId(commId)
        .message(message)
        .post(post);
    }
    
    @Override
     public CopyOfBuilder commId(String commId) {
      return (CopyOfBuilder) super.commId(commId);
    }
    
    @Override
     public CopyOfBuilder message(String message) {
      return (CopyOfBuilder) super.message(message);
    }
    
    @Override
     public CopyOfBuilder post(post post) {
      return (CopyOfBuilder) super.post(post);
    }
  }
  
}
