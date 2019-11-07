package com.wbs.java8lambda.chapter8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * TODO
 *
 * @author: wangbingshuai
 * @create: 2019-11-07 11:26
 **/
public class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        HeaderTextProcessing p1 = new HeaderTextProcessing();
        SpellCheckerProcessing p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result1 = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result1);

        UnaryOperator<String> headerProcessing = (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckProcessing = (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);
    }

    private static abstract class ProcessingObject<T> {
        protected ProcessingObject<T> successor;

        public void setSuccessor(ProcessingObject<T> successor) {
            this.successor = successor;
        }

        public T handle(T input) {
            T r = handleWork(input);
            if (successor != null) {
                return successor.handleWork(r);
            }
            return r;
        }

        abstract protected T handleWork(T input);
    }

    private static class HeaderTextProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String input) {
            return "From Raoul, Mario and Alan: " + input;
        }
    }

    private static class SpellCheckerProcessing extends ProcessingObject<String> {
        @Override
        protected String handleWork(String input) {
            return input.replaceAll("labda", "lambda");
        }
    }
}
