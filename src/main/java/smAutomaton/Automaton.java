package smAutomaton;

import java.util.List;
import java.util.Map;

public class Automaton {

//    public void smAutomaton(StringBuilder inputStr, String begin, Map<String, List<String>> rules) {
//
//        StringBuilder stack = new StringBuilder("");
//
//        for (Map.Entry<String, List<String>> entry : rules.entrySet()) {
//            System.out.format("Входная строка: %s Содержимое магазина: %s\n", inputStr, stack);
//            entry.getValue().stream().filter(value -> value.)
//        }
//
//    }

    public void extendedSmAutomaton(StringBuilder inputStr, Map<String, List<String>> rules) {
        StringBuilder stack = new StringBuilder("");

        while (true) {
            System.out.format("Входная строка: %s Содержимое магазина: %s\n", inputStr, stack);
            if (!findMatchAndReplace(stack, rules)) {
                if (inputStr.length() == 0) {
                    break;
                }
                stack.append(inputStr.charAt(0));
                inputStr.deleteCharAt(0);
            }
        }
    }

    private Boolean findMatchAndReplace(StringBuilder stack, Map<String, List<String>> rules) {
        for (Map.Entry<String, List<String>> entry : rules.entrySet()) {
            String buff = entry.getValue().stream()
                    .filter(value -> stack.length() != 0 && stack.toString().contains(value))
                    .findAny()
                    .orElse("");
            if (!buff.isEmpty()) {
                stack.replace(0, stack.length(), stack.toString().replace(buff, entry.getKey()));
                return true;
            }
        }
        return false;
    }
}
