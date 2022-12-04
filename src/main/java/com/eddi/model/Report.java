package com.eddi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "report")
public class Report {
    private static final String PATTERN = "yyyy-MM-dd";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Employee author;

    @Column(name = "content",
            columnDefinition="TEXT")
    private String content;

    @Column(name = "date_created")
    private Date dateCreated;

    public Report() {}

    public Report(Long id,
                  String title,
                  Employee author,
                  String content,
                  Date dateCreated) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.dateCreated = dateCreated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getAuthor() {
        return author;
    }

    public void setAuthor(Employee author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreated() {
        if (dateCreated != null) {
            return new SimpleDateFormat(PATTERN).format(dateCreated);
        }
        return "";
    }

    public void setDateCreated(Date dateCreated) {
            this.dateCreated = dateCreated;
    }
}
