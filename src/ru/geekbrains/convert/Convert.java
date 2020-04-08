package ru.geekbrains.convert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Convert {
    private boolean status;
    private String target = "btc-usd";
    private String API = "https://api.cryptonator.com/api/ticker/";
    public Convert() {
    }

    public double strokavalue(String Met){
        final URL url;
        int CONNECTION_TIMEOUT = 1000;
        this.target = Met;
        try {
            url = new URL(this.API + this.target);
            final HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setConnectTimeout(CONNECTION_TIMEOUT);
            con.setReadTimeout(CONNECTION_TIMEOUT);
            try (final BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                String Stroka = content.toString();
                String[] Mass = Stroka.split(",");
                String[] Mass1 = Mass[2].split(":");
                String Stroka1;
                Stroka1 = Mass1[1].substring(1,Mass1[1].length()-1);
                double price = Double.parseDouble(Stroka1);
                this.status = true;
                return price;

            } catch (final Exception ex) {
                ex.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.status = false;
        return 0;
    }


}
