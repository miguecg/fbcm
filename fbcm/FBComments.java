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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.net.URL;
import java.net.HttpURLConnection;
import org.json.simple.parser.JSONParser;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;



public class FBComments implements Serializable {

    private List<FBComment> comments = new ArrayList();

    public FBComments(List<FBComment> comments) {
        this.comments = comments;
    }

    public List<FBComment> getComments() {
        return comments;
    }

    public void setComments(List comments) {
        this.comments = comments;
    }

    public FBComments() {
    }

    public static FBComments getFBComments(String url) throws Exception {

        FBComments fbm = new FBComments();
        URL ur = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) ur.openConnection();
        conn.connect();

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String dirTempHtml = "/tmp/archivo.json";
        File f = new File(dirTempHtml);

        String linea = "";

        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        while ((linea = br.readLine()) != null) {
            bw.append(linea);
            System.out.println(linea);
        }
        bw.close();

        conn.disconnect();
        
        JSONParser jp = new JSONParser();
        JSONObject oo = (JSONObject) jp.parse(new FileReader(dirTempHtml));
        System.out.println(oo.toJSONString());
        
        JSONArray data = (JSONArray)oo.get("data");
        
        Iterator<JSONObject> it = data.iterator();
        
        List<FBComment> lfb = new ArrayList();
        
        while (it.hasNext()) {
            
            JSONObject ob = it.next();
            FBComment fc = new FBComment();
            fc.setCreatedTime(ob.get("created_time").toString());
            fc.setCanRemove(ob.get("can_remove").toString());
            fc.setId(ob.get("id").toString());
            fc.setLikeCount(ob.get("like_count").toString());
            fc.setUserLikes(ob.get("user_likes").toString());
            fc.setMessage(ob.get("message").toString());
            
            JSONObject ju = (JSONObject) ob.get("from");
            
            Usuario usu = new Usuario(ju.get("name").toString(), ju.get("id").toString());
            fc.setUsuario(usu);
            
            lfb.add(fc);
        }
        
        fbm.setComments(lfb);
        
        return fbm;
    }
}
