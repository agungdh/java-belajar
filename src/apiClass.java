
import java.io.IOException;
import javax.swing.JOptionPane;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author aa
 */
public class apiClass {
    private final OkHttpClient client = new OkHttpClient();

    public String run() throws Exception {
    Request request = new Request.Builder()
        .url("https://ipinfo.io/json")
        .build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

      Headers responseHeaders = response.headers();
//      String header = "";
      for (int i = 0; i < responseHeaders.size(); i++) {
//        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//          header += responseHeaders.name(i) + ": " + responseHeaders.value(i) + "\n";
      }

//      JOptionPane.showMessageDialog(null, header);

//      System.out.println(response.body().string());

        JSONObject json = new JSONObject(response.body().string());
//        System.out.println("\n\n");
        
//        System.out.println(json.toMap());
        String nilai = "";
        for (String key : json.toMap().keySet()) {
            nilai += key + " = " + json.toMap().get(key) + "\n";
        }
        
        return nilai;
//        System.out.println(json.toMap());
    }
  }
}
