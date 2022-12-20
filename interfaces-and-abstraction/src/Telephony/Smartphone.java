package Telephony;

import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;
    Smartphone(List<String> numbers, List<String> urls) {
    }

    @Override
    public String browse() {
        return "Browsing: ";
    }

    @Override
    public String call() {
        return "Calling... ";
    }
}
