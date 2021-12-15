import smAutomaton.Automaton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Automaton automaton = new Automaton();
        Map<String, List<String>> rules = new HashMap<>() {{
            put("S", new ArrayList<>() {{
                add("S+A");
                add("A");
            }});
            put("A", new ArrayList<>() {{
                add("(S)");
                add("a");
            }});
        }};
        automaton.extendedSmAutomaton(new StringBuilder("(a)"), rules);
    }
}
