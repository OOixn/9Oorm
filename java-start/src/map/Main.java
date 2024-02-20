package map;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> numNameHMap = new HashMap<>();
        //  💡 put 메소드를 사용하여 키와 값 삽입
        numNameHMap.put(1, "홍길동");
        numNameHMap.put(2, "전우치");
        numNameHMap.put(3, "임꺽정");

        Map<String, Double> nameHeightHMap = new HashMap<>();
        nameHeightHMap.put("김철수", 176.8);
        nameHeightHMap.put("이장신", 187.4);
        nameHeightHMap.put("박숏달", 152.3);
        nameHeightHMap.put("정기준", 171.2);

//        Map<Side, ArrayList<Unit>> sideUnitsHMap = new HashMap<>();
//        sideUnitsHMap.put(
//                Side.BLUE,
//                new ArrayList<>(
//                        Arrays.asList(
//                                new Swordman(Side.BLUE),
//                                new Knight(Side.BLUE),
//                                new MagicKnight(Side.BLUE))
//                )
//        );
//        sideUnitsHMap.put(
//                Side.RED,
//                new ArrayList<>(
//                        Arrays.asList(
//                                new Knight(Side.RED),
//                                new Knight(Side.RED),
//                                new Knight(Side.RED))
//                )
//        );
        //  💡 putAll : 대상 맵으로부터 전부 가져옴
        Map<Integer, String> numNameHMapClone = new HashMap<>();
        numNameHMapClone.putAll(numNameHMap);

        //  💡 get 메소드에 키를 넣어 값 접근
        String no2 = numNameHMap.get(2);
        Double leeHeight = nameHeightHMap.get("이장신");
        //  ⚠️ 잘못된 키 입력시 null 반환
        String wrong1 = numNameHMap.get(0);
        Double wrong2 = nameHeightHMap.get(3);

        //  💡 keySet 메소드 - 키들의 Set(인터페이스) 반환
        Set<Integer> numSet = numNameHMap.keySet();
        Set<Integer> numHSet = new HashSet<>();
        numHSet.addAll(numSet);

        //  keySet을 활용한 for-each
        for (Integer n : numNameHMap.keySet()) {
            System.out.println(numNameHMap.get(n));
        }
//        for (Side side : sideUnitsHMap.keySet()) {
//            for (Unit unit : sideUnitsHMap.get(side)) {
//                System.out.println(unit);
//            }

    }
}
