import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Compare {
    public static void main(String[] args) {
        List<String> male = Arrays.asList("김코딩", "최자바", "김코츠");
        List<String> female = Arrays.asList("박해커", "김유클", "김코딩");
        String lastName = "김";

        List<List> maleList = new ArrayList<>();
        maleList.add(male);
        maleList.add(female);
        Iterator<List> iter = maleList.iterator();
        List<String> new1 = new ArrayList<>();
        while (iter.hasNext()) {
            List<String> new_male = iter.next(); // male, female 순으로 검사
            for (int i = 0; i < new_male.size(); i++) {
                if (String.valueOf(new_male.get(i).charAt(0)).equals(lastName)) { // 성이 "김이면 통과
                    if (!new1.contains(new_male.get(i))) { // 하지만 리스트에 동명이인이 있으면 추가를 안한다.
                        new1.add(new_male.get(i));
                    }
                }
            }
        }
        Collections.sort(new1);
        System.out.println("기본문법사용 = " + new1);


        Stream<String> stream3 = Stream.concat(male.stream(), female.stream());
        List<String> a = stream3.distinct().filter(m -> m.substring(0, 1).equals(lastName)).sorted().collect(Collectors.toList());
        System.out.println("스트림 사용= " + a);
    }
}
