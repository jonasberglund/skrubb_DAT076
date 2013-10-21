/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skrubb.blog_front_end.bb.post;

import com.skrubb.blog_back_end.core.Author;
import com.skrubb.blog_back_end.core.PhotoPost;
import com.skrubb.blog_back_end.core.Tag;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.List;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

/**
 * Add a photopost to database
 * @author Anders Johansson, Jonas Berglund
 */
@Named("addPhotoPost")
@ConversationScoped
public class AddPhotoPostBB extends ConversationalPost {
    
    private static final long serialVersionUID = 10056297720999998L;
    
    private String destination="git/skrubb_DAT076/blog_front_end/target/blog_front_end-1.0-SNAPSHOT/resources/img/";
    private UploadedFile file;
    
    public void setFile(UploadedFile file) {
        this.file = file;
    }
    public UploadedFile getFile() {
        return file;
    }
    
    @Override
    protected void execute() {
        
        if (file != null) {
            
            try {
                String newFileName = copyFile(file.getFileName(), file.getInputstream());
                
                if (!newFileName.isEmpty()) {
                    
                    Author a1= blog.getAuthorRegistry().find(loginbean.getAuthor().getId());
                    PhotoPost pp = new PhotoPost(a1, getTitle(), newFileName);        
                    
                    blog.getPostArchive().add(pp);
                    
                    List<String> items = Arrays.asList(getTags().split("\\s*,\\s*"));
                    
                    for(String s : items) {
                        Tag tag = new Tag(s);
                        blog.getPostArchive().addTag(pp.getId(), tag);
                    }
                    
                }
                
            } catch (IOException e) {
                
            }
        }
    }
    
    private String copyFile(String fileName, InputStream in) {
        OutputStream out;
        
        try {
            // write the inputStream to a FileOutputStream
            
            fileName = System.currentTimeMillis() + fileName;
            String fileDestination = destination + fileName;
            
            out = new FileOutputStream(new File(fileDestination));
            
            int read;
            byte[] bytes = new byte[1024];
            
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
            in.close();
            out.flush();
            out.close();
            
            return fileName;
            
        } catch (IOException e) {
            
            return "";
        }
    }
}