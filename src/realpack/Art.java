package realpack;

public enum Art {
    BEAR(Ascii.BEAR, "bear"),
    CAT(Ascii.CAT, "cat"),
    RHINO(Ascii.RHINOCERO, "rhino"),
    DOG(Ascii.DOG, "dog"),
    DUCK(Ascii.DUCK, "duck");


    private String asciiArt;
    private String name;

    Art(String asciiArt, String name) {
        this.asciiArt = asciiArt;
        this.name = name;
    }

    public String getAsciiArt() {
        return asciiArt;
    }

    public String getName() {
        return name;
    }
}
