
import java.io.IOException;
import javax.swing.JOptionPane;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

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

    public void run() throws Exception {
    Request request = new Request.Builder()
        .url("https://ipinfo.io/json")
        .build();

    try (Response response = client.newCall(request).execute()) {
      if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

      Headers responseHeaders = response.headers();
//      String header = "";
      for (int i = 0; i < responseHeaders.size(); i++) {
        System.out.println(responseHeaders.name(i) + ": " + responseHeaders.value(i));
//          header += responseHeaders.name(i) + ": " + responseHeaders.value(i) + "\n";
      }

//      JOptionPane.showMessageDialog(null, header);

      System.out.println(response.body().string());
    }
  }
}
