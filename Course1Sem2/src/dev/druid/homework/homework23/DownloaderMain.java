package dev.druid.homework.homework23;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DownloaderMain {
    public static void main(String[] args) throws IOException {
        // Given a URL of web-page.
        // Download all files of extension x

        // URL:
        // Extenstion: .pdf

        String urlAddress = "https://en.wikipedia.org/wiki/London";
        String extension = "pdf";

        //Walk through page with url adress, find links and download them

        URL url = new URL(urlAddress);
        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

        String line = br.readLine();
        int k = 0;
        while (line != null) {
            List<String> urlsOfExtension = findAllFilesOfExtension(line, extension);
            for (String u : urlsOfExtension) {
                var temp = u.split("/");

                String filename = temp[temp.length-1];
                try {
                    download(u, filename);
                    System.out.println(filename);
                }catch(IOException e){
                    System.out.println("Could not download file: "+filename);
                }
                k++;
            }
            line = br.readLine();
        }
    }

    private static void download(String u, String filename) throws IOException {
        BufferedInputStream is = new BufferedInputStream((new URL(u).openStream()));
        FileOutputStream fos = new FileOutputStream("src/dev/druid/homework/"+filename);
        byte[] buffer = new byte[1000];
        while (is.read(buffer) != -1) {
            fos.write(buffer);
        }
        fos.close();
        is.close();
    }

    private static List<String> findAllFilesOfExtension(String line, String extension) {
        List<String> urls = new ArrayList<>();
        line = line.toLowerCase();
        Pattern p = Pattern.compile("\"[^\"]+\\." + extension + "\"");
        Matcher m = p.matcher(line);
        while (m.find()) {
            String s = m.group();
            urls.add(s.substring(1, s.length() - 1));
        }
        return urls;
    }

}
