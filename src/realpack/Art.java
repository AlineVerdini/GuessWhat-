package realpack;

public enum Art {
    BEAR(Ascii.BEAR, "bear"),
    CAT(Ascii.CAT, "cat"),
    RHINO(Ascii.RHINOCERO, "rhino"),
    SCORPION(Ascii.SCORPION, "scorpion"),
    DUCK(Ascii.DUCK, "duck"),
    DOG(Ascii.DOG, "dog"),
    BAT(Ascii.BAT, "bat"),
    DOLPHIN (Ascii.DOLPHIN, "dolphin"),
    SMURF(Ascii.SMURF, "smurf"),
    HOMER(Ascii.HOMER,"homer"),
    YODA(Ascii.YODA, "yoda"),
    MONKEY(Ascii.MONKEY, "monkey"),
    BANANA(Ascii.BANANA, "banana"),
    CROCODILE(Ascii.CROCODILE,"crocodile"),
    SPONGEBOB(Ascii.SPONGEBOB, "spongebob"),
    HARRYPOTTER(Ascii.HARRYPOTTER,"harry potter"),
    CROWN(Ascii.CROWN, "crown"),
    FROG(Ascii.FROG,"frog"),
    DRAGON(Ascii.DRAGON,"dragon"),
    ASTERIX(Ascii.ASTERIX,"asterix"),
    DEER(Ascii.DEER,"deer"),
    BYCICLE(Ascii.BYCICLE,"bycicle"),
    TRAIN(Ascii.TRAIN,"train"),
    CACTUS(Ascii.CACTUS,"cactus"),
    UMBRELLA(Ascii.UMBRELLA, "umbrella");








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
        System.out.println("returning a name");
        return name;
    }
}
