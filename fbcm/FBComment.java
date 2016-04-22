/*
 * Autor: Miguel Angel Cedeño Garcidueñas
 * FIE-UMSNH
 * 
 */
package fbcm;

/**
 *
 * @author miguel
 */
import java.io.Serializable;


public class FBComment implements Serializable {
    
    private String createdTime;
    private String message;
    private String canRemove;
    private String likeCount;
    private String userLikes;
    private String id;
    private Usuario usuario;

    public FBComment() {
    }

    public String getCanRemove() {
        return canRemove;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public String getId() {
        return id;
    }

    public String getLikeCount() {
        return likeCount;
    }

    public String getMessage() {
        return message;
    }

    public String getUserLikes() {
        return userLikes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setCanRemove(String canRemove) {
        this.canRemove = canRemove;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLikeCount(String likeCount) {
        this.likeCount = likeCount;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserLikes(String userLikes) {
        this.userLikes = userLikes;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }   
    
}
