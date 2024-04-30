import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PicnicAnalyzer {
    public static void main(String[] args) {
        String filename = "input.txt";

        // Задание 1: Подсчет количества слов
        int wordCount = countWords(filename);
        System.out.println("Количество слов в файле: " + wordCount);

        // Задание 2: Поиск самого длинного слова
        String longestWord = findLongestWord(filename);
        System.out.println("Самое длинное слово в файле: " + longestWord);

        // Задание 3: Вычисление частоты слов
        Map<String, Integer> wordFrequency = calculateWordFrequency(filename);
        System.out.println("Частота слов:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Метод для подсчета количества слов в файле
    private static int countWords(String filename) {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                count += words.length;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return count;
    }

    // Метод для поиска самого длинного слова в файле
    private static String findLongestWord(String filename) {
        String longestWord = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    if (word.length() > longestWord.length()) {
                        longestWord = word;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return longestWord;
    }

    // Метод для вычисления частоты слов
    private static Map<String, Integer> calculateWordFrequency(String filename) {
        Map<String, Integer> wordFrequency = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String word : words) {
                    wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wordFrequency;
    }
}
