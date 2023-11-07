] Pages ;

    public String getDescription() {
        return description;
    }

    public Category getPartof() {
        return partof;
    }

    public Category[] getSubcategories() {
        return subcategories;
    }

    public WikiPage[] getPages() {
        return Pages;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPartof(Category partof) {
        this.partof = partof;
    }

    public void setSubcategories(Category[] subcategories) {
        this.subcategories = subcategories;
    }

    public void setPages(WikiPage[] Pages) {
        this.Pages = Pages;
    }
}
