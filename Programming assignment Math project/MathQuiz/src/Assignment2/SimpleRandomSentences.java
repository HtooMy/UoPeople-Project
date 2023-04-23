/*
<sentence> ::= <simple_sentence> [ <conjunction> <sentence> ]
<simple_sentence> ::= <noun_phrase> <verb_phrase>
<noun_phrase> ::= <proper_noun> |
<determiner> [ <adjective> ]. <common_noun> [ who <verb_phrase> 
<verb_phrase> ::= <intransitive_verb> |
<transitive_verb> <noun_phrase> |
is <adjective> |
believes that <simple_sentence>
<conjunction> ::= and | or | but | because
<proper_noun> ::= Fred | Jane | Richard Nixon | Miss America
<common_noun> ::= man | woman | fish | elephant | unicorn
<determiner> ::= a | the | every | some
<adjective> ::= big | tiny | pretty | bald
<intransitive_verb> ::= runs | jumps | talks | sleeps
<transitive_verb> ::= loves | hates | sees | knows | looks for | finds 
The program will output the random sentences
*/

public class SimpleRandomSentences {
    static final String[] conjunction = { "and", "or", "but", "because" };
    static final String[] properNoun = { "Fred", "Jane", "Richard Nixon", "Miss America" };
    static final String[] commonNoun = { "man", "woman", "fish", "elephant", "unicorn" };
    static final String[] determiner = { "a", "the", "every", "some" };
    static final String[] adjective = { "big", "tiny", "pretty", "bald" };
    static final String[] intransitiveVerb = { "runs", "jumps", "talks", "sleeps" };
    static final String[] transitiveVerb = { "loves", "hates", "sees", "knows", "looks for", "finds" };

    public static void main(String[] args) {
        while (true) {
            sentence();
            System.out.print(".\n\n");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }
        }
    }

    public static void sentence() {
        simpeSentence();
        if (Math.random() > 0.75) {
            System.out.print(" " + randomItem(conjunction));
            sentence();
        }
    }

    public static void simpeSentence() {
        nounPhrase();
        verbPhrase();
    }

    public static void nounPhrase() {
        if (Math.random() > 0.75) {
            System.out.print(" " + randomItem(properNoun));
        } else {
            System.out.print(" " + randomItem(determiner));
            if (Math.random() > 0.5) {
                System.out.print(" " + randomItem(adjective));
            }
            System.out.print(" " + randomItem(commonNoun));
            if (Math.random() > 0.5) {
                System.out.print(" who ");
                verbPhrase();
            }
        }
    }

    public static void verbPhrase() {
        if (Math.random() > 0.75) {
            System.out.print(" " + randomItem(intransitiveVerb));
        } else if (Math.random() > 0.50) {
            System.out.print(" " + randomItem(transitiveVerb));
            nounPhrase();
        } else if (Math.random() > 0.25) {
            System.out.print(" is " + randomItem(adjective));
        } else {
            {
                System.out.print(" believes that ");
                simpeSentence();
            }
        }
    }

    public static String randomItem(String[] stringList) {
        return stringList[(int) (Math.random() * stringList.length)];
    }

}