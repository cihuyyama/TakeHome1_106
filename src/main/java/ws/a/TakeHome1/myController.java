/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ws.a.TakeHome1;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author iqbal al habib
 */

@Controller
public class myController {
    @RequestMapping("/uploadimage")
    public String hai(
            @RequestParam(value = "name") String pertama,
            @RequestParam(value = "locate") String kedua,
            @RequestParam(value = "img") MultipartFile file,
            Model kurir
    ) {
        byte[] img = null;
        try {
            img = file.getBytes();
        } catch (IOException ex) {
            Logger.getLogger(myController.class.getName()).log(Level.SEVERE, null, ex);
        }
        String base64Image = Base64.encodeBase64String(img);
        String filepathname= "data:image/png;base64,".concat(base64Image);
        
        kurir.addAttribute("name", pertama);
        kurir.addAttribute("locate", kedua); 
        kurir.addAttribute("img", filepathname);
        return "view";
    }
}
