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
public class Fbcm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        // Pasarle la liga de la noticia
        FBComments fb = FBComments.getFBComments("http://graph.facebook.com/comments?id="+args[0]+");
        
        //Muestra los comentarios de la noticia
        for (FBComment fm : fb.getComments()) {
            System.out.println("-------------------------------------------------------------");
            System.out.println("Created_time: "+fm.getCreatedTime());
            System.out.println("ID: "+fm.getId());
            System.out.println("like_count: "+fm.getLikeCount());
            System.out.println("user_likes: "+fm.getUserLikes());
            System.out.println("can_remove: "+fm.getCanRemove());
            System.out.println("ID: "+fm.getUsuario().getId()+" Nombre: "+fm.getUsuario().getNombre());
            System.out.println("Comentario: ");
            System.out.println(fm.getMessage());
        }
        
    }
    
}
