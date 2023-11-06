/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package telkomwiki;

import java.time.LocalDateTime;

/**
 *
 * @author ASUS
 */
public class WikiPage {
    private String title, content;
    final LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    //Tagged tags;

    public WikiPage(String title, String content, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.setUpdatedAt();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        this.setUpdatedAt();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
        this.setUpdatedAt();
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = java.time.LocalDateTime.now();
    }
    
    
}
