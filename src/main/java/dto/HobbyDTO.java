package dto;

import entities.Hobby;


public class HobbyDTO {
    private int id;
    private String name;
    private String type;
    private String category;
    private String wikiLink;

    public HobbyDTO() {
    }

    public HobbyDTO(Hobby h) {
        
        this.name = h.getName();
        this.wikiLink = h.getLinkWiki();
        this.category = h.getUnderCathegory();
        this.type = h.getType();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWikiLink() {
        return wikiLink;
    }

    public void setWikiLink(String wikiLink) {
        this.wikiLink = wikiLink;
    }
    
    
}