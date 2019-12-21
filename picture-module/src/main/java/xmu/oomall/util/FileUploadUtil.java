/**
 * @author xingzhou
 * @date 2019/12/17 23:06
 * @version 1.0
 */

package xmu.oomall.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class FileUploadUtil {
    public static String upload(MultipartFile file, String path) {
        if (!file.isEmpty()) {
            try {
//                URL url =new URL(path);
//                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//                conn.setDoOutput(true);
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(path)));
                //BufferedOutputStream out = new BufferedOutputStream(conn.getOutputStream());
                System.out.println(file.getOriginalFilename());
                out.write(file.getBytes());
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
                return "Failed" + e.getMessage();
            }
            return "Success";
        } else {
            return "Empty";
        }
    }
}