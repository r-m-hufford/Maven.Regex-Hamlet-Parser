public class Main {

    public static void main(String[] args) {
        HamletParser hamletParser = new HamletParser();
        String hamlet = hamletParser.changePattern(hamletParser.getHamletData(), "Hamlet", "Leon");
        hamletParser.setHamletData(hamlet);
        String horatio = hamletParser.changePattern(hamletParser.getHamletData(), "Horatio", "Tariq");
        hamletParser.setHamletData(horatio);
        hamletParser.writeToAFile(hamletParser.getHamletData());

    }
}
