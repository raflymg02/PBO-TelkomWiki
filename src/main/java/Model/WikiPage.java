/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


/**
 *
 * @author Kelompok 1
 */

@Entity
public class WikiPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Primary key

    private String title, content;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Default constructor (no-argument constructor) required by Hibernate
    public WikiPage() {
        this.createdAt = LocalDateTime.now();
    }

    public WikiPage(String title, String content, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // getter and setter for id
    public Long getId() {
        return id;
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

    public String toString() {
        return "Created At: " + createdAt + " updatedAt: " + updatedAt +  '\'' +
                title + '\'' +
                content;
    }
    
    
}
