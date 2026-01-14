package com.bangumimenu.entity;

import java.time.LocalDateTime;

/**
 * 番剧实体类
 */
public class Bangumi {
    private String title;
    private String description;
    private String writer;
    private String original;
    private String director;
    private String proposer;
    private boolean watched;
    private int votes;
    private LocalDateTime watchTime;
    private String watcher;

    // 构造函数
    public Bangumi() {}

    public Bangumi(String title, String description, String writer, String original, 
                   String director, String proposer, boolean watched, int votes) {
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.original = original;
        this.director = director;
        this.proposer = proposer;
        this.watched = watched;
        this.votes = votes;
    }

    // 带有观看时间和观看人的构造函数
    public Bangumi(String title, String description, String writer, String original, 
                   String director, String proposer, boolean watched, int votes,
                   LocalDateTime watchTime, String watcher) {
        this.title = title;
        this.description = description;
        this.writer = writer;
        this.original = original;
        this.director = director;
        this.proposer = proposer;
        this.watched = watched;
        this.votes = votes;
        this.watchTime = watchTime;
        this.watcher = watcher;
    }

    // Getter 和 Setter 方法
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public int getVotes() {
        return votes;
    }

    public void setVotes(int votes) {
        this.votes = votes;
    }

    public LocalDateTime getWatchTime() {
        return watchTime;
    }

    public void setWatchTime(LocalDateTime watchTime) {
        this.watchTime = watchTime;
    }

    public String getWatcher() {
        return watcher;
    }

    public void setWatcher(String watcher) {
        this.watcher = watcher;
    }
}