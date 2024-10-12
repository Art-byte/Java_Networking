package examples;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileDownload {
    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        String fileURL = "https://github.com/pbatard/rufus/releases/download/v4.5/rufus-4.5.exe";
        String saveDir = "/home/art/Desktop";
        try {
            downloadFile(fileURL, saveDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void downloadFile(String fileURL, String saveDir) throws IOException {
        URL url = new URL(fileURL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        int responseCode = httpURLConnection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {
            String fileName = "";
            String disposition = httpURLConnection.getHeaderField("Content-Disposition");
            String contentType = httpURLConnection.getContentType();
            int contentLength = httpURLConnection.getContentLength();

            if (disposition != null) {
                // Extract filename from the disposition
                int index = disposition.indexOf("filename=");
                if (index > 0) {
                    fileName = disposition.substring(index + 10, disposition.length() - 1);
                }
            } else {
                // Extract the file name from the URL if no Content-Disposition is present
                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            }

            System.out.println("Content-Type        : " + contentType);
            System.out.println("Content-Disposition : " + disposition);
            System.out.println("Content-Length      : " + contentLength);
            System.out.println("File Name           : " + fileName);

            // Open InputStream from the connection
            InputStream inputStream = httpURLConnection.getInputStream();
            String saveFilePath = saveDir + File.separator + fileName;

            // Open output stream to save the file
            FileOutputStream outputStream = new FileOutputStream(saveFilePath);

            try {
                int bytesRead = -1;
                byte[] buffer = new byte[BUFFER_SIZE];
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                }
                System.out.println("File downloaded to: " + saveFilePath);
            } finally {
                // Close resources
                outputStream.close();
                inputStream.close();
            }
        } else {
            System.out.println("No file to download. Server replied with HTTP code: " + responseCode);
        }

        httpURLConnection.disconnect();
    }
}
