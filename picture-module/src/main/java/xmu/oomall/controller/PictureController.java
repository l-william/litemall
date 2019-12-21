package xmu.oomall.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xmu.oomall.util.FileUploadUtil;
import xmu.oomall.util.IdUtil;
import xmu.oomall.util.ResponseUtil;


/**
 * @author zx
 */
@RestController
@RequestMapping("")
public class PictureController {
    /**
     * 管理员上传图片
     *
     * @param file
     * @return object
     * @throws Exception
     */
    @RequestMapping(value = "/pics", method = RequestMethod.POST)
    public Object uploadPicture(@RequestParam(value = "file", required = false) MultipartFile file) throws Exception {
        if (file == null) {
            return ResponseUtil.badArgument();
        }
        String path = "http:////139.196.212.100//images//"
                + IdUtil.genImageName()
                + file.getOriginalFilename();
        System.out.println(path);
        String ok = "Success";
        if (ok.equals(FileUploadUtil.upload(file, path))) {
            //String prefix = "http://localhost";
            //return ResponseUtil.ok(prefix + path);
            return ResponseUtil.ok(path);
        }
        return ResponseUtil.fail();
    }
}