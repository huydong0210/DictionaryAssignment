public class Word {
    private int id;
    private String word;
    private String description;
    private String pronounce;

    public Word(){
        id=0;
        this.word=null;
        this.description=null;
        this.pronounce=null;

    }
    public Word(int id , String word,String description,String pronounce){
        this.id=id;
        this.word=word;
        this.description=description;
        this.pronounce=pronounce;
    }
    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }

    public String getPronounce() {
        return pronounce;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPronounce(String pronounce) {
        this.pronounce = pronounce;
    }
}
