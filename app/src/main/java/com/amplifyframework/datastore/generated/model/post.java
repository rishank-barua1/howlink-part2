package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
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

/** This is an auto generated class representing the post type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "posts")
@Index(name = "byPost", fields = {"user_id"})
public final class post implements Model {
  public static final QueryField ID = field("post", "id");
  public static final QueryField CONTENT_TYPE = field("post", "content_type");
  public static final QueryField CAPTION = field("post", "caption");
  public static final QueryField VIEWS = field("post", "views");
  public static final QueryField POST = field("post", "user_id");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String content_type;
  private final @ModelField(targetType="String", isRequired = true) String caption;
  private final @ModelField(targetType="Int", isRequired = true) Integer views;
  private final @ModelField(targetType="usr") @BelongsTo(targetName = "user_id", type = usr.class) usr post;
  private final @ModelField(targetType="comment") @HasMany(associatedWith = "post", type = comment.class) List<comment> comment_conn = null;
  public String getId() {
      return id;
  }
  
  public String getContentType() {
      return content_type;
  }
  
  public String getCaption() {
      return caption;
  }
  
  public Integer getViews() {
      return views;
  }
  
  public usr getPost() {
      return post;
  }
  
  public List<comment> getCommentConn() {
      return comment_conn;
  }
  
  private post(String id, String content_type, String caption, Integer views, usr post) {
    this.id = id;
    this.content_type = content_type;
    this.caption = caption;
    this.views = views;
    this.post = post;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      post post = (post) obj;
      return ObjectsCompat.equals(getId(), post.getId()) &&
              ObjectsCompat.equals(getContentType(), post.getContentType()) &&
              ObjectsCompat.equals(getCaption(), post.getCaption()) &&
              ObjectsCompat.equals(getViews(), post.getViews()) &&
              ObjectsCompat.equals(getPost(), post.getPost());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getContentType())
      .append(getCaption())
      .append(getViews())
      .append(getPost())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("post {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("content_type=" + String.valueOf(getContentType()) + ", ")
      .append("caption=" + String.valueOf(getCaption()) + ", ")
      .append("views=" + String.valueOf(getViews()) + ", ")
      .append("post=" + String.valueOf(getPost()))
      .append("}")
      .toString();
  }
  
  public static ContentTypeStep builder() {
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
  public static post justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new post(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      content_type,
      caption,
      views,
      post);
  }
  public interface ContentTypeStep {
    CaptionStep contentType(String contentType);
  }
  

  public interface CaptionStep {
    ViewsStep caption(String caption);
  }
  

  public interface ViewsStep {
    BuildStep views(Integer views);
  }
  

  public interface BuildStep {
    post build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep post(usr post);
  }
  

  public static class Builder implements ContentTypeStep, CaptionStep, ViewsStep, BuildStep {
    private String id;
    private String content_type;
    private String caption;
    private Integer views;
    private usr post;
    @Override
     public post build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new post(
          id,
          content_type,
          caption,
          views,
          post);
    }
    
    @Override
     public CaptionStep contentType(String contentType) {
        Objects.requireNonNull(contentType);
        this.content_type = contentType;
        return this;
    }
    
    @Override
     public ViewsStep caption(String caption) {
        Objects.requireNonNull(caption);
        this.caption = caption;
        return this;
    }
    
    @Override
     public BuildStep views(Integer views) {
        Objects.requireNonNull(views);
        this.views = views;
        return this;
    }
    
    @Override
     public BuildStep post(usr post) {
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
    private CopyOfBuilder(String id, String contentType, String caption, Integer views, usr post) {
      super.id(id);
      super.contentType(contentType)
        .caption(caption)
        .views(views)
        .post(post);
    }
    
    @Override
     public CopyOfBuilder contentType(String contentType) {
      return (CopyOfBuilder) super.contentType(contentType);
    }
    
    @Override
     public CopyOfBuilder caption(String caption) {
      return (CopyOfBuilder) super.caption(caption);
    }
    
    @Override
     public CopyOfBuilder views(Integer views) {
      return (CopyOfBuilder) super.views(views);
    }
    
    @Override
     public CopyOfBuilder post(usr post) {
      return (CopyOfBuilder) super.post(post);
    }
  }
  
}
